package com.aia.open.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.aia.open.domain.LoginInfo;
import com.aia.open.service.MemberLoginService;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	public String getLoginForm() {
		
		return "member/loginForm";
	}
	
	
//	 @Autowired(required = false)
//	 private MemberLoginService service;
	
	@RequestMapping("loginComplete")
	public String login(HttpServletRequest request,
			            HttpServletResponse response,
			            @ModelAttribute("loginInfo") LoginInfo loginInfo) {
		
		if(loginInfo.getChk() != null && loginInfo.getChk().equals("on") &&
				  loginInfo.getUserId() != null && !loginInfo.getUserId().isEmpty()) {
			 System.out.println("쿠키 저장 완료!");
			  response.addCookie(new Cookie("uid", loginInfo.getUserId()));
		}	
		  
			HttpSession session = request.getSession();		
			session.setAttribute("login", loginInfo);
	
	   // service.loginService(request, response, loginInfo);
		
		return "member/loginComplete";
	}
	
	
	

}
