<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

   <div class="topheader">
        <div class="left">
            <h1 class="logo">WESTINNO&nbsp;</h1>
            <span class="slogan">管理系统</span>

            <div class="search">
            	<form action="" method="post">
                	<input type="text" name="keyword" id="keyword"  disabled="disabled" placeholder="请输入" />
                    <button class="submitbutton"></button>
                </form>
            </div><!--search-->

            <br clear="all" />

        </div><!--left-->

        <div class="right">
            <div class="userinfo">
            	<img src="images/thumbs/avatar.png" alt="" />
                <span>${ADMIN.username}</span>
            </div><!--userinfo-->

            <div class="userinfodrop">
            	<div class="avatar">
                	<a href="javascript:;"><img src="images/thumbs/avatarbig.png" alt="" /></a>
                    <div class="changetheme">
                    	切换主题: <br />
                    	<a class="default"></a>
                        <a class="blueline"></a>
                        <a class="greenline"></a>
                        <a class="contrast"></a>
                        <a style="display: none;" class="custombg"></a>
                    </div>
                </div><!--avatar-->
                <div class="userdata">
                	<h4>${ADMIN.username}</h4>
                    <ul>
						<li><a>
                    		<c:choose>
                    			<c:when test="${ADMIN.role_type == 0}">超级管理员</c:when>
                    			<c:when test="${ADMIN.role_type == 1}">总经理</c:when>
                    			<c:when test="${ADMIN.role_type == 2}">人事部</c:when>
                    			<c:when test="${ADMIN.role_type == 3}">销售经理</c:when>
                    			<c:otherwise>状态错误</c:otherwise>
                    		</c:choose>
                    	</a></li>
                        <li><a href="manage/adminUpdatePassword.action?admin.id=${ADMIN.id}" >账号密码修改</a></li>
                        <li style="padding-top: 15px;"><a href="manage/adminLogout.action" >退出</a></li>
                    </ul>
                </div><!--userdata-->
            </div><!--userinfodrop-->
        </div><!--right-->
    </div><!--topheader-->