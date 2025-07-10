<%@page import="vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/views/CSS/main.css">
</head>
<body>
	<div class="box">
		
		<c:choose>
		
			<c:when test="${list.size() ne 0}">
				<c:forEach items="${list}" var="member" varStatus="status">
					<%-- index는 0부터, count : 1부터 시작 --%>
					<h3>아이디 : ${member.id}, 이름 : ${member.name}, 나이 : ${member.age} 인덱스: ${status.index} 번호 : ${status.count}</h3>
				</c:forEach>
			</c:when>
			
			<c:otherwise>
				<h3>회원정보가 없습니다.</h3>
			</c:otherwise>
		</c:choose>		
		<a href="/">페이지 돌아가기</a>
		
	</div>
</body>
</html>