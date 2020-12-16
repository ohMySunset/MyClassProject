<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>
</head>
<body>

	<!-- response.sendRedirect()와 forward액션의 차이 비교 -->

	<%
		String select = request.getParameter("select");
	int selectNum = Integer.parseInt(select);

	if (selectNum > 0) {
		out.println(selectNum);
		// 처음엔 현재 페이지가 응답으로 처리가 되고, response가 지정한
		// result.jsp 페이지를 다시 요청하여 결과 응답처리
		response.sendRedirect("result.jsp");
	} else {
		out.println(selectNum);
	%>
	<!-- 현재 페이지로 요청을 받지만 현재 페이지가 응답으로 처리되는것이 아니고,
              forward에서 지정한  result.jsp 페이지의 결과가 응답으로 처리 -->
	<jsp:forward page="result.jsp"></jsp:forward>
	<!-- └> 태그 처리 주의 -->
	<%
		}
	%>




</body>
</html>