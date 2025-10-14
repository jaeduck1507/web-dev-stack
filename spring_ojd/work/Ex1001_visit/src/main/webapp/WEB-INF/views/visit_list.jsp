<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="/visit/resources/js/httpRequest.js"></script>
	<style>
		p {
			margin: 0;
		}
		.visit_box {
			text-align: left;
			
			width: 600px;
			border: 1px solid;
			border-color: blue;
			margin-top: 20px;
			margin-bottom: 20px;
		}
	</style>
	<script>
		// 수정,삭제를 위한 ajax 함수
		function visit_fn(f,m) { // f : form m: 수정,삭제 구분을 위한 인자
			let url = '';
			let param = 'idx=' + f.idx.value + "&pwd=" + encodeURIComponent(f.pwd.value);
			if(m == 'del') { // 삭제 시 url 변경 및 sendRequest 함수에 콜백함수(delFn) 지정 
				if(confirm('삭제하시겠습니까?')) {
				url = 'visit_delete.do';
				sendRequest(url,param,delFn, "post");
					
				} 
			}
			else if(m == 'mod') { // 수정 시 url 변경 및 sendRequest 함수에 콜백함수(modifyFn) 지정
				url = 'visit_modify_pwd_check.do';
				sendRequest(url,param,modifyFn, "post");
			}
		}
		
		function delFn() { // 삭제시 콜백함수
			if(xhr.readyState == 4 && xhr.status == 200) {
				let data = xhr.responseText; // data는 no error yes 3가지 형태로 들어옴
				if(data == 'no') {
					alert("비밀번호가 일치하지 않습니다!!");
				} else if(data == 'error') {
					alert("오류로 인해 삭제 불가");
				} else{
					alert("삭제완료!");
					location.reload();
				}
				
			}
		}
		
		function modifyFn() { // 수정시 콜백함수
			if(xhr.readyState == 4 && xhr.status == 200) {
				let data = xhr.responseText;
				
				if(data == '-1') {
					alert("비밀번호가 일치하지 않습니다!!");
				} else {
					
					location.href = 'visit_modify_form.do?idx=' + data; // data에 idx값을 담아 수정폼으로 이동
				} 
				
				
			}
		}
	</script>
</head>
<body>

	<div align="center">
	
	<h1>::::방명록 리스트::::</h1>
	<input type="button" value="글쓰기" onclick="location.href = 'visit_regi_form.do'">
		<div>
			<c:forEach var="v" items="${list}">
				<div class="visit_box">
					<div style="background:skyblue">
						<p>${v.content}</p>
						<c:if test="${v.filename ne 'no_file'}">
							<img src="resources/upload/${v.filename}">
						</c:if>
					</div>
					<div style="background:fuchsia">
						작성자:${v.name} (${v.ip})
					</div>
					<div style="background:orange">
						작성일자: ${v.regdate}
					</div>
					<form>
						<div style="background:silver">
							비밀번호: <input type="password" name="pwd">
							<input type="hidden" name="idx" value="${v.idx}">
							<input type="button" value="수정" onclick="visit_fn(this.form,'mod')">
							<input type="button" value="삭제" onclick="visit_fn(this.form,'del')">
						</div>
					</form>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>