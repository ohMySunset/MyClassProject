<%@page import="loginform.RegForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

   // beans 객체 생성 
   RegForm regform = new RegForm();

   // 사용자로부터 데이터 받기
   String userId = request.getParameter("userId");
   String pw = request.getParameter("pw");
   String userName = request.getParameter("userName");
   
   // beans에 데이터 저장
   regform.setUserId(userId);
   regform.setPassword(pw);
   regform.setUserName(userName);
   
   // 만들어진 객체를 view로 공유하기
    request.setAttribute("userData", regform);
      
%>
<jsp:forward page="regView.jsp"/>