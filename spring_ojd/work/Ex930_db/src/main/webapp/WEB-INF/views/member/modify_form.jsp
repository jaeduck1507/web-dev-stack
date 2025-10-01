<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
	function modify(f) {
		
		if(f.pwd.value.trim() == '') {
			alert("비밀번호 필수");
			return;
		}
		
		f.method="post";
		f.action = "modify_fin.do";
		f.submit();
		
	}
</script>
</head>
<body>
	<form>
		<input type="hidden" name="idx" value="${vo.idx}">
		<table border="1">
			<tr>
				<th>이름</th>
				<td> <input name="name" value="${vo.name }"> </td>
			</tr>
			<tr>
				<th>아이디</th>
				<td> <input name="id" value="${vo.id }"> </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td> <input name="pwd"> </td>
			</tr>
			<tr>
				<th>이메일</th>
				<td> <input name="email" value="${vo.email }"> </td>
			</tr>
			<tr>
				<th>주소</th>
				<td> <input name="addr" value="${vo.addr }"> </td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" value="수정" onclick="modify(this.form)">
					<input type="button" value="취소" onclick="history.go(-1)">
				</th>
			</tr>
		</table>
	</form>
</body>
</html>