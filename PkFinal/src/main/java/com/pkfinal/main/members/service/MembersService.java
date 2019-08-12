package com.pkfinal.main.members.service;

import java.util.HashMap;

public interface MembersService {

	public void join(HashMap<String, Object> map);

	public HashMap<String, Object> idDupCheck(HashMap<String, Object> map);


}
