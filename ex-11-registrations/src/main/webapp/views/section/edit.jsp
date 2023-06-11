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
		<jsp:param value="Class Edit" name="title"/>
	</jsp:include>

</head>
<body>
	
	<app:page-content title="Edit Class Room">
		
		<sf:form modelAttribute="form" method="post">
			<sf:hidden path="id"/>
			
			<div class="row">
				<!-- Course -->
				<div class="col">
					<app:form-group label="Course">
						<sf:select path="course" cssClass="form-select">
							<sf:option value="">Select Course</sf:option>
							<sf:options items="${courses}" itemValue="id" itemLabel="name"/>
						</sf:select>					
						<sf:errors path="course" cssClass="text-secondary" />
					</app:form-group>
				</div>
				
				<!-- Durations -->
				<div class="col">
					<app:form-group label="Months">
						<sf:input path="months" type="number" cssClass="form-control"/>
						<sf:errors path="months" cssClass="text-secondary" />
					</app:form-group>
				</div>
				
				<!-- Acceptable -->
				<div class="col">
					<app:form-group label="Status">
						<div class="pt-1">
							<sf:checkbox id="acceptable" path="acceptable"/>
							<sf:label path="acceptable" >Acceptable</sf:label>
						</div>
					</app:form-group>
				</div>
			
			</div>
			
			<div class="row">
			
				<!-- Start Date -->
				<div class="col">
					<app:form-group label="Start Date">
						<sf:input path="startDate" type="date" cssClass="form-control"/>
						<sf:errors path="startDate" cssClass="text-secondary" />
					</app:form-group>
				</div>

				<!-- Start Time -->
				<div class="col">
					<app:form-group label="Start Tome">
						<sf:input path="startTime" type="time" cssClass="form-control"/>
						<sf:errors path="startTime" cssClass="text-secondary" />
					</app:form-group>
				</div>
				
				<!-- End Time -->
				<div class="col">
					<app:form-group label="End Tome">
						<sf:input path="endTime" type="time" cssClass="form-control"/>
						<sf:errors path="endTime" cssClass="text-secondary" />
					</app:form-group>
				</div>
			</div>
			
			<!-- Days -->
			<app:form-group label="Open Days">
				<div>
					<sf:checkboxes items="${days}" cssClass="me-1" element="span class='me-3'" path="days"/>
				</div>
				<sf:errors path="days" cssClass="text-secondary" />
			</app:form-group>
			
			<button type="submit" class="btn btn-primary">
				<i class="bi bi-save"></i> Save
			</button>

		</sf:form>
	
	</app:page-content>

</body>
</html>