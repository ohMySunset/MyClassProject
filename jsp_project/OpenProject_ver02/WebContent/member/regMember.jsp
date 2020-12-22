<%@page import="java.sql.Connection"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    Connection conn = ConnectionProvider.getConnection();
    MemberDao dao = MemberDao.getInstance();

    int result = 0; // 데이터 저장한 결과 
 
   // 사용자가 폼에 입력한 데이터의 한글처리
   request.setCharacterEncoding("UTF-8");

   // 데이터 받아오기
   String userId = request.getParameter("userId");
   String pw = request.getParameter("pw");
   String userName = request.getParameter("userName");
   String userPhoto = request.getParameter("userPhoto");
   
   // beans 객체 불러오기
   Member member = new Member();
   
   // member에 데이터 저장
   member.setUserId(userId);
   member.setPw(pw);
   member.setUserName(userName);
   member.setUserPhoto(userPhoto);
   
   System.out.println(member);
   
   result = dao.insertMember(conn, member);
   
   request.setAttribute("result", result);
   
   
   
// regView로 데이터 전송    
%>    
<jsp:forward page="regView.jsp"/>
    
    