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
					<h3>订单详情列表</h3>
				</div>
				<table cellpadding="0" cellspacing="0" border="0" id="ordertable"
					class="stdtable stdtablecb">
					<colgroup>
						<col class="con0" style="width: 4%" />
						<col class="con1" />
						<col class="con0" />
						<col class="con0" />
						<col class="con1" />
						<col class="con1" />
						<col class="con0" />
						<col class="con1" />
					</colgroup>
					<thead>
						<tr>
							<th class="head0 center" style="width:4%"><input
								type="checkbox" class="checkall" />
							</th>
							<th class="head0 center" >订单编号</th>
							<th class="head1 center" >产品编号</th>
							<th class="head1 center" >产品名称</th>
							<th class="head1 center" >商品名称</th>
							<th class="head0 center" >商品价格(￥)</th>
							<th class="head1 center" >商品数量</th>
							<th class="head0 center" >创建时间</th>
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
	<input type="hidden" id="hidden_order_id" value="${order_id}"/>
</body>
</html>

<script type="text/javascript" src="js/pack/datatables-pack.js"></script>
<script type="text/javascript">
	//控制当前全中的menu项
	var current = document.getElementById("orderli1");
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
	
	
	var table = jQuery('#ordertable');
	jQuery(document).ready(
					function() {

						var reqData = {"order_id":jQuery('#hidden_order_id').val()};

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
									'data' : 'order_id.ordernum',
									'sClass' : "center"
								},
								{
									'data' : 'product_id.id',
									'sClass' : "center"
								},
								{
									'data' : 'product_id.name',
									'sClass' : "center"
								},
								{
									'data' : 'name',
									'sClass' : "center"
								},
								{
									'data' : 'price',
									'sClass' : "center"
								},
								{
									'data' : 'number',
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
										return "<a class='stdbtn' style='font-size:12px;' href='javascript:history.go(-1);' >返回</a>";
									},
									'orderable' : false
								} ];

						var order = [ [ 6, "desc" ] ];

						var oTable = DataTablePack.serverTable(table,
								'manage/orderItemAjaxShow.action', reqData, columns,
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
