package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutCommand implements Command {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		  
		HttpSession session = request.getSession(false);
		
		session.invalidate(); // 현재 세션을 소멸 -> 속성까지 소멸 (loginInfo 데이터 삭제)		 	
	
		return "/WEB-INF/view/index.jsp";
	}

}
