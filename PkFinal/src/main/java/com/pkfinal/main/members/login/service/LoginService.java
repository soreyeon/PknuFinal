package com.pkfinal.main.members.login.service;

import java.util.HashMap;

import com.pkfinal.main.members.vo.MembersVo;

public interface LoginService {

	public MembersVo login(HashMap<String, Object> map);

}
