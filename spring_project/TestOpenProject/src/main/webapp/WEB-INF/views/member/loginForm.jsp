<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/css/default.css" var="url_defaultCss" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${url_defaultCss}">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>


	<div class="contents">
		<h2 class="content_title">Sign In</h2>
		<hr>
		<div class="content">
			<form method="post">
				<table>
					<tr>
						<td><label for="memberid">아이디(email)</label></td>
						<td><input type="text" name="memberid" id="memberid" value="${cookie.uid.value}"></td>
					</tr>
					<tr>
						<td><label for="userPw">비밀번호</label></td>
						<td><input type="password" name="password" id="password"></td>
					</tr>
					<tr>
						<td>아이디 저장<input type="checkbox" name="chk "value="on" ${cookie.uid ne null?'checked':''}></td>
						<td class="submit"><input type="submit" value="로그인"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>