package com.aia.op.member.dao;

import java.util.List;
import java.util.Map;

import com.aia.op.member.domain.Member;

public interface MemberDao {
	
	// public abstract
	// 회원 등록을 위한 메서드
	int insertMember(Member member);
	// 회원 로그인을 위한 메서드
	Member selectLogin(String id, String pw);
	// 회원의 총 수를 구할 메서드
	int selectTotalCount();
	// 회원 정보를 구하는 메서드 (페이지 번호에 맞는)
	//List<Member> selectMemberList(int startRow, int cntPerPage);
	List<Member> selectMemberList(Map<String, Object> param);
	// 검색한 회원의 수를 구하는 메서드
	int selectSearchMemberCount(Map<String, Object> listMap);
    // 회원 정보 삭제
	int deleteMemberByIdx(int idx);
	// 수정할 회원 정보를 구하는 메서드
	Member selectMemberByIdx(int idx);
	// 수정한 회원정보를 업데이트 하는 메서드
	int updateMember(Member member);
}
