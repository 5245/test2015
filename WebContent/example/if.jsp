<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.hsnc.com.mytag" prefix="hm" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    
    <title>if标签</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<%--模拟用户登录
 	 <%
  		session.setAttribute("user","denglu");
  	 %>
  	  --%>
  <hm:if test="${user==null}">
  		你还没有登录
  </hm:if>
  
  <hm:if test="${user!=null}">
  		会员可以看到的内容
  </hm:if>
   		
  </body>
</html>
