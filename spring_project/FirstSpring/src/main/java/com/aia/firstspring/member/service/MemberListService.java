package com.aia.firstspring.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.firstspring.member.dao.MemberDao;
import com.aia.firstspring.member.dao.MemberInterfaceDao;
import com.aia.firstspring.member.dao.MyBatisMemberDao;
import com.aia.firstspring.member.domain.Member;

@Service
public class MemberListService {
//	@Autowired
//	MemberDao dao;
	
//	@Autowired   --> 여기서 주입 받지 않고 밑에서 인터페이스를 getMapper로 구현
//	private MyBatisMemberDao dao;
	
	private MemberInterfaceDao dao;
	
	@Autowired
	private SqlSessionTemplate template; /*--> Mapper 객체로 만들어줌*/
	
	
//	public MemberListService(MemberDao dao) {
//		this.dao = dao;
//	}

	public List<Member> getMemberList(){
		
		dao = template.getMapper(MemberInterfaceDao.class);
		
	   return dao.selectMemberList();			
	}
	
	public int getMemberTotalCount() {
		
		dao = template.getMapper(MemberInterfaceDao.class);
		
		return dao.totalCnt();
	}

}
