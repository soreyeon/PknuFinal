package com.pkfinal.main.members.login.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pkfinal.main.members.login.service.LoginService;
import com.pkfinal.main.members.vo.MembersVo;

@Controller
@RequestMapping("/Login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping("/")
	public String loginPage(@RequestParam HashMap<String, Object> map) {
		
		return "members/login";
	}
	
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public String login(@RequestParam HashMap<String, Object> map,
				HttpSession session, RedirectAttributes rSession) {
		
		
		String returnURL = "";
		
		MembersVo	membersVo = loginService.login(map);
		
		if(membersVo != null) {
			if(map.get("m_pwd").equals(membersVo.getM_pwd())) {
				session.setAttribute("members", membersVo);
				returnURL = "redirect:/"; //로그인 성공시 홈
			}else {
				rSession.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
				returnURL = "redirect:/Login/";
			}
		} else {
			rSession.addFlashAttribute("msg", "해당하는 아이디가 없습니다.");
			returnURL = "redirect:/Login/";		
		}		
		return returnURL;
	}
	
	@RequestMapping("/Logout")
	public String loginout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}

