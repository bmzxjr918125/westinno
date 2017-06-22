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
<script type="text/javascript">
	UE.getEditor('editor');
</script>
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
								<h3>新闻添加</h3>
							</div>
						</c:when>
						<c:otherwise>

							<div class="contenttitle2">
								<h3>新闻修改</h3>
							</div>
						</c:otherwise>
					</c:choose>
					<form class="stdform stdform2" enctype="multipart/form-data"
						id="medicineAddForm" method="post" action="manage/newsAddSava.action?flag=${flag}&news_id=${we_News.id}">
						<input type="hidden" name="we_News.id" value="${we_News.id}" />
						<input type="hidden" name="we_News.image" value="${we_News.image}" />
						<input type="hidden" name="we_News.creattime" value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${we_News.creattime}" />" />
						<p>
							<label>新闻标题<span class="inputrequiredflag">*</span> </label> <span
								class="field"><input type="text" placeholder="请输入新闻标题"
								value="${we_News.title}" style="width:1024px;" name="we_News.title"
								id="we_News.title" required /> </span>
						</p>
						<p>
							<label>新闻类型<span class="inputrequiredflag">*</span> </label> <span
								class="field"> <select name="we_News_type" id="we_News.type"  class="uniformselect">
								<c:forEach var="type" items="${newsTypeList}">
								   <option <c:if test="${we_News.news_type_id.id eq type.id}" > selected="selected"</c:if> value="${type.id}">
									     ${type.name}
									</option>
								</c:forEach>
							</select> </span>
						</p>
						<p>
							<label>新闻速览<span class="inputrequiredflag">*</span> </label> <span
								class="field"><input type="text" placeholder="请输入新闻速览"
								value="${we_News.scan}" style="width:1024px;" name="we_News.scan"
								id="we_News.scan" required /> </span>
						</p>
						<p>
							<label>缩略图片<span class="inputrequiredflag">*</span> </label> <label
								class="field" style="display: none;"> <input type="file"
								name="file1" id="file1" value="../${we_News.image}" multiple
								accept="image/*" onchange="handleFiles(this,1)">
							</label>
							<c:choose>
								<c:when test="${we_News.image eq null}">
									<span class="field"> <img id="img1"
										src="images/Add_Image.png" onclick="upImage(1)" height="200px" width="200px">
									</span>

								</c:when>
								<c:otherwise>

									<span class="field"><img id="img1"
										src="../${we_News.image}" height="200px" width="200px"  onclick="upImage(1)">
									</span>
								</c:otherwise>
							</c:choose>
						</p>
						<p>
							<label>新闻推荐</label>
                            <span class="field formwrapper">
                            <c:if test="${empty we_News}">
                                <input type="radio" name="we_News.is_recommend" id="we_News.is_recommend_y" value="1"/> 是 &nbsp; &nbsp;
                            	<input type="radio" name="we_News.is_recommend" id="we_News.is_recommend_n" checked="checked" value="0" /> 否 &nbsp; &nbsp;
                            </c:if>
                            <c:if test="${we_News.is_recommend eq 0}">
                            	<input type="radio" name="we_News.is_recommend" id="we_News.is_recommend_y" value="1"/> 是 &nbsp; &nbsp;
                            	<input type="radio" name="we_News.is_recommend" id="we_News.is_recommend_n" checked="checked" value="0" /> 否 &nbsp; &nbsp;
                            </c:if>
                            <c:if test="${we_News.is_recommend eq 1}">
                            	<input type="radio" name="we_News.is_recommend" id="we_News.is_recommend_y" checked="checked" value="1"/> 是 &nbsp; &nbsp;
                            	<input type="radio" name="we_News.is_recommend" id="we_News.is_recommend_n"  value="0" /> 否 &nbsp; &nbsp;
                            </c:if>
                            </span>
						</p>
						<p>
							<label>新闻来源<span class="inputrequiredflag">*</span> </label> <span
								class="field"> <input type="text" placeholder="请输入新闻来源"
								value="${we_News.source}" style="width:1024px;" name="we_News.source"
								id="we_News.source" required /> </span>
						</p>
						<p>
                        	<label>新闻标签</label>
                            <span class="field">
                            	<input name="we_News.tag" id="news_tag" class="longinput" value="${we_News.tag}" />
                            	<span style="color: red">* 每个标签最多五个字符</span>
                            </span>

                        </p>

						<p>
							<label>新闻内容<span class="inputrequiredflag">*</span> </label> <span
								class="field"> <textarea id="editor" name="we_News.content"
									contenteditable="true">${we_News.content}</textarea> </span>
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
	var current = document.getElementById("newsli1");
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
