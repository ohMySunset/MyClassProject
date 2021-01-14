package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
    // 입력받은 데이터의 한글처리가 가능한 필터
	
	// 인스턴스 변수
	private String encoding;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	                //web.xml의 init-param을 가져올 수 있다.
		encoding = filterConfig.getInitParameter("encoding");
		
		if(encoding == null) {
			encoding = "utf-8";
		}
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		 request.setCharacterEncoding(encoding);
		 
		 chain.doFilter(request, response); // 모든 request 요청에 encoding처리로 응답
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}





}
