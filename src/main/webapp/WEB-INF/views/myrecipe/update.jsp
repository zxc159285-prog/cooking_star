<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Recipe 수정</h1>
	<form action="/myrecipe/update" method="post" enctype="multipart/form-data">
		<div>
		<input type="hidden" name="recipeNum" value="${dto.recipeNum}">
		</div>
		<div>
			제목<input type="text" value="${dto.recipeTitle}" name="recipeTitle">
		</div>
		<div>
			내용<input type="text" value="${dto.recipeContents}"  name="recipeContents">
		</div>

		<div class="form-group">
			<label>요리 사진</label> <input type="file" name="attach"
				class="form-control" id="attach">
		</div>
		<button type="submit">저장</button>
	</form>
</body>
</html>