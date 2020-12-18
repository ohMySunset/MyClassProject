
<%@page import="loginform.Member"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // 데이터 받아오기
    String userId = request.getParameter("userid");
    String pw = request.getParameter("pw");
    String chk = request.getParameter("chk");
    
    // 쿠키 생성하고 저장하기
    // 체크값이 null이 아니고 value가 on일 때, userId가 null이 아니고 공백이 아닐때
    // uid = userId
    if(chk != null && chk.equals("on") && userId != null && !userId.isEmpty()){
    	
    	response.addCookie(CookieBox.createCookie("uid", userId, "/", 60*60*24*365));
    } else{
    	// 유지시간을 0으로 설정하여 쿠키에 저장하지 않음
    	response.addCookie(CookieBox.createCookie("uid", userId, "/", 0));
    }
    
    
    // 아이디와 비밀번호가 같을 경우 로그인 성공으로 가정
    boolean loginChk = false; // 로그인이 되지 않은 상태 
    
    if(userId.equals(pw)){
    // beans 객체 생성
    Member member = new Member();
    
    // 데이터 값 저장하기
    member.setUserId(userId);
    member.setPw(pw);
       
    request.setAttribute("log", member);
    // 로그인 정보를 session에 저장
    session.setAttribute("login", member);
    
    loginChk = true; // 로그인 성공
    
 }
    
  if(loginChk==true){
%>
<!-- View로 포워딩 -->
<jsp:forward page="loginView_self.jsp"/>
<%
} else {
%>	
<script>
alert("아이디 또는 패스워드가 틀립니다. 다시 시도해주세요!");
history.go(-1);
</script>
<%
}
%>




