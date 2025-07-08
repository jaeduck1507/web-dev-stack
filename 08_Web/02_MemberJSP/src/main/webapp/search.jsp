<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 조회</h1>
	<%Member member = (Member)request.getAttribute("member"); %>
	<%if(member != null) {%>
	<h3>아이디 : <%=member.getId()%> 비밀번호 : <%=member.getPwd() %> 이름 : <%=member.getName() %> 나이 : <%=member.getAge() %></h3>
	<%} else { %>
	<h3>아이디가 <%= request.getParameter("id") %>인 회원정보가 없습니다!</h3>
	<%} %>
</body>
</html>