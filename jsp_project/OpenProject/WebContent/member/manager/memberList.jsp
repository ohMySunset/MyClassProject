<%@page import="member.service.MemberListService"%>
<%@page import="member.model.Member"%>
<%@page import="java.util.List"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

  MemberListService service = MemberListService.getInstance();
  service.getMemberListView(request);

%>    
<jsp:forward page="memberListView.jsp"/>