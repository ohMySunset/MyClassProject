package com.aia.firstspring.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aia.firstspring.member.domain.Member;

@Repository
public class MyBatisMemberDao {
	
	private String nameSpace ="com.aia.firstspring.mybatis.mapper.member_mapper";

	@Autowired
	private SqlSessionTemplate template;
	
	public List<Member> selectMemberList(){
	 //com.aia.firstspring.mybatis.mapper.member_mapper.selectAll
		return template.selectList(nameSpace+".selectAll");
	}
	
	public int insertMember(Member member) {
	// com.aia.firstspring.mybatis.mapper.member_mapper.insertMember
		return template.update(nameSpace+".insertMember", member);
	}
	

}
