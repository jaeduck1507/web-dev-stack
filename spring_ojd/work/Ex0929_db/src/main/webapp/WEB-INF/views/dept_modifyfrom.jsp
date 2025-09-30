<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
	function modify(f) {
		f.action = 'modify.do';
		f.submit();
	}
</script>
</head>
<body>
	<form action="">
		<table border="1">
			<tr>
				<td>부서번호</td>
				<td>${res.deptno}<input type="hidden" value="${res.deptno}" name="deptno"></td>
			</tr>
			<tr>
				<td>부서명</td>
				<td> <input type="text" value="${res.dname}" name="dname"></td>
			</tr>
			<tr>
				<td>부서위치</td>
				<td><input type="text" value="${res.loc}" name="loc"></td>
			</tr>
		</table>
		<input type="submit" value="수정" onclick="modify(this.form)">
	</form>
</body>
</html>