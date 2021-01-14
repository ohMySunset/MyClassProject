package member.service;

import javax.annotation.Resource;

import member.dao.Dao;

public class MemberInfoService3 implements memberService {

	
	@Resource(name="memberDao") // @Resource 애노테이션은 빈의 이름을 이용해서 주입할 객체를 검색
	private Dao dao;

	
	@Override
	public Object process() {
		System.out.println("MemberInfoService 인스턴스 생성");
		dao.select();
		
		return null;
	}

}
