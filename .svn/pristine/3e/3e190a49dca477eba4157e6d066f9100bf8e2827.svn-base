<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<base href="<%=basePath%>"> 

    <div class="vernav2 iconmenu">
    	<ul>
    	<s:action name="menuShow" namespace="/manage"/>
    	<c:forEach var="level1" items="${menu.childrens}">
			<li>
				<a href="${level1.url}" class="elements" style="background-image: url('${level1.logopath}');">${level1.name}</a>
				<c:if test="${!empty level1.childrens}">
					<span class="arrow"></span>
					<ul id="${level1.descmark}">
						<c:forEach var="level2" items="${level1.childrens}" varStatus="st">
							<li id="${level2.descmark}">
								<a href="${level2.url}">${level2.name}</a>
							</li>
						</c:forEach>
					</ul>
				</c:if>
			</li>
		</c:forEach> 
            
        </ul>
        <a class="togglemenu"></a>
        <br /><br />
    </div><!--leftmenu-->

