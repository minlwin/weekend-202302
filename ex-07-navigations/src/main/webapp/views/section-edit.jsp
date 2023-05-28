<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDC | Section</title>

<jsp:include page="/includes/resources.jsp"></jsp:include>

</head>
<body>

	<jsp:include page="/includes/top-menu.jsp"></jsp:include>

	<div class="container mt-4">
	
		<h3>Edit Section</h3>
		
		<c:url value="/section" var="formAction"></c:url>
		<sf:form action="${formAction}" method="post" modelAttribute="form" >
			
			<sf:hidden path="id"/>
			
			<div class="row mb-3">
				<!-- Start Date -->
				<div class="col">
					<label class="form-label">Start Date</label>
					<sf:input path="startDate" cssClass="form-control" type="date" />
					<sf:errors path="startDate" cssClass="text-secondary" />
				</div>
		
				<!-- Course -->
				<div class="col">
					<label class="form-label">Course</label>
					<sf:select path="course" cssClass="form-select">
						<sf:option value="">Select Course</sf:option>
						<sf:options items="${courses}" itemValue="id" itemLabel="name" />
					</sf:select>
					<sf:errors path="course" cssClass="text-secondary" />
				</div>
				
				<!-- Teacher -->
				<div class="col">
					<label class="form-label">Teacher</label>
					<sf:select path="teacher" cssClass="form-select">
						<sf:option value="">Select Teacher</sf:option>
						<sf:options items="${teachers}" itemValue="id" itemLabel="name" />
					</sf:select>
					<sf:errors path="teacher" cssClass="text-secondary" />
				</div>
			
			</div>
			
	
			<div class="row mb-3">
				<!-- Start Time -->
				<div class="col">
					<label class="form-label">Start Time</label>
					<sf:input path="startTime" cssClass="form-control" type="time" />
					<sf:errors path="startTime" cssClass="text-secondary" />
				</div>
				
				<!-- End Time -->
				<div class="col">
					<label class="form-label">End Time</label>
					<sf:input path="endTime" cssClass="form-control" type="time" />
					<sf:errors path="endTime" cssClass="text-secondary" />
				</div>
				
				<!-- Available -->
				<div class="col btn-wrapper">
					<div class="mt-1">
						<sf:checkbox path="acceptable" id="acceptable" />
						<sf:label path="acceptable" for="acceptable">Acceptable</sf:label>
					</div>
				</div>
			
			</div>
			
			<!-- Days -->	
			<div class="mb-3">
				<label class="form-label">Days</label>
				<div class="d-flex">
					<sf:checkboxes cssClass="me-1" element="div class='me-3'" items="${days}" path="days"/>
				</div>
				<sf:errors path="days" cssClass="text-secondary" />
			</div>	
			
			<div>
				<button class="btn btn-outline-danger" type="submit">
					<i class="bi bi-save"></i> Save Section
				</button>
			</div>
		</sf:form>

		
	
	</div>

</body>
</html>