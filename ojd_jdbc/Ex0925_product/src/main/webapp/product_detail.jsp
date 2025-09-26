<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/httpRequest.js"></script>
<script>
	function addCart(idx, m_idx) {
		
		let url = "cart_insert.do";
		let param = "idx=" + idx + "&m_idx=" + m_idx;
		
		sendRequest(url,param,resultAdd, "post");
		
	}
	
	function resultAdd() {
		if(xhr.readyState == 4 & xhr.status == 200) {
			// [{'result':'%s'}]
			let data = xhr.responseText;
			
			let json = eval(data);
			
			if(json[0].result == 'yes') {
				alert("장바구니에 담았습니다");
				
				if(confirm("장바구니로 이동하시겠습니까")) {
					location.href="cart_list.do?m_idx=1";
				}
			} else {
				alert("이미 장바구니에 담겨져 있습니다");
			}
		}
	}
</script>
</head>
<body>
	<jsp:include page="index.jsp" />

	<table border="1" align="center" width="600">
		<tr>
			<td>카테고리</td>
			<td>${vo.category}</td>
		</tr>

		<tr>
			<td>제품코드</td>
			<td>${vo.p_num }</td>
		</tr>

		<tr>
			<td>제품명</td>
			<td>${vo.p_name }</td>
		</tr>

		<tr>
			<td>제조사</td>
			<td>${vo.p_company }</td>
		</tr>

		<tr>
			<td>가격</td>
			<td> 
			<fmt:formatNumber value="${vo.p_price }"/>원
			(할인가 : <fmt:formatNumber value="${vo.p_saleprice }"/>원)
			 </td>
		</tr>

		

		<tr>
			<td colspan="2" align="center">제품설명</td>

		</tr>

		<tr align="center">
			<td colspan="2">
				<img src="images/${vo.p_image_l}">
				<br><br>
				<pre>${vo.p_content }</pre>
			</td>
		</tr>

		<tr>
			<td colspan="2" align="center">
				<input type="button" value="장바구니 담기"
				onclick="addCart('${vo.idx}','${1}')"/> 
				<input type="button" value="장바구니 보기"
				onclick="location.href='cart_list.do?m_idx=1'" />
			</td>
		</tr>

	</table>
</body>
</html>