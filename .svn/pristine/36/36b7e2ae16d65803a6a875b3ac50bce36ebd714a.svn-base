<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--公共头文件引入-->
<%@ include file="/frontpage/html.inc.jsp"  %>
<base href="<%=basePath%>">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>西部创新服务中心—一站式创业服务平台</title>
    <meta name="description" content="西部创新服务中心是东唐旗下平台，专注为中小微企业提供一站式在线创业服务，提供高质量知识产权、财会税务等双创服务。" />
    <meta name="keywords" content="西创中心,西部创新服务,公司注册,商标注册,代理记账,专利申请,创业服务,税务代办,版权登记" />
</head>
<body>
<!--顶部导航、登入等操作-->
<div class="top">
    <div class="top_main">
        <div class="top_main_content">
            <div class="top_main_left">
                <div class="top_main_word">
                    <a href="javascript:;">成都东溏智盛企业管理咨询</a><span>旗下平台</span>
                </div>
                <div class="black_white_line" style="float: left;"></div>
                <div class="two_dimension">
                    <div class="two_dimension_btn">
                        <img src="<%=basePath%>frontpage/images/erweima_small.png" alt=""/>
                        <span>关注WESTINNO微信公众号</span>
                    </div>
                    <div class="two_dimension_gap">
                        <div class="two_dimension_pic">
                            <img src="<%=basePath%>frontpage/images/erweima.jpg" alt=""/>
                            <div class="two_dimension_word">
                                <span>扫一扫关注WESTINNO</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="top_main_right">
                
               <c:if test="${!empty session.USER}">
                <div class="login_in">
                    <div class="quit">
                    	<div class="black_white_line"></div>
                        <div class="login_operate">
                            <a href="loginout.html">退出</a>
                        </div>
                    </div>
                    <div class="login_operate">
                        <a href="productShopCar.html">购物车<span class="buy_num" id="car_num">${session.CAR_NUM}</span></a>
                    </div>
                    <div class="black_white_line"></div>
                    <div class="login_operate">
                        <a class="font_orange" href="memberCenter-2.html">我的订单</a>
                    </div>
                    <div class="black_white_line"></div>
                    <div class="login_operate">
                        <a class="font_orange" href="memberCenter-0.html">${session.USER.nickname}</a>
                    </div>
                </div>
              </c:if>  
              <c:if test="${empty session.USER}"> 
                <div class="login_out">
                    <div class="login_operate">
                        <a href="login.html">购物车<span class="buy_num" id="car_num">0</span></a>
                    </div>
                    <div class="black_white_line"></div>
                    <div class="login_operate">
                        <a href="register.html">免费注册</a>
                    </div>
                    <div class="black_white_line"></div>
                    <div class="login_operate">
                        <a href="login.html">登录</a>
                    </div>
                </div>
              </c:if>  
              
            </div>
        </div>
    </div>
    <div class="head_bar">
        <div class="head_bar_content">
            <div class="bar_logo">
            	<a href="#">
                <img src="<%=basePath%>frontpage/images/west.png" alt="" />
                </a>
            </div>
            <div class="bar_bank">
                <div class="bar_list">
                    <a id="tag_1"  href="index.html" class="active">首页</a>
                </div>
                <div class="bar_list">
                    <a id="tag_2" href="productShow-1.html">专利申请</a>
                </div>
                <div class="bar_list">
                    <a id="tag_3" href="productShow-2.html">商标申请</a>
                </div>
                <div class="bar_list">
                    <a id="tag_4" href="productShow-3.html">双创服务</a>
                </div>
                <div class="bar_list">
                    <a id="tag_5" href="newsShow.html">行业资讯</a>
                </div>
                <!-- <div class="search_area">
                    <div class="search_area_content">
                        <input type="text" placeholder="站内搜索"/>
                        <img src="<%=basePath%>frontpage/images/u202.png" alt=""/>
                    </div>
                </div> -->
            </div>
        </div>
    </div>
</div>

</body>
</html>
