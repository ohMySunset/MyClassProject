package com.aia.open.main;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.aia.open.service.MemberLoginService;

public class MemberMain {

	public static void main(String[] args) {
		

		GenericApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		MemberLoginService service = ctx.getBean("memberLogin",MemberLoginService.class);


	}

}
