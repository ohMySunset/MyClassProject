<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- core 태그 사용준비 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/index.jsp" /> <!-- 컨텍스트 경로 -->
	<br>
	<c:url value="index.jsp" />
	<br>
	<c:url value="/index.jsp" var="indexLink" />
	<!-- 특정 경로를 변수에 저장해놓고 쓸 수있다. -->
	${indexLink}
	<br>
  <c:url value="/index.jsp">
      <!-- param을 넣어서 경로를 만들어 낼 수 있다. -->
     <c:param name="pageNumber" value="1"/>
     <c:param name="keyWord" value="jstl"/>
  </c:url>
</body>
</html>