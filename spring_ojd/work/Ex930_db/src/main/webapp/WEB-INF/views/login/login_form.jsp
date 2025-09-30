<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script src="/member/resources/js/httpRequest.js"></script>
<script>
	function send(f) {
		
		let url = "check_login.do";
		let param = "id=" + f.id.value + "&pwd=" + encodeURIComponent(f.pwd.value);
		sendRequest(url,param,resultFn, "post");
	}
	
	// 콜백메서드
	function resultFn() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			
			// [{'res':'no_id'}]
			let data = xhr.responseText;
			let json = eval(data);
			if(json[0].res == 'no_id') {
				alert("존재하지 않는 아이디");
			} else if(json[0].res == 'no_pwd') {
				alert("비밀번호 불일치")
			} else {
				alert("로그인 성공!!");
				location.href="list.do";
			}
		}
	}
</script>
</head>
<body>
	<form>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td> <input name="id"> </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td> <input name="pwd" type="password"> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="로그인" onclick="send(this.form)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>