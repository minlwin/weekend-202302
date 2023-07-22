<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<jsp:include page="/includes/header.jsp">
		<jsp:param value="My Classes" name="title"/>
	</jsp:include>

</head>
<body>
	
	<app:page-content title="Dash Board">
		
		<div class="row">
			
			<!-- My Sections -->
			<div class="col">
				<app:result-list isEmpty="${empty mySections}">
					
					<div class="row row-cols-2">
					<c:forEach items="${mySections}" var="item">
						<div class="col">
							<app:section-item dto="${item}"></app:section-item>					
						</div>
					</c:forEach>	
					</div>
									
				</app:result-list>
			</div>

			<!-- Profile -->
			<div class="col-3">
				<div class="card mb-3">
					<div class="card-header">
						Profile
					</div>
					
					<div class="card-body">
						<c:url value="/static/images/profile.png" var="profileUrl" />
						<img class="img-fluid" src="${profileUrl}" alt="" />
					</div>
				</div>
				
				<a href="#" class="btn btn-primary d-block mb-2">
					<i class="bi bi-camera"></i> Profile Photo
				</a>
				<a href="#" class="btn btn-primary d-block mb-2">
					<i class="bi bi-pencil"></i> Edit Profile
				</a>
				
				<sec:authorize access="hasAuthority('Teacher')">
					<c:url value="/teacher/section" var="createSectionLink"></c:url>
					<a href="${createSectionLink}" class="btn btn-primary d-block mb-2">
						<i class="bi bi-plus-lg"></i> Create Section
					</a>
				</sec:authorize>
			</div>
			
		
		</div>
	
	</app:page-content>

</body>
</html>