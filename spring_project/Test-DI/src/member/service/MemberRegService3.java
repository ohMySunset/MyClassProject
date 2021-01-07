package member.service;

import javax.annotation.Resource;

import member.dao.Dao;

public class MemberRegService3 implements memberService {

	
	@Resource(name="guestDao")
    private Dao dao;
	
	@Override
	public Object process() {
		System.out.println("MemberRegService 인스턴스 생성");
		dao.insert();
		
		return null;
	}

}
