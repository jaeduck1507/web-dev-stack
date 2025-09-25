<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<!-- Ajax사용을 위한 js파일을 참조 -->
		<script src="js/httpRequest.js"></script>
		
		<script>
			//아이디 중복여부 체크
			let b_idCheck = false;
		
			function send(f){
				
				let id = f.id.value;
				if( id == '' ){
					alert("아이디를 입력하세요");
					return;
				}
				
				let name = f.name.value;
				if( name == '' ){
					alert("이름을 입력하세요");
					return;
				}
				
				//아이디 중복체크 여부 확인
				if( !b_idCheck ){
					alert("아이디 중복체크를 하세요");
					return;
				}
				
				f.action = "member_register.do";
				f.method = "post";
				f.submit();
			}
			
			//중복체크 버튼 클릭
			function check_id(){
				let id = document.getElementById("id").value.trim();
				
				if( id == '' ){
					alert("아이디를 입력하세요");
					return;
				}
				
				let url = "check_id.do";
				let param = "id="+id;
				sendRequest( url, param, resFn, "post" );
				
			}
			
			function resFn(){
				//콜백메서드
				//xhr.readyState 
				//0 : 초기화
				//1 ~ 3 : 로딩중
				//4 : 로드완료
				
				//xhr.status
				//200 : 이상없음
				//404, 500 : 이상있음
				if( xhr.readyState == 4 && xhr.status == 200){
					
					//data = "[{ result:yes, id:three }]"
					let data = xhr.responseText;
					
					let json = eval( data );
					
					if( json[0].result == 'no' ){
						alert( json[0].id + " 이미 사용중입니다" );
						return;
						
					}else{
						alert( json[0].id + "는 사용 가능합니다" );
						b_idCheck = true;
					}
				}
				
			}
			
			function che(){
				b_idCheck = false;
			}
			
		</script>
		
	</head>
	
	<body>
	 	<form>
	 		<table border="1">
	 			<caption>회원등록</caption>
	 			
	 			<tr>
	 				<th>이름</th>
	 				<td>
	 					<input name="name">
	 				</td>
	 			</tr>
	 			
	 			<tr>
	 				<th>아이디</th>
	 				<td>
	 					<input name="id" size="9" onInput="che()"
	 					       id="id">
	 					
	 					<input type="button" value="중복체크"
	 					       onClick="check_id()">
	 				</td>
	 			</tr>
	 			
	 			<tr>
	 				<th>비밀번호</th>
	 				<td>
	 					<input type="password" name="pwd">
	 				</td>
	 			</tr>
	 			
	 			<tr>
	 				<th>이메일</th>
	 				<td>
	 					<input name="email">
	 				</td>
	 			</tr>
	 			
	 			<tr>
	 				<th>주소</th>
	 				<td>
	 					<input name="addr">
	 				</td>
	 			</tr>
	 			
	 			<tr>
	 				<td colspan="2">
	 					<input type="button" value="등록"
	 					       onclick="send(this.form)">
	 					
	 					<input type="button" value="취소"
	 					       onClick="history.back()">
	 				</td>
	 			</tr>
	 			
	 		</table>
	 	</form>
	</body>
</html>













