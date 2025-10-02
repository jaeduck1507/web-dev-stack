<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function send(f) { // 등록시 데이터 post로 전송
		if(f.pwd.value.trim() == '') {
			alert('비밀번호를 입력해주세요');
			return;
		}
		if(f.file.value == '') {
			alert('사진을 넣어주세용');
			return;
		}
		
		f.action = 'visit_register.do';
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
					<textarea rows="4" cols="50" name="content"></textarea>
				</td>
			</tr>
			
			<tr>
				<th>사진</th>
				<td>
					<input type="file" name="file">
				</td>
			</tr>
			
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pwd">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="button" value="등록" onclick="send(this.form)">
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>