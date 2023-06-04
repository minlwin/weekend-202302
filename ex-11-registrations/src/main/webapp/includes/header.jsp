<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    

<title>Registration | ${param.title}</title>

<c:url value="/static/css/bootstrap.min.css" var="bootCss"></c:url>
<c:url value="/static/js/bootstrap.bundle.min.js" var="bootJs"></c:url>
<c:url value="/static/js/application.js" var="appJs"></c:url>

<link rel="stylesheet" href="${bootCss}" />
<script src="${bootJs}"></script>
<script src="${appJs}"></script>
