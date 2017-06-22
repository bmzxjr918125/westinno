<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--公共头文件引入-->
<%@ include file="/frontpage/html.inc.jsp"  %>
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>会员登录</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/css/login.css"/>
     <style>
     #loginForm label.error
		{
			width: 100%;
			position: absolute;
			left: 42px;
			top: 60px;
			color:Red;
			font-size:13px;
			margin-left:5px;
			padding-left:16px;
			background:url("error.png") left no-repeat;
		} 
   </style>
</head>
<body>
<!--顶部导航、登入等操作-->
<jsp:include page="../include/head.jsp" />

<div class="login_main">
    <div class="content">
        <div class="login_content">
            <form action=""  id="loginForm">
                <div class="login_head">
                    <span>会员登录</span>
                </div>
                <div class="login_inp">
                    <div class="login_inp_list">
                        <div class="login_icon">
                            <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                        </div>
                        <div class="input_main">
                            <input type="text" id="phoneNum" name="phoneNum" placeholder="输入手机号码或邮箱"/>
                        </div>
                    </div>
                    <div class="login_inp_list">
                        <div class="login_icon">
                            <img src="<%=basePath%>frontpage/images/pass.png" alt=""/>
                        </div>
                        <div class="input_main">
                            <input type="password" id="password" name="password" placeholder="输入账户密码"/>
                        </div>
                    </div>
                </div>
                <div class="auto_login">
                    <div class="auto_login_left">
                        <input type="checkbox"/><span>一周内自动登录</span>
                    </div>
                    <div class="auto_login_right">
                        <a href="register.html">立即注册</a>
                    </div>
                </div>
                <div class="login_btn">
                    <button class="orange_btn_9">立即登录</button>
                </div>
            </form>
            <div class="other_login">
                <div class="other_login_head">
                    <span>其他方式登录</span>
                </div>
                <div class="other_way">
                    <div class="other_way_list">
                        <img src="<%=basePath%>frontpage/images/u26.png" alt=""/>
                    </div>
                    <div class="other_way_list">
                        <img src="<%=basePath%>frontpage/images/u28.png" alt=""/>
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
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery-form.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/login.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.md5.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.validate.min.js"></script>
<script type="text/javascript">
  $(function(){
    //jquery.validate
	$("#loginForm").validate({
	   rules: {
		   phoneNum: {
		         required: true
		             },
           password:{
                required: true,
                minlength: 6,
                maxlength: 16
                   }
             },      
      messages:{
		   phoneNum: {
			    required: "手机号码不能为空"
		             },
		   password:{
                required: "密码不能为空",
                minlength: "密码长度不能少于6个字符",
                maxlength: "密码长度不能超过16个字符"
                   }
             },
      submitHandler: function() {
			//验证通过后 的js代码写在这里
			 
			 var url="loginSave.html";
			 var pass=$("#password").val();
			     $("#password").val("");
		 $("#loginForm").ajaxSubmit({
	         //定义返回JSON数据，还包括xml和script格式
	         dataType:'json',
	         data:{phoneNum:$("#phoneNum").val(),password_m:$.md5($.md5(pass).toUpperCase()).toUpperCase()},
	         beforeSend: function() {
	         },
	         url: url,
	         type: 'POST',
	         success:function(json) {
	        	if(json.response=="success") {
	        		 location.href="memberCenter-0.html";
				}else if(json.response=="error"){
					 alert(json.msg);
				}
	         }
	     });
		}
     });
	});

</script>
</body>
</html>
