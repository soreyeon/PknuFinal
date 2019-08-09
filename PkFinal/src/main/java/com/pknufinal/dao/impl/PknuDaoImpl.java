package com.pknufinal.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknufinal.dao.PknuDao;
import com.pknufinal.vo.PknuVo;

 
@Repository("PknuDao")// db와 연결되는 annotation
public class PknuDaoImpl implements PknuDao { 

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertMenuButton(HashMap<String, Object> map) {
		System.out.println("insertMenuButton :" + map); 
		sqlSession.insert("Menu.insertMenuButton",map);
		
	}
	
	@Override
	public void deleteMenuButton(HashMap<String, Object> map) {
		System.out.println("deleteMenuButton :" + map); 
		sqlSession.insert("Menu.deleteMenuButton",map);
		
	}

	@Override
	public void updateMenuButton(HashMap<String, Object> map) {
		System.out.println("updateMenuButton :" + map); 
		sqlSession.insert("Menu.updateMenuButton",map);
		
	}
	
	@Override
	public List<PknuVo> selectMenuButton(HashMap<String, Object> map) {
		System.out.println(map);
		sqlSession.selectList("Menu.selectMenuButton",map);
		System.out.println(map);
		List<PknuVo> list = (List<PknuVo>) map.get("result");
		return list;
	}
 
	

}
