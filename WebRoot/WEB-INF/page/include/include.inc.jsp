<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <base href="<%=basePath%>">
    
    <title>WESTINNO管理系统</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" href="<%=basePath%>css/style.default.css" type="text/css" />
	<link rel="stylesheet" href="<%=basePath%>css/style.css" type="text/css" />
	<link rel="stylesheet" href="<%=basePath%>fonts/roboto.css" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery-1.7.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery.cookie.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery.flot.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery.flot.resize.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery.slimscroll.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/custom/general.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery.dataTables.1.10.8.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery.alerts.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.tagsinput.min.js"></script>
	<script type="text/javascript" src="js/custom/forms.js"></script>
	<script type="text/javascript" src="js/plugins/jquery.jgrowl.js"></script>
	<script type="text/javascript" src="js/method.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery.colorbox-min.js"></script>
  </head>
