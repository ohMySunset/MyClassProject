<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 정보 페이지</title>
</head>
<body>

<h1>주문정보</h1>
  
 <h3>상품 주문 정보</h3>
 <c:forEach items="${userOrder.orderItems}" var="orderItem" >
   <div>
     상품 ID : ${orderItem.id}<br>
     개수 :  ${orderItem.number}개  <br>
     주의 사항 :  ${orderItem.remark} <hr>   
   </div>
  </c:forEach>
    <h3>배송지</h3>
    <div>
    우편번호 : ${userOrder.address.zipcode}<br>
    배송지 1 : ${userOrder.address.address1}<br>
    배송지 2 : ${userOrder.address.address2}
    </div>



</body>
</html>