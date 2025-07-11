<%@page import="com.kh.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="box">

		<h1>회원 관리</h1>
		
		<ul>
			
			<c:choose>
			<%-- 로그인 되어 있지 않은 경우 --%>
				<c:when test="${member == null}">
			<li><a href= "/register">회원가입</li>
			<%-- 회원가입 로직: 아이디, 비밀번호, 이름 나이 입력 받아서
				호출 : /register 방식 : post RegisterServlet index.jsp로 이동 --%>
			<li><a href= "/login">로그인</li>
			<%-- 로그인로직 : 아이디, 비밀번호 입력 받아서 호출 : /login, 방식 : post
				LoginServlet : 세션 데이터 바인딩! index.jsp로 이동 --%>
				</c:when>
				
			<%-- 로그인된 경우 --%>
			<c:otherwise>
			<li><a href= "/search">회원검색</li>
			<%-- 회원검색 : 검색할 아이디 입력받아서 호출 : /seach, 방식 : get SearchServlet view/result.jsp에서 성공하면 해당 정보 출력 실패하면 "검색에 실패했습니다." --%>
			<li><a href= "/allMember">전체 회원 보기</li>
			<%-- 전체 회원 보기 : /views/allMember.jsp에 리스트 출력 --%>
			<li><a href= "/logout">로그아웃</li>
			<%-- 로그아웃하고 index.jsp로! LogoutServlet --%>
			
			</c:otherwise>
			</c:choose>
		</ul>
	</div>
</body>
</html>