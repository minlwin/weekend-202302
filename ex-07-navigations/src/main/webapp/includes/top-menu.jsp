<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:url value="/" var="homeUrl"></c:url>
<c:url value="/course" var="courseUrl"></c:url>
<c:url value="/teacher" var="teacherUrl"></c:url>
<c:url value="/section" var="sectionUrl"></c:url>

<nav class="navbar navbar-expand bg-danger-subtle">
	<div class="container">
		<a href="${homeUrl}" class="navbar-brand">
			JDC Home
		</a>
		
		<ul class="navbar-nav">
			<li class="nav-item">
				<a href="${courseUrl}" class="nav-link">Courses</a>
			</li>
			<li class="nav-item">
				<a href="${teacherUrl}" class="nav-link">Teachers</a>
			</li>
			<li class="nav-item">
				<a href="${sectionUrl}" class="nav-link">Sections</a>
			</li>
		</ul>
	</div>
</nav>