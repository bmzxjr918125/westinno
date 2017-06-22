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
					<h3>订单列表</h3>
				</div>
				<table cellpadding="0" cellspacing="0" border="0" id="ordertable"
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
							<th class="head1 center" >订单编号</th>
							<th class="head0 center" >订单名称</th>
							<th class="head1 center" >订单价格(￥)</th>
							<th class="head0 center" >用户昵称</th>
							<th class="head1 center" >用户手机号</th>
							<th class="head0 center" >创建时间</th>
							<th class="head1 center" >状态</th>
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
									'data' : 'ordernum',
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
									'data' : 'user_id.nickname',
									'sClass' : "center"
								},
								{
									'data' : 'user_id.phonenum',
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
									'data' : 'status',
									'sClass' : "center",
									'render':function(data,type,full){
										switch(data){
											case 1:
												return '待完善个人资料';
											case 2:
												return '待审核';
											case 3:
												return '待付款';
											case 4:
												return '未通过';
											case 5:
												return '已付款';
											case 6:
												return '已完成';
											case 7:
												return '已取消';
											case 8:
												return '已关闭';
											default:
												return '其他';
										}
									}
								},
								{
									'data' : null,
									'sClass' : "center",
									'render' : function(data, type, full) {
										var content = "<a class='stdbtn' style='font-size:12px;' href='manage/orderItemShow.action?order_id="+full.id+"'>详情</a>&nbsp;";
										if(full.status < 5){
											content += "<a class='stdbtn' style='font-size:12px;' href='javascript:editPrice("+full.id+")'>改价</a>&nbsp;";
										}
										if(full.status == 2){
											content += "<a class='stdbtn' style='font-size:12px;' href='javascript:orderCheckPass("+full.id+");' >审核通过</a>&nbsp;";
											content += "<a class='stdbtn' style='font-size:12px;' href='javascript:orderCheck("+full.id+",2,0);' >审核不通过</a>&nbsp;";
										}
										switch(full.status){
											case 1:
											case 2:
											case 3:
											case 4:
												content += "<a class='stdbtn' style='font-size:12px;' href='javascript:orderClose("+full.id+");' >关闭</a>&nbsp;";
												break;
										}
										if(full.status == 5){
											content += "<a class='stdbtn' style='font-size:12px;' href='javascript:orderFinish("+full.id+");' >完成</a>";
										}

										return content;
									},
									'orderable' : false
								} ];

						var order = [ [ 6, "desc" ] ];

						var oTable = DataTablePack.serverTable(table,
								'manage/orderAjaxShow.action', reqData, columns,
								order, 0);
					});

	//审核通过
	function orderCheckPass(order_id){
		jQuery.ajax({
			type : 'GET',
			contentType : 'application/json',
			url : 'manage/teamGetTeam.action',
			data : '',
			dataType : 'json',
			success : function(json) {
				//alert(JSON.stringify(json));
				if (json.teamList == null) {
					alert('未查询到客服 ');
				} else {
					var content = '<select id="popup_prompt">';
					jQuery.each(json.teamList,function(i,item){
						content += '<option value="'+item.id+'">'+item.name+'</option>';
					});
					content += '</select>';
					
					jPrompt('请选择客服人员:', '', '客服人员', function(r) {
						if(r){
							//alert(r);
							orderCheck(order_id,1,r);
						}
					});
					jQuery('#popup_prompt').remove();
					jQuery('#popup_message').append(content);
					var con = jQuery('#popup_message').html();
					con = con.replace('<br>','');
					jQuery('#popup_message').html(con);
				}
			}
		});
	}
	
	//审核
	function orderCheck(order_id,status,team_id) {
		var url = 'manage/orderCheck.action?order_id=' + order_id+'&status='+status+'&team_id='+team_id;
		jQuery.ajax({
			type : 'GET',
			contentType : 'application/json',
			url : url,
			data : '',
			dataType : 'json',
			success : function(json) {
				//alert(JSON.stringify(json));
				if (json.code == 1) {
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
	
	//关闭
	function orderClose(order_id) {
		var url = 'manage/orderClose.action?order_id=' + order_id;
		jQuery.ajax({
			type : 'GET',
			contentType : 'application/json',
			url : url,
			data : '',
			dataType : 'json',
			success : function(json) {
				//alert(JSON.stringify(json));
				if (json.code == 1) {
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
	
	//完成
	function orderFinish(order_id) {
		var url = 'manage/orderFinish.action?order_id=' + order_id;
		jQuery.ajax({
			type : 'GET',
			contentType : 'application/json',
			url : url,
			data : '',
			dataType : 'json',
			success : function(json) {
				//alert(JSON.stringify(json));
				if (json.code == 1) {
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
	
	//改价
	function editPrice(order_id){
		jPrompt('请输入修改价格:', '', '修改价格', function(r) {
			if( r ) { 
				if(isNaN(r)) {
					alert('请输入正确的数字');
					return ;
				}
		
				var url = 'manage/orderEditPrice.action?order_id=' + order_id+'&price='+r;
				
				jQuery.ajax({
					type : 'GET',
					contentType : 'application/json',
					url : url,
					data : '',
					dataType : 'json',
					success : function(json) {
						//alert(JSON.stringify(json));
						if (json.code == 1) {
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
		});
	  }
</script>
