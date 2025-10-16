<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/email/resources/js/httpRequest.js"></script>
<style>
	body {
		margin: 0;
		height: 100vh;
		display: flex;
		align-items: center;
		justify-content: center;
		flex-direction: column;
		
	}
	
	form {
		padding: 20px 50px;
		border-radius: 8px;
    	box-shadow: 0 4px 8px rgba(0,0,0,0.1);
	}
	
	#mail_check_warn {
		height: 20px;
	}
	
	input[type="text"] {
		box-sizing: border-box;
		height: 40px;
		width: 200px;
		margin-bottom: 10px;
		border: 1px solid #ccc;
    	border-radius: 6px;
    	font-size: 14px;
	}
	
	input[type="button"] {
		
		box-sizing: border-box;
		height: 40px;
		margin-bottom: 10px;
		border: none;
    	border-radius: 6px;
    	font-size: 16px;
	}
	
	input[type="button"]:hover {
		cursor: pointer;
		background-color: black;
		color: white;
		
		
	}
	
	
	
</style>

	<script>
		function mailCheck(f) {
			let userEmail = f.userEmail.value;
			let url = "mailCheck.do";
			let param = "email=" + userEmail;
			sendRequest(url,param,resultMail,"post") ; // ajax 처리
			
		}
		
		let res; // 인정번호를 담을 res를 전역변수로 선언(이유 : 함수내에서 실행해서 담은 변수 값의 보존을 위해서)
		
		function resultMail() { // sendRequest에서 콜백함수 정의
			if(xhr.readyState == 4 && xhr.status == 200) {
				// 응답의 xhr.responseText에 있는 인증 번호 값을 data에 삽입
				let data = xhr.responseText;
				alert("인증코드가 이메일로 전송 되었습니다");
				
				let check_input = document.getElementById("check_input"); // 이메일에 메일 전송 완료시 check_input(인증번호 작성할 input태그) 활성화
				check_input.disabled = false;
				res = data; // 전역 변수에 삽입
			}
		}
		
		function change_input() {
			let check_input = document.getElementById("check_input"); 
			let mail_check_warn = document.getElementById("mail_check_warn"); // 인증번호 일치 여부 표시 태그
			
			if(check_input.value == res) { // 전역 변수로 저장한 res값과 check_input에 입력한 value값이 일치하는지 확인
				mail_check_warn.innerHTML = "인증성공"; // 인증번호 일치시 mail_check_warn에 메세지 출력
			}else {
				mail_check_warn.innerHTML = "인증번호 불일치";
			}
			
		}
		
	</script>

</head>
<body>
	<form>
		<input name="userEmail" placeholder="email address" type="text"/>
		<input type="button" value="본인인증" onclick="mailCheck(this.form)"> <br>
		
		<input id="check_input" placeholder="인증번호 6자리" maxlength="6" disabled="disabled" type="text"/>
		
		<input type="button" value="인증번호 확인" onclick="change_input()">
		
		<div id="mail_check_warn"></div>
	</form>
	
	
</body>
</html>