package com.aia.open.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aia.open.domain.LoginInfo;

public class MemberLoginService{
	
	public void loginService(HttpServletRequest request, HttpServletResponse response, LoginInfo loginInfo) {
		 
		if(loginInfo.getChk() != null && loginInfo.getChk().equals("on") &&
				  loginInfo.getUserId() != null && !loginInfo.getUserId().isEmpty()) {
			 System.out.println("쿠키 저장 완료!");
			  response.addCookie(new Cookie("uid", loginInfo.getUserId()));
		}	
		  
			HttpSession session = request.getSession();		
			session.setAttribute("login", loginInfo);
	}

}
