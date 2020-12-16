<%@page import="loginform.LogForm"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   // 객체에 저장된 속성 받아오기
   LogForm data = (LogForm) request.getAttribute("data");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View에서 데이터 출력</title>
</head>
<body>
       <%= data %>
       <h3>회원이 입력한 데이터 출력</h3>
       <hr>
    <table>
        <tr>
        <td>아이디(이메일)</td> 
        <td><%= data.getUserId()%></td> 
        </tr>
        <tr>
        <td>비밀번호</td>
        <td><%= data.getPassword() %></td>
        </tr>
        <tr>
        <td></td>
        <td></td> 
        </tr>
        
       </table>   
           
       <hr>      
    
</body>
</html>