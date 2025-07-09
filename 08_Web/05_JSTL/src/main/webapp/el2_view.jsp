<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. 기존 방식</h2>
	<%
		String id = request.getParameter("id");
		String[] hobby = request.getParameterValues("hobby");
		
	%>
	<p>아이디 : <%= id %></p>
	<p>취미 : <%=String.join(", ", hobby) %></p>
	
	<h2>2. el</h2>
	<p>아이디 : ${param.id}</p>
	<p>취미 :${paramValues.hobby[0]}</p>
	
	
</body>
</html>