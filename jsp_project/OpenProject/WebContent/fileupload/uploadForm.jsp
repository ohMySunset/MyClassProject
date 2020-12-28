<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
  <h1>파일 업로드</h1>
  <form action="upload.jsp" method="post" enctype="multipart/form-data">
  <input type="text" name="title"> <br>
  <input type="file" name="file">  <br>
  <input type="submit" value="업로드">  
  </form>
   
</body>
</html>