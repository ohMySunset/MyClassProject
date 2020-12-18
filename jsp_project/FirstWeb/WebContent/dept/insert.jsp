<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 한글 처리! (getParameter하기 전에)
request.setCharacterEncoding("utf-8");

// 데이터를 받고
String deptno = request.getParameter("deptno");
String name = request.getParameter("dname");
String loc = request.getParameter("loc");

Connection conn = null;

// 드라이버 로드
Class.forName("com.mysql.cj.jdbc.Driver");

// DB연결 : Connection 객체를 얻어온다.
String jdbcUrl = "jdbc:mysql://localhost:3306/open?serverTimezone=UTC";
String user = "aia";
String password = "aia";

conn = DriverManager.getConnection(jdbcUrl, user, password);

out.println("<h1> my sql 연결!</h1>");

// -> sql : insert
String sql_insert = "insert into dept values(?,?,?)";

PreparedStatement pstmt = conn.prepareStatement(sql_insert);
pstmt.setInt(1, Integer.parseInt(deptno));
pstmt.setString(2, name);
pstmt.setString(3, loc);

// -> insert_view
%>