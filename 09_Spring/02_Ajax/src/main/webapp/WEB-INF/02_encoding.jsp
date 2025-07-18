<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>encoding</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	
	
	<h1>Encoding 처리하기</h1>
    닉네임 : <input type="text" id="nick">
	<input type="button" id = "btn" value="닉네임 보내기" />
	<p id = "result"></p>
	
	<!-- get, /encoding -->
	<!-- <script>
		 let xhr;
         const nick = document.querySelector("#nick");
         
         
         const btn = document.querySelector("#btn");
         
		 function startRequest() { // 요청에 해당하는 로직을 담는 메서드
                const nickname = document.querySelector("#nick").value;
                
				xhr = new XMLHttpRequest();
		 		xhr.onreadystatechange = callback;
				xhr.open("get","/encoding?nickname=" +nickname);
               
				xhr.send(null); // 이때 서버로 전송.. 실질적인 요청이 들어감
                
		 }
		 
		 function callback() { // 응답에 해당하는 로직을 담는 함수
			if(xhr.readyState === 4) {
				if(xhr.status === 200) {
					// alert(xhr.responseText);	
					const text = xhr.responseText;
					document.querySelector("#result").innerHTML = text;
				}
			}
			
		 }

         btn.addEventListener("click",startRequest);
	</script> -->

    <!--jQuery-->
    <script>
        $("#btn").click(() =>{
            const nickname = $("#nick").val();
            $.ajax({
                // 요청
                type : "get",
                url : "/encoding",
                data : "nickname=" + nickname,
                // 응답
                success : function(result) {
                    $("#result").text(result);
                }
            })
        });
    </script>
</body>
</html>