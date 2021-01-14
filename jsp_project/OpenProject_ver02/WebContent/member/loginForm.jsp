<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
CookieBox cookiebox = new CookieBox(request);

// 삼항 연산자를 사용하여 쿠키값에 uid값이 있는지 여부 확인
//String saveId = cookiebox.exist("uid")?cookiebox.getValue("uid"):"";
//String checked = cookiebox.exist("uid")? "checked" : "";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
<style>

</style>
</head>
<body>
   
   <%@ include file="/include/header.jsp" %>
   
   <%@ include file="/include/nav.jsp" %>
    
  <div class="contents">
  <h2 class="contents_title">Sign In</h2>
  <div class="content">
   	<form action="login.jsp" method="post">
				<table class="tbody">
					<tr>
						<th><label for="userid">아이디</label></th>
						<td>
							<!-- 저장된 쿠키값을 value로 --> <input type="text" id="userid"
							name="userid" value="${cookiebox.uid.value}">
						</td>
					</tr>
					<tr>
						<th><label for="pw">비밀번호</label></th>
						<td><input type="password" id="pw" name="pw"></td>
					</tr>
					<tr>
						<th></th>
						<td>
							<!-- 쿠키값에 저장이 되어 있으면 checked 속성 적용 --> <input type="checkbox"
							name="chk" value="on" ${cookie.uid ne null?'checked':''}> 아이디 저장
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="로그인"></td>
					</tr>
				</table>
			</form>
  </div>
  </div>
 
 <%@ include file="/include/footer.jsp" %>


</body>
</html>