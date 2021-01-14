<%@page import="guestbook.exception.InvalidMessagePasswordException"%>
<%@page import="guestbook.exception.MessageNotFoundException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="guestbook.service.DeleteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  // 사용자가 입력한 메세지 아이디, 비밀번호를 받고 
  // ->서비스 클래스 인스턴스 생성 -> 삭제 메서드 실행 -> 결과출력
  String messageId = request.getParameter("mid");
  String pw = request.getParameter("pw");
  
  DeleteMessageService service = DeleteMessageService.getInstance();
  
  String msg = "정상적으로 삭제되었습니다."; //에외 default
  
  // 예외처리
  try{ // 위에서 메서드 호출 시 Service에서 throw된 예외가 등장하게됨.
  int result = service.deleteMessage(Integer.parseInt(messageId), pw);
  } catch(SQLException e){
	  msg = "삭제하는 도중 문제가 발생하였습니다. 다시 시도해주세요";		  
  } catch (MessageNotFoundException e) {
	  msg = "게시물이 존재하지 않습니다.";
  } catch (InvalidMessagePasswordException e) {
	  msg = e.getMessage();
  }
  request.setAttribute("resultMsg", msg);
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>${resultMsg}</h3>
   <a href="list.jsp">게시물 리스트 보기</a>
</body>
</html>