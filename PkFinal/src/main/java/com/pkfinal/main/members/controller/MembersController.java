package com.pkfinal.main.members.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pkfinal.main.centers.service.CentersService;
import com.pkfinal.main.members.login.service.LoginService;
import com.pkfinal.main.members.service.MembersService;
import com.pkfinal.main.members.vo.MembersVo;

@Controller

public class MembersController {
	@Autowired
	private MembersService membersService;
	@Autowired
	private CentersService centersService;
	
	

	
	// 회원가입
	
	@RequestMapping("/Members/JoinForm")
	public ModelAndView joinForm(MembersVo membersVo) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("Join");
		mv.setViewName("members/join");
		mv.addObject("membersVo", membersVo);
		
		return mv;
	}
	
	@RequestMapping("/Members/Join")
	public ModelAndView join(@RequestParam HashMap<String, Object> map) {
		ModelAndView mv = new ModelAndView();
		
		membersService.join(map);
		
		mv.setViewName("redirect:/");
		
		return mv;
	}
	
	// 아이디 중복체크
	@ResponseBody
	@RequestMapping(value="/IdDupCheck", method=RequestMethod.GET,
			headers="Accept=application/json")
	public HashMap<String, Object> idDupCheck(@RequestParam HashMap<String, Object> map) {
		
		map = membersService.idDupCheck(map);
		
		return map;
	}

	// 근처 센터 찾기
	@ResponseBody
	@RequestMapping(value="/NearCenter", method=RequestMethod.GET,
	headers="Accept=application/json")
	public HashMap<String, Object> nearCenter(@RequestParam HashMap<String, Object> map) {

		map = centersService.nearCenter(map);

		return map;
	}
	
	
	
	
	
}












