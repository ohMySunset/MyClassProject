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

	public Member loginService(HttpServletRequest request, HttpServletResponse response, LoginInfo lf) {
		// 쿠키 저장
		if (lf.getChk() != null && lf.getChk().equals("on") && lf.getMemberid() != null
				&& !lf.getMemberid().isEmpty()) {
			System.out.println("쿠키 저장 완료!");
			response.addCookie(new Cookie("uid", lf.getMemberid()));
		}

		boolean loginChk = false; // 로그인 되지 않은 상태

		dao = template.getMapper(InterfaceDao.class);

		Member member = dao.selectLoginMember(lf.getMemberid(), lf.getPassword());
		System.out.println(member);

		if (member != null) {

			HttpSession session = request.getSession();			
			session.setAttribute("loginInfo", member);
            System.out.println(session);
			System.out.println(lf);

			loginChk = true;
		}

		request.setAttribute("loginChk", loginChk);

		return member;
	}

}
