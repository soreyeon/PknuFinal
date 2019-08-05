package com.spring.menu.service;

import java.util.List;

import com.spring.menu.vo.MenuVo;

public interface MenuService {

	public List<MenuVo> getList();

	public void insertMenu(MenuVo menuVo);

	public MenuVo getContent(MenuVo vo);

	public void updateMenu(MenuVo vo);

	public void deleteMenu(MenuVo vo);
	
}
