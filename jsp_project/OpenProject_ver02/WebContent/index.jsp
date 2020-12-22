<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
<style>

</style>
</head>
<body>
   
   <%@ include file="/include/header.jsp" %>
   
   <%@ include file="/include/nav.jsp" %>
    
  <div class="contents">
  <h2 class="contents_title"> 안녕하세요! 에이아이 아카데미 입니다.</h2>
  <div class="content">
   <h3>회원 로그인이 필요합니다.</h3> <br>
   <h5>아직 회원이 아니신가요? <br>
   <a href="${pageContext.request.contextPath}/member/regForm.jsp">[회원가입 바로가기]</a>
   </h5>
  </div>
  </div>
 
 <%@ include file="/include/footer.jsp" %>


</body>
</html>