<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>encoding</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	
	<h1>회원가입</h1>
	아이디 : <input type="text" id = "id">
	<input type="button" value="중복체크" id = "idCheck">
	<span id= "idCheckView"></span>
	<!-- 
		중복체크 버튼 눌렀을 때 post 방식으로 
		/check로 id 값 넘겨서 결과값을 받아서
		아이디가 있으면 id 사용 불가 없으면 사용 가능
		스키마 : work, 테이블 member
	 -->
	
	<script >
		$("#idCheck").click(() => {
			const id = $("#id").val();
					$.ajax({
				type : "post",
				url : "/check",
				data : "id=" + id,
				success : function(result) {
                    $("#idCheckView").text(result? "아이디 사용가능":"아이디 중복");
                },
				error:function(xhr,status,error) {
					
				}
			})
		});
	</script>
	
</body>
</html>