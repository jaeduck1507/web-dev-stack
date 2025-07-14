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
		</c:otherwise>	
	
	</c:choose>
	<!-- 회원 전체 목록-->
	<c:forEach items = "${list}" var = "mList" varStatus = "status">
			
			<h3>${status.count}.</h3>
			<h3>회원 아이디 : ${mList.id}</h3>
			<h3>회원 이름 : ${mList.name}</h3>
			<h3>회원 나이 : ${mList.age}</h3>
	</c:forEach>
	
	
</body>
</html>