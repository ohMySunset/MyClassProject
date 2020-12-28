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
    //필터란 서블릿과 브라우저 간에 요청이나 응답이 이뤄질 때 미리 여러 가지 작업을 처리하는 기능이다.
    //여러 서블릿에서 반복적으로 수행해야 하는 작업을 공통으로 처리할 수 있다는 장점을 지닌다.
	
	/*
	  javax.servlet.Filter
	  javax.servlet.FilterChain
	  javax.servlet.FilterConfig
	 */
	
	@Override
	public void doFilter(
			ServletRequest request,
			ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {
		
		// 로그인 여부 확인하는 Filter
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		boolean loginCheck = false;
		
		if(session != null && session.getAttribute("loginInfo") != null) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/member02/loginForm.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
