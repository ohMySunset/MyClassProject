<%@page import="member.service.MemberRegService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
   // memberReg3.jsp의 역할 (= Controller.jsp)
   // 사용자 요청에 맞는 서비스 클래스 선택 -> 메서드 실행
   // view 페이지를 선택 -> 포워드

   // MemberRegService
   // insertMember(HttpServletRequest request) -> int 1 또는 0 반환
	 
   MemberRegService service = MemberRegService.getInstance();  
   service.insertMember(request);
   
%>
<jsp:forward page="memberRegView.jsp"/>

<!-- 
  form 에서 memberReg3.jsp로 요청이 들어올때 request 객체가 생성
 => memberRegView.jsp로 포워딩된 객체가 실행완료되기 전까지는 request 객체가 존재함.
 (고로 메서드를 호출해 service 클래스에 갔다오더라도 request 객체는 그대로 유지가 됨)
-->