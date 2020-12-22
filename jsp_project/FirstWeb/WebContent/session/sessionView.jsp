<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 속성값 확인</title>
</head>
<body>
	<h1>
		세션의 속성에 저장된 userName :
		<%=session.getAttribute("userName")%> <br>
			세션의 속성에 저장된 userName :
		${sessionScope.userName}
		<!-- 출력 표현식은 toString()으로 표현되며 object타입으로 따로 형변환할 필요가 없음 -->
	</h1>		
	<h1>
		<a href="../index.jsp">index로 이동</a>
	</h1>

</body> 
</html>