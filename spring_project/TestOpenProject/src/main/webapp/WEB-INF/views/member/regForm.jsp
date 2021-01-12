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
						<th><label for="memberid">아이디(email)</label></th>
						<td><input type="email" id="memberid" name="memberid"></td>
					</tr>
					<tr>
						<th><label for="password">비밀번호</label></th>
						<td><input type="password" id="password" name="password"></td>
					</tr>
					<tr>
						<th><label for="membername">이름</label></th>
						<td><input type="text" id="membername" name="membername"></td>
					</tr>
					<tr>
						<th><label for="memberphoto">사진</label></th>
						<td><input type="file" id="memberphoto" name="memberphoto">
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
