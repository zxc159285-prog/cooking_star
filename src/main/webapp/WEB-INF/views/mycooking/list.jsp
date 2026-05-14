<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<c:forEach items="${list}" var="d">

	<h3>
	 ${d.cookingTitle}
	</h3>


</c:forEach>


</body>
</html>