<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav>
	<ul>
		<c:url value="/" var="home" />
		<li><a href="${home}">Home</a></li>

		<c:if test="${loginInfo!=null}">
			<c:url value="logout" var="logout" />
			<li><a href="${logout}">로그아웃</a></li>
		</c:if>
		<c:if test="${loginInfo==null}">
			<c:url value="login" var="login" />
			<li><a href="${login}">로그인</a></li>
		</c:if>

		<c:url value="regForm" var="reg" />
		<li><a href="${reg}">회원가입</a></li>

		<li><a href="#">마이페이지1</a></li>
		<li><a href="#">마이페이지2</a></li>
		<li><a href="#">회원 리스트</a></li>
		<li><a href="#">방명록</a></li>
	</ul>

</nav>