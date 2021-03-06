<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
CookieBox cookiebox = new CookieBox(request);

// 삼항 연산자를 사용하여 쿠키 값에 저장된 uid가 존재하는지 확인
String savedId = cookiebox.exist("uid")?cookiebox.getValue("uid"):"";
String checked = cookiebox.exist("uid")?"checked":""; 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
 <h1>회원 로그인 </h1>
    <hr>
    <form action="login_self.jsp" method="post">
        <table>
            <tr>
                <th><label for="userid">아이디</label></th>
                <td>                                             <!-- 저장된 쿠키값을 value로 -->
                    <input type="text" id="userid" name="userid" value="<%= savedId%>">
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