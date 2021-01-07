<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>Index</h1>

  <c:url value="/hello" var="hello"/>
  <ul>
  <li><a href="hello">/hello</a></li>
  <li><a href="${hello}">${hello}</a></li>


  <c:url value="/member/login" var="login"/>
  <li><a href="${login}">${login}</a></li>


  <c:url value="/member/search" var="search"/>
  <li><a href="${search}">${search}</a></li>
  
  <c:url value="/order/order" var="order"/>
  <li><a href="${order}">${order}</a></li>

  </ul>
</body>
</html>
