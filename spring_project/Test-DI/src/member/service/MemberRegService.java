package member.service;

import member.dao.Dao;

public class MemberRegService implements memberService {

    private Dao dao;
	
	// 생성자를 통한 의존객체 주입
	public MemberRegService(Dao dao){
		this.dao = dao;
	}
		
	@Override
	public Object process() {
		System.out.println("MemberRegService 인스턴스 생성");
		dao.insert();
		
		return null;
	}

}
