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
		<jsp:param value="Accounts" name="title"/>
	</jsp:include>

</head>
<body>
	
	<sec:authentication property="principal.username" var="loginId" />

	<app:page-content title="Account Management">

		<!-- Search Form -->
		<form class="row">
			<div class="col-auto">
				<label class="form-label">Search Role</label>
				<select name="role" id="role" class="form-select">
					<option value="">All Roles</option>
					<c:forEach items="${roles}" var="role">
						<option value="${role}">${role}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="col-auto">
				<label for="name" class="form-label">Search Name</label>
				<input type="text" id="name" name="name" class="form-control" placeholder="Search Name" />
			</div>
			
			<div class="col btn-wrapper">
				<button class="btn btn-outline-primary" type="submit">
					<i class="bi bi-search"></i> Search
				</button>
				
				<c:url value="/office/account/edit" var="addNewLink"></c:url>		
				<a href="${addNewLink}" class="btn btn-outline-danger">
					<i class="bi bi-plus-lg"></i> Add New
				</a>
			</div>
		</form>
		
		<!-- Search Result -->
		<app:result-list isEmpty="${empty list}">
			<table class="table table-striped">
				<thead>
				<tr>
					<th>Name</th>
					<th>Role</th>
					<th>Email</th>
					<th>Active</th>
					<th>Retired At</th>
					<th></th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>${item.role}</td>
						<td>${item.email}</td>
						<td>${item.activated ? 'Yes' : 'No'}</td>
						<td>${item.retiredAt}</td>
						<td>
							<c:if test="${loginId ne item.email}">
								<c:url value="/office/account/edit" var="editLink">
									<c:param name="id" value="${item.id}" />
								</c:url>
								<a href="${editLink}" class="btn-link">
									<i class="bi bi-pencil"></i>
								</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				</tbody>					
			</table>
		</app:result-list>	
	</app:page-content>	

</body>
</html>