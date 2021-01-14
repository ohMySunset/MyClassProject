package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;

public class MemberRegService2 implements memberService {
	
	
	@Autowired(required = false)
	@Qualifier("guest")
    private Dao dao;
   
	
	@Override
	public Object process() {
		System.out.println("MemberRegService 인스턴스 생성");
		dao.insert();
		
		return null;
	
	}
}
