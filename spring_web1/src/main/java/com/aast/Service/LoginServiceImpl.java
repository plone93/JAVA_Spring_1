package com.aast.Service;

import java.util.HashMap;

import com.aast.Mapper.LoginMapper;

public class LoginServiceImpl implements LoginService{
	
	LoginMapper login;
	HashMap<String, Object> map;
	
	@Override
	public int loginMember(String id, String pass) {
		map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", pass);
		
		return login.loginMember(map);
	}

	@Override
	public int loginAdmin(String id, String pass) {
		map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", pass);
		
		return login.loginAdmin(map);
	}

}
