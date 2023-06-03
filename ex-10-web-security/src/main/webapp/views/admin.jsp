<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="/includes/header.jsp">
	<jsp:param value="Admin Home" name="title"/>
</jsp:include>

</head>
<body>

	<div class="container mt-4">
		<h1>Admin Home</h1>
		
		<div class="mt-3">
			<c:url value="/" var="homeLink"></c:url>
			<c:url value="/member" var="memberLink"></c:url>
			
			<a href="${homeLink}" class="btn btn-outline-danger me-2">
				Home
			</a>
		</div>
	</div>
</body>
</html>