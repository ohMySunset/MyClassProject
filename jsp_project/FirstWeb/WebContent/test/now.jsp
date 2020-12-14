
<!-- 디렉티브 : jsp의 속성 -->
<%@page import="java.util.Date"%> 
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   <!-- jsp를 실행하면 text기반의 html을 만들어내는것을 명시 -->


<!-- 스트립트릿 : 자바코드 --> 
<%
Date now = new Date();  /* 자바 객체 생성 */
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>now date</title>
</head>
<body>

<h1>현재시간 : <%= now %></h1>  <!-- 표현식 -->
<!-- 요청하는 순간에 따라 다른 응답을 제출 -->

<h1>컨텍스 경로 : <%= request.getContextPath() %></h1>

<!-- http://localhost:8080/FirstWeb/now.jsp -->
                     <!--  FirstWeb-->컨텍스트 경로 -->

</body>
</html>