package com.pkfinal.main.members.dao;

import java.util.HashMap;

import com.pkfinal.main.members.vo.MembersVo;

public interface MembersDao {

	public void join(HashMap<String, Object> map);

	public HashMap<String, Object> idDupCheck(HashMap<String, Object> map);

	public MembersVo loginAction(HashMap<String, Object> map);

}
