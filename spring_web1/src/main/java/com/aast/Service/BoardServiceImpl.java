package com.aast.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aast.Mapper.BoardMapper;

import lombok.AllArgsConstructor;
import www.aast.Domain.BoardVO;
import www.aast.Domain.CountVO;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {@Override
	
	BoardMapper board;
	HashMap<String, Object> map;
	
	public BoardVO viewBoard(String boardNumber) {
		return null;
	}

	@Override
	public String selectMemberName(String boardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReadCount(String boardNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUpCount(String boardNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDownCount(String boardNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReportCount(String boardNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getReadCount(String boardNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CountVO getTotalCount(String boardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBoard(String boardNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertBoard(BoardVO boardVO, String boardId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(BoardVO boardVO, String boardNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String selectWriter(String boardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectAllBoard(int page, String boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBoardCount(String boardId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> selectAllBoardUp(int page, String boardId, String hitCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBoardCountUp(String boardId, String hitCount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> selectAllBoardDown(int page, String boardId, String hitCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int geBoardCountDown(String boardId, String hitCount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> selectAllBoardReport(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBoardCountReport() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> selectAllBoardTotal(int page, String boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBoardCountTotal(String boardId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> selectAllBoardNotice(int page, String boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBoardCountNotice(String boardId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> selectAllBoardMember(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMemberCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> selectBoardComment(int page, String board_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectBoardReadCount(int page, String board_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectBoardUp(int page, String board_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectBoardDown(int page, String board_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectMyWriteList(int page, String memberNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectMyWriteCount(String memberNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
