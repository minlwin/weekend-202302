<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<jsp:include page="/includes/header.jsp">
		<jsp:param value="Sign In" name="title"/>
	</jsp:include>

</head>
<body>
	
	<app:page-content title="Welcome to JDC!"></app:page-content>

		<div class="container">
		<!-- Courses -->
		<div class="row row-cols-3 mb-4">
			<c:forEach items="${courses}" var="item">
				<div class="col">
					<app:course-item item="${item}"></app:course-item>
				</div>
			</c:forEach>
		</div>
		
		<!-- Sections -->
		<h3>Available Classes</h3>
		<div class="row row-cols-3">
			<c:forEach items="${classes}" var="item">
				<div class="col">
					<app:section-item dto="${item}"></app:section-item>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>