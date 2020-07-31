package com.aast.Service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.aast.Mapper.LoginMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService{
	
	LoginMapper login;
	HashMap<String, Object> map;
	
	@Override
	public int loginMember(String memberId, String memberPass) {
		map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("memberPass", memberPass);
		
		return login.loginMember(map);
	}

	@Override
	public int loginAdmin(String adminId, String adminPass) {
		map = new HashMap<String, Object>();
		map.put("adminId", adminId);
		map.put("adminPass", adminPass);
		
		return login.loginAdmin(map);
	}

}
