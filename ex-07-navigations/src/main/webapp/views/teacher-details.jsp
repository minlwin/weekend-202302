<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDC | Teacher</title>

<jsp:include page="/includes/resources.jsp"></jsp:include>

</head>
<body>

	<jsp:include page="/includes/top-menu.jsp"></jsp:include>

	<div class="container mt-4">
	
		<h3>Teacher Details</h3>
		
		<c:if test="${not empty message}">
			<div class="alert alert-info">${message}</div>	
		</c:if>
	
		<div class="row mb-3">
			<div class="col">
				<label class="form-label">Name</label>
				<span>${data.name}</span>
			</div>
			<div class="col">
				<label class="form-label">Entry Date</label>
				<span>${data.entryDate}</span>
			</div>
		</div>

		<div class="row mb-3">
			<div class="col">
				<label class="form-label">Phone</label>
				<span>${data.phone}</span>
			</div>
			<div class="col">
				<label class="form-label">Email Address</label>
				<span>${data.email}</span>
			</div>
		</div>
		
		<div>
			<c:url value="/teacher/edit" var="editUrl">
				<c:param name="id" value="${data.id}" />
			</c:url>
			
			<a href="${editUrl}" class="btn btn-outline-danger">
				<i class="bi bi-pencil"></i> Edit Teacher
			</a>
		</div>
	</div>

</body>
</html>