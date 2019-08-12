package com.pkfinal.main.members.login.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pkfinal.main.members.vo.MembersVo;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MembersVo login(HashMap<String, Object> map) {
		MembersVo membersVo = sqlSession.selectOne("Login.Login", map);
		return membersVo;
	}

}
