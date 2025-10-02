<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(f) {
		f.action = 'visit_modify.do';
		f.submit();
	}
</script>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		
		<table border="1">
			<tr>
				<th>작성내용</th>
				<td>
					<textarea rows="4" cols="50" name="content">${vo.content}</textarea>
				</td>
			</tr>
			
			<tr>
				<th>사진</th>
				<td>
				<img src="resources/upload/${vo.filename}">
					<input type="file" name="file">
					<input type="hidden" name="filename" value="${vo.filename}">
					
				</td>
			</tr>
			
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" value="${vo.name}">
				</td>
			</tr>
			
			
			
			<tr>
				<td colspan="2">
					<input type="hidden" name="idx" value="${vo.idx}">
					<input type="button" value="등록" onclick="send(this.form)">
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>