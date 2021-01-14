package com.aia.open.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginCheckController {

	
	@RequestMapping("/member/loginChk")
	public String loginChk() {
		
		return "include/loginCheck";
	}
	
}
