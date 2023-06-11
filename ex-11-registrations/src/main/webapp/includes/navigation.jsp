<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>        
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>       

<nav class="navbar navbar-expand navbar-dark bg-primary">
	
	<c:url value="/" var="home"></c:url>
	<c:url value="/office/course" var="editCourse"></c:url>
	<c:url value="/office/account" var="accountList"></c:url>
	<c:url value="/student/section" var="myClassForStudent"></c:url>
	<c:url value="/teacher/section" var="myClassForTeacher"></c:url>
	<c:url value="/login" var="signIn"></c:url>
	<c:url value="/public/section" var="section"></c:url>

	<div class="container">
		<a href="${home}" class="navbar-brand">JDC Portal</a>

		<ul class="navbar-nav">

			<!-- Office -->
			<sec:authorize access="hasAuthority('Office')">
				<li class="nav-item">
					<a href="#" class="nav-link">
						<i class="bi bi-pen"></i> Registrations
					</a>
				</li>
				<li class="nav-item">
					<a href="#" class="nav-link">
						<i class="bi bi-calendar"></i> Classes
					</a>
				</li>
				<li class="nav-item">
					<a href="${editCourse}" class="nav-link"><i class="bi bi-book"></i> Courses</a>
				</li>
				<li class="nav-item">
					<a href="${accountList}" class="nav-link"><i class="bi bi-people"></i> Accounts</a>
				</li>
			</sec:authorize>
			
			<!-- Teacher -->
			<sec:authorize access="hasAuthority('Teacher')">

				<li class="nav-item">
					<a href="${myClassForTeacher}" class="nav-link"><i class="bi bi-calendar-check"></i> My Classes</a>
				</li>

				<li class="nav-item">
					<a href="#" class="nav-link">
						<i class="bi bi-person"></i> Profile
					</a>
				</li>
			</sec:authorize>

			<!-- Student -->
			<sec:authorize access="hasAuthority('Student')">
				<li class="nav-item">
					<a href="${myClassForStudent}" class="nav-link"><i class="bi bi-calendar-check"></i> My Classes</a>
				</li>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<li class="nav-item">
					<a href="#" id="logoutMenu" class="nav-link"><i class="bi bi-lock"></i> Sign Out</a>
				</li>
			</sec:authorize>
			
			
			<sec:authorize access="isAnonymous()">
				<li class="nav-item">
					<a href="${signIn}" class="nav-link"><i class="bi bi-unlock"></i> Sign In</a>
				</li>
			</sec:authorize>
		</ul>
	</div>
	
	<c:url value="/logout" var="logoutAction"></c:url>
	<sf:form action="${logoutAction}" method="post" cssClass="d-hone" id="logoutForm"></sf:form>
	
</nav>