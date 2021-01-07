<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<h1>1. @RequestParam </h1>
<h3> id : ${uid}, pw : ${pw}</h3>

<h1>2. HttpServletRequest request </h1>
<h3> id : ${userId}, pw : ${userPw}</h3>

<h1>3. 커맨드 객체(자바 빈)로 전달 </h1>
<h3> id : ${loginRequest.uid}, pw : ${loginRequest.pw}</h3>

</body>
</html>