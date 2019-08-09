package com.pkfinal.main.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pknufinal.service.PknuService;
import com.pknufinal.vo.PknuVo;

@Controller
public class MainController {

	@Autowired
	private PknuService PknuService;
	
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/selectMenuButton")
	@ResponseBody
	public List<PknuVo> selectMenuButton(@RequestParam HashMap<String, Object> map) {
		System.out.println(map);
		List<PknuVo> selectMenuButton = PknuService.selectMenuButton(map);
		return selectMenuButton;
	}
	
	
	@RequestMapping("/insertMenuButton")
	@ResponseBody
	public List<PknuVo> insertMenuButton(@RequestParam HashMap<String, Object> map) {
		PknuService.insertMenuButton(map);
		List<PknuVo> selectMenuButton = PknuService.selectMenuButton(map);
		return selectMenuButton;
	}
	
	@RequestMapping("/deleteMenuButton")
	@ResponseBody
	public List<PknuVo> deleteMenuButton(@RequestParam HashMap<String, Object> map) {
		System.out.println("deleteMenuButton : "+ map);
		PknuService.deleteMenuButton(map);
		List<PknuVo> selectMenuButton = PknuService.selectMenuButton(map);
		return selectMenuButton;
	}
	
	@RequestMapping("/updateMenuButton")
	@ResponseBody
	public List<PknuVo> updateMenuButton(@RequestParam HashMap<String, Object> map) {
		PknuService.updateMenuButton(map);
		List<PknuVo> selectMenuButton = PknuService.selectMenuButton(map);
		return selectMenuButton;
	}
}
