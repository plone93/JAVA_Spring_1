package com.aast.Mapper;

import java.util.HashMap;

public interface LoginMapper {
	/*로그인*/
	public int loginMember(HashMap<String, Object> map);
	public int loginAdmin(HashMap<String, Object> map);
}
