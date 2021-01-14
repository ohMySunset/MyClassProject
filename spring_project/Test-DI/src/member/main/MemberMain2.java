package member.main;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.Dao;
import member.dao.MemberDao;
import member.service.MemberInfoService;
import member.service.MemberInfoService2;
import member.service.MemberRegService;
import member.service.MemberRegService2;

public class MemberMain2 {

	public static void main(String[] args) {
	
		GenericApplicationContext context = 
				new GenericXmlApplicationContext("classpath:appCtx3.xml");
		
		Dao dao1 = context.getBean("memberDao",MemberDao.class);
		Dao dao2 = context.getBean("memberDao",MemberDao.class);
		
		System.out.println("dao1==dao2 =>" + (dao1==dao2));
		
		MemberRegService regService1 = context.getBean("memberRegService",MemberRegService.class);
		MemberRegService regService2 = context.getBean("memberRegService",MemberRegService.class);
		
		regService1.process();
		regService2.process();
		
		System.out.println("regService1==regService2 =>"+(regService1==regService2));
		
		MemberInfoService infoService1 = context.getBean("memberInfoService", MemberInfoService.class);
		MemberInfoService infoService2 = context.getBean("memberInfoService", MemberInfoService.class);
		
		infoService1.process();
		infoService2.process();
		
		System.out.println("infoService1==infoService2 =>" + (infoService1==infoService2));
		
	}

}
