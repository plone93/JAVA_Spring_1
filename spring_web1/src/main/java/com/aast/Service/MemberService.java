package com.aast.Service;

import java.util.List;

import com.aast.Domain.AdminVO;
import com.aast.Domain.MemberVO;

public interface MemberService {
	/*유저*/
	public int insertMember(MemberVO memberVO);
	public MemberVO getMember(MemberVO memberVO);
	public int updateMember(MemberVO memberVO);
	public String getMemberPass(MemberVO memberVO);
	public int deleteMember(MemberVO memberVO);
	/*회원가입시 체크*/
	public int checkId(String inputId);
	public int checkEmail(String inputEmail);
	public int checkName(String inputName);
	/*개인정보창에서 업데이트*/
	public int updateEmail(MemberVO memberVO);
	public int updatePass(MemberVO memberVO);
	public int updateName(MemberVO memberVO);
	public int updateAddress(MemberVO memberVO);
	public int updatePhoneNumber(MemberVO memberVO);
	
	/*관리자*/ 
	public AdminVO getAdmin(int adminNumber);
	public int checkAdminEmail(String adminEmail);
	public int updateAdminEmail(int adminNumber, String adminEamil);
	public int updateAdminName(int adminNumber, String adminName);
	public int updateAdminPass(int adminNumber, String adminPass);
	public List<MemberVO> selectAllMember(int page);
	public int getMemberCount();
}
