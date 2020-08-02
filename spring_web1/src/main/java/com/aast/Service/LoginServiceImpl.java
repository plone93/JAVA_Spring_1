package com.aast.Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.aast.Mapper.LoginMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService{
	
	LoginMapper login;
	
	@Override
	public int loginMember(String inputId, String inputPass) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", inputId);
		map.put("memberPass", inputPass);
		
		return login.loginMember(map);
	}

	@Override
	public int loginAdmin(String inputId, String inputPass) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("inputId", inputId);
		map.put("inputPass", inputPass);
		
		return login.loginAdmin(map);
	}

}
