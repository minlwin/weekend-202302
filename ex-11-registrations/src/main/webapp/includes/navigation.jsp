<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>        
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>        

<nav class="navbar navbar-expand navbar-dark bg-primary">
	
	<c:url value="/" var="home"></c:url>
	<c:url value="/office/course" var="editCourse"></c:url>
	<c:url value="/office/account" var="accountList"></c:url>
	<c:url value="/student/section" var="myClassForStudent"></c:url>
	<c:url value="/teacher/section" var="myClassForTeacher"></c:url>
	<c:url value="/login" var="signIn"></c:url>
	<c:url value="/section" var="section"></c:url>

	<div class="container">
		<a href="${home}" class="navbar-brand">JDC Portal</a>

		<ul class="navbar-nav">
			<!-- Office -->
			<li class="nav-item">
				<a href="${editCourse}" class="nav-link">Add New Course</a>
			</li>
			<li class="nav-item">
				<a href="${accountList}" class="nav-link">Accounts</a>
			</li>
			
			<!-- Teacher or Student -->
			<li class="nav-item">
				<a href="${myClassForStudent}" class="nav-link">My Classes</a>
			</li>

			<li class="nav-item">
				<a href="#" id="logoutMenu" class="nav-link">Sign Out</a>
			</li>
			
			<li class="nav-item">
				<a href="${section}" class="nav-link">Classes</a>
			</li>

			<li class="nav-item">
				<a href="${signIn}" class="nav-link">Sign In</a>
			</li>
		</ul>
	</div>
	
	<c:url value="/logout" var="logoutAction"></c:url>
	<sf:form action="${logoutAction}" method="post" cssClass="d-hone" id="logoutForm"></sf:form>
	
</nav>