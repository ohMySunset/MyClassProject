package com.aia.open.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegController {
	
	@RequestMapping("regForm")
	public String getRegForm() {
		
		return "member/regForm";
	}

}
