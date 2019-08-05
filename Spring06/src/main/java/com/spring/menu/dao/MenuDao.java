package com.spring.menu.dao;

import java.util.List;

import com.spring.menu.vo.MenuVo;

public interface MenuDao {

	public List<MenuVo> getList();

	public void insertMenu(MenuVo menuVo);

	public MenuVo getContent(MenuVo vo);

	public void updateMenu(MenuVo vo);

	public void deleteMenu(MenuVo vo);

}
