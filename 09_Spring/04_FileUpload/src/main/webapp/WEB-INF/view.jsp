<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시글 목록</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</head>
<body>
	<!-- a링크를 통해 딱 해당 정보만 나올수 있도록! 상세보기 -->
	<div class="container">
		<h2 class="header">${content.title}</h2>
		<p>${content.content}</p>
		<img src="http://192.168.0.35:8081/${content.url}" width="200" height="120" />
		<p>${content.createdAt}</p>
		<form action="/delete" method="post">
		<input type="hidden" name="no" value="${content.no}">
		<input type="hidden" name="url" value="${content.url}">
		<button type="button" class="btn btn-outline-warning" data-bs-toggle="modal" data-bs-target="#updateModal">글 수정</button>
		<button type="submit" class="btn btn-secondary">글 삭제</button>
		</form>

		<!-- file 객체의 delete()메서드 사용 -->
		<div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">게시글 수정</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
			  <form action="/update" method="post" enctype="multipart/form-data">
			  <div class="modal-body">
				<div class="mb-3">
				<label class="form-label">Title 수정</label>
			  	<input type="hidden" class="form-control" name="no" value="${content.no}">
			  	<input type="hidden" class="form-control" name="url" value="${content.url}">
				<input type="text" class="form-control" name="title" value="${content.title}">
				</div>
				<div class="mb-3">
				<label class="form-label">Content 수정</label>
				<textarea class="form-control" rows="3" name="content">${content.content}</textarea>
				</div>
				<img src="http://192.168.0.35:8081/${content.url}" width="200" height="120" />
				<div class="mb-3">
				<label class="form-label">File 수정</label>
				<input class="form-control" name="file" type="file" accept="image/*">
				</div>
			  </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
		        <button type="submit" class="btn btn-warning">등록</button>
		      </div>
			  </form>
		    </div>
		  </div>
		</div>
	</div>
	
	
</body>
</html>








