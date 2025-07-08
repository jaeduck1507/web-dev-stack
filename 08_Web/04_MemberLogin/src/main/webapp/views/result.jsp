<%@page import="vo.Member"%> <%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%>
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
      <%Member member = (Member)request.getAttribute("member"); %> <%if(member
      != null){ %>
      <h3>검색된 아이디 : <%=member.getId() %></h3>
      <h3>이름 : <%=member.getName() %></h3>
      <h3>나이 : <%=member.getAge() %></h3>
      <%}else{ %>
      <h3><%=request.getParameter("id") %>는 없는 아이디입니다!</h3>
      <% }%>

      <a href="/">페이지 돌아가기</a>
    </div>
  </body>
</html>
