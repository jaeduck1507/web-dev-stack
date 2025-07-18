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
	<div >
		아이디 : <input type="text" id = "id" ><br>
		비밀번호 : <input type="password" id = "pwd"><br>
		나이 : <input type="text" id = "age"><br>
		이름 : <input type="text" id = "name"><br>
		<button id = "btn">회원가입</button>
	</div>
	<div id="result"></div>
	<!-- 
		중복체크 버튼 눌렀을 때 post 방식으로 
		/check로 id 값 넘겨서 결과값을 받아서
		아이디가 있으면 id 사용 불가 없으면 사용 가능
		스키마 : work, 테이블 member
	 -->
	
	<script >
		$("#btn").click(() => {
			const formData = new FormData();
			formData.append("id", $('#id').val());
			formData.append("pwd", $('#pwd').val());
			formData.append("age",$('#age').val());
			formData.append("name",$('#name').val());


			
					$.ajax({
				type : "post",
				url : "/register",
				data : formData,
				processData: false,
				contentType : false,
				success : function(response) {
                   console.log(response.name);
                   $("#result").text(response.name + "님이 회원가입 하셨습니다!");
                },
				error:function(xhr,status,error) {
					
				}
			})
		});
	</script>
	
</body>
</html>