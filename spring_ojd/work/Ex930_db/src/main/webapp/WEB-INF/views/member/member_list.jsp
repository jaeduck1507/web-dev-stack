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
	
	// �ݹ�޼���
	function resultFn() {
		
		if(xhr.readyState == 4 && xhr.status == 200) {
			
			// [{'res':'no_id'}]
			let data = xhr.responseText;
			
			if(data == 'yes') {
			alert('���� �Ϸ�');
			} else {
			alert('���� ������');
			}
			location.reload();
			
		}
	}
	
	// ���� ������ ��ȯ
	function modify(idx) {
		location.href = 'modify_form.do?idx=' + idx;
	}
</script>
</head>
<body>
	
	<table border="1">
		<tr>
			<td>ȸ����ȣ</td>
			<td>ȸ���̸�</td>
			<td>���̵�</td>
			<td>��й�ȣ</td>
			<td>�̸���</td>
			<td>�ּ�</td>
			<td>���</td>
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
					<input type="button" value="����" onclick="modify('${m.idx}')">
					<input type="button" value="����" onclick="deleteMember('${m.idx}')">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7">
				<input type="button" value="���" onclick="location.href='member_regi_form.do'">
			</td>
		</tr>
	</table>
	
	
</body>
</html>