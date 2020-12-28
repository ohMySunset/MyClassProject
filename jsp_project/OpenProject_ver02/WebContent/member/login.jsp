<%@page import="member.LoginInfo"%>
<%@page import="member.Member"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터 받기 : 아이디, 비밀번호
String userId = request.getParameter("userid");
String pw = request.getParameter("pw");
String chk = request.getParameter("chk");

if (chk != null && chk.equals("on") && userId != null && !userId.isEmpty()) {
	// 체크값이 null이 아니고 value값이 on일때, 유저아이디 값이 null이 아니고 공백이 아닐때
	// 쿠키 생성 저장
	// uid = userId 

	response.addCookie(CookieBox.createCookie("uid", userId, "/", 60 * 60 * 24 * 365));
} else{
	//유지 시간을 0으로 설정하여 쿠키에 저장하지 않음!
	response.addCookie(CookieBox.createCookie("uid", userId, "/",0));
}	
	
	// 로그인 여부 확인
	boolean loginChk = false; // 로그인 되지 않은 상태
	// userId, pw를 입력 받고 member 테이블에서 데이터를 select
	// 값이 있으면 로그인 성공, 없으면 로그인 실패
	MemberDao dao = MemberDao.getInstance();
	Connection conn = ConnectionProvider.getConnection();
	Member member = dao.selectMemberLogin(conn, userId, pw);
	
	if(member != null){
		// 로그인에 성공하면 받아온 회원 데이터를 로그인 데이터에 저장
		// session객체에 저장한다
		
		// 회원 정보 -> 로그인 정보
		LoginInfo loginInfo = member.toLoginInfo();
		
		session.setAttribute("loginInfo", loginInfo);
		
		loginChk = true;
		
}
	if(loginChk==true){
%>
<jsp:forward page="loginView.jsp"/>	
<%
	} else {
%>
 <script>
	alert("아이디 또는 패스워드가 틀립니다. 다시 로그인해주세요.")
	history.go(-1);
</script> 

<%
	}
%>


  