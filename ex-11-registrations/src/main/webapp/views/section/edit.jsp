<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<jsp:include page="/includes/header.jsp">
		<jsp:param value="Class Edit" name="title"/>
	</jsp:include>

</head>
<body>
	
	<app:page-content title="Edit Class Room">
		
		<sf:form modelAttribute="form" method="post">
			// ID
			<sf:hidden path="id"/>
			
			<div class="row">
				// Course
				
	
				// Months
				
				// Acceptable
			
			</div>
			
			<div class="row">
				// Start Date
				
				// Start Time
				
				// End Time
			</div>
			
			// Days
			

		</sf:form>
	
	</app:page-content>

</body>
</html>