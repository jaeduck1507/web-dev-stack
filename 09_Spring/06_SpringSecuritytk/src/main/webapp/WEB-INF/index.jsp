<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>전체 페이지</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>전체 페이지</h1>
	<div id="a1" >
			<a href="/login" >로그인</a><br>
			<a href="/register">회원가입</a><br>
	</div>
	
	<div id = "a2" >
		<a href="/logout" >로그아웃</a><br>
		<a href="/mypage">마이페이지</a><br>
	
		<a href="/admin">관리자페이지</a><br>
	</div>
	<script>
		const token = localStorage.getItem("token");
		console.log(token);
		if(token == null) {
			$("#a1").show();
			$("#a2").hide();
		} else {
			$("#a1").hide();
			$("#a2").show();
		}
	</script>
</body>
</html>