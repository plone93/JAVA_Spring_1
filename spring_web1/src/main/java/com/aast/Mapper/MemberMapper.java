package com.aast.Mapper;

import java.util.HashMap;
import java.util.List;

import com.aast.Domain.AdminVO;
import com.aast.Domain.MemberVO;

public interface MemberMapper {
	/*멤버 검색*/
	public int insertMember(HashMap<String, Object> map);//회원가입
	public MemberVO getMember(String memberId);//회원정보수정창에 띄울 가입된 정보
	public int updateMember(HashMap<String, Object> map);//회원정보수정 갱신
	public String getMemberPass(int memberNumber);//회원타로티 시 패스워드 인증
	public int deleteMember(int memberNumber);//회원탈퇴
	public int checkId(String id);//회원가입 시 아이디 중복확인
	public int checkEmail(String MemberEmail);//이메일 중복확인 체크
	public int checkName(String name);//닉네임 중복 체크
	public int updateEmail(HashMap<String, Object> map);//이메일 변경
	public int updateName(HashMap<String, Object> map);//닉네임 변경
	public int updatePass(HashMap<String, Object> map);
	public int updateAddress(HashMap<String, Object> map);
	public int updatePhoneNumber(HashMap<String, Object> map);
	
	/*관리자*/
	public AdminVO getAdmin(String memberId);
	public List<MemberVO> selectAllMember(HashMap<String, Object> map);//유저리스트
	public int getMemberCount();//총 멤버수 
	public int updateAdminEmail(HashMap<String, Object> map);//관리자 이메일 변경
	public int updateAdminName(HashMap<String, Object> map);//관리자 닉네임 변경
	public int updateAdminPass(HashMap<String, Object> map);//관리자 비밀번호 변경
	public int updateAdminEmail(String adminEmail);//관리자 이메일 중복체크
}
