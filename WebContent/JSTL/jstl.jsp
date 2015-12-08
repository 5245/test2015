<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hm.domain.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--  版本过低，改成下面的就可以支持CSS了。
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
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
  	<%
  		request.setAttribute("data",null);

  	 %>
  	 <br/>------------------------c:out标签--------------------------<br/>
  	<%--当设置escapeXML的属性为true时，将value中的值以字符串的形式原封不动的显示出来 --%>
  	<c:out value="${data}" default="如果value为空，输出default中的缺省值" escapeXml=""></c:out> <br/>
  	<c:out value="<a href='www.baidu.com'>超链接</a>" default="如果value为空，输出default中的缺省值" escapeXml="true"></c:out>
  	
  	<br/>---------c:set标签可以操作各个域、javabean、Map集合----------<br/>
  	<c:set var="data2" value="xxxxx" scope="page"/>
  	page域中的值：${data2 }   
  	<br/>
  	<%
  			Map map=new HashMap();
  			request.setAttribute("map",map);
  	 %>
  	 <c:set property="dd" value="yyyyyyy" target="${map}"/>
  	map的值： ${map.dd }
  	 <br/>
  	 <%
  	 	Person p=new Person();
  	 	request.setAttribute("p",p);
  	  %>
  	 <c:set property="name" value="沃尔玛" target="${p}"/>
  	 bean中的值：${p.name }
  	 <br/>-------------------分页中页码---------------------------<br/>
  	 <c:forEach	var="num" begin="1" end="9" step="1">
  	 	 ${num }
  	 </c:forEach>
  	<br/>
  	表格间色显示：<br/>
  	<%
  		List list =new ArrayList();
  		list.add("aaa");
  		list.add("bbb");
  		list.add("ccc");
  		list.add("ddd");
  		list.add("eee");
  		list.add("fff");
  		request.setAttribute("list",list);
  	 %>
  	 <style>
  	 	.odd{background-color: #FF99FF;}
  	 	.even{background-color:#FF6633; }
  	 	tr:hover{background-color:#0000FF;}
  	 </style>
  	 <table border="1" width="20%">
	  	 <c:forEach var="str" items="${list}" varStatus="status">
	  	 	<tr  class="${status.count%2==0?'even':'odd' }">	  <%--status记住当前是第几次迭代 --%>
	  	 		<td>${str }</td>
	  	 	</tr>
	  	 </c:forEach>
  	 </table>
  	 <br/>-----------------------c:url标签----------------------------<br/>
  	 <c:url var="url" value="/JSTL/1.jsp"/>  <%--构建url时，还给出了${pageContext.request.contextPath}的前缀，给出session的id号防止用户禁用cookies， --%>
  	 <a href="${url}">购买</a>
  	 <br/>
  	 <c:url var="url2" value="/index.jsp">
  	 	<c:param name="name" value="中国"/>  <%--这个参数如果是中文的话，c:url会自动url编码的 --%>
  	 </c:url>
  	 <a href="${url2}">购买</a>
  	 
  	 <br/>--------------------c:forTokens----------------------------<br/>
  	 <%
  	 	request.setAttribute("d","aa,bb,cc");
  	  %>
  	 <c:forTokens var="s" items="${d}" delims=",">
  	 	${s }
  	 </c:forTokens>
  </body>
</html>
