package com.aia.open.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping("/member/logout")
	public String getLogoutForm(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		return "member/logoutForm";
	}

}
