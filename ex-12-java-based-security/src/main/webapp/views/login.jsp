<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

	<c:url value="/resources/css/bootstrap.min.css" var="bootCss"></c:url>
	<c:url value="/resources/js/bootstrap.bundle.min.js" var="bootJs"></c:url>
	
	<link rel="stylesheet" href="${bootCss}" />
	<script src="${bootJs}"></script>

</head>
<body>

	<div class="container mt-4">
		<h1>Login</h1>
		
		<c:if test="${not empty error}">
			<div class="alert alert-info">
				Authentication Fails. Please check login information.
			</div>
		</c:if>
		
		<div>
			<c:url value="/login" var="loginAction"></c:url>
			<f:form action="${loginAction}" method="post" cssClass="w-50">
				
				<div class="mb-3">
					<label class="form-label"></label>
					<input type="email" name="username" class="form-control" placeholder="Enter Email for Login" />
				</div>
				
				<div class="mb-3">
					<label class="form-label"></label>
					<input type="password" name="password" class="form-control" placeholder="Enter Password for Login" />
				</div>
				
				<button class="btn btn-primary" type="submit">Login</button>
				
			</f:form>
		</div>
	</div>

</body>
</html>