<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--公共头文件引入-->
<%@ include file="/frontpage/html.inc.jsp"  %>
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>知识产权</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/css/knowledge.css"/>
   <style type="text/css">
     .cannot_select{
		  -moz-user-select:none;/*火狐*/
		  -webkit-user-select:none;/*webkit浏览器*/
		  -ms-user-select:none;/*IE10*/
		  -khtml-user-select:none;/*早期浏览器*/
		  user-select:none;
      }
   </style>
</head>
<body>

<!--顶部导航、登入等操作-->
<jsp:include page="../include/head.jsp" />

<div class="type_bar">
    <div class="type_bar_content">
        <c:forEach items="${jsonData.oneList}" var="one">
           <div class="type_bar_list" onclick="getTypeTwoData(${one.id})">
             <span id="type_one_${one.id}">${one.name}</span>
           </div>
        </c:forEach>
    </div>
</div>

<div class="type_main">
    <div class="type_content">
        <div class="collect" id="collect_btn">
            <div class="collect_pic" >
                <img  src="<%=basePath%>frontpage/images/star_w.png" alt=""/>
            </div>
            <p>收藏</p>
        </div>
        <div class="type_show">
            <div class="type_top">
                <div class="type_pic">
                    <img src="<%=basePath%>frontpage/images/zhishi_quan.png" alt="" id="product_image"/>
                </div>
                <div class="type_name">
                    <span id="product_name"></span>
                    <p id="product_tag"></p>
                </div>
            </div>
            <div class="type_choice">
                <div class="choice_main" id="type_content">
                    
                    <div class="choice_main_list">
                    	<div class="type_1" id="type_two1" >
	                        <div class="type_1_left">
	                            <span>服务<c:if test="${flag ne 1}"><span style="color: red;">*</span></c:if><c:if test="${flag eq 1}"><span style="color:white;">*</span></c:if></span>
	                        </div>
	                       
	                        <div class="type_1_right" id="type_two1_content">
	                            <%-- <div class="choice_list active">
	                                <span>发明</span>
	                                <img src="<%=basePath%>frontpage/images/17.png" alt=""/>
	                            </div> --%>
	                           
	                           
	                        </div> 
	                        
	                    </div>
                    </div>
                    
                    <div class="choice_main_list">
                    	<div class="type_1" id="type_two2" >
	                        <div class="type_1_left">
	                            <span>专利<span style="color: red;">*</span></span>
	                        </div>
	                        <div class="type_1_right">
	                            <div class="service_type" id="type_two2_content">
	                               
	                               
	                               
	                            </div>
	                        </div>
	                    </div>
                    </div>
                    
                    <div class="choice_main_list">
                    	<div class="type_1" id="type_two3">
	                        <div class="type_1_left">
	                            <span>减缓<span style="color: red;">*</span></span>
	                        </div>
	                        <div class="type_1_right" id="type_two3_content">
	                               
	                               
	                               
	                        </div>
	                    </div>
                    </div>
                    
                </div>
                <div class="type_price">
                    <span id="product_price" ></span>
                </div>
                <div class="num_choice">
                    <div class="num_choice_left">
                        <span>数量</span>
                    </div>
                    <div class="num_choice_right">
                        <img class="reduce_pic" src="<%=basePath%>frontpage/images/u111.png" alt=""/>
                        <input type="text" id="car_number" value="1" readonly="readonly" placeholder="1"/>
                        <img class="add_pic" src="<%=basePath%>frontpage/images/u109.png" alt=""/>
                    </div>
                </div>
                <div class="buy_btn">
                    <button class="gray_btn_9" id="addToCar">加入购物车</button><button id="addToOrder" class="orange_btn_6" >立即申请</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="goods_info_main">
    <div class="goods_info_content">
        <div class="goods_info_head">
            <div class="goods_info_head_content"><button class="active">商品详情</button><button>常见问题</button></div>
            <div class="move_line"></div>
        </div>
        <div class="goods_info_list">
            <div class="goods_info_show" id="product_description" style="display: block;">
               
            </div>
            
            <div class="goods_info_show" id="product_problem">
                
            </div>
        </div>
    </div>
</div>

<!--底部链接-->
<jsp:include page="../include/foot.jsp" />

<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/common.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/knowledge.js"></script>
<script type="text/javascript">
    var flag="${flag}";
    //top菜单选中
    choiceTop((parseInt(flag)+1));
    $(".type_bar_list").eq(0).click();
    
    
    /**
     *获取二级类型数据
     */
    function getTypeTwoData(type_one){
          var url = "productGetByTypeOne-"+type_one+".html" ;
				$.ajax({
					type : "GET",
					contentType : "application/json",
					url : url,
					data : "",
					dataType : "json",
					success : function(json) {
						if (json.response =="success") {
						    $(".type_bar_list").find("span").removeClass("active");
                            $("#type_one_"+type_one).addClass("active");
                           
                              $("#type_two1_content").html("");
                              $("#type_two2_content").html("");
                              $("#type_two3_content").html("");
                               $("#type_two1").css({
                                 display:"inline-block"
                               });
                               $("#type_two2").css({
                                 display:"inline-block"
                               });
                               $("#type_two3").css({
                                 display:"inline-block"
                               });
                             
                            if(flag!=1){
                               $("#type_two2").css({
                                 display:"none"
                               });
                               $("#type_two3").css({
                                 display:"none"
                               });
                            }
                            
                            
                            
						    var twoList=json.twoList;
						    
						    if(twoList.length==0){
						       $("#type_two1").css({
                                 display:"none"
                               });
                               $("#type_two2").css({
                                 display:"none"
                               });
                               $("#type_two3").css({
                                 display:"none"
                               });
						    }
						       var blo1=true;
						       var blo2=true;
						       var blo3=true;
						      for(var i=0;i<twoList.length;i++){
		                           var html="";
		                           if(twoList[i].flag==1){
			                              if(blo1){
			                                html="<div class='choice_list active' onclick='quxiaoChoice("+type_one+",this)'  twoid="+twoList[i].id+">"+
	                                				"<span class='cannot_select' onselectstart='return   false' >"+twoList[i].name+"</span>"+
	                                				"<img src='<%=basePath%>frontpage/images/17.png' alt=''/>"+
	                            				"</div>";
	                            				blo1=false;
			                              }else{
			                                 html="<div class='choice_list' onclick='typeChoice("+type_one+",this)' twoid="+twoList[i].id+">"+
	                                				"<span class='cannot_select' onselectstart='return   false'>"+twoList[i].name+"</span>"+
	                                				"<img src='<%=basePath%>frontpage/images/17.png' alt=''/>"+
	                            				"</div>";
			                              }
		                              $("#type_two1_content").append(html);
		                           }
		                           if(twoList[i].flag==2){
			                            if(blo2){
			                                html="<div class='choice_list active' onclick='typeChoice("+type_one+",this)' twoid="+twoList[i].id+">"+
	                                				"<span class='cannot_select' onselectstart='return   false'>"+twoList[i].name+"</span>"+
	                                				"<img src='<%=basePath%>frontpage/images/17.png' alt=''/>"+
	                            				"</div>";
	                            				blo2=false;
			                              }else{
			                                 html="<div class='choice_list' onclick='typeChoice("+type_one+",this)' twoid="+twoList[i].id+">"+
	                                				"<span class='cannot_select' onselectstart='return   false'>"+twoList[i].name+"</span>"+
	                                				"<img src='<%=basePath%>frontpage/images/17.png' alt=''/>"+
	                            				"</div>";
	                            				
			                              }
		                              $("#type_two2_content").append(html);
		                           }
		                           if(twoList[i].flag==3){
			                           if(blo3){
			                                html="<div class='choice_list active' onclick='typeChoice("+type_one+",this)' twoid="+twoList[i].id+">"+
	                                				"<span class='cannot_select' onselectstart='return   false'>"+twoList[i].name+"</span>"+
	                                				"<img src='<%=basePath%>frontpage/images/17.png' alt=''/>"+
	                            				"</div>";
	                            				blo3=false;
			                              }else{
			                                 html="<div class='choice_list' onclick='typeChoice("+type_one+",this)' twoid="+twoList[i].id+">"+
	                                				"<span class='cannot_select' onselectstart='return   false'>"+twoList[i].name+"</span>"+
	                                				"<img src='<%=basePath%>frontpage/images/17.png' alt=''/>"+
	                            				"</div>";
			                              }
		                              $("#type_two3_content").append(html);
		                           }
		                         }
		                         var type_two2= $("#type_two2_content .active").length==0?0:$("#type_two2_content .active").attr("twoid");
							     if(type_two2==4||type_two2==14||type_two2==23){
							           $("#type_two2_content").find(".choice_list").eq(1).click(); 
							      }else{
							           getProductData(type_one);
							      }
							} else {
								alert(json.msg);
							}
					}
				});
    }
    /**
     *点击选类型
     */
    function typeChoice(type_one,obj){
        var type_two2= $("#type_two2_content .active").length==0?0:$("#type_two2_content .active").attr("twoid");
        var twoid= $(obj).attr("twoid");
        if($(obj).parent().attr("id")!="type_two2_content"&&(type_two2==4||type_two2==14||type_two2==23)){
             return false;
        }
        if(flag==1){
          if(twoid==4||twoid==14||twoid==23){
            $("#type_content").find(".active").removeClass("active");
            
            $("#type_two1").css({
                                 display:"none"
                               });
            $("#type_two3").css({
                                 display:"none"
                               });
            
         }else{
            $("#type_two1").css({
                                 display:"inline-block"
                               });
            $("#type_two3").css({
                                 display:"inline-block"
                               });
         }
        }
       
      
        $(obj).parent().find(".choice_list").attr("onclick","typeChoice("+type_one+",this)").removeClass("active");
        $(obj).addClass("active");
        if(flag==1&& $(obj).parent().attr("id")=="type_two1_content"){
           $(obj).attr("onclick","quxiaoChoice("+type_one+",this)");
         }else{
           $(obj).attr("onclick","");
         }
        getProductData(type_one);
    }
    
    function quxiaoChoice(type_one,obj){
         $(obj).attr("onclick","typeChoice("+type_one+",this)").removeClass("active");
        getProductData(type_one);
    }
    
    /**
     *获取商品数据
     */
    function getProductData(type_one){
       
       var type_two1= $("#type_two1_content .active").length==0?0:$("#type_two1_content .active").attr("twoid");
       var type_two2= $("#type_two2_content .active").length==0?0:$("#type_two2_content .active").attr("twoid");
       var type_two3= $("#type_two3_content .active").length==0?0:$("#type_two3_content .active").attr("twoid");
    
       var url = "productGetByType-"+type_one+"-"+type_two1+"-"+type_two2+"-"+type_two3+".html" ;
        $.ajax({
					type : "GET",
					contentType : "application/json",
					url : url,
					data : "",
					dataType : "json",
					success : function(json) {
						if (json.response =="success") {
						      $("#car_number").val(1);
						     if(json.isLogin){
						         if(json.product.price==0){
						             $("#addToOrder").text("立即咨询");
						            $("#addToCar").attr("onclick","carSave(160)");  
						             $("#addToOrder").attr("onclick","alert('暂未开通')");
						           }else{
						             $("#addToOrder").text("立即申请");
						             $("#addToCar").attr("onclick","carSave("+json.product.id+")"); 
						             $("#addToOrder").attr("onclick","orderSave("+json.product.id+")");
						           }
						        if(json.isCollect){//点击取消收藏
						           $(".collect").css({
								        backgroundColor: "#f2f2f2"
								    });
								    $(".collect_pic img").attr("src","<%=basePath%>frontpage/images/y_star.png");
								    $(".collect p").text("取消").css({
								        color: "#cccccc"
								    });
								    $("#collect_btn").addClass("collect_ed").removeClass("collect");  
						           $("#collect_btn").attr("onclick","collectSave("+json.product.id+",0)");
						        }else{//点击收藏
						           $(".collect_ed").css({
								        backgroundColor: "#ff9900"
								    });
								    $(".collect_pic img").attr("src","<%=basePath%>frontpage/images/w_star.png");
								    $(".collect_ed p").text("收藏").css({
								        color: "#ffffff"
								    });
								    $("#collect_btn").addClass("collect").removeClass("collect_ed");
						            $("#collect_btn").attr("onclick","collectSave("+json.product.id+",1)");
						        }
						     }else{//点击跳转登录
						        $("#collect_btn").attr("onclick","gotoLogin()"); 
						        $("#addToCar").attr("onclick","gotoLogin()"); 
						        $("#addToOrder").attr("onclick","gotoLogin()"); 
						     }
						
		                     $("#product_name").text(json.product.name);
		                     $('#product_image').attr('src',json.product.logo);
		                     if(json.product.price==0){
		                       $("#product_price").attr("price",json.product.price);
		                       $("#product_price").text("");
		                     }else{
		                       $("#product_price").attr("price",json.product.price);
		                       $("#product_price").text("￥"+parseFloat(json.product.price));
		                     }
		                     $("#product_tag").html(json.product.tag);
		                     $("#product_description").html(json.product.description);
		                     $("#product_problem").html(json.product.problem);
							} else {
							    $("#product_price").attr("price",-1);
							    $("#product_price").text("");
							    $("#addToOrder").text("立即咨询");
								$("#addToCar").attr("onclick","carSave(160)"); 
						        $("#addToOrder").attr("onclick","alert('暂未开通');");
							}
					}
				});
       
    }
    
    /**
     *收藏商品/取消收藏 collect_status 0 取消 1收藏
     */
    function collectSave(product_id,collect_status){
         var url = "productCollectSave-"+product_id+"-"+collect_status+".html" ;
        $.ajax({
					type : "GET",
					contentType : "application/json",
					url : url,
					data : "",
					dataType : "json",
					success : function(json) {
						if (json.response =="success") {
						       if(collect_status==0){
						          $(".collect_ed").css({
								        backgroundColor: "#ff9900"
								    });
								    $(".collect_pic img").attr("src","<%=basePath%>frontpage/images/w_star.png");
								    $(".collect_ed p").text("收藏").css({
								        color: "#ffffff"
								    });
								    $("#collect_btn").addClass("collect").removeClass("collect_ed");
								    $("#collect_btn").attr("onclick","collectSave("+product_id+",1)");
						       }else{
						           $(".collect").css({
								        backgroundColor: "#f2f2f2"
								    });
								    $(".collect_pic img").attr("src","<%=basePath%>frontpage/images/y_star.png");
								    $(".collect p").text("取消").css({
								        color: "#cccccc"
								    });
								    $("#collect_btn").addClass("collect_ed").removeClass("collect");
								    $("#collect_btn").attr("onclick","collectSave("+product_id+",0)");
						       }
							}else{
								alert(json.msg);
							}
					}
				});
    }
    /**
     *跳转登录
     */
    function gotoLogin(){
       location.href="login.html";
    }
    
    /**
     *加入购物车
     */
    function carSave(product_id){
 			var url = "productCarSave.html" ;
 			var number=$("#car_number").val();
 			
 			var productList =[];
			var product;
			product=new Product(product_id,number);
			productList.push(product);
			var jsondata={"productList":productList};
        $.ajax({
					type : "POST",
					contentType : "application/json",
					url : url,
					data : JSON.stringify(jsondata),
					dataType : "json",
					success : function(json) {
						if (json.response =="success") {
						        $("#car_num").text(json.car_num);
						        alert("加入购物车成功");
							}else{
								alert(json.msg);
							}
					}
				});      
    }

	
    
    /**
     *跳转提交订单页面
     */
    function orderSave(product_id){
        var number=$("#car_number").val();
        var url = "productOrderAdd-"+product_id+"-"+number+".html" ;
		location.href=url;
    }
    
    
    
    
</script>
</body>
</html>