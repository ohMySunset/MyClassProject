<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  // 로그인이 되어있는지 확인
  boolean chk = false;
  chk = session.getAttribute("loginInfo")==null? false : true; 

   if(!chk){
%>
<script>
alert("로그인이 필요한 페이지 입니다.");
location.href='${pageContext.request.contextPath}/member/loginForm.jsp';
</script>
<%
   }
%>