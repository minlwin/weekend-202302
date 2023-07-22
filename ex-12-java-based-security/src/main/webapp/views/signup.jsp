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
			<f:form modelAttribute="form" method="post" cssClass="w-50">
				
				<div class="mb-3">
					<label class="form-label">Role</label>
					<f:select path="role" cssClass="form-select">
						<f:option value="">Select One</f:option>
						<f:options items="${roles}"/>
					</f:select>
					<f:errors path="role" cssClass="text-secondary" />
				</div>
				
				<div class="mb-3">
					<label class="form-label">Name</label>
					<f:input path="name" type="text" placeholder="Enter Name" class="form-control" />
					<f:errors path="name" cssClass="text-secondary" />
				</div>

				<div class="mb-3">
					<label class="form-label">Email</label>
					<f:input path="email" type="email" placeholder="Enter Email" class="form-control" />
					<f:errors path="email" cssClass="text-secondary" />
				</div>

				<div class="mb-3">
					<label class="form-label">Password</label>
					<f:input path="password" type="password" placeholder="Enter Password" class="form-control" />
					<f:errors path="password" cssClass="text-secondary" />
				</div>

				<button class="btn btn-primary" type="submit">Login</button>
				
			</f:form>
		</div>
	</div>

</body>
</html>