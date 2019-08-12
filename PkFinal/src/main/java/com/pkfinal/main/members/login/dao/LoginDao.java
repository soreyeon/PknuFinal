package com.pkfinal.main.members.login.dao;

import java.util.HashMap;

import com.pkfinal.main.members.vo.MembersVo;

public interface LoginDao {

	public MembersVo login(HashMap<String, Object> map);

}
