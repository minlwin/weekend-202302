<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ attribute name="dto" required="true" type="com.jdc.registration.service.entity.Section" %>

<section class="card">
	
	<div class="card-body">
		
		<h5 class="card-title">
			<i class="bi bi-book"></i> ${dto.course.name}
		</h5>
		
		<p>${dto.course.description}</p>
		
		<div class="list-group list-group-flush">
			<app:group-item icon="bi-person" value="${dto.teacher.name}" title="Teacher" />
			<app:group-item icon="bi-calendar-check" value="${dto.startDate}" title="Start Date" />
			<app:group-item icon="bi-clock" value="${dto.startTime}" title="Start Time" />
			<app:group-item icon="bi-clock" value="${dto.endTime}" title="End Time" />
		</div>
		
		<div class="mt-3">
			<sec:authorize access="hasAnyAuthority('Teacher', 'Office')">
			<sec:authentication var="loginId" property="name"/>
			
			<c:if test="${dto.teacher.email eq loginId}">
				<c:url value="/teacher/section" var="editUrl">
					<c:param name="id" value="${dto.id}" />
				</c:url>
				<a href="${editUrl}" class="btn btn-outline-danger">
					<i class="bi bi-pencil"></i> Edit
				</a>
			</c:if>
			</sec:authorize>

			<c:url value="/public/section/${dto.id}" var="detailsUrl" />
			<a href="${detailsUrl}" class="btn btn-outline-primary">
				<i class="bi bi-send"></i> Show Details
			</a>
		</div>
		
		
	</div>

</section>