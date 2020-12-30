package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPage2Command implements Command {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		return "/WEB-INF/view/member/mypage/mypage2.jsp";
	}

}
