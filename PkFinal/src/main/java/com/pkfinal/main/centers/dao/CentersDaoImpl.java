package com.pkfinal.main.centers.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pkfinal.main.centers.vo.CentersVo;
@Repository
public class CentersDaoImpl implements CentersDao {
	@Autowired
	private SqlSession sqlSession;
	@Override
	public HashMap<String, Object> nearCenter(HashMap<String, Object> map) {
		CentersVo centersVo = sqlSession.selectOne("Centers.NearCenter", map);
		map.put("centersVo", centersVo);
		return map;
	}


}
