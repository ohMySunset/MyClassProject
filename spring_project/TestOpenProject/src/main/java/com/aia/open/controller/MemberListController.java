package com.aia.open.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.open.service.MemberListService;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberListService listService;
	
	@RequestMapping("/member/list")
	public String getMemberList(Model model) {
		
		model.addAttribute("memberList", listService.getMemberList());
		model.addAttribute("memberCnt", listService.totalMemberCnt());
		return "member/list";
	}
	

}
