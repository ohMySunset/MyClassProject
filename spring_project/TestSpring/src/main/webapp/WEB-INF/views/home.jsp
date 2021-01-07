<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Index Page</title>
</head>
<body>
<h1>
	  Index
</h1>


  <c:url value="/order/order" var="order"/>
  <h3><a href="${order}">Order Page</a></h3>

</body>
</html>
