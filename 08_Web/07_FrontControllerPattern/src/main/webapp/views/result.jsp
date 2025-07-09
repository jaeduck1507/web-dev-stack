<%@page import="vo.Member"%> <%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="CSS/main.css" />
  </head>
  <body>
    <div class="box">
      <h1>검색</h1>
      
      <c:choose>
      
      	<c:when test="${not empty member}">
	      <h3>검색된 아이디 : ${member.id}</h3>
	      <h3>이름 : ${member.name}</h3>
	      <h3>나이 : ${member.age}</h3>
      	</c:when>
      	
      	<c:otherwise>
	      <h3>${param.id}는 없는 아이디입니다!</h3>
      	</c:otherwise>
      </c:choose>
      

      <a href="/">페이지 돌아가기</a>
    </div>
  </body>
</html>
