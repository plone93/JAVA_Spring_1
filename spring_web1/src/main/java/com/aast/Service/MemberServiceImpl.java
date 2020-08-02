package com.aast.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aast.Domain.AdminVO;
import com.aast.Domain.MemberVO;
import com.aast.Mapper.MemberMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	MemberMapper member;
	//HashMap<String, Object> map;
	
	@Override
	public int insertMember(MemberVO memberVO) {
		return member.insertMember(memberVO);
	}

	@Override
	public MemberVO getMember(MemberVO memberVO) {
		return member.getMember(memberVO);
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		return member.updateMember(memberVO);
	}

	@Override
	public String getMemberPass(MemberVO memberVO) {
		return member.getMemberPass(memberVO);
	}

	@Override
	public int deleteMember(MemberVO memberVO) {
		return member.deleteMember(memberVO);
	}

	@Override
	public int checkId(String inputId) {
		return member.checkId(inputId);
	}

	@Override
	public int checkEmail(String inputEmail) {
		return member.checkEmail(inputEmail);
	}

	@Override
	public int checkName(String inputName) {
		return member.checkName(inputName);
	}

	@Override
	public int updateEmail(MemberVO memberVO) {
		return member.updateEmail(memberVO);
	}

	@Override
	public int updatePass(MemberVO memberVO) {
		return member.updatePass(memberVO);
	}

	@Override
	public int updateName(MemberVO memberVO) {
		return member.updateName(memberVO);
	}

	@Override
	public int updateAddress(MemberVO memberVO) {
		return member.updateAddress(memberVO);
	}

	@Override
	public int updatePhoneNumber(MemberVO memberVO) {
		return member.updatePhoneNumber(memberVO);
	}

	@Override
	public AdminVO getAdmin(int adminNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkAdminEmail(String adminEmail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAdminEmail(int adminNumber, String adminEamil) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAdminName(int adminNumber, String adminName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAdminPass(int adminNumber, String adminPass) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> selectAllMember(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMemberCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
