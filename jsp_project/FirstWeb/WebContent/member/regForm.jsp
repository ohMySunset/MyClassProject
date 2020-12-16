<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
</head>
<body>
    
    <h3> 회원가입</h3>
    <hr>
  <form action="regResult.jsp" action="get">
    <table>
     <tr>
         <td><label for="userId">아이디(이메일)</label></td>
         <td><input type="email" name="userId" id="userId"></td>
        </tr>
        <tr>
            <td><label for="pw">비밀번호</label></td>
            <td><input type="password" name="pw" id="pw"></td>
        </tr>    
        <tr>
            <td><label for=userName>이름</label></td>
            <td><input type="text" name="userName"></td>
        </tr>   
        <tr>
            <td></td>
            <td> <input type="submit" value="등록"></td>
        </tr>
    </table>             
    </form>
    
</body>
</html>