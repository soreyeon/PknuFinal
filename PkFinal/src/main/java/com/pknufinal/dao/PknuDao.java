package com.pknufinal.dao;

import java.util.HashMap;
import java.util.List;

import com.pknufinal.vo.PknuVo;

public interface PknuDao {

	void insertMenuButton(HashMap<String, Object> map);

	List<PknuVo> selectMenuButton(HashMap<String, Object> map);

	void deleteMenuButton(HashMap<String, Object> map);

	void updateMenuButton(HashMap<String, Object> map);


}
