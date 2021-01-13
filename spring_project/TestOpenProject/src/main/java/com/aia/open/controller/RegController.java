package com.aia.open.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.aia.open.domain.MemberRegRequest;
import com.aia.open.service.MemberRegService;

@Controller
@RequestMapping("/member/reg")
public class RegController {
	
	@Autowired
	private MemberRegService regService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getRegForm() {
		
		return "member/regForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String regMember(@ModelAttribute("regInfo") MemberRegRequest regRequest,
			                 HttpServletRequest request,
			                 Model model) {
		
		int result = regService.MemberReg(regRequest, request);
		model.addAttribute("result", result);
		
		return "member/regComplete";
	}
}
