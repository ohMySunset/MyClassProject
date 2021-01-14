<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>파일 업로드 : Report 제출</h1>
	<hr>
	<h3>@RequestParam 이용한 파일 업로드</h3>
	<form action="upload1"
	      method="POST"
	      enctype="multipart/form-data"><!-- /fs/upload/uploadForm -> /fs/uplaod/upload -->
	  학번 : <input type="text" name="sn"><br>
	 리포트 파일 : <input type="file" name="report"> <br>
	 <input type="submit"> 
	</form>
	
	<hr>
	<h3>MultipartHttpServletReqeust 이용한 파일 업로드</h3>
	<form action="upload2"
	      method="POST"
	      enctype="multipart/form-data"><!-- /fs/upload/uploadForm -> /fs/uplaod/upload -->
	  학번 : <input type="text" name="sn"><br>
	 리포트 파일 : <input type="file" name="report"> <br>
	 <input type="submit"> 
	</form>
	
	<hr>
	<h3>Command 객체를 이용한 파일 업로드</h3>
	<form action="upload2"
	      method="POST"
	      enctype="multipart/form-data"><!-- /fs/upload/uploadForm -> /fs/uplaod/upload -->
	  학번 : <input type="text" name="sn"><br>
	 리포트 파일 : <input type="file" name="report"> <br>
	 <input type="submit"> 
	</form>
</body>
</html>