package member.main;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.Dao;
import member.service.MemberInfoService;
import member.service.MemberRegService;

public class MemberMain2 {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너 생성 (컨테이너는 빈(객체)의 생성과 관계 설정, 사용, 제거 등의 기능을 담당)
		GenericApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx5.xml");
		                                        //src 아래 클래스 영역에 있는 xml파일
		Dao dao1 = ctx.getBean("memberDao", Dao.class);
		Dao dao2 = ctx.getBean("memberDao", Dao.class);
		
		System.out.println("dao1==dao2 = >"+ (dao1==dao2)); // true
		// 2. MemberRegService 객체가 필요
		MemberRegService regService1 = ctx.getBean("memberRegService", MemberRegService.class);
		                               // getBean("xml에 명시된 빈의 id", 이용할 클래스명.class)
		MemberRegService regService2 = ctx.getBean("memberRegService", MemberRegService.class);
		
		System.out.println("regService1==regService2 => "+(regService1==regService2)); //flase
		// 4. MemberInfoService 객체가 필요
		MemberInfoService infoService1 = ctx.getBean("memberInfoService", MemberInfoService.class);
		MemberInfoService infoService2 = ctx.getBean("memberInfoService", MemberInfoService.class);
		
        System.out.println("infoService1==infoService2 =>"+(infoService1==infoService2)); //true

	}

}
