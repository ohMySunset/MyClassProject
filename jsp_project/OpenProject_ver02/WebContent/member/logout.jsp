<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  //로그아웃 처리
  session.invalidate(); // 세션 소멸
  response.sendRedirect(request.getContextPath()); // 컨텍스트 경로로 이동시킴   
%>
