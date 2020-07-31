package com.aast.Service;

import java.util.List;

import com.aast.Domain.BoardVO;
import com.aast.Domain.CountVO;

public interface BoardService {
	
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
	public List<BoardVO> selectAllBoard(BoardVO boardVO, int page);
	public int getBoardCount(BoardVO boardVO);
	
	/*추천게시판*/
	public List<BoardVO> selectAllBoardUp(BoardVO boardVO, int page);
	public int getBoardCountUp(BoardVO boardVO);
	
	/*비추천게시판*/
	public List<BoardVO> selectAllBoardDown(BoardVO boardVO, int page);
	public int geBoardCountDown(BoardVO boardVO);
	
	/*신고게시판*/
	public List<BoardVO> selectAllBoardReport(int page);
	public int getBoardCountReport();
	
	/*통합게시판*/
	public List<BoardVO> selectAllBoardTotal(BoardVO boardVO, int page);
	public int getBoardCountTotal(BoardVO boardVO);
	
	/*공지사항게시판*/
	public List<BoardVO> selectAllBoardNotice(BoardVO boardVO, int page);
	public int getBoardCountNotice(BoardVO boardVO);
	
	/*회원관리게시판*/
	public List<BoardVO> selectAllBoardMember(int page);
	public int getMemberCount();
	
	/*메인게시글*/
	/*게시판 드롭메뉴*/
	public List<BoardVO> selectBoardComment(BoardVO boardVO, int page);
	public List<BoardVO> selectBoardReadCount(BoardVO boardVO, int page);
	public List<BoardVO> selectBoardUp(BoardVO boardVO, int page);
	public List<BoardVO> selectBoardDown(BoardVO boardVO, int page);
	
	/*마이페이지*/
	public List<BoardVO> selectMyWriteList(BoardVO boardVO, int page);
	public int selectMyWriteCount(BoardVO boardVO);
	
	/*관리자페이지*/
}
