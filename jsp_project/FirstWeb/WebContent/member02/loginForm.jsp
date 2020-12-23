<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
CookieBox cookiebox = new CookieBox(request);

// 삼항 연산자를 사용하여 쿠키값에 uid값이 있는지 여부 확인
String saveId = cookiebox.exist("uid")?cookiebox.getValue("uid"):"";
String checked = cookiebox.exist("uid")? "checked" : "";

%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 폼</title>
</head>

<body>
    <h1>회원 로그인 </h1>
    <hr>
    <form action="<c:url value="/member02/login.jsp"/>" method="post">
        <table>
            <tr>
                <th><label for="userid">아이디</label></th>
                <td>                                             <!-- 저장된 쿠키값을 value로 -->
                    <%-- <input type="text" id="userid" name="userid" value="<%= saveId%>"> --%>
                    <input type="text" id="userid" name="userid" value="${cookiebox.uid.value}">
                </td>
            </tr>
            <tr>
                <th><label for="pw">비밀번호</label></th>
                <td>
                    <input type="password" id="pw" name="pw">
                </td>
            </tr>
            <tr>
                <th></th>
                <td>                                            <!-- 쿠키값에 저장이 되어 있으면 checked 속성 적용 -->
                    <input type="checkbox" name="chk" value="on" <%= checked %>> 아이디 저장
                </td>
            </tr>
            <tr>
                <td >
                    
                </td>
                <td>
                <input type="submit" value="로그인">
                </td>
            </tr>
        </table>
    </form>

</body>

</html>
