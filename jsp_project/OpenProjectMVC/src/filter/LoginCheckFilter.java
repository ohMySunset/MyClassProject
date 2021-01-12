package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
	
	//필터는 서블릿 실행 전, 후에 어떤 작업을 하고자 할때 사용

	// 필터와 매핑된 URL에 요청이 들어올때마다 doFilter()가 호출된다.
	// 이 메소드에 필터가 할 작업을 작성한다.
	// filterChain은 다음 필터를 가리키고 filterChain.doFilter()는 다음 필터를 호출한다.
	// 다음 필터가 없다면 내부적으로 서블릿의 service()를 호출한다.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request; 
		HttpSession session = httpRequest.getSession();		
		
		System.out.println("LoginCheckFilter 실행!");
	
		boolean loginCheck = false;
		
		if(session != null && session.getAttribute("loginInfo")!= null) {
			chain.doFilter(request, response);
		} else {			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/loginForm.do");
		    dispatcher.forward(request, response);
		}
	}
	
	// 서블릿 컨테이너는 웹 어플리케이션을 종료하기 전에 필터들에 대해 destroy()를 호출해서 마무리 작업을 한다. 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	// init() 메소드는 필터 객체가 생성되고 준비 작업을 위해 딱 한번 호출된다.
	//서블릿의 init()과 같은 용도이다
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
