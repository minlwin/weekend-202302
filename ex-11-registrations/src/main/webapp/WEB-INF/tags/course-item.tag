<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ attribute name="item" required="true" type="com.jdc.registration.service.entity.Course" %>

<div class="card">
	<div class="card-body">
		<h5 class="card-title d-flex justify-content-between">
			<span><i class="bi bi-book"></i> ${item.name}</span>
			<span>${item.hours} Hours</span>
		</h5>
		<small>${item.level}</small>
		<p>${item.description}</p>
		<small>${item.fees} MMK</small>
	</div>
</div>
