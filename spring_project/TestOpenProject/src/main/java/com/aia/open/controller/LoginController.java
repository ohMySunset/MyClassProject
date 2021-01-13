package com.aia.open.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.open.domain.LoginInfo;
import com.aia.open.service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	@Autowired
	private MemberLoginService login;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm() {			
		return "member/loginForm";
	}
		
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			            HttpServletResponse response,
                        @ModelAttribute("loginInfo") LoginInfo loginInfo,
			            Model model) {
		System.out.println("요청 들어옴");
	   
	   model.addAttribute("loginCheck", login.loginService(request, response, loginInfo));
		
		return "member/loginComplete";
	}
	

}
