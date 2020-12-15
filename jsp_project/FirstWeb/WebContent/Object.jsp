<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!--내장객체를 이용한 속성관리 -->
 <%
 request.setAttribute("userName", "손흥민");  /* 사용자의 입력정보를 읽으려고 사용, HTML폼을 통해 입력된 값을 JSP에서 가져올때*/
 application.setAttribute("userId", "1111");
 session.setAttribute("nickName", "SON"); /* 사용자가 접속중임을 인증, 특정시간 동안 활동이 없으면 자동 소멸 */
 pageContext.setAttribute("age", 27);
 %>   
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= request.getAttribute("userName") %>,
<%= application.getAttribute("userId") %>,
<%= session.getAttribute("nickName") %>,
<%= pageContext.getAttribute("age") %>


</body>
</html>