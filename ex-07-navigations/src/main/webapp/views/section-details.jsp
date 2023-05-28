<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDC | Section</title>

<jsp:include page="/includes/resources.jsp"></jsp:include>

</head>
<body>

	<jsp:include page="/includes/top-menu.jsp"></jsp:include>

	<div class="container mt-4">
	
		<h3>Section Details</h3>
		
		<c:if test="${not empty message}">
			<div class="alert alert-info">${message}</div>
		</c:if>
		
		<div class="row mb-3">
			<div class="col">
				<label class="form-label">Start Date</label>
				<div class="form-control">${data.startDate}</div>
			</div>
			<div class="col">
				<label class="form-label">Course</label>
				<div class="form-control">${data.course.name}</div>
			</div>
			<div class="col">
				<label class="form-label">Teacher</label>
				<div class="form-control">${data.teacher.name}</div>
			</div>
		</div>
		
		<div class="row mb-3">
			<div class="col">
				<label class="form-label">Start Time</label>
				<div class="form-control">${data.startTime}</div>
			</div>
			<div class="col">
				<label class="form-label">End Time</label>
				<div class="form-control">${data.endTime}</div>
			</div>
			<div class="col">
				<label class="form-label">Status</label>
				<div class="form-control">${data.acceptable ? 'Open' : 'Closed'}</div>
			</div>
		</div>
		
		<div class="mb-3">
			<label class="form-label">Days</label>
			<div class="d-flex form-control">
				<c:forEach items="${data.days}" var="d">
					<div class="me-2">${d}</div>
				</c:forEach>
			</div>		
		</div>
		
		<c:url value="/section/edit" var="edtiLink">
			<c:param name="id" value="${data.id}" />
		</c:url>
		<a href="${editLink}" class="btn btn-outline-danger">
			<i class="bi bi-pencil"></i> Edit Section
		</a>
	</div>

</body>
</html>