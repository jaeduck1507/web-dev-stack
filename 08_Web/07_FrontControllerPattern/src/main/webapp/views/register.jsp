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
      <h1>회원가입</h1>
      <form action="/front" method="post">
      	<input type="hidden" name="command" value="register">
        아이디 : <input type="text" name="id" /><br />
        비밀번호 : <input type="password" name="pwd" /><br />
        이름 : <input type="text" name="name" /><br />
        나이 : <input type="number" name="age" /><br />
        <input type="submit" value="회원가입!" />
      </form>
    </div>
  </body>
</html>
