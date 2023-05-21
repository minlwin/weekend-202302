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
						<option value="${item}">${item}</option>
					</c:forEach>
				</select>
			</div>
			
			<!-- Keyword -->
			<div class="col-auto">
				<label class="form-label">Keyword</label>
				<input name="keyword" type="text" class="form-control" placeholder="Search Keyword" />
			</div>
			
			<div class="col btn-wrapper">
				<!-- Search Button -->
				<button type="submit" class="btn btn-outline-primary">Search</button>
								
				<!-- Add New Button -->
				<c:url value="/course/edit" var="addNew"></c:url>
				<a href="${addNew}" class="btn btn-outline-danger">Add New Course</a>
			
			</div>
		
		</form>
		
		<!-- Search Result -->	
	</div>

</body>
</html>