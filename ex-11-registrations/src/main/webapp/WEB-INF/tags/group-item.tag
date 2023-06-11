<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="icon" required="true" type="java.lang.String" %>
<%@ attribute name="title" required="true" type="java.lang.String" %>
<%@ attribute name="value" required="true" type="java.lang.String" %>

<div class="list-group-item">
	<div class="row">
		<div class="col-auto">
			<i class="bi ${icon}"></i>
		</div>
		<div class="col d-flex justify-content-between">
			<span class="text-secondary">${title}</span>
			<span>${value}</span>
		</div>
	</div>
</div>
