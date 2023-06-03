<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="/includes/header.jsp">
	<jsp:param value="Member Home" name="title"/>
</jsp:include>

</head>
<body>

	<div class="container mt-4">
	
		<h1>Member Home</h1>
		
		<div class="mt-3">
			<c:url value="/" var="homeLink"></c:url>
			<c:url value="/member" var="memberLink"></c:url>
			
			<a href="${homeLink}" class="btn btn-outline-danger me-2">
				Home
			</a>
			
			<c:url value="/logout" var="logoutUrl"></c:url>
			<sf:form action="${logoutUrl}" class="d-inline-block" method="post">
				<button class="btn btn-outline-danger" type="submit">Logout</button>
			</sf:form>			
		</div>
	</div>
</body>
</html>