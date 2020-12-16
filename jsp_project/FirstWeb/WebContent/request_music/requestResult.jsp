<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>[사용자 음악 취향 조사]</h3>
	<h3>What is your Music taste♬?</h3>
	<hr>

	<table>
		<tr>
			<td>당신의 나이는?<br></td>
			<td><%=request.getParameter("age")%></td>
		</tr>
		<tr>
			<td>당신의 성별은?</td>
			<td><%=request.getParameter("sex")%></td>
		</tr>
		<tr>
			<td>선호하는 음악의 연도는?</td>
			<td>
				<%
					String[] years = request.getParameterValues("year");
				for (int i = 0; i < years.length; i++) {
					out.println(years[i] + "<br>");
				}
				%>
			</td>
		</tr>
		<tr>
			<td>선호하는 음악 장르는?</td>
			<td>
				<%
					String[] genre = request.getParameterValues("genre");
				for (int i = 0; i < genre.length; i++) {
					out.println(genre[i] + "<br>");
				}
				%>
			</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>

</body>
</html>