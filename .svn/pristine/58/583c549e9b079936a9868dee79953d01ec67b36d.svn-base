<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--公共头文件引入-->
<%@ include file="/WEB-INF/page/include/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
	<title>WESTINNO管理系统</title>
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
						<li><a href="manage/adminShow">管理员列表</a></li>
						<li>新增管理员</li>
					</ul>
					
					<br />
					
					<div class="contenttitle2">
						<h3>新增管理员</h3>
					</div>
					<!--contenttitle-->
					
					<br /><br />

					<form action="manage/adminAddSave.action" method="post" class="stdform stdform2" id="adminForm">
						<p>
							<label>用户名</label> 
							<span class="field"> 
								<input type="text" 
									   name="admin.username"
									   maxlength="24"
									   style="width:200px;" />
							</span>
						</p>
						<p>
							<label>密码</label> 
							<span class="field">
								<input type="password" 
									   name="admin.password"
									   id="admin_password"
									   maxlength="24"
									   style="width:200px;height:33px;" /> 
							</span>
						</p>
						<p>
							<label>重复密码</label> 
							<span class="field"> 
								<input type="password"
									   name="echoPwd"
									   maxlength="24" 
									   style="width:200px;height:33px;"  />
							</span>
						</p>
						<p>
							<label>角色选择</label>
							<span class="field" style="width:500px;">
								<select name="admin.role_type">
                                    <option value="1">总经理</option>
                                    <option value="2">人事部</option>
                                    <option value="3">销售经理</option>
                                    <!-- <option value="4">普通员工</option> -->
                                </select>
							</span>
						</p>
						
                        <p class="stdformbutton">
                        	<button type="submit" id="uploadfiles" class="submit radius2">发布</button>
                        </p>
					</form>
				</div>
			</div>
		</div>
		<!-- centercontent -->

	</div>
	<!--bodywrapper-->

</body>
<script type="text/javascript">
//验证数据
jQuery("#adminForm").validate({
	rules:{
   		 'admin.username':{
   			 required: true,
   			 remote:'manage/adminCheckUnique.action',
   			 minlength: 6
   		 },
   		 'admin.password':{
   			 required: true,
   			 minlength: 6
   		 },
   		 'echoPwd':{
   			 required: true,
   			 minlength: 6,
   			 equalTo:'#admin_password'
   		 }
   	 },
   	 messages:{
   		 'admin.username':{
   			 required:'用户名不能为空!',
   			 minlength:'用户名最小长度为6个!',
   			 remote:'用户名重复，请重新输入!'
   		 },
   		 'admin.password':{
   			 required:'密码不能为空!',
   			 minlength:'密码最小长度为6个!'
   		 },
   		 'echoPwd':{
   			 required:'重复密码不能为空!',
   			 minlength:'重复密码最小长度为6个!',
   			 equalTo:'两次密码不相同!'
   		 }
   	 }
});

/**
 * 操作提示START
 */
if(""!="${notify}"&&"${notify.code}"!="0"){
//有操作提示
 //提示后自动消息
	if("${notify.code}"=="1"){
  		 jQuery.jGrowl("${notify.msg}",{position:"center",theme:"jGrowlSuccess"});
	}else if("${notify.code}"=="2"){
   		 jQuery.jGrowl("${notify.msg}",{sticky: true,position:"center",theme:"jGrowlErorr"});
	}else{
   		 jQuery.jGrowl("${notify.msg}",{sticky: true,position:"center",theme:"jGrowlWarning"});
	}
 	//ajax 清除session
	//clearNotify();
}  
/**
*END
*/
</script>
</html>
