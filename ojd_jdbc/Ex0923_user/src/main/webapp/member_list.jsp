<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script src="js/httpRequest.js"></script>
		
		<script>
			function del( idx ){
				
				if( !confirm("정말로 삭제하시겠습니까?") ){
					return;
				}
				
				//location.href='member_del.do?idx='+idx;
				let url = "member_del.do";
				let param = "idx="+ encodeURIComponent(idx);
				sendRequest( url, param, resDel, "post" );
			}
			
			function resDel(){
				
				if( xhr.readyState == 4 && xhr.status == 200 ){
					
					//data = "[{'res':'no'}]"
					let data = xhr.responseText;
					
					let json = eval( data );
					
					if( json[0].res == 'yes' ){
						alert("삭제성공");
						location.href='list.do';
					}else{
						alert("삭제실패");
					}
				}
				
			}
			
		</script>
		
	</head>
	
	<body>
		<table border="1">
			<caption>회원 목록</caption>
			
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>비고</th>
			</tr>
			
			<c:forEach var="vo" items="${ list }">
				<tr>
					<td>${ vo.idx }</td>
					<td>${ vo.name }</td>
					<td>${ vo.id }</td>
					<td>${ vo.pwd }</td>
					<td>${ vo.email }</td>
					<td>${ vo.addr }</td>
					<td>
						<input type="button" value="수정"
						       onclick="location.href='modify_sel.do?idx=${vo.idx}'">
						
						<input type="button" value="삭제" 
						       onClick="del( '${vo.idx}' )">
					</td>
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="7">
					<input type="button" value="등록"
					       onclick="location.href='regi_form.jsp'">
				</td>
			</tr>
			
		</table>
	</body>
</html>













