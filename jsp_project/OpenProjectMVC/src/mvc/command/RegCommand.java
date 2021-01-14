package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberRegService;

public class RegCommand implements Command {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		   // 사용자 요청에 맞는 서비스 클래스 선택 -> 메서드 실행
		   // view 페이지를 선택 -> 포워드

		   // MemberRegService
		   // insertMember(HttpServletRequest request) -> int 1 또는 0 반환
			 
		   MemberRegService service = MemberRegService.getInstance();  
		   service.insertMember(request);
		   
		
		return "/WEB-INF/view/member/memberRegView.jsp";
		
	}

}
