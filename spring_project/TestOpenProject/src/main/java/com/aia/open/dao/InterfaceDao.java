package com.aia.open.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aia.open.domain.Member;

public interface InterfaceDao {
	
	int insertMember(Member member);
	List<Member> selectMemberList();
	int totalMemberCnt();
	Member selectLoginMember(@Param("memberid") String uid, @Param("password") String pw);

}
