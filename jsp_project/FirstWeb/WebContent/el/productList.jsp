<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- useBean : 컨테이너가 beans를 자동으로 생성해줌! -->
<!-- id가 클래스의 참조변수 처럼 쓰임 -->
<jsp:useBean id="product" class="test.Product" scope="session"/>

<%--  ${sessionScope.product}  --%>

<form action="selectProduct.jsp" method="post">
  
   <select name="sel"> 
     <%  
      for (String item : product.getProductList()){
	     out.println("<option>"+item+"</option>");
     }	
     %>
   </select>
   
   <input type="submit" value="선택">

</form>

</body>
</html>