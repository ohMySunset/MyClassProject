<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
  request.setAttribute("now", new Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${now}
<br>

<%-- <fmt:timeZone value="Hongkong"> --%>
<br>
년.월.일 => <fmt:formatDate value="${now}"/> 
<br>
년.월.일 => <fmt:formatDate value="${now}" type="date"/> 
<br> 
년 월 일 요일 => <fmt:formatDate value="${now}" type="date" dateStyle="full"/>
<br> 
년.월.일 => <fmt:formatDate value="${now}" type="date" dateStyle="short"/>
<br>
오전/오후 시:분:초 => <fmt:formatDate value="${now}" type="time"/> 
<br>
오전/오후 시 분 초 (지역) => <fmt:formatDate value="${now}" type="time" timeStyle="full"/> 
<br>
오전/오후 시:분 => <fmt:formatDate value="${now}" type="time" timeStyle="short"/>
<br>
date + time => <fmt:formatDate value="${now}" type="both"/>
<br>
date + time (풀버전) => <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>
<br>
패턴 => <fmt:formatDate value="${now}" pattern="z a h:mm"/> 
<br>
패턴 => <fmt:formatDate value="${now}" pattern="hh:mm"/> 
<br>
패턴 => <fmt:formatDate value="${now}" pattern="yyyy.MM.dd hh:mm"/> 
<br>
패턴(홍콩시간) => <fmt:formatDate value="${now}" pattern="yyyy.MM.dd hh:mm" timeZone="Hongkong"/> 
<br>
<%-- </fmt:timeZone> --%>

</body>
</html>