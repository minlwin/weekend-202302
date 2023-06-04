<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<jsp:include page="/includes/header.jsp">
		<jsp:param value="Sign In" name="title"/>
	</jsp:include>

</head>
<body>
	
	<jsp:include page="/includes/navigation.jsp"></jsp:include>
	
	<div class="container mt-3">
		<h3>Sign In</h3>
		
		<form method="post" class="w-50">
			
			<sec:csrfInput/>
			
			<div class="mb-3">
				<label class="form-label">Email </label>
				<input type="email" class="form-control" required="required" name="username" placeholder="Enter Login Id" />
			</div>
		
			<div class="mb-3">
				<label class="form-label">Password</label>
				<input type="password" class="form-control" required="required" name="password" placeholder="Enter Password" />
			</div>
			
			<button type="submit" class="btn btn-outline-primary">Sign In</button>

		</form>
	</div>

</body>
</html>