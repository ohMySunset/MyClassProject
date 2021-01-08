<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/css/default.css" var="url_defaultCss" scope="application" />
<html>
<head>
<link rel="stylesheet" href="${url_defaultCss}">
<style>
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	
	<div class="contents">
		<h2 class="content_title">Home</h2>
		<hr>
		<div class="content_photo">
		<c:url value="/images/p1.jpg" var="photo"/>
         <img width="600" alt="" src="${photo}">
		</div>
	</div>

    <%@ include file="/WEB-INF/views/include/footer.jsp"%>


</body>
</html>
