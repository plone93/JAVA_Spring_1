package com.aast.Mapper;

import java.util.HashMap;
import java.util.List;

import com.aast.Domain.BoardVO;
import com.aast.Domain.CountVO;
import com.aast.Domain.MemberVO;

public interface BoardMapper {
	
	/*기능*/
	public BoardVO viewBoard(BoardVO boardVO);
	public String selectMemberName(BoardVO boardVO);
	public void updateReadCount(BoardVO boardVO);
	public void updateUpCount(BoardVO boardVO);
	public void updateDownCount(BoardVO boardVO);
	public void updateReportCount(BoardVO boardVO);
	public int getReadCount(BoardVO boardVO);
	public CountVO getTotalCount(BoardVO boardVO);
	public int deleteBoard(BoardVO boardVO);
	
	public int insertBoard(BoardVO boardVO);
	public int updateBoard(BoardVO boardVO);
	public String selectWriter(BoardVO boardVO);
	
	/*기본게시판*/
	public List<BoardVO> selectAllBoard(BoardVO boardVO);
	public int getBoardCount(BoardVO boardVO);
	
	/*추천게시판*/
	public List<BoardVO> selectAllBoardUp(BoardVO boardVO);
	public int getBoardCountUp(BoardVO boardVO);
	
	/*비추천게시판*/
	public List<BoardVO> selectAllBoardDown(BoardVO boardVO);
	public int getBoardCountDown(BoardVO boardVO);
	
	/*통합게시판*/
	public List<BoardVO> selectAllBoardTotal(BoardVO boardVO);
	public int getBoardCountTotal(BoardVO boardVO);
	
	/*신고게시판*/
	public List<BoardVO> selectAllBoardReport(BoardVO boardVO);
	public int getBoardCountReport();
	
	/*공지사항게시판*/
	public List<BoardVO> selectAllBoardNotice(BoardVO boardVO);
	public int getBoardCountNotice(BoardVO boardVO);
	
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
