<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--公共头文件引入-->
<%@ include file="/frontpage/html.inc.jsp"  %>
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>确认订单</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/css/order_sure.css"/>
</head>
<body>

<!--顶部导航、登入等操作-->
<jsp:include page="../include/head.jsp" />


<div class="main">
    <div class="content">
        <div class="member_top">
            <img src="<%=basePath%>frontpage/images/shop_car.png" alt=""/>
            <span>确认订单</span>
        </div>
        <div class="shop_main">
            <div class="shop_bar">
                <div class="goods_info goods_name">
                    <span>商品名称</span>
                </div>
                <div class="goods_info unit_price">
                    <span>单价(￥)</span>
                </div>
                <div class="goods_info goods_num">
                    <span>数量</span>
                </div>
                <div class="goods_info total">
                    <span>合计(￥)</span>
                </div>
            </div>
            <div class="shop_content">
             <c:forEach items="${jsonData.productList}" var="product">
                <div class="shop_list">
                    <div class="shop_list_left goods_info_list">
                        <div class="shop_list_pic">
                            <img src="<%=basePath%>frontpage/images/collect.png" alt=""/>
                        </div>
                        <div class="shop_list_name">
                            <span>${product.name}</span>
                        </div>
                    </div>
                    <div class="price_num goods_info_list">
                        <span>${product.unitprice}</span>
                    </div>
                    <div class="num goods_info_list">
                        <span>${product.number}件</span>
                    </div>
                    <div class="total_num goods_info_list">
                        <span>${product.numberprice}</span>
                    </div>
                </div>
               </c:forEach>
            </div>
            <c:if test="${jsonData.flag eq 1}">
	            <div class="total_money">
	                <button onclick="orderSure(${jsonData.product.id},${jsonData.number})" class="orange_btn_9 accounts_btn">确认提交订单</button><i>${jsonData.totalprice}</i><span>金额合计(￥):</span>
	            </div>
            </c:if>
            <c:if test="${jsonData.flag eq 2}">
                <div class="total_money">
	                <button onclick="carOrderSure()" class="orange_btn_9 accounts_btn">确认提交订单</button><i>${jsonData.totalprice}</i><span>金额合计(￥):</span>
	            </div>
            </c:if>
        </div>
    </div>
</div>

<div class="gap"></div>
<!--加载图标-->
<div class="loading">
    <div class="loading_main">
        <div class="loading_pic">
            <img src="<%=basePath%>frontpage/images/loading.png" alt=""/>
        </div>
        <div class="loading_word">
            <span>订单生成中请稍候</span>
        </div>
    </div>
</div>
<!--立即付款-->
<div class="pay_now" style="display: none;">
    <div class="pay_now_main">
        <div class="order_cancel_head">
            <span class="orange_font">立即付款</span>
            <img class="cancel_btn" src="<%=basePath%>frontpage/images/cancel.png" alt=""/>
        </div>
        <div class="pay_now_content">
            <div class="pay_info">
                <div class="pay_info_list">
                    <div class="pay_info_list_left">
                        <span>商品名称：</span>
                    </div>
                    <div class="pay_info_list_right">
                        <span>${jsonData.product.name}</span>
                    </div>
                </div>
                <div class="pay_info_list">
                    <div class="pay_info_list_left">
                        <span>订单号：</span>
                    </div>
                    <div class="pay_info_list_right">
                        <span id="order_number"></span>
                    </div>
                </div>
                <div class="pay_info_list">
                    <div class="pay_info_list_left">
                        <span>金额(￥)：</span>
                    </div>
                    <div class="pay_info_list_right">
                        <span class="red_font" id="order_price">0.00</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="other_way">
            <div class="other_way_head">
                <span>您可以选择下列支付方式</span>
            </div>
            <div class="other_way_main">
                <div class="other_way_list">
                    <div class="way_pic">
                        <img src="<%=basePath%>frontpage/images/pay.png" alt=""/>
                    </div>
                    <div class="way_name">
                        <span>支付宝支付</span>
                    </div>
                </div>
                <div class="other_way_list">
                    <div class="way_pic">
                        <img src="<%=basePath%>frontpage/images/weixin.png" alt=""/>
                    </div>
                    <div class="way_name">
                        <span>微信支付</span>
                    </div>
                </div>
                <div class="other_way_list">
                    <div class="way_pic">
                        <img src="<%=basePath%>frontpage/images/bank.png" alt=""/>
                    </div>
                    <div class="way_name">
                        <span>银联支付</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="copy">
    <span>© COPYRIGHT 东唐|EASTOW INNOVATION 蜀ICP备13019988号-1</span>
</div>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/common.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/order_sure.js"></script>
<script type="text/javascript">
   /**
     *确认提交订单
     */
    function orderSure(product_id,number){
 			var url = "productOrderSave.html" ;
 			
 			var productList =[];
			var product;
			product=new Product(product_id,number);
			productList.push(product);
			var jsondata={"productList":productList};
			
			$(".gap").css({
		        display: "block"
		    });
		    $(".loading").css({
		        display: "block"
		    });
		   
			
        $.ajax({
					type : "POST",
					contentType : "application/json",
					url : url,
					data : JSON.stringify(jsondata),
					dataType : "json",
					success : function(json) {
						if (json.response =="success") {
						$(".loading").css({
				            display: "none"
				        });
				        
						       if(json.code==0){//未完成个人资料 跳转个人中心
						          $(".gap").css({
								        display: "none"
								    });
						         location.href="memberCenter-2.html";
						       }else if(json.code==1){//弹框付款
						        // $("#order_number").text(json.ordernum);
						         //$("#order_price").text(json.totalprice);
						        /*  $(".pay_now").css({
						            display: "block"
						         }); */
						         location.href="memberCenter-2.html";
						       }else if(json.code==2){//联系客户 跳转个人中心
						           $(".gap").css({
								        display: "none"
								    });
						          location.href="memberCenter-2.html";
						       }
						       
							}else{
								alert(json.msg);
							}
					}
				});      
    }
    
    function carOrderSure(){
       location.href="productCarOrderSure.html";
    
    }
    
   
</script>
</body>
</html>
