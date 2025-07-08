<%@page import="vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/views/CSS/main.css">
</head>
<body>
	<div class="box">
		
		<%ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list"); %>
		<%if(list.size() != 0) { %>
		<%for(Member member : list) { %>
		<h3>아이디 : <%=member.getId() %>, 이름 : <%=member.getName() %>, 나이 : <%=member.getAge() %></h3>
		<%} %>
		<%} else { %>
		<h3>회원정보가 없습니다.</h3>
		<%} %>
		<a href="/">페이지 돌아가기</a>
	</div>
</body>
</html>