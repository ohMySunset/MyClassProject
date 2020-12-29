<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  div.msgBox{
    padding : 5px;
    width : 400px;
    border : 1px solid #AAA;
    margin : 5px 0;
  }
  
  div.paging{
    padding : 10px;
    width : 390px;
    
    text-align: center;
    
    margin-top : 10px;
    margin-bottom : 50px;
    
    overflow: hidden;
  }
  
  div.numberBox{
     border : 1px solid #AAA;
     width : 30px;
     height : 30px;
     
     float : left;
     
     margin : 0 5px;
  }
  
  div.numberBox>a{
    display : block;
    height : 30px;
    line-height: 30px;
    text-decoration: none;
  }
  
  
</style>
</head>
<body>
	<h3>방명록 작성</h3>
	<form action="writeMessage.jsp" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="memberId"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>메시지</td>
				<td><textarea name="message" rows="5" cols="30"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="글쓰기"><input
					type="reset" value="초기화"></td>
			</tr>
		</table>			
	</form>
	
	 <hr>

	 <div class="msgBox">
	 <table border="1">
	 <tr>
	 <th>게시물 No.</th>
	 <th colspan="3">10</th>
	 </tr>
	 <tr>
	 <td rowspan="3">
	 이미지<img height="50" src="<c:url value="/upload/member/${member.userPhoto}"/>">
	 <br>
	 작성자 : 땡땡땡
	 </td>
	 <td rowspan ="3" colspan="3">여기는 메시지 자리당</td>
	 </tr>
	 <tr>
	 </tr>
	 <tr>
	 </tr>
	 <tr>
	 <td colspan="4">작성일자 : 20202020</td>
	 </tr>
	  <tr>
	 <td colspan="4"><a href="#">삭제하기</a></td>
	 </tr>
	 </table>
	 </div>

</body>
</html>