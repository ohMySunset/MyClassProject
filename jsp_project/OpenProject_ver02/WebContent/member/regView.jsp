<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   // 회원정보로 저장된 데이터 받아오기 (형변환 필요)
  int result = (Integer) request.getAttribute("result");
%>    
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
  <h2 class="contents_title">Sign Up</h2>
  <div class="content">
   <% if(result > 0){    
	   out.println("회원가입이 정상 처리되었습니다.");
   } else{
	   out.println("회원가입에 실패하였습니다. 다시 시도해주세요.");
   }
	   %>
   
  </div>
  </div>
 
 <%@ include file="/include/footer.jsp" %>


</body>
</html>