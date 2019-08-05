package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	//Authenticate : 인증-->아이디/암호 통과
	//Authorization : 권한 --> 관리자, 일반유저, 과장, 사원

	
	//preHandle(): 컨트롤러보다 먼저 수행되는 메소드
	//로그인 체크 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1. 기존 session 정보를 가져옴
		HttpSession session = request.getSession();
		
		//2. session로그인 정보를 가져옴
		Object obj = session.getAttribute("login");// key 값
		
		System.out.println("현재 실행중인 파일정보: " + request.getRequestURI());
		
		//로그인되지 않아도 Controller로 이동가능하도록 예외등록
		switch(request.getRequestURI()) {
		case "/login":
		case "/loginProcess":
			return true; //dispatcher-servlet 실행하러 이동
		}
		
		//로그인되지 않으면
		if(obj == null) {
			response.sendRedirect("/login"); 
			return false;  //dispatcher-servlet 금지
		}
		
		//prehandle의 return의 의미는 컨트롤러 요청 uri로 가도 되는지 안되는지를 허가하는 의미
		//true면 컨트롤러 uri로 가게됨
		return true;
	}

	//컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
	
}
