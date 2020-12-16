<%@page import="loginform.RegForm"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   RegForm userData = (RegForm) request.getAttribute("userData");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View에 데이터 출력하기</title>
</head>
<body>

<h3>회원 정보 출력</h3>
    
    <table>
     <tr>
         <td>아이디(이메일)</td>
         <td><%= userData.getUserId() %></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><%= userData.getPassword()%></td>
        </tr>    
        <tr>
            <td>이름</td>
            <td><%= userData.getUserName()%></td>
        </tr>   
        <tr>
            <td></td>
            <td></td>
        </tr>
    </table>             


</body>
</html>