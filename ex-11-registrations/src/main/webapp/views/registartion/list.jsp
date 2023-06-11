<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<jsp:include page="/includes/header.jsp">
		<jsp:param value="Registrations" name="title"/>
	</jsp:include>

</head>
<body>
	
	<app:page-content title="Registration">
		
		<!-- Search Form -->
		<form class="row">
			<!-- Course -->
			<div class="col-auto">
				<app:form-group label="Course">
					<select class="form-select" name="course">
						<option value="" >All Courses</option>
						<c:forEach items="${courses}" var="item">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
				</app:form-group>
			</div>
			<!-- Teacher -->
			<div class="col-auto">
				<app:form-group label="Teacher">
					<select class="form-select" name="teacher">
						<option value="" >All Teachers</option>
						<c:forEach items="${teachers}" var="item">
							<option value="${item.id}">${item.name}</option>
						</c:forEach>
					</select>
				</app:form-group>
			</div>
			<!-- Date From -->
			<div class="col-auto">
				<app:form-group label="From Date">
					<input type="date" class="form-control" name="from">				
				</app:form-group>
			</div>
			<!-- Search -->
			<div class="col btn-wrapper">
				<button class="btn btn-outline-primary">
					<i class="bi bi-search"></i> Search
				</button>
			</div>
		</form>
		
		<!-- Search Result -->
		<app:result-list isEmpty="${empty list}">
			
			<table class="table table-striped">
			
				<thead>
					<tr>
						<th>Student</th>
						<th>Registration At</th>
						<th>Teacher</th>
						<th>Course</th>
						<th>Start Date</th>
						<th>Start Time</th>
						<th>End Time</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.student.name}</td>
							<td>${item.registAt}</td>
							<td>${item.section.teacher.name}</td>
							<td>${item.section.teacher.name}</td>
							<td>${item.section.course.name}</td>
							<td>${item.section.startDate}</td>
							<td>${item.section.startTime}</td>
							<td>${item.section.endTime}</td>
						</tr>
					</c:forEach>
				</tbody>
			
			</table>
		
		</app:result-list>
		
	
	</app:page-content>

</body>
</html>