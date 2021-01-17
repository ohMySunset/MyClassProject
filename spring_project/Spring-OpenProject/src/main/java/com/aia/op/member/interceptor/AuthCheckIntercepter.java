package com.aia.op.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			                 HttpServletResponse response, 
			                 Object handler)
			throws Exception {
		
		// 로그인 여부 확인하고
		// 로그인 상태 -> return true
		// 비로그인 상태 -> return false, 로그인 페이지로 redirect
		
		// Session이 null일 때도 그대로 유지하기 위해서 false를 전달한다.
		HttpSession session = request.getSession(false); 
		
		if(session != null && session.getAttribute("loginInfo") != null) {
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/member/login");
		
		return false;
	}

	
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
	

}
