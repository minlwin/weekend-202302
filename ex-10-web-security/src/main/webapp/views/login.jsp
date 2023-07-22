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
	
		<h1>Login Page</h1>
		
		<div class="mt-3">
			
			<c:url value="/logout" var="logoutUrl"></c:url>
			<sf:form action="${logoutUrl}" class="w-25" method="post">

				<div class="mb-3">
					<label for="username" class="form-label">Username</label>
					<input id="username" type="text" name="username" placeholder="Enter username" class="form-control" />
				</div>

				<div class="mb-3">
					<label for="password" class="form-label">Password</label>
					<input id="password" type="password" name="password" placeholder="Enter password" class="form-control" />
				</div>
				
				<div class="mb-3">
					<input type="checkbox" id="remember" class="form-check-input" />
					<label for="remember" class="form-check-label">Remember Me</label>
				</div>
				
				<button type="submit" class="btn btn-primary">Log In</button>
			</sf:form>			
		</div>
	</div>
</body>
</html>