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
	
		<h3>Course Management</h3>

		<form class="row">
			<!-- Search Form -->
			<!-- Level -->
			<div class="col-auto">
				<label class="form-label">Level</label>
				<select name="level" class="form-select">
					<option value="">All Level</option>
					<c:forEach items="${levels}" var="item">
						<option value="${item}" ${item eq param.level ? 'selected="selected"' : ''} >${item}</option>
					</c:forEach>
				</select>
			</div>
			
			<!-- Keyword -->
			<div class="col-auto">
				<label class="form-label">Keyword</label>
				<input name="keyword" value="${param.keyword}" type="text" class="form-control" placeholder="Search Keyword" />
			</div>
			
			<div class="col btn-wrapper">
				<!-- Search Button -->
				<button type="submit" class="btn btn-outline-primary">
					<i class="bi bi-search"></i> Search
				</button>
								
				<!-- Add New Button -->
				<c:url value="/course/edit" var="addNew"></c:url>
				<a href="${addNew}" class="btn btn-outline-danger">
					<i class="bi bi-plus-lg"></i> Add New
				</a>
			
			</div>
		
		</form>
		
		<!-- Search Result -->	
		<div class="mt-4">
				
		<c:choose>
			
			<c:when test="${not empty list}">
				
				<table class="table table-striped table-hover">
					
					<thead>
						<tr>
							<td>Level</td>
							<td>Name</td>
							<td>Hours</td>
							<td>Fees</td>
							<td>Description</td>
							<td></td>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${list}" var="c">
							<tr>
								<td>${c.level}</td>
								<td>${c.name}</td>
								<td>${c.hours}</td>
								<td>${c.price}</td>
								<td>${c.description}</td>
								<td>
									<c:url value="/course/edit" var="editLink">
										<c:param name="id" value="${c.id}"></c:param>
									</c:url>
									<a href="${editLink}" class="icon-link me-2">
										<i class="bi bi-pencil"></i>
									</a>
									
									<c:url value="/course/${c.id}" var="detailsLink"></c:url>
									<a href="${detailsLink}" class="icon-link">
										<i class="bi bi-send"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			
			</c:when>
			
			<c:otherwise>
				<div class="alert alert-info">
					There is no courses.
				</div>
			</c:otherwise>
		</c:choose>	
		
		</div>
		
	</div>

</body>
</html>