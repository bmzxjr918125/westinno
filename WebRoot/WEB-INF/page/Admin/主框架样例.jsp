<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--公共头文件引入-->
<%@ include file="/WEB-INF/page/include/include.inc.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>邻邻后台管理系统</title>
</head>

<body class="withvernav">
<div class="bodywrapper">
     <!--topheader引入-->
     <jsp:include page="/WEB-INF/page/include/topheader.jsp" />
     <!--header引入-->
     <jsp:include page="/WEB-INF/page/include/header.jsp" />
     <!--vaernav2iconmenu引入-->
     <jsp:include page="/WEB-INF/page/include/vernav2iconmenu.jsp" />
    
   
       <!--右部类容--> 
    <div class="centercontent">
       <div id="contentwrapper" class="contentwrapper">
       
       </div>
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>
<script type="text/javascript">
   //控制当前全中的menu项
   var current=document.getElementById("sysli1");
   current.parentNode.parentNode.className="current";
   current.className="current";
</script>
</html>
