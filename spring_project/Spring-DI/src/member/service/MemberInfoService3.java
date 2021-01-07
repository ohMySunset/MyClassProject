package member.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;

public class MemberInfoService3 implements MemberService {
	
	/*
	 * 1.name 속성에 지정한 빈 객체를 찾는다. 존재하면 해당 객체를 주입할 객체로 사용한다 
	 * 2.name 속성이 없을 경우, 동일한 타입을 갖는 빈 객체를 찾는다. 
	 * 존재하면 해당 객체를 주입할 객체로 사용한다.
	 * 3.name 속성이 없고, 동일한 타입을 갖는 빈 객체가 두 개 이상일 경우, 같은 이름을 가진 빈 객체를 찾는다. 
	 * 존재하면 해당 객체를 주입할 객체로 사용한다. 
	 * 4.name 속성이 없고, 동일한 타입을 갖는 빈 객체가 두 개 이상이고 같은 이름을 가진 빈 객체가 없을 경우,
	 *  @Qualifer를 이용해서 주입할 빈 객체를 찾는다.
	 */
	
	@Resource(name="memberDao")  // @Resource 애노테이션은 빈의 이름을 이용해서 주입할 객체를 검색
	private Dao dao;  // 자동 주입 대상에 어노테이션 사용

	@Override
	public Object process() {
		System.out.println("MemberInfoService 인스턴스 실행");
		dao.select();
		
		return null;
	}

}
