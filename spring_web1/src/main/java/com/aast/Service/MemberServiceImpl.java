package com.aast.Service;

import java.util.HashMap;
import java.util.List;

import com.aast.Mapper.MemberMapper;

import www.aast.Domain.AdminVO;
import www.aast.Domain.MemberVO;

public class MemberServiceImpl implements MemberService{
	
	MemberMapper member;
	HashMap<String, Object> map;
	
	@Override
	public int insertMember(MemberVO memberVO) {
		map = new HashMap<String, Object>();
		map.put("memberVO", memberVO);
		
		return member.insertMember(map);
	}

	@Override
	public MemberVO getMember(String memberId) {
		return member.getMember(memberId);
	}

	@Override
	public int updateMember(MemberVO memberVO, String memberNumber) {
		map = new HashMap<String, Object>();
		map.put("memberVO", memberVO);
		map.put("memberNumber", memberNumber);
		
		return member.updateMember(map);
	}

	@Override
	public String getMemberPass(String memberNumber) {
		return member.getMemberPass(memberNumber);
	}

	@Override
	public int deleteMember(String memberNumber) {
		return member.deleteMember(memberNumber);
	}

	@Override
	public int checkId(String memberId) {
		return member.checkId(memberId);
	}

	@Override
	public int checkEmail(String memberEmail) {
		return member.checkEmail(memberEmail);
	}

	@Override
	public int checkName(String memberName) {
		return member.checkName(memberName);
	}

	@Override
	public int updateEmail(String memberNumber, String memberEmail) {
		map = new HashMap<String, Object>();
		map.put("memberNumber", memberNumber);
		map.put("memberEmail", memberEmail);
		
		return member.updateEmail(map);
	}

	@Override
	public int updatePass(String memberNumber, String memberPass) {
		map = new HashMap<String, Object>();
		map.put("memberNumber", memberNumber);
		map.put("memberPass", memberPass);
		
		return member.updatePass(map);
	}

	@Override
	public int updateName(int memberNumber, String memberName) {
		map = new HashMap<String, Object>();
		map.put("memberNumber", memberNumber);
		map.put("memberName", memberName);
		
		return member.updateName(map);
	}

	@Override
	public int updateAddress(int memberNumber, String addressA, String addressB) {
		map = new HashMap<String, Object>();
		map.put("memberNumber", memberNumber);
		map.put("addressA", addressA);
		map.put("addressB", addressB);
		
		return member.updateAddress(map);
	}

	@Override
	public int updatePhoneNumber(int memberNumber, String phoneNumber) {
		map = new HashMap<String, Object>();
		map.put("memberNumber", memberNumber);
		map.put("phoneNumber", phoneNumber);
		
		return member.updatePhoneNumber(map);
	}

	@Override
	public AdminVO getAdmin(String adminNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkAdminEmail(String adminEmail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAdminEmail(String adminNumber, String adminEamil) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAdminName(String adminNumber, String adminName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAdminPass(String adminNumber, String adminPass) {
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
