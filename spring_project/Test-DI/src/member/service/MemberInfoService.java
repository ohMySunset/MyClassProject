package member.service;

import member.dao.Dao;

public class MemberInfoService implements memberService {

	private Dao dao;
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	@Override
	public Object process() {
		System.out.println("MemberInfoService 인스턴스 생성");
		dao.select();
		
		return null;
	}

}
