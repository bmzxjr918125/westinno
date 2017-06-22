<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--公共头文件引入-->
<%@ include file="/frontpage/html.inc.jsp"  %>
<%--<base href="<%=basePath%>">--%>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>会员中心</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/js/need/laydate.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontpage/css/member_center.css"/>
    <style>
     #userInfo label.error
		{
			width: 100%;
			position: absolute;
			left: 402px;
			top: 14px;
			color:Red;
			font-size:13px;
			margin-left:5px;
			padding-left:16px;
			background:url("error.png") left no-repeat;
		} 
   </style>
</head>
<body>
<!--顶部导航、登入等操作-->
<jsp:include page="../include/head.jsp" />

<div class="main">
    <div class="content">
        <div class="member_top">
            <img src="<%=basePath%>frontpage/images/member.png" alt=""/>
            <span>会员中心</span>
        </div>
        <div class="member_content">
            <div class="member_left">
                <div class="member_list active">
                    <span>消息中心 (</span><i> 2 </i><span> ) </span>
                </div>
                <div class="member_list my_info_btn" id="my_info">
                    <span>我的资料</span>
                </div>
                <div class="member_list" onclick="getUserOrder()">
                    <span>我的订单</span>
                </div>
                <div class="member_list" onclick="getUserCollect()">
                    <span>我的收藏</span>
                </div>
                <div class="member_list">
                    <span>账户管理</span>
                </div>
            </div>
            <div class="member_right">
                <div class="member_show" style="display: block;">
                    <!--消息中心-->
                    <div class="news_center">
                        <div class="news_top">
                            <div class="news_type">
                                <span class="active">未读</span>
                            </div>
                            <div class="news_type">
                                <span>已读</span>
                            </div>
                        </div>
                        <div class="news_content">
                            <div class="news_show">
                                <div class="news_list">
                                    <div class="news_list_left">
                                        <a href="javascript:;">创新基金（科技型中小企业发展专项资金）</a>
                                    </div>
                                    <div class="news_list_mid">
                                        <span>2016-10-16</span>
                                    </div>
                                    <div class="news_list_right">
                                        <span>标记已读</span>
                                    </div>
                                </div>
                            </div>
                            <div class="news_show" style="display: none;">
                                <div class="news_list">
                                    <div class="news_list_left">
                                        <a href="javascript:;">创新基金（科技型中小企业发展专项资金）</a>
                                    </div>
                                    <div class="news_list_mid">
                                        <span>2016-10-16</span>
                                    </div>
                                    <div class="news_list_right">
                                        <span>标记已读</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="member_show" style="display: none;">
                    <!--我的资料-->
                    <div class="my_info">
                        <div class="my_info_content">
                            <div class="my_info_top">
                                <div class="my_info_pic">
                                    <img src="<%=basePath%>frontpage/images/u62.png" alt=""/>
                                    <span>${session.USER.nickname}</span>
                                </div>
                                <div class="info_replay">
                                    <a href="javascript:;" id="update_info">修改资料</a>
                                </div>
                            </div>
                            <div class="info_main">
                                <div class="info_show" style="display: block;">
                                    <div class="info_show_content">
                                        <div class="info_list">
                                            <div class="info_list_left">
                                                <span>用户姓名:</span>
                                            </div>
                                            <div class="info_list_right">
                                                <span>${session.USER.nickname}</span>
                                            </div>
                                        </div>
                                        <div class="info_list">
                                            <div class="info_list_left">
                                                <span>性别:</span>
                                            </div>
                                            <div class="info_list_right">
                                                <span>${session.USER.sex eq 1?'男':(session.USER.sex eq 2?'女':'其他')}</span>
                                            </div>
                                        </div>
                                        <div class="info_list">
                                            <div class="info_list_left">
                                                <span>手机号码:</span>
                                            </div>
                                            <div class="info_list_right">
                                                <span>${session.USER.phonenum}</span>
                                            </div>
                                        </div>
                                        <div class="info_list">
                                            <div class="info_list_left">
                                                <span>电子邮箱:</span>
                                            </div>
                                            <div class="info_list_right">
                                                <span>${session.USER.e_mail}</span>
                                            </div>
                                        </div>
                                        <div class="info_list">
                                            <div class="info_list_left">
                                                <span>QQ:</span>
                                            </div>
                                            <div class="info_list_right">
                                                <span>${session.USER.qq}</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="info_show"  style="display: none;">
                                <form action="" id="userInfo">
                                   <input type="hidden" value="${session.USER.id}" name="id" />
                                    <div class="replay_show_content">
                                        <div class="replay_list">
                                            <div class="replay_list_left">
                                                <span>用户姓名：</span>
                                            </div>
                                            <div class="replay_list_right">
                                                <input class="userName" value="${session.USER.nickname}" name="nickname" required="required" type="text" maxlength="12" placeholder="输入您的尊姓大名"/>
                                            </div>
                                            <div class="must_icon">
                                                <span>*</span>
                                            </div>
                                        </div>
                                        <div class="replay_list">
                                            <div class="replay_list_left">
                                                <span>性别：</span>
                                            </div>
                                            <div class="replay_list_right" style="border: none;">
                                                <div class="sex_choice">
                                                 
                                                    <input type="radio" value="1"  <c:if test="${session.USER.sex eq 1}"> checked="true" </c:if> name="sex" placeholder=""/><span>先生</span>
                                                  
                                                </div>
                                                <div class="sex_choice">
                                                    <input type="radio" value="2" <c:if test="${session.USER.sex eq 2}"> checked="true" </c:if> name="sex" placeholder=""/><span>女士</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="replay_list">
                                            <div class="replay_list_left">
                                                <span>手机号码：</span>
                                            </div>
                                            <div class="replay_list_right">
                                                <input class="telNum" readonly="readonly" value="${session.USER.phonenum}" maxlength="11" required="required" type="text" placeholder="请输入您的手机号码"/>
                                            </div>
                                            <div class="must_icon">
                                                <span>*</span>
                                            </div>
                                        </div>
                                        <div class="replay_list">
                                            <div class="replay_list_left">
                                                <span>电子邮箱：</span>
                                            </div>
                                            <div class="replay_list_right">
                                                <input class="emailNum" name="e_mail" value="${session.USER.e_mail}" required="required" maxlength="30" type="text" placeholder="输入您的电子邮箱号码"/>
                                            </div>
                                            <div class="must_icon">
                                                <span>*</span>
                                            </div>
                                        </div>
                                        <div class="replay_list">
                                            <div class="replay_list_left">
                                                <span>QQ：</span>
                                            </div>
                                            <div class="replay_list_right">
                                                <input class="qqNum" name="qq" value="${session.USER.qq}" maxlength="30" type="text" placeholder="输入您的QQ号码"/>
                                            </div>
                                        </div>
                                    </div>
                                    <button  id="submit_btn" style="display: none;">提交</button>
                                    
                                    </form>
                                    <div class="replay_btn">
                                        <button class="gray_btn_c cancel_btn">取消</button>
                                        <button onclick="updateUserInfo(this);" class="orange_btn_9 save_info">保存资料</button>
                                    </div>
                                </div>
                                
                                
                                
                            </div>
                        </div>
                    </div>
                </div>
                <div class="member_show" style="display: none;">
                    <!--我的订单-->
                    <div class="my_order">
                        <div class="order_top">
                            <div class="apply_service">
                                <span>申请服务:</span>
                                <div class="service_search">
                                    <input type="text" placeholder="输入服务名称搜索" id="order_name"/>
                                </div>
                            </div>
                            <div class="order_state">
                                <span class="order_state_span">订单状态:</span>
                                <div class="state_choice">
                                	<span class="standard_select">
                                		<span class="select_shelter">
                                			<select name="state" id="order_status">
		                                        <option value="0">全部订单</option>
		                                        <option value="1">待完善个人资料</option>
		                                        <option value="2">已提交待审核</option>
		                                        <option value="3">审核通过待付款</option>
		                                        <option value="4">审核未通过</option>
		                                        <option value="5">已付款</option>
		                                        <option value="6">已完成</option>
		                                        <option value="7">已取消</option>
		                                        <option value="8">已关闭</option>
		                                    </select>
                                		</span>
                                	</span>
                                </div>
                            </div>
                            <div class="deal_time">
                                <span>成交时间:</span>
                                <div class="time_choice">
                                    <ul class="inline">
                                        <li class="inline" id="start"></li>
                                        <li class="aim"><span>到</span></li>
                                        <li class="inline" id="end"></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="search_btn">
                                <button class="orange_btn_9" onclick="getUserOrder()">查询</button>
                            </div>
                        </div>
                        <div class="order_main">
                            <div class="order_list_top">
                                <div class="order_num float_l">
                                    <span>订单号</span>
                                </div>
                                <div class="service_name float_l">
                                    <span>服务名称</span>
                                </div>
                                <div class="money_num float_l">
                                    <span>金额(￥)</span>
                                </div>
                                <div class="time float_l">
                                    <span>时间</span>
                                </div>
                                <div class="state float_l">
                                    <span>状态</span>
                                </div>
                                <div class="operate float_l">
                                    <span>操作</span>
                                </div>
                            </div>
                            <div class="order_list_content" id="user_order">
                                <!-- <div class="order_list">
                                    <div class="order_num float_l">
                                        <span>1603141040191535</span>
                                    </div>
                                    <div class="service_name float_l">
                                        <span>创新基金(科技型中小企业发展专项资金)</span>
                                    </div>
                                    <div class="money_num float_l">
                                        <span>7,000.00</span>
                                    </div>
                                    <div class="time float_l">
                                        <span>2016-03-14</span>
                                    </div>
                                    <div class="state float_l">
                                        <span>待完善资料</span>
                                    </div>
                                    <div class="operate float_l">
                                        <a class="complete_info orange_font" href="javascript:;">完善资料</a>
                                        <a class="cancel_btn gray_font" href="javascript:;">取消</a>
                                    </div>
                                </div>
                                <div class="order_list">
                                    <div class="order_num float_l">
                                        <span>1603141040191535</span>
                                    </div>
                                    <div class="service_name float_l">
                                        <span>创新基金(科技型中小企业发展专项资金)</span>
                                    </div>
                                    <div class="money_num float_l">
                                        <span>7,000.00</span>
                                    </div>
                                    <div class="time float_l">
                                        <span>2016-03-14</span>
                                    </div>
                                    <div class="state float_l">
                                        <span>待付款</span>
                                    </div>
                                    <div class="operate float_l">
                                        <a class="pay_now_btn orange_font" href="javascript:;">立即付款</a>
                                        <a class="contact_service orange_font" href="javascript:;">联系客服</a>
                                        <a class="cancel_btn gray_font" href="javascript:;">取消</a>
                                    </div>
                                </div>
                                <div class="order_list">
                                    <div class="order_num float_l">
                                        <span>1603141040191535</span>
                                    </div>
                                    <div class="service_name float_l">
                                        <span>创新基金(科技型中小企业发展专项资金)</span>
                                    </div>
                                    <div class="money_num float_l">
                                        <span>7,000.00</span>
                                    </div>
                                    <div class="time float_l">
                                        <span>2016-03-14</span>
                                    </div>
                                    <div class="state float_l">
                                        <span>进行中</span>
                                    </div>
                                    <div class="operate float_l">
                                        <a class="my_service orange_font" href="javascript:;">我的客服</a>
                                    </div>
                                </div>
                                <div class="order_list">
                                    <div class="order_num float_l">
                                        <span>1603141040191535</span>
                                    </div>
                                    <div class="service_name float_l">
                                        <span>创新基金(科技型中小企业发展专项资金)</span>
                                    </div>
                                    <div class="money_num float_l">
                                        <span>7,000.00</span>
                                    </div>
                                    <div class="time float_l">
                                        <span>2016-03-14</span>
                                    </div>
                                    <div class="state float_l">
                                        <span>进行中</span>
                                    </div>
                                    <div class="operate float_l">
                                        <a class="cancel_btn gray_font" href="javascript:;">取消</a>
                                    </div>
                                </div>
                                <div class="order_list">
                                    <div class="order_num float_l">
                                        <span>1603141040191535</span>
                                    </div>
                                    <div class="service_name float_l">
                                        <span>创新基金(科技型中小企业发展专项资金)</span>
                                    </div>
                                    <div class="money_num float_l">
                                        <span>7,000.00</span>
                                    </div>
                                    <div class="time float_l">
                                        <span>2016-03-14</span>
                                    </div>
                                    <div class="state float_l">
                                        <span>进行中</span>
                                    </div>
                                    <div class="operate float_l">

                                    </div>
                                </div>
                                <div class="order_list">
                                    <div class="order_num float_l">
                                        <span>1603141040191535</span>
                                    </div>
                                    <div class="service_name float_l">
                                        <span>创新基金(科技型中小企业发展专项资金)</span>
                                    </div>
                                    <div class="money_num float_l">
                                        <span>7,000.00</span>
                                    </div>
                                    <div class="time float_l">
                                        <span>2016-03-14</span>
                                    </div>
                                    <div class="state float_l">
                                        <span>进行中</span>
                                    </div>
                                    <div class="operate float_l">

                                    </div>
                                </div>
                                <div class="order_list">
                                    <div class="order_num float_l">
                                        <span>1603141040191535</span>
                                    </div>
                                    <div class="service_name float_l">
                                        <span>创新基金(科技型中小企业发展专项资金)</span>
                                    </div>
                                    <div class="money_num float_l">
                                        <span>7,000.00</span>
                                    </div>
                                    <div class="time float_l">
                                        <span>2016-03-14</span>
                                    </div>
                                    <div class="state float_l">
                                        <span>进行中</span>
                                    </div>
                                    <div class="operate float_l">

                                    </div>
                                </div> -->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="member_show" style="display: none;">
                    <!--我的收藏-->
                    <div class="my_collect">
                        <div class="my_collect_top">
                            <div class="collect_type goods_name">
                                <span>商品名称</span>
                            </div>
                            <div class="collect_type good_reception" style="border-left:none;">
                                <span>&nbsp;</span>
                            </div>
                            <div class="collect_type collect_operate">
                                <span>操作</span>
                            </div>
                        </div>
                        <div class="collect_content" id="user_collect">
                            <div class="collect_list">
                                <div class="collect_list_pic">
                                    <img src="<%=basePath%>frontpage/images/collect.png" alt=""/>
                                </div>
                                <div class="collect_list_right">
                                    <div class="collect_name">
                                        <span>创新基金(科技型中小企业发展专项资金)</span>
                                    </div>
                                    <div class="collect_reception">
                                        <span>100%</span>
                                    </div>
                                    <div class="collect_cancel">
                                        <span>取消收藏</span>
                                    </div>
                                </div>
                            </div>
                            <div class="collect_list">
                                <div class="collect_list_pic">
                                    <img src="<%=basePath%>frontpage/images/collect.png" alt=""/>
                                </div>
                                <div class="collect_list_right">
                                    <div class="collect_name">
                                        <span>创新基金(科技型中小企业发展专项资金)</span>
                                    </div>
                                    <div class="collect_reception">
                                        <span>100%</span>
                                    </div>
                                    <div class="collect_cancel">
                                        <span>取消收藏</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="member_show" style="display: none;">
                    <!--账户管理-->
                    <div class="user_manage">
                        <!--账户管理首页-->
                        <div class="user_show user_info_main" style="display: none;">
                            <div class="user_info">
                                <div class="user_info_list">
                                    <div class="user_info_left">
                                        <div class="user_info_pic">
                                            <img src="<%=basePath%>frontpage/images/u62.png" alt=""/>
                                        </div>
                                        <div class="user_info_dic">
                                            <span>手机绑定</span>
                                            <i>${session.USER.phonenum}</i>
                                        </div>
                                    </div>
                                    <div class="user_info_right">
                                        <a class="replace_tel_btn" href="javascript:;">更换手机</a>
                                    </div>
                                </div>
                                <div class="user_info_list">
                                    <div class="user_info_left">
                                        <div class="user_info_pic">
                                            <img src="<%=basePath%>frontpage/images/u62.png" alt=""/>
                                        </div>
                                        <div class="user_info_dic">
                                            <span>登录密码</span>
                                            <i>${session.USER.phonenum}</i>
                                        </div>
                                    </div>
                                    <div class="user_info_right">
                                        <a class="replace_psd_btn" href="javascript:;">修改密码</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--更换手机-->
                        <div class="user_show replace_tel_main" style="display: none;">
                            <div class="replace_tel">
                                <div class="replace_tel_head">
                                    <div class="replace_head_type">
                                        <span>更换手机</span>
                                    </div>
                                    <div class="replace_tel_pic">
                                        <img class="cancel_btn" src="<%=basePath%>frontpage/images/cancel.png" alt=""/>
                                    </div>
                                </div>
                                <div class="info_main">
                                    <div class="login_inp">
                                        <div class="login_inp_list">
                                            <div class="login_icon">
                                                <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                                            </div>
                                            <div class="input_main">
                                                <input type="text" id="phoneNum" onchange="phoneChange(this)" onkeydown="phoneChange(this)" onkeyup="phoneChange(this)"  required="required" maxlength="11" name="phoneNum" placeholder="输入手机号码"/>
                                            </div>
                                        </div>
                                    </div>
                                    <%--<div class="inp_test">
                                        <div class="login_inp_list">
                                            <div class="login_icon">
                                                <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                                            </div>
                                            <div class="input_main">
                                                <input type="text" placeholder="输入验证码"/>
                                            </div>
                                        </div>
                                        <div class="test_pic">
                                            <img src="<%=basePath%>frontpage/images/u26(1).png" alt=""/>
                                        </div>
                                    </div>
                                    --%><div class="test_btn">
                                        <button class="gray_btn_9" id="sendCodeBtn">获取短信验证码</button>
                                    </div>
                                    <div class="login_inp">
                                        <div class="login_inp_list">
                                            <div class="login_icon">
                                                <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                                            </div>
                                            <div class="input_main">
                                                <input type="text" id="checkNum" required="required" maxlength="6" onchange="checkChange(this)" onkeydown="checkChange(this)" onkeyup="checkChange(this)" placeholder="输入您收到的手机验证码"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="login_btn tel_sure_btn">
                                        <button class="gray_btn_9" id="sureBtn" type="button" >确认更换手机</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="user_show replace_psd_main">
                            <div class="replace_tel">
                                <div class="replace_tel_head">
                                    <div class="replace_head_type">
                                        <span>更换密码</span>
                                    </div>
                                    <div class="replace_tel_pic">
                                        <img class="cancel_btn" src="<%=basePath%>frontpage/images/cancel.png" alt=""/>
                                    </div>
                                </div>
                                <div class="info_main">
                                    <div class="login_inp">
                                        <div class="login_inp_list">
                                            <div class="login_icon">
                                                <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                                            </div>
                                            <div class="input_main">
                                                <input type="password" id="old_password" required="required" minlength="6" placeholder="输入您之前的登录密码"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="login_inp">
                                        <div class="login_inp_list">
                                            <div class="login_icon">
                                                <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                                            </div>
                                            <div class="input_main">
                                                <input type="password" id="new_password" required="required" minlength="6" placeholder="输入您新的登录密码"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="login_inp">
                                        <div class="login_inp_list">
                                            <div class="login_icon">
                                                <img src="<%=basePath%>frontpage/images/ID.png" alt=""/>
                                            </div>
                                            <div class="input_main">
                                                <input type="password" id="echo_password" required="required" minlength="6" placeholder="再次输入您新的登录密码"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="login_btn psd_sure_btn">
                                        <button type="button" class="orange_btn_9" onclick="switchPassword()">更换密码</button>
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

<div class="gap" style="display: none;"></div>
<!--取消订单-->
<div class="cancel_main" style="display: none;">
    <div class="order_cancel">
        <div class="order_cancel_head">
            <span>取消订单</span>
            <img class="cancel_btn" src="<%=basePath%>frontpage/images/cancel.png" alt=""/>
        </div>
        <div class="order_cancel_main">
            <div class="order_cancel_tip">
                <span>亲!能告诉我们您取消订单的原因吗?我们一定会好好更正的!</span>
            </div>
            <div class="order_cancel_reason">
                <div class="reason_list">
                    <span>不想买了</span>
                    <img class="yes" src="<%=basePath%>frontpage/images/choice2.png" alt=""/>
                </div>
                <div class="reason_list">
                    <span>不想买了</span>
                    <img src="<%=basePath%>frontpage/images/choice1.png" alt=""/>
                </div>
                <div class="reason_list">
                    <span>不想买了</span>
                    <img src="<%=basePath%>frontpage/images/choice1.png" alt=""/>
                </div>
                <div class="reason_list">
                    <span>不想买了</span>
                    <img src="<%=basePath%>frontpage/images/choice1.png" alt=""/>
                </div>
            </div>
            <div class="order_btn">
                <button class="gray_btn_c cancel_order_btn">取消订单</button><button class="orange_btn_9 think_more_btn">再想想</button>
            </div>
        </div>
    </div>
</div>

<!--立即付款-->
<div class="pay_now" style="display: none;">
    <div class="pay_now_main">
        <div class="order_cancel_head">
            <span class="orange_font">立即付款</span>
            <img class="cancel_btn" src="<%=basePath%>frontpage/images/cancel.png" alt=""/>
        </div>
        <div class="pay_now_content">
            <div class="pay_info">
                <div class="pay_info_list">
                    <div class="pay_info_list_left">
                        <span>商品名称：</span>
                    </div>
                    <div class="pay_info_list_right">
                        <span id="span_order_name">创新基金(科技型中小企业发展专项资金)</span>
                    </div>
                </div>
                <div class="pay_info_list">
                    <div class="pay_info_list_left">
                        <span>订单号：</span>
                    </div>
                    <div class="pay_info_list_right">
                        <span id="span_order_number">1603141040191535</span>
                    </div>
                </div>
                <div class="pay_info_list">
                    <div class="pay_info_list_left">
                        <span>金额(￥)：</span>
                    </div>
                    <div class="pay_info_list_right">
                        <span class="red_font" id="span_order_price">7,000.00</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="other_way">
            <div class="other_way_head">
                <span>您可以选择下列支付方式</span>
            </div>
            <div class="other_way_main">
                <div class="other_way_list" id="pay_order_alipay">
                    <div class="way_pic">
                        <img src="<%=basePath%>frontpage/images/pay.png" alt=""/>
                    </div>
                    <div class="way_name">
                        <span>支付宝支付</span>
                    </div>
                </div>
                <div class="other_way_list" onclick="alert('暂不支持')">
                    <div class="way_pic">
                        <img src="<%=basePath%>frontpage/images/weixin.png" alt=""/>
                    </div>
                    <div class="way_name">
                        <span>微信支付</span>
                    </div>
                </div>
                <div class="other_way_list" onclick="alert('暂不支持')">
                    <div class="way_pic">
                        <img src="<%=basePath%>frontpage/images/bank.png" alt=""/>
                    </div>
                    <div class="way_name">
                        <span>银联支付</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<input type="hidden" value="" id="hidden_input_order_id"/>
<input type="hidden" value="" id="hidden_input_user_id"/>--%>

<!--客服-->
<div class="service_gap" style="display: none;">
    <div class="service_gap_main">
        <div class="head_pic_content">
            <div class="head_pic">
                <img src="<%=basePath%>frontpage/images/N1.jpg" alt="" id="custom_img"/>
            </div>
        </div>
        <div class="cancel_btn_pic">
            <img class="cancel_btn" src="<%=basePath%>frontpage/images/cancel.png" alt=""/>
        </div>
        <div class="service_gap_name">
            <span id="custom_name">王尼玛</span>
        </div>
        <div class="service_info">
            <div class="service_info_list">
                <div class="service_info_pic">
                    <img src="<%=basePath%>frontpage/images/qq_small.png" alt=""/>
                </div>
                <div class="service_info_num">
                    <span id="custom_qq">447200109</span>
                </div>
            </div>
            <div class="service_info_list">
                <div class="service_info_pic">
                    <img src="<%=basePath%>frontpage/images/email_small.png" alt=""/>
                </div>
                <div class="service_info_num">
                    <span id="custom_email">44720109@qq.com</span>
                </div>
            </div>
            <div class="service_info_list">
                <div class="service_info_pic">
                    <img src="<%=basePath%>frontpage/images/tel_small.png" alt=""/>
                </div>
                <div class="service_info_num">
                    <span id="custom_phone">18030468751</span>
                </div>
            </div>
        </div>
        <div class="service_btn">
            <!-- <button class="orange_btn_9">联系TA</button> -->
        </div>
    </div>
</div>
<input type="hidden" id="hidden_phoneNum" value="${session.USER.phonenum}" />
<input type="hidden" id="hidden_user_id" value="${session.USER.id}" />
<!--底部链接-->
<jsp:include page="../include/foot.jsp" />

<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/common.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/laydate.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/member_center.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery-form.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/basicJS/jquery.md5.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/js/method.js"></script>
<script type="text/javascript" src="<%=basePath%>frontpage/User/js/pingpp-pc.js"></script>
<script>
    !function(){
        laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
        laydate({elem: '#demo'});//绑定元素
    }();

    //日期范围限制
    var start = {
        elem: '#start',
        format: 'YYYY-MM-DD',
//        min: laydate.now(), //设定最小日期为当前日期
//        max: '2099-06-16', //最大日期
        istime: true,
        istoday: true,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas; //将结束日的初始值设定为开始日
        }
    };

    var end = {
        elem: '#end',
        format: 'YYYY-MM-DD',
//        min: laydate.now(),
//        max: '2099-06-16',
        istime: true,
        istoday: true,
        choose: function(datas){
            start.max = datas; //结束日选好后，充值开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);

    //自定义日期格式
    laydate({
        elem: '#test1',
        format: 'YYYY年MM月DD日',
        festival: true, //显示节日
        choose: function(datas){ //选择日期完毕的回调
            alert('得到：'+datas);
        }
    });

    //日期范围限定在昨天到明天
    laydate({
        elem: '#hello3',
        min: laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
        max: laydate.now(+1) //+1代表明天，+2代表后天，以此类推
    });
    
    //$('#start').html(UnixToDate((new Date()).getTime(),false,null));
    $('#start').html('');
    //$('#end').html(UnixToDate((new Date()).getTime(),false,null));
    $('#end').html('');
    
    $(function(){
      var flag="${flag}";
       choiceLeftMenu(flag);
    });
    /**
     *控制左侧菜单选中
     */
    function choiceLeftMenu(flag){
        $(".member_list").removeClass("active");
	    var indexVal =flag;
	    if(indexVal==2){
	    $(".member_list").eq(indexVal).click();
	    }
	   $(".member_list").eq(indexVal).addClass("active");
	    $(".member_show").eq(indexVal).css({
	        display: "block"
	    }).siblings().css({
	        display: "none"
	    });
	    $(".news_show").eq(0).css({
	        display: "block"
	    }).siblings().css({
	        display: "none"
	    });
	    $(".info_show").eq(0).css({
	        display: "block"
	    }).siblings().css({
	        display: "none"
	    });
	    $(".user_show").eq(0).css({
	        display: "block"
	    }).siblings().css({
	        display: "none"
	    });
    }
    
    function updateUserInfo(obj){
        $("#submit_btn").click();
    }
     $(function(){
    //jquery.validate
	$("#userInfo").validate({
	   rules: {
		   nickname: {
		         required: true,
		         maxlength: 20
		             },
           e_mail:{
                required: true,
                minlength: 6,
                maxlength: 30
                   },
           qq:{
                minlength: 6,
                maxlength: 30
                   }
             },   
      messages:{
		   nickname: {
			    required: "不能为空",
			    maxlength: "最大20位"
		             },
		   e_mail:{
                required: "不能为空",
                minlength: "长度在6-30个字符",
                maxlength: "长度在6-30个字符"
                   },
		   qq:{
                required: "密码不能为空",
                minlength: "长度在6-30个字符",
                maxlength: "长度在6-30个字符"
                   }
             },
      submitHandler: function() {
			//验证通过后 的js代码写在这里
			var url="updateSave.html";
	 $("#userInfo").ajaxSubmit({
         //定义返回JSON数据，还包括xml和script格式
         dataType:'json',
         beforeSend: function() {
             
         },
         url: url,
         type: 'POST',
         success:function(json) {
        	if(json.response=="success") {
        		location.href="memberCenter-1.html";
			}else if(json.response=="error"){
				alert(json.msg);
			}
         }
     });
		}
    });
	});
     
     function phoneChange(obj){
  	   var phonenum = $(obj).val();
  	   var session_phoneNum = $('#hidden_phoneNum').val();
  	    if(phonenum.length==11){
  	       $("#sendCodeBtn").removeClass("gray_btn_9").addClass("orange_btn_9");
  	       $("#sendCodeBtn").attr("onclick","sendCode(this)");
  	    }else if(phonenum == session_phoneNum){
  	    	 alert("此手机号码为当前手机号码，请更换!");
  	    	 $("#sendCodeBtn").removeClass("orange_btn_9").addClass("gray_btn_9");
    	     $("#sendCodeBtn").attr("onclick","");
  	    }else{
  	       $("#sendCodeBtn").removeClass("orange_btn_9").addClass("gray_btn_9");
  	       $("#sendCodeBtn").attr("onclick","");
  	    }
  	}
     
     //
     function checkChange(obj){
    	 var checkNum = $(obj).val();
    	 if(checkNum.length == 6){
    	       $("#sureBtn").removeClass("gray_btn_9").addClass("orange_btn_9");
    	       $("#sureBtn").attr("onclick","sureSubmit(this)");
    	    }else{
    	       $("#sureBtn").removeClass("orange_btn_9").addClass("gray_btn_9");
    	       $("#sureBtn").attr("onclick","");
    	    }
     }
     
     /**
      * 发送验证码
      */
     function sendCode(obj){
 	    $(obj).removeClass("orange_btn_9").addClass("gray_btn_9");   
 	    $("#phoneNum").attr('readonly',"readonly");
 	    $("#sendCodeBtn").attr("onclick","");
 	     var phonenum= $("#phoneNum").val();
 	      if(phonenum.length==11){
 	         $("#sendCodeBtn").text("验证码发送中..");   
 	          var url = "sendCode-"+phonenum+".html" ;
 				$.ajax({
 					type : "GET",
 					contentType : "application/json",
 					url : url,
 					data : "",
 					dataType : "json",
 					success : function(json) {
 						if (json.response =="success") {
 						    $("#sendCodeBtn").text("验证码已发送");
 		                    setTimeout(function(){
 		                    	$("#phoneNum").attr('readonly',false);
 		            	    	$("#sendCodeBtn").attr("onclick","sendCode(this)");
 						        $(obj).removeClass("gray_btn_9").addClass("orange_btn_9");
 						        $("#sendCodeBtn").text("重新获取");
 						    },80000);
 						} else {
 							alert(json.msg);
 						}
 					}
 				});
 	        }else{
 	          alert("请正确填写手机号码");
 	        }
 	        
 	    setTimeout(function(){
 	    	$("#phoneNum").attr('readonly',false);
 	    	$("#sendCodeBtn").attr("onclick","sendCode(this)");
 	    	$(obj).removeClass("gray_btn_9").addClass("orange_btn_9");
 	        $("#sendCodeBtn").text("重新获取");
 	    },80000);
 	}
     
     /**
      * 更新手机号码
      */
     function sureSubmit(obj){
    	 var phoneNum= $("#phoneNum").val();
    	 var checkNum = $("#checkNum").val();
    	 
    	 if(phoneNum.length == 11 && checkNum.length == 6){
	          var url = "updatePhoneNum-"+phoneNum+"-"+checkNum+".html" ;
				$.ajax({
					type : "GET",
					contentType : "application/json",
					url : url,
					data : "",
					dataType : "json",
					success : function(json) {
						if (json.response == "success") {
							alert("修改手机号码成功");
							location.href = "memberCenter-4.html";
						} else {
							alert(json.msg);
						}
					}
				});
    	 }else{
    		 alert("请正确填写手机号码或验证码");
    	 }
     }
     
     //更换密码
     function switchPassword(){
    	 var old_pass = $('#old_password').val();
    	 var new_pass = $('#new_password').val();
    	 var echo_pass = $('#echo_password').val();
 
    	 if(old_pass == '' || new_pass == '' || echo_pass == ''){
    		 alert('密码不能为空');
    	 }else if(new_pass != echo_pass){
    		 alert('两次密码不一样');
    	 }else{
			var url = "switchPassword-"+$.md5(old_pass)+"-"+$.md5(new_pass)+"-"+$.md5(echo_pass)+".html" ;
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : url,
				data : "",
				dataType : "json",
				success : function(json) {
					if (json.response == "success") {
						alert("修改密码成功");
						location.href = "memberCenter-4.html";
					} else {
						alert(json.msg);
					}
				}
			});
    	 }
     }
     
     //获取用户的收藏信息
     function getUserCollect(){
    	 var user_id = jQuery('#hidden_user_id').val();
    	 var url = "getUserCollect-"+user_id+".html" ;
    	 $.ajax({
			type : "GET",
			contentType : "application/json",
			url : url,
			data : "",
			dataType : "json",
			success : function(json) {
				if (json.collectList == "" || json.collectList == null) {
				    //alert('没有收藏商品');
					jQuery('#user_collect').html('<div class="collect_list" style="text-align: center;"><span style="color: #ccc; line-height: 120px;">您还没有收藏商品!</span></div>');
				}else {
					var content = "";
					jQuery.each(json.collectList,function(i,item){
						content += '<div class="collect_list">';
						content += '<div class="collect_list_pic">';
						content += '<img src="<%=basePath%>frontpage/images/collect.png" alt=""/>';
						content += '</div>';
						content += '<div class="collect_list_right">';
						content += '<div class="collect_name">';
						content += '<span>' + item.product_id.name + '</span>';
						content += '</div>';
						content += '<div class="collect_reception">';
						content += '<span>&nbsp;</span>';
						content += '</div>';
						content += '<div class="collect_cancel">';
						content += '<span onclick="cancelCollect(' + item.product_id.id + ')">取消收藏</span>';
						content += '</div>';
						content += '</div>';
						content += '</div>';
					});
					jQuery('#user_collect').html(content);
				}
			}
		});
     }
     
     /**
      * 取消收藏
      */
     function cancelCollect(product_id){
    	 var url = "productCollectSave-" + product_id + "-0.html" ;
         $.ajax({
			type : "GET",
			contentType : "application/json",
			url : url,
			data : "",
			dataType : "json",
			success : function(json) {
				if (json.response =="success") {
					getUserCollect();
				}else{
					alert(json.msg);
				}
			}
		});
     }
     
   //获取用户的订单信息
     function getUserOrder(){
    	 var user_id = jQuery('#hidden_user_id').val();
    	 var params = {
    		'order_name' : jQuery('#order_name').val(),
    		'order_status' : jQuery('#order_status').val(),
    		'order_start' : jQuery('#start').html(),
    		'order_end' : jQuery('#end').html()
    	 };

    	 var url = "getUserOrder-" + user_id + ".html" ;
    	 $.ajax({
			type : "POST",
			url : url,
			data : params,
			dataType : "json",
			success : function(json) {
				if (json.orderList == "" || json.orderList == null) {
				    //alert('没有订单信息');
				    //alert('ds');
					jQuery('#user_order').html('<div class="collect_list" style="text-align: center;"><span style="color: #ccc; line-height: 120px;">没有查询到订单信息!</span></div>');
				}else {
					var content = "";
					jQuery.each(json.orderList,function(i,item){
						content += '<div class="order_list">';
						content += '<div class="order_num float_l">';
						content += '<span>' + item.ordernum + '</span>';
						content += '</div>';
						content += '<div class="service_name float_l">';
						content += '<span>' + item.name + '</span>';
						content += '</div>';
						content += '<div class="money_num float_l">';
						content += '<span>' + (item.price == 0 ? '联系客服' : item.price) + '</span>';
						content += '</div>';
						content += '<div class="time float_l">';
						content += '<span>' + UnixToDate(item.creattime.time,true,null) + '</span>';
						content += '</div>';
						
						switch(item.status){
							case 1:
								content += '<div class="state float_l">';
								content += '<span>待完善个人资料</span>';
								content += '</div>';
								content += '<div class="operate float_l">';
								content += '<a class="complete_info orange_font" href="javascript:finishInfo();">完善资料</a>';
								//content += '<a class="cancel_btn gray_font" href="javascript:;">取消</a>';
								content += '</div>';
								break;
							case 2:
								content += '<div class="state float_l">';
								content += '<span>已提交待审核</span>';
								content += '</div>';
								content += '<div class="operate float_l">';
								//content += '<a class="cancel_btn gray_font" href="javascript:;">取消</a>';
								content += '</div>';
								break;
							case 3:
								content += '<div class="state float_l">';
								//content += '<span>立即付款</span>';href="javascript:showCustom('+item.id+');"
								content += '<a class="pay_now_btn orange_font" onclick="getCharge('+item.id+')">立即付款</a>';
								content += '</div>';
								content += '<div class="operate float_l">';
								content += '<a class="contact_service orange_font" href="javascript:showCustom('+item.id+');">联系客服</a>';
								//content += '<a class="cancel_btn gray_font" href="javascript:;">取消</a>';
								content += '</div>';
								break;
							case 4:
								content += '<div class="state float_l">';
								content += '<span>审核未通过</span>';
								content += '</div>';
								content += '<div class="operate float_l">';
								//content += '<a class="complete_info orange_font" href="javascript:finishInfo();;">完善资料</a>';
								//content += '<a class="cancel_btn gray_font" href="javascript:;">取消</a>';
								content += '</div>';
								break;
							case 5:
								content += '<div class="state float_l">';
								content += '<span>已付款</span>';
								content += '</div>';
								content += '<div class="operate float_l">';
								//content += '<a class="complete_info orange_font" href="javascript:;">完善资料</a>';
								content += '<a class="contact_service orange_font" href="javascript:showCustom('+item.id+');">联系客服</a>';
								//content += '<a class="cancel_btn gray_font" href="javascript:;">取消</a>';
								content += '</div>';
								break;
							case 6:
								content += '<div class="state float_l">';
								content += '<span>已完成</span>';
								content += '</div>';
								content += '<div class="operate float_l">';
								//content += '<a class="complete_info orange_font" href="javascript:;">完善资料</a>';
								content += '<a class="contact_service orange_font" href="javascript:showCustom('+item.id+');">联系客服</a>';
								//content += '<a class="cancel_btn gray_font" href="javascript:;">取消</a>';
								content += '</div>';
								break;
							case 7:
								content += '<div class="state float_l">';
								content += '<span>已取消</span>';
								content += '</div>';
								content += '<div class="operate float_l">';
								//content += '<a class="complete_info orange_font" href="javascript:;">完善资料</a>';
								content += '<a class="contact_service orange_font" href="javascript:showCustom('+item.id+');">联系客服</a>';
								//content += '<a class="cancel_btn gray_font" href="javascript:;">取消</a>';
								content += '</div>';
								break;
							case 8:
								content += '<div class="state float_l">';
								content += '<span>已关闭</span>';
								content += '</div>';
								content += '<div class="operate float_l">';
								//content += '<a class="complete_info orange_font" href="javascript:;">完善资料</a>';
								content += '<a class="contact_service orange_font" href="javascript:showCustom('+item.id+');">联系客服</a>';
								//content += '<a class="cancel_btn gray_font" href="javascript:;">取消</a>';
								content += '</div>';
								break;
							default:
								content += '<div class="state float_l">';
								content += '<span>无效</span>';
								content += '</div>';
								content += '<div class="operate float_l">';
								//content += '<a class="complete_info orange_font" href="javascript:;">完善资料</a>';
								content += '<a class="contact_service orange_font" href="javascript:showCustom('+item.id+');">联系客服</a>';
								//content += '<a class="cancel_btn gray_font" href="javascript:;">取消</a>';
								content += '</div>';
								break;
						}
						content += '</div>';
					});
					jQuery('#user_order').html(content);
				}
			}
		});
     }
    
   //获取客服人员
   function showCustom(order_id){
	   var url = "getOrderTeam-" + order_id + ".html" ;
	   $.ajax({
			type : "GET",
			contentType : "application/json",
			url : url,
			data : "",
			dataType : "json",
			success : function(json) {
				if (json.order_team != null) {
					jQuery('#custom_img').attr('src','../'+json.order_team.team_id.logo);
					jQuery('#custom_name').html(json.order_team.team_id.name);
					jQuery('#custom_qq').html(json.order_team.team_id.qq);
					jQuery('#custom_email').html(json.order_team.team_id.e_mail);
					jQuery('#custom_phone').html(json.order_team.team_id.phonenum);
					
					$(".gap").css({
				        display: "block"
				    });
				    $(".service_gap").css({
				        display: "block"
				    });
				}else{
					alert("未获取到客服人员");
				}
			}
		});
   }
   
   //跳转到完善资料页面
   function finishInfo() {
	   jQuery('#my_info').click();
	   jQuery('#update_info').click();
	 }
</script>
</body>
</html>
