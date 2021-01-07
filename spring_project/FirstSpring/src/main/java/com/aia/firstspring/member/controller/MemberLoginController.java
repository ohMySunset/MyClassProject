package com.aia.firstspring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aia.firstspring.member.domain.LoginRequest;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {

	//@RequestMapping(value="/member/login", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLoginForm() {
		
		return new ModelAndView("member/loginForm");
	}
	
	//@RequestMapping(value="/member/login", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("uid")String uid, // = request.getParameter() 
			                  @RequestParam("pw")String pw,
			                  HttpServletRequest request,
			                  LoginRequest loginRequest) {
		  
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/login");
		
		// 사용자의 파라미터 값을 받는 방법
		// 1. HttpServletRequest 객체를 이용
		String userId = request.getParameter("uid");
		String userPw = request.getParameter("pw");
		
		mav.addObject("userId", userId);
		mav.addObject("userPw", userPw);
		
		// 2. @RequestParam(form의 네임속성) 어노테이션 이용
		mav.addObject("uid", uid);
		mav.addObject("pw", pw);
		
		// 3. 커맨드 객체(Beans)를 이용한다 
		System.out.println(loginRequest);
		//mav.addObject("loginRequest", loginRequest);
		//커맨드형식의 LoginRequest는 자동으로 request 객체에 속성으로 저장되므로 따로 저장하지 않아도 공유가 가능
	
		return mav;
	}
}
