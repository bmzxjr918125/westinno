<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--公共头文件引入-->
<%@ include file="/WEB-INF/page/include/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
	<title>WESTINNO管理系统</title>
	<style type="text/css">
.checkStatus1N {
	border-bottom-color: red !important;
	border-width: 2px !important;
}

.checkStatus1Y {
	border-bottom-color: #59bf04 !important;
	border-width: 2px !important;
}

.checkStatus2N {
	border-color: red !important;
	border-width: 2px !important;
}

.checkStatus2Y {
	border-color: #59bf04 !important;
	border-width: 2px !important;
}

.field img {
	padding: 5px;
	border: 1px solid #ddd;
	border-radius: 2px;
	box-shadow: 0 1px 0 #eee;
	display: inline-block;
	max-height: 200px;
	max-width: 200px;
}
</style>
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
						<li>设置权限</li>
					</ul>
					
					<br />
					
					<div class="contenttitle2">
						<h3>设置权限</h3>
					</div>
					<!--contenttitle-->
					
					<br /><br />

					<form action="manage/adminUpdatePowerSave" method="post" class="stdform stdform2" id="adminUpdatePowerSaveForm">
						<input type="hidden" name="admin.id" value="${admin.id}" />
						<p style="border-top:1px solid #ddd">
							<label>用户名</label> 
							<span class="field"> 
								<input type="text" 
									   name="admin.username"
									   value="${admin.username}"
									   maxlength="24"
									   readonly="readonly"
									   style="width:200px;" />
							</span>
						</p>
						<p>
							<label>角色选择</label>
							<span class="field" style="width:500px;">
								<select name="admin.role_type">
                                    <option value="1" <c:if test="${admin.role_type == 1}">selected="selected"</c:if>>总经理</option>
                                    <option value="2" <c:if test="${admin.role_type == 2}">selected="selected"</c:if>>人事部</option>
                                    <option value="3" <c:if test="${admin.role_type == 3}">selected="selected"</c:if>>销售经理</option>
                                    <!-- <option value="4" <c:if test="${admin.role_type == 4}">selected="selected"</c:if>>普通员工</option> -->
                                </select>
							</span>
						</p>
						
                        <p class="stdformbutton">
                        	<button type="submit" id="uploadfiles" class="submit radius2">确认设置</button>
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
