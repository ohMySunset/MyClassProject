<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <nav>
  <ul>
  <li><a href="${pageContext.request.contextPath}">HOME</a></li>
  <li><a href="${pageContext.request.contextPath}/member/regForm.jsp">Join</a></li>
  
  <%
     if(session.getAttribute("loginInfo")==null){   	
  %>
  <li><a href="${pageContext.request.contextPath}/member/loginForm.jsp">Login</a></li>
  <%
     } else{
  %>
  <li><a href="${pageContext.request.contextPath}/member/logout.jsp">Logout</a></li>
  <%
    }
  %>
  <li><a href="${pageContext.request.contextPath}/member/mypage/mypage1.jsp">My page1</a></li>
  <li><a href="${pageContext.request.contextPath}/member/mypage/mypage2.jsp">My page2</a></li>
  </ul>
  </nav>