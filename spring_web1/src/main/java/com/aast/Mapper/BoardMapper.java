package com.aast.Mapper;

import java.util.HashMap;
import java.util.List;

import www.aast.Domain.BoardVO;
import www.aast.Domain.CountVO;
import www.aast.Domain.MemberVO;

public interface BoardMapper {
	
	/*기능*/
	public BoardVO viewBoard(String boardNumber);
	public String selectMemberName(String boardNumber);
	public void updateReadCount(String boardNumber);
	public void updateUpCount(String boardNumber);
	public void updateDownCount(String boardNumber);
	public void updateReportCount(String boardNumber);
	public int getReadCount(String boardNumber);
	public CountVO getTotalCount(String boardNumber);
	public int deleteBoard(String boardNumber);
	
	public int insertBoard(HashMap<String, Object> map);
	public int updateBoard(HashMap<String, Object> map);
	public String selectWriter(String boardNumber);
	
	/*기본게시판*/
	public List<BoardVO> selectAllBoard(HashMap<String, Object> map);
	public int getBoardCount(String boardId);
	
	/*추천게시판*/
	public List<BoardVO> selectAllBoardUp(HashMap<String, Object> map);
	public int getBoardCountUp(HashMap<String, Object> map);
	
	/*비추천게시판*/
	public List<BoardVO> selectAllBoardDown(HashMap<String, Object> map);
	public int getBoardCountDown(HashMap<String, Object> map);
	
	/*통합게시판*/
	public List<BoardVO> selectAllBoardTotal(HashMap<String, Object> map);
	public int getBoardCountTotal(HashMap<String, Object> map);
	
	/*신고게시판*/
	public List<BoardVO> selectAllBoardReport(HashMap<String, Object> map);
	public int getBoardCountReport();
	
	/*공지사항게시판*/
	public List<BoardVO> selectAllBoardNotice(HashMap<String, Object> map);
	public int getBoardCountNotice(String boardId);
	
	/*회원관리게시판*/
	public List<MemberVO> selectAllBoardMember(int page);
	public int getAllMemberCount();
	
	/*게시판 드롭메뉴 기능*/
	public List<BoardVO> selectBoardComment(HashMap<String, Object> map);
	public List<BoardVO> selectBoardReadCount(HashMap<String, Object> map);
	public List<BoardVO> selectBoardUp(HashMap<String, Object> map);
	public List<BoardVO> selectBoardDown(HashMap<String, Object> map);
	
	/*마이페이지*/
	public List<BoardVO> selectMyWriteList(HashMap<String, Object> map);
	public int selectMyWriteCount(String memberId);
	
	/*관리자페이지*/
}
