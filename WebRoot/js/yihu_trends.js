/**
 * Created by Administrator on 2015/5/4.
 */
 $(function(){
    var screenHeight = $(window).height();
    $(".trends_content_show").css({
        minHeight: screenHeight-105-80-2+"px"
    });
});
 
 
 
 
 
$(document).ready(function(){
 
 getNwesData(1,4);
 trendsHeight();
 
});


function trendsHeight(){
    var trendsLength = $(".trends_list").length;
    for( var i = 0;i < trendsLength;i++ ){
        var trendsHeight = $(".trends_list").eq(i).find(".trends_words_show_content").height();
        if( trendsHeight < 200 ){
            $(".trends_list").eq(i).find(".so_on").css({
                display: "none"
            });
        }else{
            $(".trends_list").eq(i).find(".so_on").css({
                display: "block"
            });
        }
    }
}
$(".read_all").live("click",function(){
    var trendsHeight = $(this).parents(".trends_list").find(".trends_words_show_content").height();
    if( trendsHeight < 200 ){
        $(this).find("a").text("阅读全文");
        $(this).attr("class","read_all");
    }else{
        $(this).find("a").text("收起");
        $(this).attr("class","pack_up");
    }
    $(this).parents(".trends_list").find(".trends_words_show").css({
        height: "auto"
    });
    $(this).parents(".trends_list").find(".trends_dic").css({
        height: "auto",
        minHeight: "200px"
    });
    $(this).parents(".trends_list").find(".so_on").css({
        display: "none"
    });

});

$(".pack_up").live("click",function(){
    $(this).parents(".trends_list").find(".trends_words_show").css({
        height: "200px"
    });
    $(this).parents(".trends_list").find(".trends_dic").css({
        height: "200px"
    });
    $(this).parents(".trends_list").find(".so_on").css({
        display: "block"
    });
    $(this).find("a").text("阅读全文");
    $(this).attr("class","read_all");
});


/**
 * ajax 加载更多订单
 */
function getNwesData(currentPage,perNumPage){
	
	var url="http://www.ehuu.com/tmg/newsajaxGetData?currentPage="+currentPage+"&pageNumber="+perNumPage;
	
	$.ajax({
        type: 'GET',   //方式请求
        contentType: 'application/json', 
        url: url, 
        data: '',  //这里是要传递的参数，格式为 data: '{paraName:paraValue}',下面将会看到       
        dataType: 'json',   //返回Json类型
        success: function(json) {
        	 
        	 var html="";
        	 if(json.response=='error'){
			 if(json.code==1){
			     html="<div class='trends_list no_trends'>"+
							"<h1>"+json.msg+"</h1>"+
						"</div>";
						 $('.trends_content_show').append(html);
			 }else{
			    alert(json.msg);
			 }
        		
        	 }else{
        		 if(json.response=='success'){
        			 
        				 var newsList= json.newslists;
        				
        				 for(var i=0;i<newsList.length;i++){
						 html=html+"<div class='trends_list'>"+
									"<div class='nav_left'>"+
										"<div class='move_piece'></div>"+
										"<span>"+newsList[i].createtime+"</span>"+
									"</div>"+
									"<div class='trends_list_content'>"+
										"<div class='trends_name'>"+newsList[i].title+"</div>"+
										"<div class='trends_date'>"+newsList[i].createtime+"</div>"+
										"<div class='trends_dic'>"+
										 "<div class='trends_words_show'>"+
											 "<div class='trends_words_show_content'>"+newsList[i].subTitle+
											 "</div>"+
											 
											"</div>"+
										"</div>"+
								
										"<div class='read_all'><a href='trends_information.html?pagenum="+newsList[i].pagenum+"'>阅读全文</a></div>"+
									"</div>"+
								"</div>";
						 
        				 } 
        				 
						 $("#loadmorebtn").remove();
						 currentPage=currentPage+1;
        	        	 html=html+"<div id='loadmorebtn' class='trends_list'>"+
										"<div class='nav_left'></div>"+
										"<div class='trends_list_btn'>"+
										"<button onclick='getNwesData("+currentPage+","+perNumPage+")'>更多动态</button>"+
										"</div>"+
									"</div>";
        	        	 $('.trends_content_show').append(html);
        		 }else{
        			 //获取数据失败
        			 
        			
        		 }
        	 }
        	
        }
	
    });
}