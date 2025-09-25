<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/httpRequest.js"></script>
<script>
	function m_send(f) {
		let url = "list.do";
		let param = "search_txt=" +f.search_txt.value;
		sendRequest(url, param, resultFn, "get");
	}
	
	function resultFn() {
		if( xhr.readyState == 4 && xhr.status == 200 ) {
			
			let data = xhr.responseText;
			let json = eval(data);
			
			console.log(json[0].items[0]);
			
			let resTable = document.getElementById("resTable");
			resTable.innerHTML = "";
			json[0].items.forEach( item => {
				let row = document.createElement("tr");
				
				row.innerHTML = 
					"<td><img src='"+ item.image +"' width='100'/></td>" +
					"<td><span>" + item.title + "</span>"+
					"<br>" + item.author +
					"<br>" + item.discount +
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
		<input name="search_txt">
		<input type="button" value="검색" onclick="m_send(this.form)">
		<table id="resTable" border="1"></table>
	</form>
</body>
</html>