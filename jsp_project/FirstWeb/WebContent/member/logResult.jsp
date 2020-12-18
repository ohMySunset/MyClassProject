<%@page import="loginform.LogForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  // beans 객체 생성
  LogForm logform = new LogForm();

  // 사용자로부터 데이터 받기
  String userId = request.getParameter("userId");
  String pw = request.getParameter("pw");
  
  // bean에 데이터 저장
  logform.setUserId(userId);  // 유저 아이디 저장
  logform.setPassword(pw);    // 유저 패스워드 저장
  
 
  request.setAttribute("data", logform);
  
  
%>
 // logView로 객체 공유
<jsp:forward page="logView.jsp"/>