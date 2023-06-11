<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<jsp:include page="/includes/header.jsp">
		<jsp:param value="Course" name="title"/>
	</jsp:include>

</head>
<body>
	
	<app:page-content title="Course Management">
	
		<!-- Controls -->
		<div class="mb-3">
			<c:url value="/office/course/edit" var="addNewLink"></c:url>
			<a href="${addNewLink}" class="btn btn-outline-primary">
				<i class="bi bi-plus-lg"></i> Add New Course
			</a>
		</div>
		
		<!-- Result Tables -->
		<app:result-list isEmpty="${empty list}">
			
			<table class="table table-striped">
				
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Level</th>
						<th>Hours</th>
						<th>Fees</th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.level}</td>
						<td>${item.hours} Hours</td>
						<td>${item.fees} MMK</td>
						<td>
							<c:url value="/office/course/edit" var="editLink">
								<c:param name="id" value="${item.id}" />
							</c:url>
							<a href="${editLink}" class="btn-link">
								<i class="bi bi-pencil"></i>
							</a>
						</td>
					</tr>								
				</c:forEach>	
				</tbody>
			
			</table>
		
		</app:result-list>
		
	
	</app:page-content>
	
	

</body>
</html>