<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/page/include/include.inc.jsp"  %>
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

    <div class="centercontent tables">

       <!--  <div class="pageheader notab">
            <h1 class="pagetitle">Tables</h1>
            <span class="pagedesc">This is a sample description of a page</span>

        </div> --><!--pageheader-->

        <div id="contentwrapper" class="contentwrapper">
        		<div class="tableoptions">
        				<a class="btn btn2 btn_book" href="manage/adminAdd.action"><span>新增管理员</span></a>

        				<a class="btn btn2 btn_trash batchOp"
        				   href="manage/adminDeleteByBatch?ids={values}"
        				   title="你确定要删除这些管理员帐户么？|确认删除"><span>批量删除</span></a>
        		</div>
                <table cellpadding="0" cellspacing="0" border="0" class="stdtable stdtablecb" id="adminAjaxShow_Table">
                    <thead>
                        <tr>
                          <th class="head1 nosort" style="width:20px;"><input type="checkbox"  class="checkall"/></th>
                            <th class="head1">编号</th>
                            <th class="head1">账号</th>
                            <th class="head1" style="width:150px;">创建时间</th>
                            <th class="head1" style="width:150px;">修改时间</th>
                            <th class="head1">上次登录时间</th>
                            <th class="head1">本次登录时间</th>
                            <th class="head1">角色类型</th>
                            <th class="head1">操作</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
        </div><!--contentwrapper-->

	</div><!-- centercontent -->
</div><!--bodywrapper-->
</body>
</html>
<script type="text/javascript" src="js/pack/datatables-pack.js"></script>
<script type="text/javascript">
jQuery(document).ready(function(){

	var table = jQuery('#adminAjaxShow_Table');

	var reqData = {};

	var columns = [
	    {
	    	'data':null,
	    	'render':function(data,type,full){
	    		var content = '<div class="checker"><span>';
	    			content += '<input class="check" type="checkbox" value="'+full.id+'">';
	    			content += '</span></div>';
	    		return full.id == '${ADMIN.id}' ? '' : content;
	    	},
	    	'orderable':false
	    },
	    {'data':'id'},
	    {'data':'username'},
	    {
	    	'data':'creatTime',
	    	'render':function(data,type,full){
	    		return data != null ? data.replace(/\T/g,' ') : "-.-.-";
	    	}
	    },
	    {
	    	'data':'updateTime',
	    	'render':function(data,type,full){
	    		return data != null ? data.replace(/\T/g,' ') : "-.-.-";
	    	}
	    },
	    {
	    	'data':'lastLoginTime',
	    	'render':function(data,type,full){
	    		return data != null ? data.replace(/\T/g,' ') : "-.-.-";
	    	}
	   	},
	    {
	   		'data':'thisLoginTime',
	    	'render':function(data,type,full){
	    		return data != null ? data.replace(/\T/g,' ') : "-.-.-";
	    	}
	   	},
	    {
	   		'data':'role_type',
	   		'render':function(data,type,full){
	    		switch(data){
	    			case 0:
	    				return "超级管理员";
	    				break;
	    			case 1:
	    				return "总经理";
	    				break;
	    			case 2:
	    				return "人事部";
	    				break;
	    			case 3:
	    				return "销售经理";
	    				break;
	    			case 4:
	    				return "普通员工";
	    				break;
	    			default:
	    				return "角色错误";
	    				break;
	    		}
	    	}
	   	},
	    {
	    	'data':null,
	    	'render':function(data,type,full){
	    		var content = "<button class='stdbtn' onclick='location.href=\"manage/adminUpdatePower.action?admin.id="+full.id+"\"' >设置权限</button>";

	    		return full.id == '${ADMIN.id}' ? '' : content;
	    	},
	    	'orderable':false
	    }
	];

	var order = [[3,"desc"]];

	var oTable = DataTablePack.serverTable(table,'manage/adminAjaxShow.action',reqData,columns,order,0);
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
	 clearNotify();
}
/**
*END
*/
</script>
