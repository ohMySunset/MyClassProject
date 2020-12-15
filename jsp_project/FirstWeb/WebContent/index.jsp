<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First JSP</title>
</head>
<body>

    <h1>INDEX</h1>
    <Ul>
                 <!--┌>서버 루트 기준으로 context를 불러옴 -->
    <li><a href="/FirstWeb/test/now.jsp">/FirstWeb/test/now.jsp(절대경로)</a></li>                     
    <li><a href="test/now.jsp">test/now.jsp(상대경로)</a></li>
    <li><a href="test/msword.jsp">test/msword.jsp(상대경로)</a></li>
    </Ul>
</body>
</html>