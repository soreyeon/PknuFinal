package com.spring.user.service;

import java.util.HashMap;

import com.spring.user.vo.UserVo;

public interface UserService {

	public UserVo login(HashMap<String, Object> map);

}
