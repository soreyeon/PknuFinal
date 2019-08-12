package com.pkfinal.main.members.login.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkfinal.main.members.login.dao.LoginDao;
import com.pkfinal.main.members.vo.MembersVo;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao	loginDao;
	
	@Override
	public MembersVo login(HashMap<String, Object> map) {
		
		return loginDao.login(map);
	}

}
