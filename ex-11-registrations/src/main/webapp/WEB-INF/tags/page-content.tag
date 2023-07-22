<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" type="java.lang.String" required="true" %>

<jsp:include page="/includes/navigation.jsp"></jsp:include>

<div class="container mt-3">
	<h3 class="mb-3">${title}</h3>
	
	<jsp:doBody></jsp:doBody>
</div>
