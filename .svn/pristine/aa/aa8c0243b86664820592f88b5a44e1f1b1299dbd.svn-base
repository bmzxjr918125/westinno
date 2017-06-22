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
					<h3>客服人员列表</h3>
				</div>
                <div class="tableoptions">
        				<a class="btn btn2 btn_book" href="manage/teamAdd.action?flag=1"><span>新增客服</span></a>
        		</div>
				<table cellpadding="0" cellspacing="0" border="0" id="teamtable"
					class="stdtable stdtablecb">
					<colgroup>
						<col class="con0" style="width: 4%" />
						<col class="con1" />
						<col class="con0" />
						<col class="con1" />
						<col class="con1" />
						<col class="con0" />
						<col class="con1" />
						<col class="con0" />
					</colgroup>
					<thead>
						<tr>
							<th class="head0 center" style="width:4%"><input
								type="checkbox" class="checkall" />
							</th>
							<th class="head1 center" style="width:5%">序号</th>
							<th class="head0 center" style="width:10%">头像</th>
							<th class="head1 center" style="width:20%">名称</th>
							<th class="head0 center" style="width:10%">qq</th>
							<th class="head1 center" style="width:15%">电话</th>
							<th class="head0 center" style="width:10%">邮箱</th>
							<th class="head0 center" style="width:10%">创建时间</th>
							<th class="head1 center" style="width:15%">操作</th>
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
	var current = document.getElementById("teamli1");
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
	var table = jQuery('#teamtable');
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
									'data' : 'id',
									'sClass' : "center"
								},
								{
									'data' : 'logo',
									'sClass' : "center",
									'render' : function(data, type, full) {
									   return "<img width='50px;' height='50px;' src='../"+data+"'/>";
									}
								},
								{
									'data' : 'name',
									'sClass' : "center"
								},
								{
									'data' : 'qq',
									'sClass' : "center"
								},
								{
									'data' : 'phonenum',
									'sClass' : "center"
								},
								{
									'data' : 'e_mail',
									'sClass' : "center"
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
									'data' : null,
									'sClass' : "center",
									'render' : function(data, type, full) {
										var content = "<button class='stdbtn' onclick=\"location.href='manage/teamAdd.action?team_id="
												+ full.id
												+ "&flag=2"
												+ "'\" >编辑</button>&nbsp;"
												+ "<button class='stdbtn' onclick='teamDelete("
												+ full.id + ")' >删除</button>";

										return content;
									},
									'orderable' : false
								} ];

						var order = [ [6, "desc" ] ];

						var oTable = DataTablePack.serverTable(table,
								'manage/teamGetData.action', reqData, columns,
								order, 0);
					});

	//删除客服
	function teamDelete(id) {
		var url = 'manage/teamDelete.action?team_id=' + id;
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
