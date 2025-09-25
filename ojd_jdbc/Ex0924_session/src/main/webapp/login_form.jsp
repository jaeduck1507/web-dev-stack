<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script src="js/httpRequest.js"></script>
		
		<script>
			function send(f){
				let id = f.id.value.trim();
				let pwd = f.pwd.value.trim();
				
				let url = "login.do";
				let param = "id="+id+"&pwd="+encodeURIComponent(pwd);
				
				sendRequest( url, param, resultFn, "post" );
			}
			
			function resultFn(){
				
				if( xhr.readyState == 4 && xhr.status == 200 ){
					
					//data = "[{param:no_id}]"
					let data = xhr.responseText;
					
					let json = eval( data );
					
					if( json[0].param == 'no_id' ){
						alert("아이디가 존재하지 않습니다");
					}else if( json[0].param == 'no_pwd' ){
						alert("비밀번호가 일치하지 않습니다");
					}else{
						//로그인 성공
						location.href='main_content.jsp';
					}
					
				}
				
			}
			
		</script>
		
	</head>
	
	<body>
		<form>
			<table border="1">
				<caption>로그인</caption>
				
				<tr>
					<th>아이디</th>
					<td>
						<input name="id">
					</td>
				</tr>
				
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pwd"/>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="button" value="로그인"
						       onClick="send(this.form)">
						       
						<input type="reset" value="취소">       
					</td>
				</tr>
				
			</table>		
		</form>
	</body>
</html>






























