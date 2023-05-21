<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Spring MVC</title>

<c:url value="/resources/css/bootstrap.min.css" var="bootCss"></c:url>
<c:url value="/resources/js/bootstrap.bundle.min.js" var="bootJs"></c:url>

<link rel="stylesheet" href="${bootCss}" />
<script src="${bootJs}"></script>

</head>
<body>

	<div class="container mt-4">

		<h1>Hello Spring MVC</h1>
		
		<ul class="list-group">
			<c:forEach items="${days}" var="day">
				<li class="list-group-item">${day}</li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>