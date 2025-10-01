<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="/member/resources/js/httpRequest.js"></script>
<script>
	function deleteMember(idx) {
		
		let url = "member_delete.do";
		let param = "idx=" + idx;
		sendRequest(url,param,resultFn, "get");
	}
	
	// 콜백메서드
	function resultFn() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			
			// [{'res':'no_id'}]
			let data = xhr.responseText;
			
			if(data == 'yes') {
			alert('삭제 완료');
			} else {
			alert('삭제 실패잇');
			}
			location.reload();
			
		}
	}
	
	// 수정 폼으로 전환
	function modify(idx) {
		location.href = 'modify_form.do?idx=' + idx;
	}
</script>
</head>
<body>
	
	<table border="1">
		<tr>
			<td>회원번호</td>
			<td>회원이름</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>주소</td>
			<td>비고</td>
		</tr>
		<c:forEach var="m" items="${list}">
			<tr>
				<td>${m.idx}</td>
				<td>${m.name }</td>
				<td>${m.id }</td>
				<td>${m.pwd }</td>
				<td>${m.email }</td>
				<td>${m.addr }</td>
				<td>
					<input type="button" value="수정" onclick="modify('${m.idx}')">
					<input type="button" value="삭제" onclick="deleteMember('${m.idx}')">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7">
				<input type="button" value="등록" onclick="location.href='member_regi_form.do'">
			</td>
		</tr>
	</table>
	
	
</body>
</html>