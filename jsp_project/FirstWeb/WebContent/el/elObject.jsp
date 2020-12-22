<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setAttribute("userName", "손흥민1");   
  session.setAttribute("userName", "손흥민2"); 
  application.setAttribute("userName", "손흥민3"); 
  session.setAttribute("userId", "son");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <h1>                                                
                                                  <!-- *내장객체 표현식이 생략일 때 규칙 :
                                                  page,request,session,application 차례로 내려가면서 찾음 -->
    requestScope.userName : ${requestScope.userName}, ${userName}, 
                          <%= request.getAttribute("userName") %> <br>
    sessionScoope.userId : ${sessionScope.userId},  ${userId},
                          <%= session.getAttribute("userId") %>  <br>
                          
    param.code : <%= request.getParameter("code") %>, <!-- 핵심처리에서는 자바코드 -->
                  ${param.code}  <br>                 <!-- 표현처리에서는 EL -->
    pageContext : <%= pageContext.getRequest().getServletContext().getContextPath() %>, <br> 
                  ${pageContext.request.requestURI}, <br>   
                  ${pageContext.request.requestURL}, <br>  
                  ${pageContext.request.contextPath},  <br>
                  <%= request.getContextPath() %>
  </h1>
  <a href="view1.jsp">session 페이지 확인</a>
  
</body>
</html>