<%@page import="member.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/loginChk.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>                      
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/default.css">
<style>

</style>
</head>
<body>

   <%@ include file ="/include/header.jsp" %>

   <%@ include file ="/include/nav.jsp" %>

<div class="contents">
 <h2 class="content_title">My page 2</h2>
 <hr>
 <div class="content">
  
 <% 
 LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
 
 if(loginInfo != null){
 
 %>
 <img alt="프로필 사진" 
 src="<%= request.getContextPath()%>/images/<%= loginInfo.getMemberPhoto()%>"
 height="200"
 > <%
 }%>
 
 <br>
 
 <%= session.getAttribute("loginInfo") %>

</div>

</div>

<%@ include file ="/include/footer.jsp" %>


</body>
</html>