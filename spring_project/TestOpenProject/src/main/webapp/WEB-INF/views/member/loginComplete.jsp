<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/css/default.css" var="url_defaultCss" scope="application" />
<c:if test="${not loginCheck}">
 <script>
	alert("아이디 또는 패스워드가 틀립니다. 다시 로그인해주세요.")
	history.go(-1);
</script> 
</c:if>

<c:if test="${loginCheck}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="${url_defaultCss}">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	
   <div class="contents">
   <h2 class="content_title">Login</h2>
   <hr>
   <div class="content">
	<h3>로그인에 성공하였습니다</h3>
	<h3>${loginMember.memberid}님 환영합니다!</h3>
	</div>
  </div>
<%--<c:url value="/" var="home" />
    <a href="${home}">홈으로 이동</a> --%>
    
    	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>
</html>
</c:if>