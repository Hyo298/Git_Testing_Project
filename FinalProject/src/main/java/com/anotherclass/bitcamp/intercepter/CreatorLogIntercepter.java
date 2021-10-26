package com.anotherclass.bitcamp.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CreatorLogIntercepter extends HandlerInterceptorAdapter {
	
	// 컨트롤러가 호출되기전에 호출되는 메소드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		//로그인된 아이디구하기
		HttpSession session = request.getSession();
		String creatorLog= (String)session.getAttribute("creatorLog");
		
		//로그인이 안된경우
		if(creatorLog==null || !creatorLog.equals("Y")) {
			response.sendRedirect(request.getContextPath()+"/creatorLogin");
			return false;
		}
		//로그인이 된 경우
		return true;
	}
	// 컨트롤러가 실행된 후 view 페이지로 이동하기 전에 호출된다.
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView)throws Exception {
		
	}
	
	// 컨트롤러가 실행후 호출된다.
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView)throws Exception {
		
	}
}