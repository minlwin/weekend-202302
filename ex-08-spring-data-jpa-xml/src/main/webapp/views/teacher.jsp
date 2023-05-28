<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
	
		<h3>Teacher Management</h3>
		
		
		<form class="row">
			<div class="col-auto col-sm-3">
				<label class="form-label">Search Name</label>
				<input class="form-control" type="text" placeholder="Search Name" name="name" />
			</div>
			<div class="col-auto col-sm-3">
				<label class="form-label">Search Phone</label>
				<input class="form-control" type="text" placeholder="Search Phone" name="phone" />
			</div>
			<div class="col btn-wrapper">
				<button class="btn btn-outline-primary" type="submit">
					<i class="bi bi-search"></i> Search
				</button>
				
				<c:url value="/teacher/edit" var="editUrl"></c:url>
				<a href="${editUrl}" class="btn btn-outline-danger">
					<i class="bi bi-plus-lg"></i> Add New
				</a>
			</div>
		</form>
		
		<div class="mt-4">
			
			<c:choose>
				<c:when test="${not empty list}">
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Name</th>
								<th>Phone</th>
								<th>Email</th>
								<th>Entry Date</th>
								<th></th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach items="${list}" var="t">
								<tr>
									<td>${t.name}</td>
									<td>${t.phone}</td>
									<td>${t.email}</td>
									<td>${t.entryDate}</td>
									<td>
										<c:url value="/teacher/edit" var="editLink">
											<c:param name="id" value="${t.id}" />
										</c:url>
										<a href="${editLink}" class="icon-link">
											<i class="bi bi-pencil"></i>
										</a>
										
										<c:url value="/teacher/${t.id}" var="detailsLink" />
										<a href="${detailsLink}" class="icon-link">
											<i class="bi bi-send"></i>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					
					</table>				
				</c:when>
				
				<c:otherwise>
					<div class="alert alert-info">There is no data.</div>
				</c:otherwise>
			</c:choose>
		
		</div>
	
	</div>
</body>
</html>