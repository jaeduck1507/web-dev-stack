<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/httpRequest.js"></script>
<style>
	form {
		width: 70%;
    margin: 40px auto;
	}
	table {
	width: 100%;
    margin: 40px 0px;
    background-color: #fdfdfd;
    padding: 20px 30px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0,0,0,0.1);
    border-collapse: separate;
   	border-spacing: 50px 50px;
    
	}
	
	input[type="text"] {
		width: 300px;
	    padding: 12px 15px;
	    margin-bottom: 20px;
	    border: 1px solid #ccc;
	    border-radius: 6px;
	    font-size: 14px;
	}
	
	input[type="button"] {
		display: inline-block;
	    margin-right: 10px;
	    padding: 10px 20px;
	    font-size: 14px;
	    border: none;
	    border-radius: 5px;
	    cursor: pointer;
		background-color: blue;
    	color: white;
	}
	
	input[type="button"]:hover {
		background-color: skyblue;
    	color: white;
	}
	
	table tr{
	height: 200px;
    	
	}
	
	
	table tr td:nth-child(2) {
		border-radius: 8px;
    	box-shadow: 0 4px 8px rgba(0,0,0,0.4);
    	display: flex;
    	height: 200px;
    	flex-direction: column;
    	padding: 0px 20px;
    	justify-content: center;
	}
	
	table tr td span:nth-child(1) {
		font-weight: bold;
		font-size: 15px;
	}
	
	img {
		border: 1px solid #ccc;
	}
	
</style>
<script>
	// 검색 실행
	function m_send(f) {
		let url = "list.do"; // action
		let param = "search_txt=" +f.search_txt.value; // 검색단어 파라미터로 저장
		sendRequest(url, param, resultFn, "get"); // url,파라미터,콜백함수,메서드 인자값으로 sendRequest실행 (비동기처리)
	}
	
	function resultFn() {
		if( xhr.readyState == 4 && xhr.status == 200 ) {
			
			let data = xhr.responseText; // 응답값 받기
			let json = eval(data); // json형태 객체리스트로 변환
			
			console.log(json[0].items[0]);
			
			// 비동기 처리로 테이블 형태로 변환
			let resTable = document.getElementById("resTable");
			resTable.innerHTML = "";
			// json[0].items에 담겨진 배열 정보를 하나씩 resTable의 열에 입력
			json[0].items.forEach( item => {
				let row = document.createElement("tr");
				
				row.innerHTML = 
					"<td><img src='"+ item.image +"' width='100'/></td>" +
					"<td><span>" + item.title + "</span>"+
					"<br><span>" + item.author + "</span>"+
					"<br><span>" + item.discount + "원</span>" +
					"</td>";
				resTable.appendChild(row);	
			});
			
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	
	<form>
		<input name="search_txt" type="text">
		<input type="button" value="검색" onclick="m_send(this.form)">
		<table id="resTable" ></table>
	</form>
</body>
</html>