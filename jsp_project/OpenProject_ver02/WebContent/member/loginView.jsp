<%@page import="member.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
<style>

</style>
</head>
<body>
   
   <%@ include file="/include/header.jsp" %>
   
   <%@ include file="/include/nav.jsp" %>
    
  <div class="contents">
  <h2 class="contents_title">Sign In</h2>
  <div class="content">
    로그인 되었습니다!
  ${loginInfo}
  </div>
  </div>
 
 <%@ include file="/include/footer.jsp" %>


</body>
</html>