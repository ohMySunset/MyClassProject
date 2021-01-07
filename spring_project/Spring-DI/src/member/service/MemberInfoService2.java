package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;

public class MemberInfoService2 implements MemberService {
	
	/*
	 * 1.타입이 같은 빈 객체를 검색한다. 한 개면 그 객체를 사용한다.
	 *  @Qualifier가 명시되어 있을 경우, @Qualifier와 같은 값을 갖는 빈 객체이어야 한다. 
	 * 2.타입이 같은 빈 객체가 두 개 이상 존재하면, @Qualifer로 지정한 빈 객체를 찾는다.
	 *  존재하면 그 객체를 사용한다.
	 * 3.타입 같은 빈 객체가 두 개 이상 존재하고, @Qualifier가 없을 경우, 이름이 같은 빈 객체를 찾는다.
	 *  존재하면,그 객체를 사용한다.
	 */
	
	@Autowired(required = false)
	@Qualifier("member")
	private Dao dao;  // 자동 주입 대상에 어노테이션 사용

	@Override
	public Object process() {
		System.out.println("MemberInfoService 인스턴스 실행");
		dao.select();
		
		return null;
	}

}
