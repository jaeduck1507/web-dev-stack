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
		<a href="/logout" id="logout">로그아웃</a><br>
		<a href="/mypage" id="mypage">마이페이지</a><br>
	
	</div>
		<a href="/admin" id="admin">관리자페이지</a><br>
	<script>
		const token = localStorage.getItem("token");
		if(token == null) {
			$("#a1").show();
			$("#a2").hide();
			$("#admin").hide();
			
		} else {
			$("#a1").hide();
			$("#a2").show();
			$("#admin").hide();
			$.ajax({
				url:'/check',
				type:'get',
				data:{token : token},
				success:function(data) {
					//console.log(data);
					if(data.role == "ROLE_ADMIN") $("#admin").show();
				}
			})
		}
		
		$("#logout").click((e) => {
			e.preventDefault();
			localStorage.removeItem("token");
			location.reload();
			
		});
		
		$("#mypage").click((e) => {
			e.preventDefault();
			$.ajax({
				url:'/mypage',
				type:'get',
				beforeSend: function(xhr) {
					xhr.setRequestHeader('Authorization','Bearer ' + token);
				},
				success:function(data) {
					$('body').html(data);
				}
			})
		});
		$("#admin").click((e) => {
			e.preventDefault();
			$.ajax({
				url:'/admin',
				type:'get',
				beforeSend: function(xhr) {
					xhr.setRequestHeader('Authorization','Bearer ' + token);
				},
				success:function(data) {
					$('body').html(data);
				}
			})
		});
	</script>
</body>
</html>