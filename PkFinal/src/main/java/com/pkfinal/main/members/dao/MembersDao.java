package com.pkfinal.main.members.dao;

import java.util.HashMap;

public interface MembersDao {

	public void join(HashMap<String, Object> map);

	public HashMap<String, Object> idDupCheck(HashMap<String, Object> map);

}
