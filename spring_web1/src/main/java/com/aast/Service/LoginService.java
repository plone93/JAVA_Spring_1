package com.aast.Service;

public interface LoginService {
	/*로그인*/
	public int loginMember(String id, String pass);
	public int loginAdmin(String id, String pass);
}
