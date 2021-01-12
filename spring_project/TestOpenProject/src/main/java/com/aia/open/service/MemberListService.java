package com.aia.open.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.open.dao.InterfaceDao;
import com.aia.open.domain.Member;

@Service
public class MemberListService {
	
	private InterfaceDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public List<Member> getMemberList(){
		
		dao = template.getMapper(InterfaceDao.class);
		
		return dao.selectMemberList();
	}
	
	public int totalMemberCnt() {
		
		dao = template.getMapper(InterfaceDao.class);
		
		return dao.totalMemberCnt();
	}

}
