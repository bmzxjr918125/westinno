<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--公共头文件引入-->
<%@ include file="/frontpage/html.inc.jsp"  %>
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>会员注册</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/css/register.css"/>
   <style>
     #jsForm label.error
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
            <form action="" id="jsForm">
                <div class="login_head">
                    <span>免费注册</span>
                </div>
                <div class="login_inp">
                    <div class="login_inp_list">
                        <div class="login_icon">
                            <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                        </div>
                        <div class="input_main">
                            <input  type="text" id="phoneNum" onkeyup="phoneChange(this)"  required="required" maxlength="11" name="phoneNum" placeholder="输入手机号码"/>
                        </div>
                    </div>
                </div>
              <%--   <div class="inp_test">
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
                </div> --%>
                <div class="test_btn" style="cursor: pointer;">
                	<div class="btn_moni gray_btn_9" id="sendCodeBtn" >
                		<span id="sendCodeSpan">获取短信验证码</span>
                	</div>
                </div>
                <div class="login_inp">
                    <div class="login_inp_list">
                        <div class="login_icon">
                            <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                        </div>
                        <div class="input_main">
                            <input type="text" maxlength="6"  id="phoneCode" name="phoneCode" placeholder="输入您收到的手机验证码"/>
                        </div>
                    </div>
                </div>
                <div class="login_inp">
                    <div class="login_inp_list">
                        <div class="login_icon">
                            <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                        </div>
                        <div class="input_main">
                            <input  type="password" minlength="6" maxlength="16" name="password" id="password" onpaste="return false;" placeholder="输入6-16位账户密码"/>
                        </div>
                    </div>
                </div>
               <!--  <input type="submit" style="display: none" id="hiddenSub"/> -->
                 <div class="login_btn">
                    <button class="orange_btn_9">立即注册</button>
                  </div>
            </form>
           
             <div class="register_dic">
                    <span>点击“立即注册”，表示您同意并愿意遵守</span><a href="registration_protocol.html" target="_blank">《WESTINNO服务协议》</a>
             </div>
             
             <button id="sendCodeCommit" style="display: none;" class="gray_btn_9">获取短信验证码</button>
             
        </div>
    </div>
</div>

<div class="copy">
    <span>© COPYRIGHT 东唐|EASTOW INNOVATION 蜀ICP备13019988号-1</span>
</div>

<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/common.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/register.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery-form.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.validate.min.js"></script>
<script type="text/javascript">
  $(function(){
    //jquery.validate
	$("#jsForm").validate({
	   rules: {
   
		   phoneNum: {
		         required: true,
		         maxlength: 11
		             },
		   phoneCode: {
		         required: true,
		         maxlength: 6
		             },
           password:{
                required: true,
                minlength: 6,
                maxlength: 16
                   }
             },      
      messages:{
		   phoneNum: {
			    required: "手机号码不能为空",
			    maxlength: "手机号码最大11位"
		             },
		   phoneCode: {
			    required: "验证码不能为空",
			    maxlength: "手机号码最大11位"
		             },
		   password:{
                required: "密码不能为空",
                minlength: "密码长度不能少于6个字符",
                maxlength: "密码长度不能超过16个字符"
                   }
             },
      submitHandler: function() {
			//验证通过后 的js代码写在这里
			var url="registerSave.html";
	 $("#jsForm").ajaxSubmit({
         //定义返回JSON数据，还包括xml和script格式
         dataType:'json',
         beforeSend: function() {
             
         },
         url: url,
         type: 'POST',
         success:function(json) {
        	if(json.response=="success") {
        		location.href="registerSuceess.html";
			}else if(json.response=="error"){
				 alert(json.msg);
			}
         }
     });
		}
    });
	});
	function phoneChange(obj){
	
	   var phonenum= $(obj).val();
	    if(phonenum.length==11){
	       $("#sendCodeBtn").removeClass("gray_btn_9").addClass("orange_btn_9");
	       $("#sendCodeBtn").attr("onclick","sendCode(this)");
	    }else{
	       $("#sendCodeBtn").removeClass("orange_btn_9").addClass("gray_btn_9");
	       $("#sendCodeBtn").attr("onclick","");
	    }
	}
	
	function sendCode(obj){
	    $(obj).removeClass("orange_btn_9").addClass("gray_btn_9");   
	   
	     var phonenum= $("#phoneNum").val();
	      if(phonenum.length==11){
	         $("#sendCodeSpan").text("验证码发送中..");   
	          var url = "sendCode-"+phonenum+".html" ;
				$.ajax({
					type : "GET",
					contentType : "application/json",
					url : url,
					data : "",
					dataType : "json",
					success : function(json) {
						if (json.response =="success") {
						    $("#sendCodeSpan").text("验证码已发送");
		                    setTimeout(function(){
						        $(obj).removeClass("gray_btn_9").addClass("orange_btn_9");
						        $("#sendCodeSpan").text("重新获取");
						    },80000);
						} else {
							alert(json.msg);
						}
					}
				});
	        }else{
	          alert("请正确填写手机号码");
	        }
	        
	    setTimeout(function(){
	        $(obj).removeClass("gray_btn_9").addClass("orange_btn_9");
	        $("#sendCodeSpan").text("重新获取");
	    },80000);
	}
	
</script>
</body>
</html>
