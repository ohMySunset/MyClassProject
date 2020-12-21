<%@page import="member.LoginInfo"%>
<%@page import="jdbc.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="util.CookieBox"%>
<%@page import="member.Member"%>
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

// session을 이용해서 로그인 처리	
// id, pw를 조건으로 Member 테이블에서 select 한 결과가 있으면 인증에 성공, 
// 없으면 인증 실패
// 로그인 여부 체크
boolean loginChk = false; // 로그인이 되지 않은 상태

MemberDao dao = MemberDao.getInstance();

Connection conn = ConnectionProvider.getConnection();

Member member = dao.selectMemberLogin(conn, userId, pw);


if(member!=null){
	// 인증이 되어 로그인 처리 : session 객체에 로그인 정보를 속성에 저장
	//System.out.println(member);

  LoginInfo loginInfo = member.toLoginInfo();
  
  session.setAttribute("loginInfo", loginInfo);
  //System.out.println(loginInfo);  
  
  loginChk = true;
  
} 


// loginView.jsp로 포워딩
if (loginChk==true) {
%>
<jsp:forward page="loginView.jsp" />
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
