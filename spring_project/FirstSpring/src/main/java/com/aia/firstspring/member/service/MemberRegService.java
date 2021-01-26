package com.aia.firstspring.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aia.firstspring.member.dao.MemberDao;
import com.aia.firstspring.member.dao.MemberInterfaceDao;
import com.aia.firstspring.member.dao.MyBatisMemberDao;
import com.aia.firstspring.member.domain.Member;
import com.aia.firstspring.util.AES256Util;
import com.aia.firstspring.util.Sha256;

@Service
public class MemberRegService {
	
//	@Autowired
//	private MemberDao dao;
	
//	@Autowired
//	private MyBatisMemberDao dao;
	
	private MemberInterfaceDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private MailSenderService mailSenderService;
	
	@Autowired
	private Sha256 sha256;
	
	@Autowired
	private AES256Util aes256Util;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public int insertMember(Member member) {
		
		int result = 0;
		
		try {
			
		dao = template.getMapper(MemberInterfaceDao.class);
		//result = dao.insertMember(member);
		result = 1;
		
		System.out.println("암호화 : "+sha256.encrypt(member.getPassword()));
		
		//AES256으로 암호화된 문자열
		String epw = aes256Util.encrypt(member.getPassword());
		//AES256으로 	복호화된 문자열
		String ppw = aes256Util.decrypt(epw);
		System.out.println("-----------------");
		System.out.println("AES256으로 암호화된 문자열");
		System.out.println(epw);
		System.out.println("//AES256으로 	복호화된 문자열");
	    System.out.println(ppw);
	    
	    System.out.println("-------------------");
	    System.out.println("spring-security BCryptPasswordEncoder 이용한 암호화 ");
     	String securityPw = bCryptPasswordEncoder.encode(member.getPassword());
     	System.out.println(securityPw);
     	System.out.println("비밀번호 비교 메서드 : matchs");
     	System.out.println(bCryptPasswordEncoder.matches("111", securityPw));
     	System.out.println(bCryptPasswordEncoder.matches(member.getPassword(), securityPw));
		
	    String html = "<h1>아래 링크를 통해 인증해주세요." 
	    + "<a href=\"http://localhost:8080/firstspring\">인증하기</a></h1>";	
	
		//메일전송
//		mailSenderService.mailSend(member.getMemberid(),
//				                   member.getMembername(),
//				                   "[안내] 회원가입을 위한 계정 인증 안내",
//				                   html);
//		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}

}
