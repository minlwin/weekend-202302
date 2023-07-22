<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<jsp:include page="/includes/header.jsp">
		<jsp:param value="Class" name="title"/>
	</jsp:include>

</head>
<body>
	
	<app:page-content title="Class Room Details">
		
		<div class="row">
			<div class="col">
				<!-- Course -->
				<app:course-item item="${dto.course}"></app:course-item>
				
				<div class="card mt-3">
					<div class="card-body">
						<h5 class="card-title">
							<i class="bi bi-calendar"></i> Class Information
						</h5> 
						
						<div class="row mt-3">
							<!-- Start Date -->
							<div class="col">
								<label class="form-label">
									<i class="bi bi-calendar-check"></i> Start Date
								</label>
								<span class="form-control">${dto.startDate}</span>
							</div>
							
							<!-- Start Time -->
							<div class="col">
								<label class="form-label">
									<i class="bi bi-clock"></i> Start Time
								</label>
								<span class="form-control">${dto.startTime}</span>
							</div>
							
							<!-- End Time -->
							<div class="col">
								<label class="form-label">
									<i class="bi bi-clock"></i> End Time
								</label>
								<span class="form-control">${dto.endTime}</span>
							</div>
						
						</div>
						
						<!-- Days -->
						<div class="mt-3 row">
						
							<!-- Duration -->
							<div class="col-4">
								<label class="form-label"> 
									<i class="bi bi-calendar"></i> Duration</label>
								<span class="form-control">
									${dto.months} Months
								</span>
							</div>

							<div class="col">
								<label class="form-label">
									<i class="bi bi-calendar"></i> Class Days
								</label>
								
								<div class="row gx-2">
									<c:forEach items="${dto.days}" var="day">
										<div class="col-auto">
											<span class="form-control">${day}</span>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						
						
						<sec:authorize access="isAnonymous()">
							<div class="mt-3">
								<!-- Apply Course Button -->
								<c:url value="/public/registration/${dto.id}" var="registration"></c:url>
								<a href="${registration}" class="btn btn-outline-primary">
									<i class="bi bi-send"></i> Apply Course
								</a>
							</div>
						</sec:authorize>
						
						<sec:authorize access="hasAuthority('Student')">
						
						</sec:authorize>
					</div>
				</div>
			</div>
			
			<div class="col-4">
				<!-- Teacher -->
				<div class="card mb-3">
					<div class="card-body">
						<h5 class="card-title">
							<i class="bi bi-person"></i> Teacher
						</h5>
						
						<div>
							<div>${dto.teacher.name}</div>
							<div>${dto.teacher.email}</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
		
		<!-- Class Room Information -->
	
	</app:page-content>

</body>
</html>