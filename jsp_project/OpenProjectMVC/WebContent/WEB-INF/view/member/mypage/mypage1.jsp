<%@page import="member.model.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/loginCheck.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
                      
<link rel="stylesheet" href="${url_defaultCss}">
<style>

</style>
</head>
<body>

   <%@ include file ="/WEB-INF/view/include/header.jsp" %>

   <%@ include file ="/WEB-INF/view/include/nav.jsp" %>

<div class="contents">
 <h2 class="content_title">My page 1</h2>
 <hr>
 <div class="content">
<%--  <%= session.getAttribute("loginInfo") %> --%>
 ${loginInfo}
 <br>
 <% 
 LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
 
 if(loginInfo != null){
 
 %>
<%--  <img alt="프로필 사진" 
 src="<%= request.getContextPath()%>/images/<%= loginInfo.getMemberPhoto()%>"
 height="100"
 > --%>
 <img alt="프로필 사진" 
 src="${pageContext.request.contextPath}/upload/member/${loginInfo.memberPhoto}"
 height="100"
 > <%
 }%>
</div>

</div>

<%@ include file ="/WEB-INF/view/include/footer.jsp" %>


</body>
</html>