<%@page import="member.service.WriteMessageService"%>
<%@page import="member.model.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
   // 인코딩 처리
   request.setCharacterEncoding("utf-8");
   // 데이터 받기 
   String memberId = request.getParameter("memberId");
   String password = request.getParameter("password");
   String message = request.getParameter("message");
   
   //메세지 빈즈 객체 생성
   Message msg = new Message();
   msg.setMemberId(memberId);
   msg.setPassword(password);
   msg.setMessage(message);  
   
   request.setAttribute("msg", msg);
   
   WriteMessageService service = WriteMessageService.getInstance();
   int result = service.writeMessage(msg);
%>    

<c:set var="result" value="<%= result %>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <c:if test="${result>0}">
    메세지가 정상적으로 입력되었습니다. <br>
    ${msg}   
   </c:if>

   <c:if test="${result<1}">
    메세지 입력이 정상처리되지 않았습니다. 다시 시도해주세요    
   </c:if>

   <a href="<c:url value="/member/list.jsp"/>">목록보기</a> 
</body>
</html>