<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<jsp:include page="/includes/header.jsp">
		<jsp:param value="Sign In" name="title"/>
	</jsp:include>

</head>
<body>
	
	<app:page-content title="Welcome to JDC!"></app:page-content>


</body>
</html>