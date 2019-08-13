package com.pkfinal.main.members.service;

import java.util.HashMap;

import com.pkfinal.main.members.vo.MembersVo;

public interface MembersService {

	public void join(HashMap<String, Object> map);

	public HashMap<String, Object> idDupCheck(HashMap<String, Object> map);

	public MembersVo loginAction(HashMap<String, Object> map);


}
