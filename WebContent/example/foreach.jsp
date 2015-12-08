<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.hsnc.com.mytag" prefix="hm" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    
    <title>foreach标签</title>
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
  	<%--模拟用户登录  --%>
 	 <br/>----------------------迭代单列集合List---------------------------<br/> 
 	 <%
  		List list =new ArrayList();
  		list.add("aaa");
  		list.add("bbb");
  		list.add("ccc");
  		request.setAttribute("list",list);
  	 %>
  	
  <hm:foreach var="user" items="${list}">
  		${user} <br/>
  </hm:foreach>
 <br/>----------------------迭代双列集合Map---------------------------<br/> 
   <%
  		Map map =new HashMap();
  		map.put("aa","1111");
  		map.put("bb","2222");
  		map.put("cc","3333");
  		request.setAttribute("map",map);
  	 %>
  	
  <hm:foreach var="entry" items="${map}">
  		${entry.key}=${entry.value } <br/>
  </hm:foreach>
   
  <br/>----------------------迭代对象数组---------------------------<br/>  
   <%
  		Integer num[]={1,2,3,4,5};
  		request.setAttribute("num",num);
  	 %>
  	
  <hm:foreach var="i" items="${num}">
  		${i}
  </hm:foreach>
  
 <br/>----------------------迭代(8种基本类型的数组)int集合---------------------------<br/> 
   <%
  		int arr[]={1,2,3,4,5};
  		request.setAttribute("arr",arr);
  	 %>
  	
  <hm:foreach var="i" items="${arr}">
  		${i} 
  </hm:foreach>
  
  <br/>----------------------迭代迭代(8种基本类型的数组)double集合---------------------------<br/> 
   <%
  		double d[]={1f,10f,100f};
  		request.setAttribute("d",d);
  	 %>
  	
  <hm:foreach var="double" items="${d}">
  		${double} 
  </hm:foreach>
 <br/>----------------------迭代迭代(8种基本类型的数组)boolean集合---------------------------<br/> 
   <%
  		boolean b[]={true,false,false};
  		request.setAttribute("b",b);
  	 %>
  	
  <hm:foreach var="boolean" items="${b}">
  		${boolean} 
  </hm:foreach>
  
  <br/>----------------------迭代迭代String集合---------------------------<br/> 
   <%
  		String s[]={"hm","hhm","hhhm","hhhhm"};
  		request.setAttribute("s",s);
  	 %>
  	
  <hm:foreach var="string" items="${s}">
  		${string} 
  </hm:foreach>
  
  </body>
</html>
