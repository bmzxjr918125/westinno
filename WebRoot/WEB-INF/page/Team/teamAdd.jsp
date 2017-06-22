<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--公共头文件引入-->
<%@ include file="/WEB-INF/page/include/include.inc.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>WESTINNO管理系统</title>
<script type="text/javascript"
	src="<%=basePath%>ueditor/ueditor.config.js"></script>
<script type="text/javascript"
	src="<%=basePath%>ueditor/ueditor.all.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>ueditor/lang/zh-cn/zh-cn.js"></script>
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
								<li><a onclick="history.go(-1);" href="javascript:void(0);">返回</a>
								</li>
								<c:if test="${flag eq 1}">
								  <li>添加</li>
								</c:if>
								<c:if test="${flag eq 2}">
								  <li>修改</li>
								</c:if>
							</ul>
					<c:choose>
						<c:when test="${flag eq 1}">
							<div class="contenttitle2">
								<h3>客服添加</h3>
							</div>
						</c:when>
						<c:otherwise>

							<div class="contenttitle2">
								<h3>客服修改</h3>
							</div>
						</c:otherwise>
					</c:choose>
					<form class="stdform stdform2" enctype="multipart/form-data"
						id="teamAddForm" method="post" action="manage/teamAddSava.action?flag=${flag}&team_id=${we_Team.id}">
						<input type="hidden" name="we_Team.id" value="${we_Team.id}" />
						<input type="hidden" name="we_Team.logo" value="${we_Team.logo}" />
						<input type="hidden" name="we_Team.creattime" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${we_Team.creattime}" />" />
						<p>
							<label>客服名称<span class="inputrequiredflag">*</span> </label> <span
								class="field"><input type="text" placeholder="请输入 客服名称"
								value="${we_Team.name}" style="width:600px;" name="we_Team.name"
								id="we_Team.name" required /> </span>
						</p>
						
						<p>
							<label>客服头像<span class="inputrequiredflag">*</span> </label> <label
								class="field" style="display: none;"> <input type="file"
								name="file1" id="file1" value="../${we_Team.logo}" multiple
								accept="image/*" onchange="handleFiles(this,1)">
							</label>
							<c:choose>
								<c:when test="${we_Team.logo eq null}">
									<span class="field"> <img id="img1"
										src="images/Add_Image.png" onclick="upImage(1)" height="200px" width="200px">
									</span>

								</c:when>
								<c:otherwise>

									<span class="field"><img id="img1"
										src="../${we_Team.logo}" height="200px" width="200px"  onclick="upImage(1)">
									</span>
								</c:otherwise>
							</c:choose>
						</p>
						
						<p>
                        	<label>QQ</label>
                            <span class="field">
                            	<input type="text" name="we_Team.qq" id="team_qq" style="width:600px;"  value="${we_Team.qq}" />
                            	<span style="color: red">*</span>
                            </span>

                        </p>
						<p>
                        	<label>电话</label>
                            <span class="field">
                            	<input type="text" name="we_Team.phonenum" style="width:600px;" id="team_phonenum"  value="${we_Team.phonenum}" />
                            	<span style="color: red">*</span>
                            </span>

                        </p>
						<p>
                        	<label>邮箱</label>
                            <span class="field">
                            	<input type="text" name="we_Team.e_mail" style="width:600px;" id="team_e_mail" value="${we_Team.e_mail}" />
                            	<span style="color: red">*</span>
                            </span>

                        </p>

						<p class="stdformbutton">
							<button class="submit radius2" id="submit_sava"
								onclick="validate();">保存</button>
							<!-- <input class="reset radius2" type="reset" onclick="" value="重置"> -->
						</p>
						<input type="submit" id="submit_sava" style="display: none;" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript" src="js/validateMethod.js"></script>
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
		//ajax 清除session
		clearNotify();
	}
    jQuery('#news_tag').tagsInput(
    {
         'minChars' : 1,
         'maxChars' : 5,
         'onChange':function(input,tag){
	      if(jQuery('.tag').length>4){
	          jQuery.jGrowl("最多添加4个标签", {
				sticky : true,
				position : "center",
				theme : "jGrowlErorr"
			});
			jQuery('#news_tag').removeTag(tag);
	      }
	    },
    }
    );



	window.URL = window.URL || window.webkitURL;

	function upImage(ff) {
		jQuery("#file" + ff).click();
	}

	function handleFiles(obj, flag) {

		var files = obj.files, img = new Image();
		if (window.URL) {
			if (files[0].size > 4194304) {
				alert("图片大小请不要超过4M");
				return false;
			}
			jQuery("#img" + flag).attr("src",
					window.URL.createObjectURL(files[0]));
			jQuery("#img" + flag).onload = function(e) {
				window.URL.revokeObjectURL(this.src); //图片加载后，释放object URL
			}

		} else if (window.FileReader) {
			var reader = new FileReader();
			reader.readAsDataURL(files[0]);
			reader.onload = function(e) {
				if (e.total > 4194304) {
					alert("图片大小请不要超过4M");
					return false;
				}
				jQuery("#img" + flag).attr("src", this.result);
			}
		} else {
			//ie
			obj.select();
			obj.blur();
			var nfile = document.selection.createRange().text;
			document.selection.empty();
			jQuery("#img" + flag).attr("src", this.nfile);
			jQuery("#img" + flag).onload = function() {
				if (jQuery("#img" + flag).fileSize > 4194304) {
					alert("图片大小请不要超过4M");
					return false;
				}
			}

		}
	}

	function validate() {
		var file1 = jQuery("#file1").val();
		var new_title = jQuery("#we_News.title").val();
		var editor = jQuery("#editor").val();

		/* 		if (file1 == "") {
		 alert("请选择封面照片");
		 return false;
		 } */
		if (new_title == "") {
			alert("新闻标题不能空");
			return false;
		}
		if (editor == "") {
			alert("新闻内容不能为空");
			return false;
		}
		jQuery("#submit_sava").click();
	}
</script>

</html>
