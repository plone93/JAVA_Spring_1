package com.aast.Service;

import java.util.List;

import www.aast.Domain.AdminVO;
import www.aast.Domain.MemberVO;

public interface MemberService {
	/*유저*/
	public int insertMember(MemberVO memberVO);
	public MemberVO getMember(String memberId);
	public int updateMember(MemberVO memberVO, String memberNumber);
	public String getMemberPass(String memberNumber);
	public int deleteMember(String memberNumber);
	public int checkId(String memberId);
	public int checkEmail(String memberEmail);
	public int checkName(String memberName);
	public int updateEmail(String memberNumber, String memberEmail);
	public int updatePass(String memberNumber, String memberPass);
	public int updateName(String memberNumber, String memberName);
	public int updateAddress(String memberNumer, String addressA, String addressB);
	public int updatePhoneNumber(String memberNumber, String phoneNumber);
	
	/*관리자*/ 
	public AdminVO getAdmin(String adminNumber);
	public int checkAdminEmail(String adminEmail);
	public int updateAdminEmail(String adminNumber, String adminEamil);
	public int updateAdminName(String adminNumber, String adminName);
	public int updateAdminPass(String adminNumber, String adminPass);
	public List<MemberVO> selectAllMember(int page);
	public int getMemberCount();
}
