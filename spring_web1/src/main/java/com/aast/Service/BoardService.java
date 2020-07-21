package com.aast.Service;

import java.util.List;

import www.aast.Domain.BoardVO;
import www.aast.Domain.CountVO;

public interface BoardService {
	
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
	public int insertBoard(BoardVO boardVO, String boardId);
	public int updateBoard(BoardVO boardVO, String boardNumber);
	public String selectWriter(String boardNumber);
	
	
	/*기본게시판*/
	public List<BoardVO> selectAllBoard(int page, String boardId);
	public int getBoardCount(String boardId);
	
	/*추천게시판*/
	public List<BoardVO> selectAllBoardUp(int page, String boardId, String hitCount);
	public int getBoardCountUp(String boardId, String hitCount);
	
	/*비추천게시판*/
	public List<BoardVO> selectAllBoardDown(int page, String boardId, String hitCount);
	public int geBoardCountDown(String boardId, String hitCount);
	
	/*신고게시판*/
	public List<BoardVO> selectAllBoardReport(int page);
	public int getBoardCountReport();
	
	/*통합게시판*/
	public List<BoardVO> selectAllBoardTotal(int page, String boardId);
	public int getBoardCountTotal(String boardId);
	
	/*공지사항게시판*/
	public List<BoardVO> selectAllBoardNotice(int page, String boardId);
	public int getBoardCountNotice(String boardId);
	
	/*회원관리게시판*/
	public List<BoardVO> selectAllBoardMember(int page);
	public int getMemberCount();
	
	/*메인게시글*/
	/*게시판 드롭메뉴*/
	public List<BoardVO> selectBoardComment(int page, String board_Id);
	public List<BoardVO> selectBoardReadCount(int page, String board_Id);
	public List<BoardVO> selectBoardUp(int page, String board_Id);
	public List<BoardVO> selectBoardDown(int page, String board_Id);
	
	/*마이페이지*/
	public List<BoardVO> selectMyWriteList(int page, String memberNumber);
	public int selectMyWriteCount(String memberNumber);
	
	/*관리자페이지*/
}
