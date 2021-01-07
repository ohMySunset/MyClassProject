package member.main;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import member.service.MemberInfoService2;
import member.service.MemberInfoService3;
import member.service.MemberRegService2;
import member.service.MemberRegService3;

public class MemberMain3 {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너 생성 (컨테이너는 빈(객체)의 생성과 관계 설정, 사용, 제거 등의 기능을 담당)
//		GenericApplicationContext ctx = 
//				new GenericXmlApplicationContext("classpath:appCtx6.xml");
//		GenericApplicationContext ctx = 
//				new GenericXmlApplicationContext("classpath:appCtx7.xml");
//		GenericApplicationContext ctx = 
//				new GenericXmlApplicationContext("classpath:appCtx8.xml");
		GenericApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx9.xml");   
		//src 아래 클래스 영역에 있는 xml파일
		
		// 2. MemberRegService 객체가 필요
		MemberRegService3 regService = ctx.getBean("memberRegService", MemberRegService3.class);
		                               // getBean("xml에 명시된 빈의 id", 이용할 클래스명.class)
		// 3. MemberRegService -> process() 실행
		regService.process();
		
		// 4. MemberInfoService 객체가 필요
		MemberInfoService3 infoService = ctx.getBean("memberInfoService", MemberInfoService3.class);
		
		// 5. MemberInfoService -> process() 실행
		infoService.process();
		

	}

}
