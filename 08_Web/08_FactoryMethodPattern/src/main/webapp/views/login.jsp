<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="CSS/main.css" />
  </head>
  <body>
    <div class="box">
      <h1>로그인</h1>
      <form action="/login.do" method="post">
      	<input type="hidden" name="command" value="login">
        아이디 : <input type="text" name="id" /><br />
        비밀번호 : <input type="password" name="pwd" /><br />
        <input type="submit" value="로그인!!" />
      </form>
    </div>
  </body>
</html>
