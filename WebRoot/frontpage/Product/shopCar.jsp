<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--公共头文件引入-->
<%@ include file="/frontpage/html.inc.jsp"  %>
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>购物车</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/css/shop_car.css"/>
</head>
<body>

<!--顶部导航、登入等操作-->
<jsp:include page="../include/head.jsp" />

<div class="main">
    <div class="content">
        <div class="member_top">
            <img src="<%=basePath%>frontpage/images/shop_car.png" alt=""/>
            <span>我的购物车</span>
        </div>
        <div class="shop_main">
            <div class="shop_bar">
                <div class="goods_info goods_name">
                    <span>服务名称</span>
                </div>
                <div class="goods_info unit_price">
                    <span>单价(￥)</span>
                </div>
                <div class="goods_info goods_num">
                    <span>数量</span>
                </div>
                <div class="goods_info total">
                    <span>合计</span>
                </div>
                <div class="goods_info operate">
                    <span>操作</span>
                </div>
            </div>
            <div class="shop_content" style="min-height: 120px;">
                <c:if test="${empty jsonData.carList}">
                   <div style="text-align: center;">
                	<span style="color: #ccc; line-height: 120px;">购物车空空如也~~</span>
                   </div>
                </c:if>
                <c:if test="${!empty jsonData.carList}">
                 <c:forEach items="${jsonData.carList}" var="car">
                      <div class="shop_list">
	                    <div class="shop_list_left goods_info_list">
	                        <div class="shop_list_pic">
	                            <img src="<%=basePath%>frontpage/images/collect.png" alt=""/>
	                        </div>
	                        <div class="shop_list_name">
	                            <span>${car.product_id.name}</span>
	                        </div>
	                    </div>
	                    <div class="price_num goods_info_list">
	                        <span>
	                           <c:if test="${car.product_id.price eq 0}">
	                                                            联系客服
	                           </c:if>
	                           <c:if test="${car.product_id.price ne 0}">
	                              <fmt:formatNumber value="${car.product_id.price}" pattern='#,##.00'/>
	                           </c:if>
	                        </span>
	                    </div>
	                    <div class="num goods_info_list">
	                        <div class="num_main">
	                            <img class="reduce_pic" src="<%=basePath%>frontpage/images/u111.png" onclick="changeNumber(-1,this,${car.id})" alt=""/>
	                            <input type="text" value="${car.number}" readonly="readonly" placeholder="1"/>
	                            <img class="add_pic" src="<%=basePath%>frontpage/images/u109.png" onclick="changeNumber(1,this,${car.id})" alt=""/>
	                        </div>
	                    </div>
	                    <div class="total_num goods_info_list">
	                           <c:if test="${car.product_id.price eq 0}">
	                                                            联系客服
	                           </c:if>
	                           <c:if test="${car.product_id.price ne 0}">
	                              <fmt:formatNumber value="${car.product_id.price*car.number}" pattern='#,##.00'/>
	                           </c:if>
	                    </div>
	                    <div class="operate_pic goods_info_list delete_btn" onclick="deleteCar(${car.id});">
	                        <img src="<%=basePath%>frontpage/images/cancel.png" alt=""/>
	                    </div>
	                </div>
                 </c:forEach>
                </c:if>
            </div>
            <div class="total_money">
                <button class="orange_btn_9 accounts_btn" onclick="location.href='productCarToOrderAdd.html'">去结账</button><i id="totalprice"><fmt:formatNumber value="${jsonData.totalprice}" pattern='#,##.00'/></i><span>金额合计(￥):</span>
            </div>
        </div>
    </div>
</div>

<div class="gap"></div>

<!--快速注册-->
<%-- <div class="register_soon_main">
    <div class="register_soon">
        <div class="login_head">
            <span>快速注册</span>
            <div class="cancel_pic">
                <img src="<%=basePath%>frontpage/images/cancel.png" alt=""/>
            </div>
        </div>
        <form action="">
            <div class="register_content">
                <div class="login_inp">
                    <div class="login_inp_list">
                        <div class="login_icon">
                            <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                        </div>
                        <div class="input_main">
                            <input type="text" placeholder="输入手机号码"/>
                        </div>
                    </div>
                </div>
                <div class="inp_test">
                    <div class="login_inp_list">
                        <div class="login_icon">
                            <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                        </div>
                        <div class="input_main">
                            <input type="text" placeholder="输入手机号码"/>
                        </div>
                    </div>
                    <div class="test_pic">
                        <img src="<%=basePath%>frontpage/images/u26(1).png" alt=""/>
                    </div>
                </div>
                <div class="test_btn">
                    <div class="gray_btn_9 btn_moni">
                        <span>获取短信验证码</span>
                    </div>
                </div>
                <div class="login_inp">
                    <div class="login_inp_list">
                        <div class="login_icon">
                            <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                        </div>
                        <div class="input_main">
                            <input type="text" placeholder="输入您收到的手机验证码"/>
                        </div>
                    </div>
                </div>
                <div class="login_inp">
                    <div class="login_inp_list">
                        <div class="login_icon">
                            <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                        </div>
                        <div class="input_main">
                            <input type="password" placeholder="设置账户密码"/>
                        </div>
                    </div>
                </div>
                <div class="login_btn">
                    <button class="orange_btn_9">立即注册</button>
                </div>
                <div class="register_dic">
                    <span>点击“立即注册”，表示您同意并愿意遵守</span><a href="javascript:;">《WESTINNO服务协议》</a>
                </div>
            </div>
        </form>
    </div>
</div> --%>

<!--底部链接-->
<jsp:include page="../include/foot.jsp" />

<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/common.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/shop_car.js"></script>
<script type="text/javascript">
    function deleteCar(car_id){
      location.href="productCarDelete-"+car_id+".html";    
    }
    function changeNumber(type,obj,car_id){
         var number= Number($(obj).parent().find("input").val());
         if((number+type)>0){
           var url="";
             if(type==-1){
               url = "productCarChangeNumber-2-"+car_id+".html" ;
             }else{
               url = "productCarChangeNumber-1-"+car_id+".html" ;
             }
           
           $.ajax({
					type : "POST",
					contentType : "application/json",
					url : url,
					data : '',
					dataType : "json",
					success : function(json) {
						if (json.response =="success") {
						       $(obj).parent().find("input").val(json.number);
						       $(obj).parent().parent().parent().find(".total_num").text(json.numberprice);
						       $("#totalprice").text(json.totalprice);
							}else{
								alert(json.msg);
							}
					}
				}); 
         }else{
           return false;
         }
    }
    
    $(document).ready(function(){
        var doc=document,inputs=doc.getElementsByTagName('input'),supportPlaceholder='placeholder'in doc.createElement('input'),placeholder=function(input){var text=input.getAttribute('placeholder'),defaultValue=input.defaultValue;
            if(defaultValue==''){
                input.value=text}
            input.onfocus=function(){
                if(input.value===text){this.value=''}};
            input.onblur=function(){if(input.value===''){this.value=text}}};
        if(!supportPlaceholder){
            for(var i=0,len=inputs.length;i<len;i++){var input=inputs[i],text=input.getAttribute('placeholder');
    if(input.type==='text'&&text){placeholder(input)}}}});
</script>
</body>
</html>
