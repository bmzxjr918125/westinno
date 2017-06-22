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
	UE.getEditor('editor1');
	UE.getEditor('editor2');
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
								  <li>修改</li>
							</ul>
							<div class="contenttitle2">
								<h3>商品修改</h3>
							</div>

					<form class="stdform stdform2" enctype="multipart/form-data"
						id="medicineAddForm" method="post" action="manage/productUpdateSave.action?product_id=${product.id}">
						<input type="hidden" name="product.id" value="${product.id}" />
						<input type="hidden" name="product.logo" value="${product.logo}" />
						<c:if test="${empty product.type_one_id}">
						   <input type="hidden" name="product_type_one_id" value="0" />
						</c:if>
						<c:if test="${!empty product.type_one_id}">
						  <input type="hidden" name="product_type_one_id" value="${product.type_one_id.id}" />
						</c:if>
						<c:if test="${empty product.type_two_1}">
						  <input type="hidden" name="product_type_two_1" value="0" />
						</c:if>
						<c:if test="${!empty product.type_two_1}">
						  <input type="hidden" name="product_type_two_1" value="${product.type_two_1.id}" />
						</c:if>
						<c:if test="${empty product.type_two_2}">
						  <input type="hidden" name="product_type_two_2" value="0" />
						</c:if>
						<c:if test="${!empty product.type_two_2}">
						  <input type="hidden" name="product_type_two_2" value="${product.type_two_2.id}" />
						</c:if>
						<c:if test="${empty product.type_two_3}">
						  <input type="hidden" name="product_type_two_3" value="0" />
						</c:if>
						<c:if test="${!empty product.type_two_3}">
						  <input type="hidden" name="product_type_two_3" value="${product.type_two_3.id}" />
						</c:if>

						<p>
							<label>名称<span class="inputrequiredflag">*</span> </label> <span
								class="field"><input type="text" placeholder="请输入商品名称"
								value="${product.name}" readonly="readonly" style="width:1024px;" name="product.name"
								id="product.name" required /> </span>
						</p>
						<p>
							<label>类型</label>
							<span class="field">

								<c:if test="${!empty product.type_one_id.id}">
								   ${product.type_one_id.name}
								</c:if>

								<c:if test="${!empty product.type_two_1}">
								  -${product.type_two_1.name}
								</c:if>
								
								<c:if test="${!empty product.type_two_2}">
								  -${product.type_two_2.name}
								</c:if>
								
								<c:if test="${!empty product.type_two_3}">
								  -${product.type_two_3.name}
								</c:if>
							</span>
						</p>
						<p>
							<label>价格<span class="inputrequiredflag">*</span> </label> 
							<span class="field">
								<input type="text" placeholder="请设置商品的价格"
								value="${product.price}" class="priceinput" onpaste="return false;" style="width:1024px;" name="product_price"
								id="product_price" required /> </span>
						</p>
						<p>
							<label>LOGO图片<span class="inputrequiredflag">*</span> </label> <label
								class="field" style="display: none;"> <input type="file"
								name="file1" id="file1" value="../${product.logo}" multiple
								accept="image/*" onchange="handleFiles(this,1)">
							</label>
							<c:choose>
								<c:when test="${product.logo eq '' || empty product.logo}">
									<span class="field"> <img id="img1"
										src="images/Add_Image.png" onclick="upImage(1)" height="200px" width="200px">
									</span>

								</c:when>
								<c:otherwise>
									<span class="field"><img id="img1"
										src="../${product.logo}" height="200px" width="200px"  onclick="upImage(1)">
									</span>
								</c:otherwise>
							</c:choose>
						</p>
						<p>
							<label>介绍<span class="inputrequiredflag">*</span> </label> <span
								class="field">
								<textarea  name="product.tag" rows="8" cols="10"
									contenteditable="true">${product.tag}</textarea>
								</span>
						</p>
						<p>
							<label>商品描述<span class="inputrequiredflag">*</span> </label> <span
								class="field"> <textarea id="editor1" name="product.description"
									contenteditable="true">${product.description}</textarea> </span>
						</p>
						<p>
							<label>常见问题<span class="inputrequiredflag">*</span> </label> <span
								class="field"> <textarea id="editor2" name="product.problem"
									contenteditable="true">${product.problem}</textarea> </span>
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
	var current = document.getElementById("productli1");
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

		var name = jQuery("#product.name").val();
		var name = jQuery("#product_price").val();



		if (name == "") {
			alert("商品名称不能空");
			return false;
		}
		if (price == "") {
			alert("商品价格不能空");
			return false;
		}

		jQuery("#submit_sava").click();
	}

	jQuery(".priceinput").live("keyup", function() {
	var price = $(this).val();
	//数字
	if (price==""||isNaN(price)) {
		jQuery(this).val("");
		jQuery("#product.price").val("");
		return false;
	}
	if (price < 0) {
		jQuery(this).val("");
		jQuery("#product.price").val("");
		return false;
	}
	if (price > 100000) {
		jQuery(this).val("");
		jQuery("#product.price").val("");
		return false;
	}
	jQuery("#product.price").val(price);
});

</script>

</html>
