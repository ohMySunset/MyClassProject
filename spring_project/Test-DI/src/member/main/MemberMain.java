package member.main;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.service.MemberInfoService;
import member.service.MemberInfoService2;
import member.service.MemberRegService;
import member.service.MemberRegService2;

public class MemberMain {

	public static void main(String[] args) {
	
		GenericApplicationContext context = 
				new GenericXmlApplicationContext("classpath:appCtx7.xml");
		
		MemberRegService2 regService= context.getBean("memberRegService",MemberRegService2.class);	
		
		regService.process();
		
		MemberInfoService2 infoService = context.getBean("memberInfoService", MemberInfoService2.class);
	
		infoService.process();

		
	}

}
