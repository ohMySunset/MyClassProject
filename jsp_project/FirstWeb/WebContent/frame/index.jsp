<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Frame Include</title>

<style>
  div.header{
    text-align: center;
  }
  
  div.navi{
    text-align: center;
  }
  
  div.news, div.shopping{
     width : 45%;
  }
  
  div.news{
     float : left;    
  }
  
  div.shopping{
     float : right;
  }
  
  div.footer{
     clear : both;
     text-align: center;
  }
</style>

</head>
<body>

<%@ include file="header.jsp" %>
    
<%@ include file="navi.jsp" %>	


	<div class="contents">
	<%@ include file="news.jsp" %>
	<%@ include file="shopping.jsp" %>
	</div>
	
	<!--* include 액션 : 제시어 include는 코드를 받아오지만 액션 include는 결과를 받아옴-->
<%-- 	<jsp:include page="footer.jsp">
	<jsp:param value="cool@gmail.com" name="email"/>
	<jsp:param value="010-1111-2222" name="tel"/>
	</jsp:include>
	 --%>
	 
	 
    <!--* forward 액션
	index.jsp 처리 결과 => footer.jsp의 실행결과로 응답처리
        사용자의 요청을 분석해서 분기하여 맞는 답만을 보여줄 수 있다 => MVC패턴에서 쓰임
    -->
	<jsp:forward page="footer.jsp">
	<jsp:param value="cool@gmail.com" name="email"/>
	<jsp:param value="010-1111-2222" name="tel"/>
	</jsp:forward>
	
	
	
<%-- <%@ include file="footer.jsp" %> --%>

</body>
</html>