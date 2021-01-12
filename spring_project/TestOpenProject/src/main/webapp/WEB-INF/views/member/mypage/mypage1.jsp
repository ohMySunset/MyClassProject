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
		<h2 class="content_title">회원 정보</h2>
		<hr>
		<div class="content">
			<table>
				<tr>
					<td>아이디(email)</td>
					<td>${loginInfo.memberid}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${loginInfo.password}</td>
				</tr>
				<tr>
					<td>사진</td>
					<td><img alt="프로필" src="${loginInfo.memberphoto}"></td>
				</tr>
				<tr>
				<td>가입일</td>
				<td>${loginInfo.toDate}</td>
				</tr>				
			</table>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>