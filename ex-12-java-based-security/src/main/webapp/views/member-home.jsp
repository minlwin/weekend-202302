<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Home</title>

	<c:url value="/resources/css/bootstrap.min.css" var="bootCss"></c:url>
	<c:url value="/resources/js/bootstrap.bundle.min.js" var="bootJs"></c:url>
	
	<link rel="stylesheet" href="${bootCss}" />
	<script src="${bootJs}"></script>

</head>
<body>

	<div class="container mt-4">
		<sec:authentication property="authorities" var="roles"/>
		<h1>${roles[0]} Home</h1>
		
		<div>
			<c:url value="/logout" var="logout"></c:url>
			<form action="${logout}" method="post">
				<sec:csrfInput/>
				<button type="submit" class="btn btn-primary">Logout</button>
			</form>
		</div>
	</div>

</body>
</html>