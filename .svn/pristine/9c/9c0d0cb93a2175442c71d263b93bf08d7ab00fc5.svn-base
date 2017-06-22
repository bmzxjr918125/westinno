<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/page/include/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>WESTINNO管理系统</title>
</head>

<body class="withvernav">
	<div class="bodywrapper">
		<!--topheader引入-->
		<jsp:include page="/WEB-INF/page/include/topheader.jsp" />
		<jsp:include page="/WEB-INF/page/include/header.jsp" />
		<jsp:include page="/WEB-INF/page/include/vernav2iconmenu.jsp" />

		<div class="centercontent">
			<div id="contentwrapper" class="contentwrapper">
				<div class="contenttitle2">
					<h3>用户列表</h3>
				</div>
				<table cellpadding="0" cellspacing="0" border="0" id="usertable"
					class="stdtable stdtablecb">
					<colgroup>
						<col class="con0" style="width: 4%" />
						<col class="con0" />
						<col class="con1" />
						<col class="con1" />
						<col class="con0" />
						<col class="con1" />
						<col class="con0" />
						<col class="con0" />
					</colgroup>
					<thead>
						<tr>
							<th class="head0 center" style="width:4%"><input
								type="checkbox" class="checkall" />
							</th>
							<th class="head0 center" >昵称</th>
							<th class="head1 center" >联系电话</th>
							<th class="head0 center" >性别</th>
							<th class="head1 center" >电子邮箱</th>
							<th class="head0 center" >QQ</th>
							<th class="head1 center" >完善资料</th>
							<th class="head0 center" >创建时间</th>
							<th class="head0 center" >上次登录时间</th>
							<th class="head1 center" >操作</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			<!--contentwrapper-->

		</div>
		<!-- centercontent -->
	</div>
	<!--bodywrapper-->
</body>
</html>

<script type="text/javascript" src="js/pack/datatables-pack.js"></script>
<script type="text/javascript">
	//控制当前全中的menu项
	var current = document.getElementById("userli1");
	current.parentNode.parentNode.className = "current";
	current.className = "current";
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
		clearNotify();
	}
	var table = jQuery('#usertable');
	jQuery(document).ready(
					function() {

						var reqData = {};

						var columns = [
								{
									'data' : null,
									'sClass' : "center",
									'render' : function(data, type, full) {
										var content = '<div class="checker"><span>';
										content += '<input class="check" type="checkbox" value="'+full.id+'">';
										content += '</span></div>';
										return content;
									},
									'orderable' : false
								},
								{
									'data' : 'nickname',
									'sClass' : "center"
								},
								{
									'data' : 'phonenum',
									'sClass' : "center"
								},
								{
									'data' : 'sex',
									'sClass' : "center",
									'render':function(data,type,full){
										return data == 1 ? '男' : data == 2 ? '女' : '其他'; 
									}
								},
								{
									'data' : 'e_mail',
									'sClass' : "center"
								},
								{
									'data' : 'qq',
									'sClass' : "center"
								},
								{
									'data' : 'is_complete',
									'sClass' : "center",
									'render':function(data,type,full){
										return data == 1 ? "是" : "否";
									}
								},
								{
									'data' : 'creattime',
									'sClass' : "center",
									'render' : function(data, type, full) {
										if (data != null) {
											return data.replace(/\T/g,' ');//UnixToDate(data.time,false,"")
										} else {
											return "-.-.-";
										}
									}
								},
								{
									'data' : 'lastlogintime',
									'sClass' : "center",
									'render' : function(data, type, full) {
										if (data != null) {
											return data.replace(/\T/g,' ');//UnixToDate(data.time,false,"")
										} else {
											return "-.-.-";
										}
									}
								},
								{
									'data' : null,
									'sClass' : "center",
									'render' : function(data, type, full) {
										var content = "<button class='stdbtn' onclick=\"location.href='manage/newsAdd.action?news_id="
												+ full.id
												+ "&flag=2"
												+ "'\" >编辑</button>&nbsp;"
												+ "<button class='stdbtn' onclick='newsDelete("
												+ full.id + ")' >删除</button>";

										return "";
									},
									'orderable' : false
								} ];

						var order = [ [ 5, "desc" ] ];

						var oTable = DataTablePack.serverTable(table,
								'manage/userAjaxShow.action', reqData, columns,
								order, 0);
					});

	//删除新闻
	function newsDelete(id) {
		var url = 'manage/newsDelete.action?news_id=' + id;
		jQuery.ajax({
			type : 'GET',
			contentType : 'application/json',
			url : url,
			data : '',
			dataType : 'json',
			success : function(json) {
				if (json.response =="success") {

					jQuery.jGrowl(json.msg, {
						position : "center",
						theme : "jGrowlSuccess"
					});
					table.fnDraw();
				} else {
					jQuery.jGrowl(json.msg, {
						sticky : true,
						position : "center",
						theme : "jGrowlErorr"
					});
				}
			}
		});
	}
</script>
