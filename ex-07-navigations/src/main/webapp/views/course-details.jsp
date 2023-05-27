<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
	
		<h3>Course Details</h3>
		
		<c:if test="${not empty message}">
			<div class="alert alert-info">
				<i class="bi bi-info-lg"></i> ${message}
			</div>	
		</c:if>
		
		<div class="row mb-3">

			<div class="col">
				<label class="form-label">Course Level</label>
				<span class="form-control">${data.level}</span>
			</div>

			<div class="col">
				<label class="form-label">Course Name</label>
				<span class="form-control">${data.name}</span>
			</div>
		
		</div>
			
		<div class="row mb-3">
			<div class="col">
				<label class="form-label">Duration</label>
				<span class="form-control">${data.hours} Hours</span>
			</div>
			
			<div class="col">
				<label class="form-label">Course Fees</label>
				<span class="form-control">${data.price} MMK</span>
			</div>
		</div>	
		
		<div class="mb-3">
			<label class="form-label">Description</label>
			<span class="form-control">${data.description}</span>
		</div>	
		
		<div class="mb-3">
			<c:url value="/course/edit" var="editLink">
				<c:param name="id" value="${data.id}"></c:param>
			</c:url>
			<a href="${editLink}" class="btn btn-outline-danger">
				<i class="bi bi-pencil"></i> Edit Course
			</a>
		</div>
	</div>

</body>
</html>