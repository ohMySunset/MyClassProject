<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/css/default.css" var="url_defaultCss" scope="application" />
<html>
<head>
<link rel="stylesheet" href="${url_defaultCss}">
<style>
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>

	<div class="contents">
		<h2 class="content_title">Sign up</h2>
		<hr>
		<div class="content">
			<form action="regComplete">
				<table>
					<tr>
						<th><label for="userId">아이디(email)</label></th>
						<td><input type="email" id="userId" name="userId"></td>
					</tr>
					<tr>
						<th><label for="userPw">비밀번호</label></th>
						<td><input type="password" id="userPw" name="userPw"></td>
					</tr>
					<tr>
						<th><label for="userName">이름</label></th>
						<td><input type="text" id="userName" name="userName"></td>
					</tr>
					<tr>
						<th><label for="userPhoto">사진</label></th>
						<td><input type="file" id="userPhoto" name="userPhoto">
						</td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" value="회원가입"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
