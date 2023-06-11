<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<jsp:include page="/includes/header.jsp">
		<jsp:param value="Course Edit" name="title"/>
	</jsp:include>

</head>
<body>
	
	<app:page-content title="${form.id == 0 ? 'Add New' : 'Edit'} Course">
	
		<sf:form method="post" cssClass="w-50" modelAttribute="form">
			
			<sf:hidden path="id"/>
		
			<!-- Name -->
			<app:form-group label="Course Name">
				<sf:input path="name" cssClass="form-control" placeholder="Enter Course Name"/>
				<sf:errors path="name" cssClass="secondary-text" />
			</app:form-group>

			<!-- Level -->
			<app:form-group label="Level">
				<sf:select path="level" cssClass="form-select">
					<sf:option value="">Select One</sf:option>
					<sf:options items="${levels}"/>
				</sf:select>
				<sf:errors path="level" cssClass="secondary-text" />
			</app:form-group>		
			
			<div class="row">
				<!-- Hours -->
				<div class="col">
					<app:form-group label="Hours">
						<sf:input path="hours" type="number" cssClass="form-control"/>
						<sf:errors path="hours" cssClass="secondary-text" />
					</app:form-group>				
				</div>
				
				<!-- Fees -->
				<div class="col">
					<app:form-group label="Fees">
						<sf:input path="fees" type="number" cssClass="form-control"/>
						<sf:errors path="fees" cssClass="secondary-text" />
					</app:form-group>				
				</div>
			</div>
			
			<!-- Description -->
			<app:form-group label="Description">
				<sf:textarea path="description" cssClass="form-control"/>
			</app:form-group>
			
			<button type="submit" class="btn btn-outline-primary">
				<i class="bi bi-save"></i> Save
			</button>
			
		</sf:form>
	
	</app:page-content>

</body>
</html>