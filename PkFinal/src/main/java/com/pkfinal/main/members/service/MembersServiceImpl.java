package com.pkfinal.main.members.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkfinal.main.members.dao.MembersDao;

@Service
public class MembersServiceImpl implements MembersService {
	@Autowired
	private MembersDao membersDao;
	
	@Override
	public void join(HashMap<String, Object> map) {
		membersDao.join(map);

	}

	@Override
	public HashMap<String, Object> idDupCheck(HashMap<String, Object> map) {
		map = membersDao.idDupCheck(map);
		return map;
	}

}
