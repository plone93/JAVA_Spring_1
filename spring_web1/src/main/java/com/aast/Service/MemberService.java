package com.aast.Service;

import java.util.List;

import com.aast.Domain.AdminVO;
import com.aast.Domain.MemberVO;

public interface MemberService {
	/*유저*/
	public int insertMember(MemberVO memberVO);
	public MemberVO getMember(String memberId);
	public int updateMember(MemberVO memberVO, int memberNumber);
	public String getMemberPass(int memberNumber);
	public int deleteMember(int memberNumber);
	public int checkId(String memberId);
	public int checkEmail(String memberEmail);
	public int checkName(String memberName);
	public int updateEmail(int memberNumber, String memberEmail);
	public int updatePass(int memberNumber, String memberPass);
	public int updateName(int memberNumber, String memberName);
	public int updateAddress(int memberNumer, String addressA, String addressB);
	public int updatePhoneNumber(int memberNumber, String phoneNumber);
	
	/*관리자*/ 
	public AdminVO getAdmin(int adminNumber);
	public int checkAdminEmail(String adminEmail);
	public int updateAdminEmail(int adminNumber, String adminEamil);
	public int updateAdminName(int adminNumber, String adminName);
	public int updateAdminPass(int adminNumber, String adminPass);
	public List<MemberVO> selectAllMember(int page);
	public int getMemberCount();
}
