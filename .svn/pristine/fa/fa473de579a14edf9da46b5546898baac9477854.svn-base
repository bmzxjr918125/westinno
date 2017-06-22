<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--公共头文件引入-->
<%@ include file="/frontpage/html.inc.jsp"  %>
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册成功</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/css/register_success.css"/>
</head>
<body>
<!--顶部导航、登入等操作-->
<jsp:include page="../include/head.jsp" />

<div class="login_main">
    <div class="content">
        <div class="success_pic">
            <img src="<%=basePath%>frontpage/images/u9.png" alt=""/>
        </div>
        <div class="success_tip1">
            <span>注册成功</span>
        </div>
        <div class="success_word">
            <p>感谢您注册成为WESTINNO会员，我们将竭诚为您提供最优质的知识产权、双创、项目申报等服务。再次感谢您的加入！</p>
            <p>系统将在 <span id="secend_span">10</span> 秒后跳转至会员中心</p>
        </div>
        <div class="success_tip">
            <span>温馨提示 : 只有在完善了您的个人信息后才能够在线下单哦！</span>
        </div>
        <div class="complete_info">
            <a href="javascript:;">立即完善</a>
        </div>
    </div>
</div>

<div class="copy">
    <span>© COPYRIGHT 东唐|EASTOW INNOVATION 蜀ICP备13019988号-1</span>
</div>

<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/common.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/register_success.js"></script>
<script type="text/javascript">
    jQuery(function(){
       var total=10;
        var iCount =setInterval(function(){
          total=total-1;
          if(total>0){
            jQuery("#secend_span").text(total);
          }else{
            //跳转
           location.href="memberCenter-1.html";
           clearInterval(iCount);
          }
       },1000);    
    });

</script>
</body>
</html>
