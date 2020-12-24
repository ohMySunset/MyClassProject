<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>

    <h1>파일 업로드</h1>
    
    <!-- ※필수 1 : formtag 안의 속성 =>  method = "post", 
                                   enctype = "multipart/form-data" -->
   
    <form action="upload.jsp" method="post" enctype="multipart/form-data">
    <input type="text" name="title"> <br>
    
    <input type="file" name="file"> <br>
     <!--※필수 2 : 업로드할 파일을 선택할 수 있는  input -->
    <input type="submit">
    </form>
    
</body>
</html>