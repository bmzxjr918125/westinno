<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--公共头文件引入-->
<%@ include file="/WEB-INF/page/include/include.inc.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<title>WESTINNO管理系统</title>
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
          <div class="pageheader" style="padding-bottom: 20px;">
            <h1 class="pagetitle">控制台</h1>
            <span class="pagedesc">欢迎使用WESTINNO管理系统，${sessionScope.adminInfo.username}</span>
            
            <ul class="hornav" style="display: none;">
                <!-- <li class="current"><a href="#updates">远端工具</a></li>
                <li><a href="#activities">最近活动</a></li> -->
            </ul>
         </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
      
        	<div id="updates" class="subcontent">
                    
                    <div class="two_third dashboard_left" style="margin-top: 20px;width: 98%;">
                    
                    <div class="notibar announcement">
                        <a class="close"></a>
                        <h3>JVM 内存使用情况</h3>

								<%
									double total = (Runtime.getRuntime().totalMemory())
											/ (1024.0 * 1024);
									double max = (Runtime.getRuntime().maxMemory()) / (1024.0 * 1024);
									double free = (Runtime.getRuntime().freeMemory()) / (1024.0 * 1024);
									out.println("<h4 style='margin-left:10%;margin-top:2%'>当前JVM的最大可用内存:&nbsp;&nbsp;&nbsp;&nbsp;" + max + "MB</h4><br/>");
									out.println("<h4 style='margin-left:10%;'>当前JVM占用的内存总数:&nbsp;&nbsp;&nbsp;&nbsp;" + total
											+ "MB</h4><br/>");
									out.println("<h4 style='margin-left:10%;'>当前JVM空闲内存:&nbsp;&nbsp;&nbsp;&nbsp;" + free
											+ "MB</h4><br/>");
									out.println("<h4 style='margin-left:10%;'>JVM实际可用内存:&nbsp;&nbsp;&nbsp;&nbsp;" + (max - total + free) + "MB</h4><br/>");
								%>
                    </div>
      
                    	<!-- <ul class="shortcuts">
                        	<li><a href="" class="settings"><span>设置</span></a></li>
                            <li><a href="" class="users"><span>用户</span></a></li>
                            <li><a href="" class="gallery"><span>相册</span></a></li>
                            <li><a href="" class="events"><span>事件</span></a></li>
                            <li><a href="" class="analytics"><span>分析</span></a></li>
                        </ul> -->
                        
                    </div><!--two_third dashboard_left -->
                    
            </div><!-- #updates -->
            
            <div id="activities" class="subcontent" style="display: none;">
            	&nbsp;
            </div><!-- #activities -->
        
        </div><!--contentwrapper-->
        
        <br clear="all" />
	</div><!-- centercontent -->
    
</div><!--bodywrapper-->

</body>
<script type="text/javascript" src="js/method.js"></script>
<script type="text/javascript">
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
</html>
