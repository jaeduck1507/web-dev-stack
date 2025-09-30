<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>
	<input type="button" value="부서 추가" onclick="location.href = 'insertform.do'"> <br>
	<table border="1">
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>위치</th>
			<th colspan="2">수정/삭제</th>
		</tr>
		<c:forEach var="d" items="${list}">
		<tr>
			<td>${d.deptno}</td>
			<td>${d.dname}</td>
			<td>${d.loc}</td>
			<td><input type="button" value="수정" onclick="location.href = 'modifyform.do?deptno=${d.deptno}'"></td>
			<td><input type="button" value="삭제" onclick="location.href = 'delete.do?deptno=${d.deptno}'"></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>