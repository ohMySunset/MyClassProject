package com.aia.op.member.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.op.member.domain.Member;
import com.aia.op.member.domain.MemberRegRequest;
import com.aia.op.member.service.MemberEditService;
import com.aia.op.member.service.MemberListService;
import com.aia.op.member.service.MemberRegService;

@RestController
@RequestMapping("/rest/ver1/members")
public class MemberRestController {
	
	@Autowired
	private MemberListService listService;
	@Autowired
	private MemberEditService editService;
	@Autowired
	private MemberRegService regService;
	
	// List
	@GetMapping
	@CrossOrigin
    public List<Member> getMemberList(){
    	
    	return listService.getListView();       	
    }
    
	// 1개의 회원 정보 Member
	@GetMapping("/{idx}")
	@CrossOrigin
	public Member getMember(@PathVariable("idx") int idx) {
		
		return editService.getMember(idx);
	}
	
	// 회원 정보의 저장
	@PostMapping
	public String insertMember(
			@RequestBody MemberRegRequest regRequest,
			HttpServletRequest request) {
		
		return regService.memberReg(regRequest, request)==0?"N":"Y";
	}
	
	// 회원 정보 수정
	
	// 회원 정보 삭제
	
	// 회원 존재 유무 확인
	
	
	
	

}
