<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--公共头文件引入-->
<%@ include file="/frontpage/html.inc.jsp"  %>
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新闻中心</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/css/news_center.css"/>
</head>
<body>
<!--顶部导航、登入等操作-->
<jsp:include page="../include/head.jsp" />

<div class="main">
    <div class="content">
        <div class="left_link">
            <div class="left_link_label">
                <a href="#">东唐品牌</a><span> > </span><a href="newsShow.html">双创新闻</a><span> > </span><a href="javascript:;">${we_News.title}</a>
            </div>
            <div class="left_link_icon" style="margin-top: 7px;">
					<div class="bshare-custom">
						<a title="分享到QQ空间" class="bshare-qzone"></a>
						<a title="分享到新浪微博" class="bshare-sinaminiblog"></a>
						<a title="分享到微信" class="bshare-weixin"></a>
						<a title="分享到腾讯微博" class="bshare-qqmb"></a></a><a title="更多平台"
							class="bshare-more bshare-more-icon more-style-addthis"></a><span
							class="BSHARE_COUNT bshare-share-count">0</span>
					</div>
					<script type="text/javascript" charset="utf-8"
						src="http://static.bshare.cn/b/buttonLite.js#style=-1&amp;uuid=&amp;pophcol=2&amp;lang=zh"></script>
					<script type="text/javascript" charset="utf-8"
						src="http://static.bshare.cn/b/bshareC0.js"></script>
				</div>
        </div>
        <div class="top_news">
            <div class="left_main">
                <div class="news_head">
                    <span>${we_News.title}</span>
                </div>
                <div class="news_label">
                    <div class="news_label_list">
                        <span>发布时间:</span><i><fmt:formatDate value="${we_News.creattime}" pattern="yyyy-MM-dd" /></i>
                    </div>
                    <div class="news_label_list">
                        <span>来源:</span><i>${we_News.source}</i>
                    </div>
                    <div class="news_label_list">
                        <span>标签:</span><i>${we_News.tag}</i>
                    </div>
                </div>
                <div class="news_content">
                    ${we_News.content}
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
    </div>
</div>
<!--底部链接-->
<jsp:include page="../include/foot.jsp" />


<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/common.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/news_center.js"></script>
<script type="text/javascript">
   //top菜单选中
    choiceTop(5);
</script>
</body>
</html>
