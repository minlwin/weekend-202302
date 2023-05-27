<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDC | Teacher</title>

<jsp:include page="/includes/resources.jsp"></jsp:include>

</head>
<body>

	<jsp:include page="/includes/top-menu.jsp"></jsp:include>

	<div class="container mt-4">
	
		<h3>Edit Teacher</h3>
		
		<c:url value="/teacher" var="actionUrl"></c:url>
		<sf:form modelAttribute="form" method="POST" action="${actionUrl}">
			
			<sf:hidden path="id"/>
			
			<div class="row mb-3">
				<div class="col">
					<label class="form-label">Name</label>
					<sf:input path="name" placeholder="Enter Name"/>
					<sf:errors path="name" cssClass="text-secondary" />
				</div>
				<div class="col">
					<label class="form-label">Entry Date</label>
					<sf:input path="entryDate" type="date" placeholder="Enter Entry Date"/>
					<sf:errors path="entryDate" cssClass="text-secondary" />
				</div>
			</div>
		
			<div class="row mb-3">
				<div class="col">
					<label class="form-label">Phone</label>
					<sf:input path="phone" type="tel" placeholder="Enter Phone Number"/>
					<sf:errors path="phone" cssClass="text-secondary" />
				</div>
				<div class="col">
					<label class="form-label">Email Address</label>
					<sf:input path="email" type="email" placeholder="Enter Email Address"/>
					<sf:errors path="email" cssClass="text-secondary" />
				</div>
			</div>
			
			<div>
				<button class="btn btn-outline-danger" type="submit">
					<i class="bi bi-save"></i> Save Teacher
				</button>
			</div>

		</sf:form>		
	
	</div>

</body>
</html>