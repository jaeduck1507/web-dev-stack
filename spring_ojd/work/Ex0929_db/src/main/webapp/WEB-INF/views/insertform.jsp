<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
	function register(f) {
		f.action = 'insert.do';
		f.submit();
	}
</script>
</head>
<body>
	<form action="">
		<table border="1">
			<tr>
				<td>부서번호</td>
				<td><input type="text"  name="deptno"></td>
			</tr>
			<tr>
				<td>부서명</td>
				<td> <input type="text"  name="dname"></td>
			</tr>
			<tr>
				<td>부서위치</td>
				<td><input type="text"  name="loc"></td>
			</tr>
		</table>
		<input type="submit" value="등록" onclick="register(this.form)">
	</form>
</body>
</html>