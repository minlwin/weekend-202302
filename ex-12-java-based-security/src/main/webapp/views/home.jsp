<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo</title>

	<c:url value="/resources/css/bootstrap.min.css" var="bootCss"></c:url>
	<c:url value="/resources/js/bootstrap.bundle.min.js" var="bootJs"></c:url>
	
	<link rel="stylesheet" href="${bootCss}" />
	<script src="${bootJs}"></script>

</head>
<body>

	<div class="container mt-4">
		<h1>Java Based Config Spring Security</h1>
		
		<c:if test="${not empty message}">
			<div class="alert alert-info">
				${message}
			</div>
		</c:if>
		
		<div>
			<c:url value="/office" var="officeLink"></c:url>
			<c:url value="/teacher" var="teacherLink"></c:url>
			<c:url value="/student" var="studentLink"></c:url>
			<c:url value="/signup" var="signupLink"></c:url>
			
			<a href="${officeLink}" class="btn btn-primary">Office</a>
			<a href="${teacherLink}" class="btn btn-primary">Teacher</a>
			<a href="${studentLink}" class="btn btn-primary">Student</a>
			<a href="${signupLink}" class="btn btn-primary">Sign Up</a>
		</div>
	</div>

</body>
</html>