<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
	function register(f) {
		f.action = 'register.do';
		f.method='post';
		f.submit();
	}
</script>
</head>
<body>
	<form>
	<table border="1">
	
		<tr>
			<td>이름</td>
			<td> <input type="text" name="name"> </td>
		</tr>
		
		<tr>
			<td>아이디</td>
			<td> <input type="text" name="id"> </td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td> <input type="password" name="pwd"> </td>
		</tr>
		
		<tr>
			<td>이메일</td>
			<td> <input type="text" name="email"> </td>
		</tr>
		
		<tr>
			<td>주소</td>
			<td> <input type="text" name="addr"> </td>
		</tr>
	</table>
	<input type="button" value="등록" onclick="register(this.form)">
	<input type="button" value="취소" onclick="history.go(-1)">
	</form>
</body>
</html>