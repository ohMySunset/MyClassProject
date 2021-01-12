<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/css/default.css" var="url_defaultCss" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
<link rel="stylesheet" href="${url_defaultCss}">
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<div class="contents">
		<h2 class="content_title">회원 리스트</h2>
		<hr>
		<div class="content">
			<h3>전체회원 :${memberCnt}명</h3>
			<hr>
			<%-- ${members} --%>
			<table border="1">
				<tr>
					<th>idx</th>
					<th>아이디</th>
					<th>이름</th>
					<th>비밀번호</th>
					<th>사진</th>
					<th>가입일</th>
				</tr>
				<c:forEach items="${memberList}" var="member">
				<tr>
					<td>${member.idx}</td>
					<td>${member.memberid}</td>
					<td>${member.membername}</td>
					<td>${member.password}</td>
					<td>${member.memberphoto}</td>
					<td>${member.toDate}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>