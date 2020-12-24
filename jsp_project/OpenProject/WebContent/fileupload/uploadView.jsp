<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- 파일 업로드에 성공했을 때 -->
  <c:if test="${result}">
    <h1>파일 업로드가 완료되었습니다!</h1> 
    <h3>
     title : ${title} <br>
          파일 이름   : ${saveFileName}
    </h3>   
  </c:if>
  <!-- 파일 업로드에 실패했을 때 -->
    <c:if test="${!result}">
    <h1>파일 업로드에 실패하였습니다. 다시 시도해주세요</h1> 
  </c:if>
  
</body>
</html>