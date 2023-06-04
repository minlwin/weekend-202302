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
		<jsp:param value="Account Edit" name="title"/>
	</jsp:include>

</head>
<body>
	
	<jsp:include page="/includes/navigation.jsp"></jsp:include>
	
	<div class="container mt-3">
		
		<h3>${form.id eq 0 ? 'Add New' : 'Edit'} Account</h3>
		
		<div class="row">
			<div class="col-6">
				
				<sf:form modelAttribute="form" method="post">
					<sf:hidden path="id"/>
					
					<app:form-group label="Role">
						<sf:select path="role" cssClass="form-select">
							<sf:option value="">Select One</sf:option>
							<sf:options items="${roles}" />
						</sf:select>
						<sf:errors path="role" cssClass="text-secondary" />
					</app:form-group>	
					
					<app:form-group label="Name">
						<sf:input path="name" placeholder="Enter Name" cssClass="form-control"/>
						<sf:errors path="name" cssClass="text-secondary" />
					</app:form-group>	
					
					<app:form-group label="Email">
						<sf:input path="email" type="email" placeholder="Enter Email" cssClass="form-control"/>
						<sf:errors path="name" cssClass="text-secondary" />
					</app:form-group>	
					
					<button type="submit" class="btn btn-outline-danger">
						<i class="bi bi-save"></i> Save
					</button>
				</sf:form>
				
			</div>
		</div>
	
	</div>

</body>
</html>