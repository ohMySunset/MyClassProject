<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!-- css파일을 url경로로 어플리케이션 속성에 저장한다 -->
 <c:url value="/css/default.css" var="url_defaultCss" scope="application"/>
 
<!--  http://localhost:8080.opmvc/css/default.css
 url-pattern을 "/" 뒤의 모든 요청을 처리하는 방식으로 하면
 /css/default.css -> 프론트 컨트롤러에서 요청으로 받아들임
 확장자를 "*.do"로 해서 처리 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
                      
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css"> --%>
<link rel="stylesheet" href="${url_defaultCss}">
<style>

</style>
</head>
<body>

  

   <%@ include file ="/WEB-INF/view/include/header.jsp" %>

   <%@ include file ="/WEB-INF/view/include/nav.jsp" %>

<div class="contents">
 <h2 class="content_title">index</h2>
 <hr>
 <div class="content">
  인덱스 페이지 입니다. 
 </div>
</div>

<%@ include file ="/WEB-INF/view/include/footer.jsp" %>


</body>
</html>