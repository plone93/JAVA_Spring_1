package com.aast.Mapper;

import java.util.HashMap;
import java.util.List;

import www.aast.Domain.BoardVO;
import www.aast.Domain.MemberVO;

public interface SearchMapper {
	/*일반게시판 검색*/
	public List<BoardVO> search(HashMap<String, Object> map);
	public int searchCount(HashMap<String, Object> map);
	
	/*공지사항 검색*/
	public List<BoardVO> searchNotice(String boardId);
	public int searchNoticeCount(String boardId);
	
	/*추천 검색*/
	public List<BoardVO> searchUp(HashMap<String, Object> map);
	public int searchUpCount(HashMap<String, Object> map);
	
	/*비추천 검색*/
	public List<BoardVO> searchDown(HashMap<String, Object> map);
	public int searchDownCount(HashMap<String, Object> map);
	
	/*신고 검색*/
	public List<BoardVO> searchReport(HashMap<String, Object> map);
	public int searchReportCount(HashMap<String, Object> map);
	
	/*통합 검색*/
	public List<BoardVO> searchTotal(HashMap<String, Object> map);
	public int searchTotalCount(HashMap<String, Object> map);
	
	/*회원 검색*/
	public List<MemberVO> searchMember(HashMap<String, Object> map);
	public int searchMemberCount(HashMap<String, Object> map);
}
