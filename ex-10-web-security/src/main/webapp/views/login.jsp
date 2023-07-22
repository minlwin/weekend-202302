<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<<<<<<< HEAD

=======
>>>>>>> 4331c83d9c5696742e0b4d92ef1987c2017f49bd
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="/includes/header.jsp">
<<<<<<< HEAD
	<jsp:param value="Member Home" name="title"/>
=======
	<jsp:param value="Admin Home" name="title"/>
>>>>>>> 4331c83d9c5696742e0b4d92ef1987c2017f49bd
</jsp:include>

</head>
<body>

	<div class="container mt-4">
<<<<<<< HEAD
	
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
=======
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
			
>>>>>>> 4331c83d9c5696742e0b4d92ef1987c2017f49bd
		</div>
	</div>
</body>
</html>