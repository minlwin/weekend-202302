<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<jsp:include page="/includes/header.jsp">
		<jsp:param value="Registration" name="title"/>
	</jsp:include>

</head>
<body>
	
	<app:page-content title="Registration">
		
		<div class="row">
			<div class="col-4">
				<!-- Class Information -->
				<app:section-item showControls="false" dto="${dto}" />
			</div>
			
			<div class="col">
				<!-- Student Registration Form -->
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">
							<i class="bi bi-person"></i> Student Information
						</h5>
						
						<form:form modelAttribute="form" method="post">
							<!-- Section ID -->
							<form:hidden path="sectionId"/>
							
							<form:errors element="div class='alert alert-info'" path="*"></form:errors>
							
							<!-- Name -->
							<app:form-group label="Student Name">
								<form:input path="name" placeholder="Enter Student Name" cssClass="form-control"/>
							</app:form-group>
							
							<!-- Phone -->
							<app:form-group label="Phone Number">
								<form:input path="phone" type="tel" placeholder="Enter Phone Number" cssClass="form-control"/>
							</app:form-group>
							
							<!-- Email -->
							<app:form-group label="Email Address">
								<form:input path="email" type="email" placeholder="Enter Student Name" cssClass="form-control"/>
							</app:form-group>
							
							<!-- Password -->
							<app:form-group label="Password">
								<form:input path="password" type="password" placeholder="Enter Student Name" cssClass="form-control"/>
							</app:form-group>
							
							<!-- Apply Course Button -->
							<button type="submit" class="btn btn-primary">
								<i class="bi bi-save"></i> Apply Course
							</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>		
		
	</app:page-content>

</body>
</html>