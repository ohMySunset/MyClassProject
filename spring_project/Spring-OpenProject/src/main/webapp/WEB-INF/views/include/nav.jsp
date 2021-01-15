<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
	<nav>
		<ul>      <!-- <c:url value="/" /> ==> /op --> 
			<li><a href="<c:url value="/" />">HOME</a></li>
				
			<li><a href="<c:url value="/member/reg" />">회원가입</a></li>	
			<li>
			
			<%
			if(session.getAttribute("loginInfo")==null){
				
			
			%>
			<a href="<c:url value="/member/login" />">LOGIN</a>
			<%
			   } else {
			%>	
			<a href="<c:url value="/member/logout" />">LOGOUT</a>
			<%
			   }
			%>
			</li>
			<li><a href="<c:url value="/mypage/mypage1" />">My page 1</a></li>
			<li><a href="<c:url value="/mypage/mypage2" />">My page 2</a></li>		
			<li><a href="<c:url value="/mypage/mypage3" />">My page 3</a></li>				
			<li><a href="<c:url value="/member/list" />">회원 리스트</a></li>
			<li><a href="<c:url value="/member/list.jsp" />">방명록</a></li>
		</ul>
	</nav>