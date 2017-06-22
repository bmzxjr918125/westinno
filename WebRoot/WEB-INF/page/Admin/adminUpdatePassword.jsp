<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--公共头文件引入-->
<%@ include file="/WEB-INF/page/include/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
	<title>邻邻员工管理后台管理系统</title>
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
				<div id="validation" class="subcontent">
					<ul class="breadcrumbs">
						<li><a>管理员密码修改</a></li>
					</ul>

					<br />
					<div class="contenttitle2">
						<h3>密码修改</h3>
					</div>
					
					<br /><br />
					<!--contenttitle-->
					<form class="stdform stdform2" method="post" action="manage/adminUpdatePasswordSave" id="updatePasswordForm">
						<input type="hidden" name="admin.id" value="${admin.id}" />
						<p style="border-top:1px solid #ddd">
							<label>管理员帐号<span class="inputrequiredflag">*</span></label> 
							<span class="field"> 
								<input type="text" 
									   name="admin.username"
									   value="${admin.username}"
									   readonly="readonly"
									   style="width:200px;" />
							</span>
						</p>
						<p>
							<label>原密码<span class="inputrequiredflag">*</span></label> 
							<span class="field"> 
								<input type="password" 
									   name="oldPwd"
									   style="width:200px;height:33px;" />
							</span>
						</p>
						<p>
							<label>新密码<span class="inputrequiredflag">*</span></label> 
							<span class="field"> 
								<input type="password" 
									   name="admin.password"
									   id="admin_password"
									   style="width:200px;height:33px;" />
							</span>
						</p>
						<p>
							<label>重复密码<span class="inputrequiredflag">*</span></label> 
							<span class="field"> 
								<input type="password" 
									   name="echoPwd"
									   style="width:200px;height:33px;" />
							</span>
						</p>

						<p class="stdformbutton">
							<button type="submit" class="submit radius2">确定修改</button>
						</p>
					</form>
				</div>
			</div>
		</div>
		<!-- centercontent -->


	</div>
	<!--bodywrapper-->

</body>
<script type="text/javascript" src="js/validateMethod.js"></script>
<script type="text/javascript" src="js/method.js"></script>

<script type="text/javascript">

   //表单验证

jQuery("#updatePasswordForm").validate({
	rules : {
		"oldPwd" : {
			required : true,
			minlength : 6
		},
		"admin.password" : {
			required : true,
			minlength : 6
			//isPass : true
		},
		"echoPwd" : {
			required : true,
			minlength : 6,
			//isPass : true,
			equalTo:'#admin_password'
		}

	},
	messages : {
		"oldPwd" : {
			required : "请填写原密码！",
			minlength : "原密码不能小于6个字符！"
		},

		"admin.password" : {
			required : "请填写新密码！",
			minlength : "新密码不能小于6个字符！"
			//isPass : "只能输入8-16个字母、数字、下划线"
		},
		"echoPwd" : {
			required : "请填写重复密码！",
			minlength : "重复密码不能小于6个字符",
			//isPass : "只能输入8-16个字母、数字、下划线",
			equalTo:'两次密码不相同!'
		}
	}
});

	/**
	 * 操作提示START
	 */
	if ("" != "${notify}" && "${notify.code}" != "0") {
		//有操作提示
		//提示后自动消息
		if ("${notify.code}" == "1") {
			jQuery.jGrowl("${notify.msg}", {
				position : "center",
				theme : "jGrowlSuccess"
			});
		} else if ("${notify.code}" == "2") {
			jQuery.jGrowl("${notify.msg}", {
				sticky : true,
				position : "center",
				theme : "jGrowlErorr"
			});
		} else {
			jQuery.jGrowl("${notify.msg}", {
				sticky : true,
				position : "center",
				theme : "jGrowlWarning"
			});
		}
		//ajax 清除session
		//clearNotify();
	}
	/**
	 *END
	 */
</script>

</html>
