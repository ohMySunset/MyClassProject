<%@page import="loginform.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    //객체에 저장된 속성 받아오기
    Member member = (Member) request.getAttribute("log");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

     <h1>로그인 성공!</h1>
     <h3>ID : <%= member.getUserId()%></h3>
     <h3>PW : <%= member.getPw() %></h3>
     <h3><a href="loginSessionCheck_self.jsp">로그인 확인 페이지로 이동</a></h3>
</body>
</html>