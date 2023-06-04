<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
		<h1>Member Login</h1>
		
		<div class="mt-3">
			<c:url value="/login" var="loginAction"></c:url>
			<sf:form class="w-50" action="${loginAction}" method="post">
				
				<div class="mb-3">
					<label class="form-label">Login Id</label>
					<input type="text" placeholder="Enter Login Id" name="username" class="form-control" />
				</div>
				
				<div class="mb-3">
					<label class="form-label">Password</label>
					<input type="password" placeholder="Enter Password" name="password" class="form-control" />
				</div>

				<div class="form-check-inline mb-3">
					<input id="rememberMe" type="checkbox" name="remember-me" class="form-check-input me-1" />
					<label for="rememberMe" class="form-check-label">Remember Me</label>	
				</div>
				
				<div>
					<button type="submit" class="btn btn-outline-danger">Login</button>			
				</div>

			</sf:form>
			
		</div>
	</div>
</body>
</html>