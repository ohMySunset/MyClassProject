<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
String name = request.getParameter("name").toUpperCase();
%>

<!-- 에러 우선순위
지정한 errorPage > 타입 > 코드 > 기본 에러 페이지-->

<!-- 별도의 에러페이지 필요 시 -> page 디렉티브의 errorPage속성
범용적인 에러코드 404,500등 -> web.xml에 코드지정
별도로 처리해 주어야 하는 익셉션 타입 -> web.xml에 타입지정 -->

</body>
</html>