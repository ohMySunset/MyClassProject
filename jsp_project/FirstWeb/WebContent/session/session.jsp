<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.setAttribute("userName", "손흥민");
%>
<!-- 브라우저가 달라지면 세션 값도 달라짐. session.jsp에서 실행해야함 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Control</title>
</head>
<body>

	<h1>세션에 정보를 저장했습니다.</h1>
	<h1>
		<a href="sessionView.jsp">세션의 속성 확인</a>
	</h1>
</body>
</html>