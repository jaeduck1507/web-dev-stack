<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>회원관리</h1>
	<c:choose>
		<c:when test = "${member == null}">
			<a href="/register">회원가입</a>
			<a href="/login">로그인</a>	
		
		</c:when>
		<c:otherwise>
			<h3>${member.name}님 환영합니다</h3>
			
	<!-- 로그인한 사람의 정보 수정-->
			<form action ="/update" method="post">
					이름 : <input type= "text" name = "name" value = "${member.name}""><br>
					비밀번호 : <input type= "password" name = "pwd" value = "${member.pwd}"}><br>
					나이 : <input type= "text" name = "age" value = "${member.age}"><br>
					<input type= "submit" name = "회원정보 수정">
			</form>	
			<a href="/delete">회원탈퇴</a>
			<h2>비밀번호만 수정</h2>
			<form action ="/update" method="post">
								비밀번호 : <input type= "password" name = "pwd" value = "${member.pwd}"}><br>
								<input type= "submit" name = "비밀번호 수정">
						</form>	
		</c:otherwise>	
	
	</c:choose>
	
	<form action ="/search">
				<select name = "select">
					<option value="all">이름 또는 아이디</option>
					<option value="id">아이디</option>
					<option value="name">이름</option>
				</select>
						<input type= "text" name = "keyword" placeholder= "아이디 입력"><br>
						<input type= "submit" name = "검색">
				</form>	
	
	<!-- 회원 전체 목록-->
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
		${searchList}
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.pwd}</td>
				<td>${item.name}</td>
				<td>${item.age}</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>