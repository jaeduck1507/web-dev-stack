<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function modify(f) {
		f.action = 'cart_modify.do';
		f.method = 'get';
		f.submit();
	}
</script>
</head>
<body>
	<jsp:include page="index.jsp" />
	
	<table border="1" align="center" width="600">
		<tr bgcolor="#dedede">
			<th>제품코드</th>
			<th>이미지</th>
			<th width="30%">제품명</th>
			<th width="30%">단가</th>
			<th>수량</th>
			<th colspan="2">금액</th>
		</tr>
		
		<c:forEach var="p" items="${list}">
			<tr align="center">
				<td>${p.p_num}</td>
				<td><img src="images/${p.p_image_s}" width="100"></td>
				<td>${p.p_name}</td>
				<td>
					단가 : <br><fmt:formatNumber value="${p.p_price}"/>원 <br>
					<font color="red">
						세일가격: <b><fmt:formatNumber value="${p.p_saleprice}"/>원</b>
					</font>
				</td>
				<td>
					<form>
						<input type="hidden" value="${p.c_idx}" name="c_idx">
						<input size="3" name="c_cnt" value="${p.c_cnt}" style="text-align: center;"><br>
						<input type="submit" value="수정" onclick="modify(this.form)">
					</form>
				
				</td>
				<td width="20%"><fmt:formatNumber value="${p.amount}"/>원</td>
				<td><input type="button" value="삭제"></td>
			</tr>
		</c:forEach>
		
		
		
		<tr>
			<td colspan="6" align="right">
				총 결제액 &nbsp;
			</td>
			<td>&nbsp;<fmt:formatNumber value="${total}"/>&nbsp;</td>
		</tr>
	</table>
</body>
</html>