<%@page import="loginform.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

 List<Member> members = new ArrayList<Member>();
 members.add(new Member("cool1","1111","COOL1","photo1.jpg"));
 members.add(new Member("cool2","2222","COOL2","photo2.jpg"));
 members.add(new Member("cool3","3333","COOL3",null));
 members.add(new Member("cool4","4444","COOL4","photo4.jpg"));
 members.add(new Member("cool5","5555","COOL5","photo5.jpg"));
 members.add(new Member("cool6","6666","COOL6","photo6.jpg"));
 members.add(new Member("cool7","7777","COOL7","photo7.jpg"));
 members.add(new Member("cool8","8888","COOL8",null));
 members.add(new Member("cool9","9999","COOL9",null)); 
 members.add(new Member("cool10","0000","COOL10","photo10.jpg"));
 
 session.setAttribute("members", members);

 
%>