<%@page import="vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>회원 조회</h2>
	<form action="search">
		검색할 회원 아이디 : <input type="text" name ="id">
		<input type="submit" value="조회">
	</form>
	
	<h1>전체 리스트</h1>
	<%ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");%>
	<table border="1"> 
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
	<%for(Member m  : list) {%>
		<tr>
			<td><%=m.getId() %></td>
			<td><%=m.getPwd()%></td>
			<td><%=m.getName() %></td>
			<td><%=m.getAge() %></td>

		</tr>
	
	<%} %>
	</table>
	
	
	
</body>
</html>