package com.spring.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.service.MenuService;
import com.spring.menu.vo.MenuVo;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	//메뉴목록조회
	@RequestMapping("/Menu/List")
	public ModelAndView menuList() {
		List<MenuVo> list = menuService.getList();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menus/menulist");
		mv.addObject("menuList", list);
		return mv;
	}
	
	//메뉴추가 form
	@RequestMapping("/Menu/WriteForm")
	public ModelAndView writeForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menus/writemenu");
		return mv;
	}
	
	//메뉴추가
	@RequestMapping("/Menu/Write")
	public ModelAndView write(MenuVo menuVo) {
		menuService.insertMenu(menuVo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Menu/List");
		return mv;
	}
	
	//메뉴수정form
	@RequestMapping("/Menu/UpdateForm")
	public ModelAndView updateForm(MenuVo vo) {
		MenuVo menuVo = menuService.getContent(vo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menus/updatemenu");
		mv.addObject("menuVo", menuVo);
		return mv;
	}
	
	//메뉴수정
	@RequestMapping("/Menu/Update")
	public ModelAndView update(MenuVo vo) {
		menuService.updateMenu(vo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Menu/List");
		return mv;
	}
	
	//메뉴삭제
	@RequestMapping("/Menu/Delete")
	public ModelAndView delete(MenuVo vo) {
		menuService.deleteMenu(vo);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Menu/List");
		return mv;
	}
	
	
}
