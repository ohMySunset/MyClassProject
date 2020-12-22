<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- core 태그 사용준비 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%-- 중요! : <c:if> 태그 : 자바의 if와 비슷하지만 else문은 지원하지 않는다 --%>

 <c:set var="msg" value="user1"/>
  msg : ${msg} <br>
 <%--  <c:if test="${true(논리값)}"> --%>
 <c:if test="${msg =='user1'}" var="result1">
  test 속성의 값이 true일 때 body 내용이 출력 : ${result1}
  </c:if>
  
  <br>
  
  <c:set var="msg" value="user2"/>
  msg : ${msg} <br>
 <c:if test="${msg ne'user2'}" var="result2">
  test 속성의 값이 true일 때 body 내용이 출력 : ${result2}
  </c:if>
  
  <br>
  
  <c:set var="number" value="0"/>
  <c:choose>
  <c:when test="${number > 0}">
     양수입니다.
  </c:when>
  <c:when test="${number < 0}">
     음수입니다.
  </c:when>
  <c:otherwise>
  0입니다.
  </c:otherwise>
  </c:choose>
  
  <br>
  <!-- 삼항 연산자 활용 -->
  <input type="checkbox" ${msg eq 'user1'?'checked':''}> 
  <br>
  id 저장 <input type="checkbox" ${cookie.uid ne null?'checked':''}> 
  
</body>
</html>