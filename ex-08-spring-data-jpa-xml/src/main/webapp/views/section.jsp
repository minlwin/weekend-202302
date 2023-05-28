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
	
		<h3>Section Management</h3>
		
		<!-- Search Form -->
		<form class="row mb-4">
			<div class="col-auto">
				<label class="form-label">Date From</label>
				<input type="date" name="dateFrom" class="form-control" />
			</div>
			
			<div class="col-auto">
				<label class="form-label">Teacher</label>
				<input name="teacher" placeholder="Teacher Name" class="form-control" />
			</div>
			
			<div class="col-auto">
				<label class="form-label">Course</label>
				<input name="course" placeholder="Course Name" class="form-control" />
			</div>
			
			<div class="col btn-wrapper">
				<button class="btn btn-outline-primary" type="submit">
					<i class="bi bi-search"></i> Search
				</button>
				
				<c:url value="/section/edit" var="editLink"></c:url>
				<a href="${editLink}" class="btn btn-outline-danger">
					<i class="bi bi-pencil"></i> Add New
				</a>
			</div>
		</form>
		
		<!-- Result Table -->
		<c:choose>
			<c:when test="${not empty list}">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Course</th>
							<th>Level</th>
							<th>Fees</th>
							<th>Teacher</th>
							<th>Start Date</th>
							<th>Days</th>
							<th></th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${list}" var="s">
							<tr>
								<td>${s.course.name}</td>
								<td>${s.course.level}</td>
								<td>${s.course.price} MMK</td>
								<td>${s.teacher.name}</td>
								<td>${s.startDate}</td>
								<td class="d-flex">
									<c:forEach items="${s.days}" var="d">
										<div class="me-2">${d}</div>
									</c:forEach>
								</td>
								<td>
									<c:url value="/section/edit" var="editLink">
										<c:param name="id" value="${s.id}" />
									</c:url>
									<a href="${editLink}" class="icon-link me-2">
										<i class="bi bi-pencil"></i>
									</a>
									
									<c:url value="/section/${s.id}" var="detailsLink"></c:url>
									<a href="${detailsLink}" class="icon-link me-2">
										<i class="bi bi-send"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			
			<c:otherwise>
				<div class="alert alert-info">There is no data.</div>
			</c:otherwise>
		</c:choose>
	
	</div>

</body>
</html>