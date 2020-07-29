package com.aast.Service;

public interface LoginService {
	
	
	/*로그인*/
	public int loginMember(String memberId, String memberPass);
	public int loginAdmin(String adminId, String adminPass);
}
