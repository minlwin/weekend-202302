<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="scriptless" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ attribute name="isEmpty" required="true" %>

<section class="mt-2">

	<c:choose>
		<c:when test="${isEmpty}">
			<div class="alert alert-info">There is no data.</div>
		</c:when>
		
		<c:otherwise>
			<jsp:doBody></jsp:doBody>
		</c:otherwise>
	</c:choose>

</section>