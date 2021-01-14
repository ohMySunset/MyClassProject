package com.aia.open.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.open.dao.InterfaceDao;
import com.aia.open.domain.Member;
import com.aia.open.domain.MemberRegRequest;

@Service
public class MemberRegService {
	
	private InterfaceDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public int MemberReg(MemberRegRequest regRequest,
			             HttpServletRequest request) {
		
		// 파일의 웹 경로
		String uploadPath = "/fileupload/member";
		
		// 파일의 시스템 저장 경로
		String saveDirPath = request.getSession().getServletContext().getRealPath(uploadPath);
		
		// 새롭게 저장할 파일 이름
		String newFileName = regRequest.getUserid()+System.currentTimeMillis();
		
		File file = new File(saveDirPath, newFileName);
		
		int result = 0;
		
		try {
			regRequest.getUserPhoto().transferTo(file);
			
			Member member = regRequest.toMember();
			member.setMemberphoto(newFileName); // 나중에 출력하기 위해 사진이름 저장
			
			dao = template.getMapper(InterfaceDao.class);			
			result = dao.insertMember(member);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			
			if(file.exists()) {
				file.delete();
			}
		}
		
		
		return result;
	}

}
