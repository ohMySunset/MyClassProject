<%@page import="member.dao.MemberDao"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int result = 0;

  // DAO객체의 insert 메서드로 member 참조변수 전달, Connection 객체의 참조변수 전달 
  Connection conn = ConnectionProvider.getConnection();
  MemberDao dao = MemberDao.getInstance();

  // 객체 생성이 성공했을 경우 처리
  if (conn != null) {

	// 폼에 입력한 사용자 입력 데이터의 한글 처리
	request.setCharacterEncoding("utf-8");

	String userId = request.getParameter("userid");
	String pw = request.getParameter("pw");
	String userName = request.getParameter("username");
	String userPhoto = request.getParameter("userPhoto");

	// Member 타입의 객체 불러오기
	Member member = new Member();
	member.setUserId(userId);
	member.setPassword(pw);
	member.setUserName(userName);
	member.setUserPhoto(userPhoto);

	System.out.println(member);

	// DB에 데이터 저장
	result = dao.insertMember(conn, member);
}
  
  request.setAttribute("result", result);
  
%>
<jsp:forward page="memberRegView.jsp"/>