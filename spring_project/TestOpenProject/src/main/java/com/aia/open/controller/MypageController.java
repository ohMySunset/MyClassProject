package com.aia.open.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.open.domain.LoginInfo;

@Controller
public class MypageController {
	
	@RequestMapping("/member/mypage/mypage1")
	public String getMypage1() {
		return "/member/mypage/mypage1";
	}
	
	@RequestMapping("/member/mypage/mypage2")
	public String getMypage2() {
		return "/member/mypage/mypage2";
	}


}
