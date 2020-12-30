package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberListService;

public class MemberListCommand implements Command {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		 
		MemberListService service = MemberListService.getInstance();
		service.getMemberListView(request);

		return "/WEB-INF/view/member/manager/memberListView.jsp";
	}

}
