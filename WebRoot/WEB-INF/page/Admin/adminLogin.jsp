<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/include/include.inc.jsp"  %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>后台登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=basePath%>css/style.default.css" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery-1.7.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery.cookie.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plugins/jquery.uniform.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/custom/general.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/custom/index.js"></script>
	<script type="text/javascript">
		function validate(){
			if(jQuery('#username').val() == '' || jQuery('#password').val() == '') {
				jQuery('.nousername').fadeIn();
				jQuery('.nopassword').hide();
				return false;
			}
		}
		setTimeout("jQuery('.nousername').html('')", 5000);
	</script>
  </head>
  ${notify}
	<body class="loginpage">
	    <div class="loginbox">
	    	<div class="loginboxinner">
	            <div class="logo">
	            	<h1 class="logo">WESTINNO.<span>Admin</span></h1>
					<span class="slogan">后台管理系统</span>
	            </div><!--logo-->

	            <br clear="all" /><br />
            	<div class="nousername">
					<div class="loginmsg">用户名不能为空.</div>
	            </div><!--nousername-->
	            <c:if test="${!empty notify}">
	            	<div class="nousername" style="display: block;">
						<div class="loginmsg">${notify.msg}</div>
		            </div><!--nousername-->
	            </c:if>
	            <div class="nopassword">
					<div class="loginmsg">密码不能为空.</div>
	                <div class="loginf">
	                    <div class="thumb"><img alt="" src="images/thumbs/avatar1.png" /></div>
	                    <div class="userlogged">
	                        <h4></h4>
	                      <!--   <a href="index.html">Not <span></span>?</a>  -->
	                    </div>
	                </div><!--loginf-->
	            </div><!--nopassword-->

	            <form id="login" action="<%=basePath%>manage/adminloginin.action" method="POST" onsubmit="return validate()">

	                <div class="username">
	                	<div class="usernameinner">
	                    	<input type="text" name="admin.username" id="username" />
	                    </div>
	                </div>

	                <div class="password">
	                	<div class="passwordinner">
	                    	<input type="password" name="admin.password" id="password" />
	                    </div>
	                </div>
	                <button>登录</button>
	               <!--  <div class="keep"><input type="checkbox" /> 记住密码</div> -->
	            </form>
	        </div>
	    </div>
	</body>
</html>
