package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.LoginInfo;
import member.model.Member;
import util.CookieBox;

public class MemberLoginService {
	
	// 싱글톤 처리
	private MemberLoginService() {}
	private static MemberLoginService service = new MemberLoginService();
	public static MemberLoginService getInstance() {
		return service;
	}
	
	// request, response 전달받고
	// 사용자가 입력한 데이터 id/pw 로그인 처리, 아이디 저장
	// session 객체 => request.getSession()
	public void memberLogin(HttpServletRequest request, HttpServletResponse response) {
		
		// 데이터 받기 : 아이디, 비밀번호
		String userId = request.getParameter("userid");
		String pw = request.getParameter("pw");

		String chk = request.getParameter("chk");

		if (chk != null && chk.equals("on") && userId != null && !userId.isEmpty()) {
			// 체크값이 null이 아니고 value값이 on일때, 유저아이디 값이 null이 아니고 공백이 아닐때
			// 쿠키 생성 저장
			// uid = userId 

			response.addCookie(CookieBox.createCookie("uid", userId, "/", 60 * 60 * 24 * 365));
		} else{
			//유지 시간을 0으로 설정하여 쿠키에 저장하지 않음!
			response.addCookie(CookieBox.createCookie("uid", userId, "/",0));
		}

		// session을 이용해서 로그인 처리	
		// id, pw를 조건으로 Member 테이블에서 select 한 결과가 있으면 인증에 성공, 
		// 없으면 인증 실패
		// 로그인 여부 체크
		boolean loginChk = false; // 로그인이 되지 않은 상태

		MemberDao dao = null;		
		Connection conn = null;
		
		try {
		dao = MemberDao.getInstance();
		conn = ConnectionProvider.getConnection();

		Member member = dao.selectMemberLogin(conn, userId, pw);


		if(member!=null){
			// 인증이 되어 로그인 처리 : session 객체에 로그인 정보를 속성에 저장
			//System.out.println(member);

		  LoginInfo loginInfo = member.toLoginInfo();
		  
		  // getSession() -> session이 있으면 있는 session을 반환하고, 없으면 새로운 session 객체를 생성
		  // getSession(false) -> session이 있으면 있는session 반환하고, 없으면 null 반환
		  // getSession(true) -> 무조건 새로운 session을 만들어 반환
		  HttpSession session = request.getSession(); 
		 	  
		  session.setAttribute("loginInfo", loginInfo);
		  //System.out.println(loginInfo);  
		  
		  loginChk = true;
		  
		} 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		request.setAttribute("loginChk", loginChk);
		
		
		
		
	}
	

}
