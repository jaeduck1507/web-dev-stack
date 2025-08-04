<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h1>로그인</h1>
	<form action="" id="frm">
	아이디 <input type="text" name="id" id="id"> <br>
	비밀번호 <input type="password" name="pwd" id="pwd"> <br>
	<button type="button" id="btn">로그인</button>
	</form>
	<script>
		$("#btn").click((e) => {
		const id = $("#id").val();
		const pwd = $("#pwd").val();
		const formData = new FormData();
		formData.append("id", $('#id').val());
		formData.append("pwd", $('#pwd').val());
		
		$.ajax({
			type : "post",
			url : "/login",
			data : formData,
			processData: false,
			contentType : false,
			success : function(data) {
               // localStrage에 token 키 값으로 저장
               // / <- index.jsp로 이동
				localStorage.setItem("token", data);
				location.href = "/";
            },
			error:function(xhr,status,error) {
				
			}
		})
		
		});
	</script>
</body>
</html>