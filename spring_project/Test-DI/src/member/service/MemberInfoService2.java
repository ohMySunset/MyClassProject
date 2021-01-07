package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;

public class MemberInfoService2 implements memberService {

	
	@Autowired(required = false)
	@Qualifier("member")
	private Dao dao;
 
	@Override
	public Object process() {
		System.out.println("MemberInfoService 인스턴스 생성");
		dao.select();
		
		return null;
	}

}
