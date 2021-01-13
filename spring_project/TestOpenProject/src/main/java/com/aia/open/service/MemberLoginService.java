package com.aia.open.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aia.open.dao.InterfaceDao;
import com.aia.open.domain.LoginInfo;
import com.aia.open.domain.Member;

@Service
public class MemberLoginService {

	private InterfaceDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public boolean loginService(HttpServletRequest request,
			                   HttpServletResponse response,
			                   LoginInfo lf) {
	
		boolean loginChk = false; // 로그인 되지 않은 상태

		dao = template.getMapper(InterfaceDao.class);
		
		Member member = dao.selectLoginMember(lf.getMemberid(), lf.getPassword());
	
		if (member != null) {
            // 세션에 저장
			request.getSession().setAttribute("loginMember", member.toLoginMember());
			loginChk = true; // 로그인 성공
			System.out.println(member);
			// 쿠키생성
		   if(lf.getChk()!=null && lf.getChk().equals("on")) {
			   Cookie cookie = new Cookie("uid", lf.getMemberid());
			   cookie.setMaxAge(60*60*24*365);
			   response.addCookie(cookie);
		   } else {
			   Cookie cookie = new Cookie("uid", lf.getMemberid());
			   cookie.setMaxAge(0);
			   response.addCookie(cookie);
		   }
		}

		return loginChk;
	}

}
