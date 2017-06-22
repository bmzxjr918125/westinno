/**
 * Created by Administrator on 2015/5/4.
 */
 $(function(){
    var screenHeight = $(window).height();
    $(".trends_content_show").css({
        minHeight: screenHeight-105-80-2+"px"
    });
});

 $(".trends_words_show_content p").css({
	fontFamily: "Verdana, Microsoft YaHei, Simsun"
 });

$(document).ready(function(){
urlinfo=window.location.href; //获取当前页面的url
len=urlinfo.length;//获取url的长度
offset=urlinfo.indexOf("?");//设置参数字符串开始的位置
newsidinfo=urlinfo.substr(offset,len)//取出参数字符串 这里会获得类似“id=1”这样的字符串
newsids=newsidinfo.split("=");//对获得的参数字符串按照“=”进行分割
newsid=newsids[1];//得到参数值
newsname=newsids[0];//得到参数名字

if(newsname=='?pagenum'){
var id=newsid;
 ajaxGetDescData(id);
 
}

});








/**
 * ajax 加载更多订单
 */
function ajaxGetDescData(id){
	
	var url="http://www.ehuu.com/tmg/newsajaxGetDescData?id="+id;
	
	$.ajax({
        type: 'GET',   //方式请求
        contentType: 'application/json', 
        url: url, 
        data: '',  //这里是要传递的参数，格式为 data: '{paraName:paraValue}',下面将会看到       
        dataType: 'json',   //返回Json类型
        success: function(json) {
        	 
        	 var html="";
        	
        		 if(json.response=='success'){
        			 
        				
						 html=html+"<div class='trends_list'>"+
									"<div class='nav_left'>"+
										"<div class='move_piece'></div>"+
										"<span>"+json.createtime+"</span>"+
									"</div>"+
									"<div class='trends_list_content'>"+
										"<div class='trends_name'>"+json.title+"</div>"+
										"<div class='trends_date'>"+json.createtime+"</div>"+
										"<div class='trends_dic'>"+
										 "<div class='trends_words_show'>"+
											 "<div class='trends_words_show_content'>"+json.content+
											 "</div>"+
											 
											"</div>"+
										"</div>"+
								
										
									"</div>"+
								"</div>";
						 
        				 
        				 
						
					
        	        	 $('.trends_content_show').append(html);
						 $(".trends_words_show_content p").css({
							fontFamily: "Verdana, Microsoft YaHei, Simsun"
						 });
        		 }else{
        			 //获取数据失败
        			 alert("获取数据失败");
        			
        		 }
        	 }

	
    });
}