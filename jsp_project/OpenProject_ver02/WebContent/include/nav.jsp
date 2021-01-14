<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

  <nav>
  <ul>
  <li >
  <a href="${pageContext.request.contextPath}">
  <button type="button" class="btn">HOME</button></a>
  </li>
  <li>
  <a href="${pageContext.request.contextPath}/member/regForm.jsp" >
  <button type="button" class="btn">Join</button></a>
  </li>
  
  <%
     if(session.getAttribute("loginInfo")==null){   	
  %>
  <li>
  <a href="${pageContext.request.contextPath}/member/loginForm.jsp">
  <button type="button" class="btn">Login</button></a>
  </li>
  <%
     } else{
  %>
  <li>
  <a href="${pageContext.request.contextPath}/member/logout.jsp">
  <button type="button" class="btn">Logout</button></a>
  </li>
  <%
    }
  %>
  <li>
  <a href="${pageContext.request.contextPath}/member/mypage/mypage1.jsp">
  <button type="button" class="btn">My page1</button></a>
  </li>
  <li>
  <a href="${pageContext.request.contextPath}/member/mypage/mypage2.jsp">
  <button type="button" class="btn">My page2</button></a>
  </li>
  </ul>
  </nav>