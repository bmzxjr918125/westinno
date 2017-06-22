<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--公共头文件引入-->
<%@ include file="/frontpage/html.inc.jsp"  %>
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>行业资讯</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <%--<link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/css/basicCss/swiper.css"/>
    --%><link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/css/industry_news.css"/>
</head>
<body onload="GetList(1,10,1);">
<!--顶部导航、登入等操作-->
<jsp:include page="../include/head.jsp" />

<div class="main">
    <div class="content">
        <div class="top_news">
            <div class="left_pic">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                    <c:if test="${empty jsonData.imageList}">
                        <div class="swiper-slide">
                            <img src="<%=basePath%>frontpage/images/bar1.jpg" alt=""/>
                        </div>
                    </c:if>
                     <c:if test="${!empty jsonData.imageList}">   
                        <c:forEach items="${jsonData.imageList}" var="image">
                          <div class="swiper-slide">
                             <img onclick="showNewsInfo(${image.id})" src="../${image.image}" alt="${image.title}"/>
                          </div>
                        </c:forEach>
                     </c:if>
                    </div>
                </div>
                <!-- Add Pagination -->
                <div class="btn_gap"></div>
                <div class="btn_content">
                    <div class="swiper-pagination"></div>
                </div>
            </div>
            <div class="right_bar">
                <div class="right_bar_head">
                    <span>热文推荐</span>
                </div>
                <div class="right_bar_content">
                  <c:forEach items="${jsonData.recommendList}" var="news">
	                    <div class="right_bar_list">
	                        <div class="right_bar_list_content">
	                        	<a href="javascript:;" onclick="showNewsInfo(${news.id})">${news.title}</a>
	                        </div>
	                    </div>
                  </c:forEach>  
                </div>
            </div>
        </div>
        <div class="news_show">
            <div class="news_bar">
                <c:forEach items="${jsonData.newsTypeList}" var="newsType" varStatus="st">
	                <div class="news_bar_list" onclick="GetList(${newsType.id},10,1)">
	                    <span <c:if test="${st.index eq 0}"> class="active" </c:if>  id="newstype_${newsType.id}">${newsType.name}</span>
	                </div>
                </c:forEach>
            </div>
            <div class="news_content">
                <div class="news_show">
                    <div class="news_show_content" id="list_content">
                        
                        
                    </div>
                   
                   
                    <div class="page" id="list_page">
                      <div class="page_main" id="list_page_modle">
                            <div class="page_main_content">
                                <div class="page_click" id="per_page">
                                    <span>上一页</span>
                                </div>
                                <div class="page_num">
                                    <div class="page_num_content" id="page_num_content">
                                        
                                    </div>
                                </div>
                                <div class="page_click" id="next_page">
                                    <span>下一页</span>
                                </div>
                            </div>
                     </div>
                    </div>
                    
                    <!--新闻列表模版-->
                    <div id="list_content_modle" >
                    <div class="news_list" onclick="[entity.click]" style="display: none;">
                            <div class="news_list_pic">
                                <img src="../[entity.image]" alt=""/>
                            </div>
                            <div class="news_list_dic">
                                <div class="news_list_head">
                                    <a href="javascript:void(0);">[entity.title]</a>
                                </div>
                                <div class="news_list_word">
                                    <span>[entity.scan]</span>
                                </div>
                                <div class="news_list_more">
                                    <div class="more_list">
                                        <img src="<%=basePath%>frontpage/images/timu.png" alt=""/>
                                        <span>[entity.news_type_id.name]</span>
                                    </div>
                                    <div class="more_list">
                                        <img src="<%=basePath%>frontpage/images/time.png" alt=""/>
                                        <span>[entity.creattime]</span>
                                    </div>
                                    <div class="more_list">
                                        <img src="<%=basePath%>frontpage/images/label.png" alt=""/>
                                        <span>[entity.tag]</span>
                                    </div>
                                </div>
                            </div>
                     </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!--底部链接-->
<jsp:include page="../include/foot.jsp" />
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/common.js"></script>
<%--<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/swiper.jquery.js"></script>
--%><script type="text/javascript" src="<%=basePath%>frontpage/js/industry_news.js"></script>
<script type="text/javascript">
   //top菜单选中
    choiceTop(5);
   
   
    //加载数据
  function GetList(type,pageNumber,currentPage){
       var url = "newsGetList-"+type+"-"+pageNumber+"-"+currentPage+".html" ;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : url,
			data : "",
			dataType : "json",
			success : function(json) {
				if (json.response =="success") {
				    $(".news_bar_list span").removeClass("active");
				    var newstypeid="newstype_"+type;
				    $("#"+newstypeid).addClass("active");
				    if(json.list!=null){
				    var content="";
				     for(var i=0;i<json.list.length;i++){
				         var html=$("#list_content_modle").html();
					         html=html.replace("[entity.click]","showNewsInfo("+json.list[i].id+")");
					         html=html.replace("[entity.image]",json.list[i].image);
					         html=html.replace("[entity.title]",json.list[i].title);
					         html=html.replace("[entity.scan]",json.list[i].scan);
					         html=html.replace("[entity.news_type_id.name]",json.list[i].news_type_id.name);
					         html=html.replace("[entity.creattime]",UnixToDate(json.list[i].creattime.time,false,""));
					         html=html.replace("[entity.tag]",json.list[i].tag);
					         content=content+html; 
				      }
				      $("#list_content").html("");
				      $("#list_content").append(content);
				      $("#list_content .news_list").css({
				         display:"block"
				      });
				    }
				       
				      //页标 
				      var per=(currentPage-1)>0?(currentPage-1):1;
				      var next=(currentPage+1)<json.totalPage?(currentPage+1):json.totalPage;
				      $("#per_page").attr("onclick","GetList("+type+","+pageNumber+","+per+")");
				      $("#next_page").attr("onclick","GetList("+type+","+pageNumber+","+next+")");
				      
				      $("#page_num_content").html("");
				      
				       if(json.totalPage<6){//最大6
				           for(var i=1;i<json.totalPage+1;i++){
				           if(json.currentPage==i){
				             $("#page_num_content").append("<span class='active'>"+i+"</span>");
				           }else{
				             $("#page_num_content").append("<span  onclick='GetList("+type+","+pageNumber+","+i+")'>"+i+"</span>");
				           }
				           }
				       }else{
				       var f=0;
				           if((json.currentPage-1)>0){
				              f= json.currentPage-1;
				           }else{
				              f=json.currentPage;
				           }
				       var e=0;    
				       if((json.totalPage-json.currentPage)>4){
				           e= json.currentPage+3;
				            for(var i=f;i<e;i++){
				            if(json.currentPage==i){
				                 $("#page_num_content").append("<span class='active'>"+i+"</span>");
					           }else{
					             $("#page_num_content").append("<span onclick='GetList("+type+","+pageNumber+","+i+")'>"+i+"</span>");
					           }
				           }
				           $("#page_num_content").append("<span>...</span><span onclick='GetList("+type+","+pageNumber+","+json.totalPage+")'>"+json.totalPage+"</span>");
				       }else{
				           for(var i=json.totalPage-5;i<json.totalPage+1;i++){
				            if(json.currentPage==i){
				                 $("#page_num_content").append("<span class='active'>"+i+"</span>");
					           }else{
					             $("#page_num_content").append("<span onclick='GetList("+type+","+pageNumber+","+i+")'>"+i+"</span>");
					           }
				           }
				       }
				       }
                    
				} else {
					alert(json.msg);
				}
			}
		});
    }
    
    
    
</script>
</body>
</html>
