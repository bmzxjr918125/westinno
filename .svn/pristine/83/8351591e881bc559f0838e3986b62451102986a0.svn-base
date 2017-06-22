    <%@page import="java.io.File"%>
        <%@page import="java.util.Properties"%>
        <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
       
        <%@ page import="java.io.FileInputStream" %>


            <%
    request.setCharacterEncoding( Uploader2BD.ENCODEING );
    response.setCharacterEncoding( Uploader2BD.ENCODEING );
    
    String currentPath = request.getRequestURI().replace( request.getContextPath(), "" );

    File currentFile = new File( currentPath );

    currentPath = currentFile.getParent() + File.separator;

    //加载配置文件
    String propertiesPath = request.getSession().getServletContext().getRealPath( currentPath + "config.properties" );
    Properties properties = new Properties();
    try {
        properties.load( new FileInputStream( propertiesPath ) );
    } catch ( Exception e ) {
        //加载失败的处理
        e.printStackTrace();
    }
    
    Uploader2BD up = new Uploader2BD(request);
    
    up.setSavePath("upload"); //保存路径
    String[] fileType = { ".swf"};  //允许的文件类型
    up.setAllowFiles(fileType);
    up.setMaxSize(500 * 1024);        //允许的文件最大尺寸，单位KB
    up.upload();
    response.getWriter().print("{'url':'"+up.getUrl()+"','fileType':'"+up.getType()+"','state':'"+up.getState()+"','original':'"+up.getOriginalName()+"'}");

%>
