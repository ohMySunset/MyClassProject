package com.aia.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.op.member.domain.MemberEditRequest;
import com.aia.op.member.service.MemberEditService;

@Controller
@RequestMapping("/member/edit")
public class MemberEditController {
	
	@Autowired
	private MemberEditService editService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String editForm(
			@RequestParam("idx") int idx,
			Model model) {
		// Service -> MemberDao -> Mapper에 정의 -> Member객체 반환 -> view에 반환		
				
		model.addAttribute("member", editService.getMember(idx));
		
		return "member/editForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String editMember(
			MemberEditRequest editRequest,
			HttpServletRequest request,
			Model model
			) {
		
		// Service -> MemberDao : update -> mapper -> int
		model.addAttribute("result", editService.editMember(editRequest, request));
		
		System.out.println(editRequest);
		return "member/edit";
	}
	

}
