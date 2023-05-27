<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDC | Course</title>

<jsp:include page="/includes/resources.jsp"></jsp:include>

</head>
<body>

	<jsp:include page="/includes/top-menu.jsp"></jsp:include>

	<div class="container mt-4">
	
		<h3>${ form.id eq 0 ? 'Add New' : 'Edit' } Course</h3>
		
		<c:url value="/course" var="saveAction"></c:url>
		<sf:form action="${saveAction}" method="POST" modelAttribute="form">
			
			<!-- ID -->
			<sf:hidden path="id"/>
			
			<!-- Level -->
			<div class="mb-3">
				<label class="form-label">Course Level</label>
				<sf:select path="level" cssClass="form-select">
					<sf:options items="${levels}" />
				</sf:select>
				<sf:errors path="level" cssClass="text-secondary"></sf:errors>
			</div>
			
			<!-- Name -->
			<div class="mb-3">
				<label class="form-label">Course Name</label>
				<sf:input path="name" cssClass="form-control"/>
				<sf:errors path="name" cssClass="text-secondary"></sf:errors>
			</div>
			
			<div class="row mb-3">
				<!-- Duration -->
				<div class="col">
					<label class="form-label">Total Hours</label>
					<sf:input type="number" path="hours" cssClass="form-control"/>
					<sf:errors path="hours" cssClass="text-secondary"></sf:errors>
				</div>
				<!-- Fees -->
				<div class="col">
					<label class="form-label">Fees</label>
					<sf:input type="number" path="price" cssClass="form-control"/>
					<sf:errors path="price" cssClass="text-secondary"></sf:errors>
				</div>
			</div>
			
			
			<!-- Description -->
			<div class="mb-3">
				<label class="form-label">Description</label>
				<sf:textarea path="description" cssClass="form-control"/>
			</div>
			
			<!-- Action Button -->
			<button type="submit" class="btn btn-outline-danger">Save Course</button>
		</sf:form>
	
	</div>

</body>
</html>