package com.pkfinal.main.centers.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkfinal.main.centers.dao.CentersDao;
@Service
public class CentersServiceImpl implements CentersService {
	@Autowired
	private CentersDao centersDao;
	
	@Override
	public HashMap<String, Object> nearCenter(HashMap<String, Object> map) {
		map = centersDao.nearCenter(map);
		return map;
	}

}
