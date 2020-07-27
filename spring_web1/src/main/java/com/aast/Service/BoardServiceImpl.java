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
public class BoardServiceImpl implements BoardService {
		
	BoardMapper board;
	HashMap<String, Object> map;
	int startNumber;
	int endNumber;
	
	@Override
	public BoardVO viewBoard(String boardNumber) {
		return board.viewBoard(boardNumber);
	}

	@Override
	public String selectMemberName(String boardNumber) {
		return board.selectMemberName(boardNumber);
	}

	@Override
	public void updateReadCount(String boardNumber) {
		board.updateReadCount(boardNumber);
	}

	@Override
	public void updateUpCount(String boardNumber) {
		board.updateUpCount(boardNumber);
	}

	@Override
	public void updateDownCount(String boardNumber) {
		board.updateDownCount(boardNumber);
	}

	@Override
	public void updateReportCount(String boardNumber) {
		board.updateReportCount(boardNumber);
	}

	@Override
	public int getReadCount(String boardNumber) {
		return board.getReadCount(boardNumber);
	}

	@Override
	public CountVO getTotalCount(String boardNumber) {
		return board.getTotalCount(boardNumber);
	}

	@Override
	public int deleteBoard(String boardNumber) {
		return board.deleteBoard(boardNumber);
	}

	@Override
	public int insertBoard(BoardVO boardVO, String boardId) {
		map = new HashMap<String, Object>();
		map.put("boardVO", boardVO);
		map.put("boardId", boardId);
		
		return board.insertBoard(map);
	}

	@Override
	public int updateBoard(BoardVO boardVO, String boardNumber) {
		map = new HashMap<String, Object>();
		map.put("boardVO", boardVO);
		map.put("boardNumber", boardNumber);
		return board.updateBoard(map);
	}

	@Override
	public String selectWriter(String boardNumber) {
		return board.selectWriter(boardNumber);
	}

	@Override
	public List<BoardVO> selectAllBoard(int page, String boardId) {
		map = new HashMap<String, Object>();
		startNumber = (page-1)*10+1;
		endNumber = page*10;
		
		map.put("startNumber", startNumber);
		map.put("endNumber", endNumber);
		map.put("boardId", boardId);
		
		return board.selectAllBoard(map);
	}

	@Override
	public int getBoardCount(String boardId) {
		return board.getBoardCount(boardId);
	}

	@Override
	public List<BoardVO> selectAllBoardUp(int page, String boardId, String hitCount) {
		map = new HashMap<String, Object>();
		startNumber = (page-1)*10+1;
		endNumber = page*10;
		
		map.put("startNumber", startNumber);
		map.put("endNumber", endNumber);
		map.put("boardId", boardId);
		map.put("hitCount", hitCount);
		
		return board.selectAllBoardUp(map);
	}

	@Override
	public int getBoardCountUp(String boardId, String hitCount) {
		map = new HashMap<String, Object>();
		map.put("boardId", boardId);
		map.put("hitCount", hitCount);
		
		return board.getBoardCountUp(map);
	}

	@Override
	public List<BoardVO> selectAllBoardDown(int page, String boardId, String hitCount) {
		map = new HashMap<String, Object>();
		startNumber = (page-1)*10+1;
		endNumber = page*10;
		
		map.put("startNumber", startNumber);
		map.put("endNumber", endNumber);
		map.put("boardId", boardId);
		map.put("hitCount", hitCount);
		
		return board.selectAllBoardDown(map);
	}

	@Override
	public int geBoardCountDown(String boardId, String hitCount) {
		map = new HashMap<String, Object>();
		map.put("boardId", boardId);
		map.put("hitCount", hitCount);
		
		return board.getBoardCountDown(map);
	}

	@Override
	public List<BoardVO> selectAllBoardReport(int page) {
		map = new HashMap<String, Object>();
		startNumber = (page-1)*10+1;
		endNumber = page*10;
		
		map.put("startNumber", startNumber);
		map.put("endNumber", endNumber);
		
		return board.selectAllBoardReport(map);
	}

	@Override
	public int getBoardCountReport() {
		return board.getBoardCountReport();
	}

	@Override
	public List<BoardVO> selectAllBoardTotal(int page, String boardId) {
		map = new HashMap<String, Object>();
		startNumber = (page-1)*10+1;
		endNumber = page*10;
		
		map.put("startNumber", startNumber);
		map.put("endNumber", endNumber);
		
		return board.selectAllBoardTotal(map);
	}

	@Override
	public int getBoardCountTotal(String boardId) {
		return board.getBoardCountTotal(map);
	}

	@Override
	public List<BoardVO> selectAllBoardNotice(int page, String boardId) {
		map = new HashMap<String, Object>();
		startNumber = (page-1)*10+1;
		endNumber = page*10;
		
		map.put("startNumber", startNumber);
		map.put("endNumber", endNumber);
		map.put("boardId", boardId);
		
		return board.selectAllBoardNotice(map);
	}

	@Override
	public int getBoardCountNotice(String boardId) {
		return board.getBoardCountNotice(boardId);
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
