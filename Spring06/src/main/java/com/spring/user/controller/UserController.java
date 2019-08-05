package com.spring.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.user.service.UserService;
import com.spring.user.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인 화면으로 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "login/loginForm";
	}
	
	//로그인 처리
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(HttpSession session, @RequestParam HashMap<String, Object> map) {
		String returnURL = "";
		
		
		if(session.getAttribute("login") != null) {
			//기존에 login이란 session 값이 존재하면
			session.removeAttribute("login"); //기존값 제거
		}
		
		//로그인 성공하면 UserVo값 리턴
		UserVo vo = userService.login(map);
		
		if(vo != null) {
			session.setAttribute("login", vo);
			returnURL = "redirect:/Pds/List?menu_id=MENU01&nowpage=1&pagecount=2&pagegrpnum=1"; //로그인성공시 목록으로
		} else {
			returnURL = "redirect:/login"; //로그인 폼으로 이동
		}
		return returnURL;
	}
	
	//로그아웃
	@RequestMapping(value = "/loginout")
	public String loginout(HttpSession session) {
		session.invalidate(); //session의 모든 속성을 지운다.
		//session.removeAttribute("login");
		return "redirect:/Pds/List?menu_id=MENU01";
	}
}
