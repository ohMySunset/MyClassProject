package com.aia.firstspring.member.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	// 메소드는 FrontController 쪽으로 ViewName을 반환한다.
	// 반환 타입을 ModelAndView로 설정
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("member/hello"); //  /WEB-INF/view/member/hello.jsp -> member/hello (반환할 부분)
 		mav.addObject("greeting", greeting());
		return mav;
	}

	private String greeting() {
	   String result = "안녕하세요.";
	   
	   int nowTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	   
	   if(nowTime>=6 && nowTime<=10) {
		   return "좋은 아침 입니다.";
	   } else if(nowTime>= 12 && nowTime<=15) {
		   return "점심 식사는 하셨나요?";
	   } else if(nowTime>=18 && nowTime<=22) {
		   return "좋은 밤 되세요.";
	   }
	   
		return result;
	}

}
