<%@page import="loginform.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    // 로그인 상태 확인 : session객체 속성에 'login'이 있는지 확인
    Member member = (Member) session.getAttribute("login");
    // 삼항 연산자를 사용하여 처리
    boolean chk =(member == null)? false: true;
       
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 상태 확인</title>
</head>
<body>
<%
    if(chk){
    	out.println("로그인 상태입니다.");
    	out.println("<h1>"+member+"</h1>");
    	out.println("<h3><a href=\"logout_self.jsp\">로그아웃</a></h3>");	
    } else{
    	%>
    	<script>
    	alert("로그인이 필요한 페이지 입니다. 로그인 화면으로 돌아갑니다.");
    	location.href="loginForm_self.jsp";
    	</script>
    	<%
    }
%>



</body>
</html>