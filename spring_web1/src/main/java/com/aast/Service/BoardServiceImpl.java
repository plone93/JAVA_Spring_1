package com.aast.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aast.Domain.BoardVO;
import com.aast.Domain.CountVO;
import com.aast.Domain.MemberVO;
import com.aast.Mapper.BoardMapper;

import lombok.AllArgsConstructor;

//@Component
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
		
	BoardMapper board;
	
	@Override
	public BoardVO viewBoard(BoardVO boardVO) {
		return board.viewBoard(boardVO);
	}

	@Override
	public String selectMemberName(BoardVO boardVO) {
		return board.selectMemberName(boardVO);
	}

	@Override
	public void updateReadCount(BoardVO boardVO) {
		board.updateReadCount(boardVO);
	}

	@Override
	public void updateUpCount(BoardVO boardVO) {
		board.updateUpCount(boardVO);
	}

	@Override
	public void updateDownCount(BoardVO boardVO) {
		board.updateDownCount(boardVO);
	}

	@Override
	public void updateReportCount(BoardVO boardVO) {
		board.updateReportCount(boardVO);
	}

	@Override
	public int getReadCount(BoardVO boardVO) {
		return board.getReadCount(boardVO);
	}

	@Override
	public CountVO getTotalCount(BoardVO boardVO) {
		return board.getTotalCount(boardVO);
	}

	@Override
	public int deleteBoard(BoardVO boardVO) {
		return board.deleteBoard(boardVO);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return board.insertBoard(boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return board.updateBoard(boardVO);
	}

	@Override
	public String selectWriter(BoardVO boardVO) {
		return board.selectWriter(boardVO);
	}

	@Override
	public List<BoardVO> selectAllBoard(BoardVO boardVO, int page) {
		boardVO.setPageStartNumber((page-1)*10+1); 
		boardVO.setPageEndNumber(page*10);

		return board.selectAllBoard(boardVO);
	}

	@Override
	public int getBoardCount(BoardVO boardVO) {
		return board.getBoardCount(boardVO);
	}

	@Override
	public List<BoardVO> selectAllBoardUp(BoardVO boardVO, int page) {
		boardVO.setPageStartNumber((page-1)*10+1); 
		boardVO.setPageEndNumber(page*10);


		return board.selectAllBoardUp(boardVO);
	}

	@Override
	public int getBoardCountUp(BoardVO boardVO) {
		return board.getBoardCountUp(boardVO);
	}

	@Override
	public List<BoardVO> selectAllBoardDown(BoardVO boardVO, int page) {
		boardVO.setPageStartNumber((page-1)*10+1); 
		boardVO.setPageEndNumber(page*10);
		
		return board.selectAllBoardDown(boardVO);
	}

	@Override
	public int geBoardCountDown(BoardVO boardVO) {
		return board.getBoardCountDown(boardVO);
	}

	@Override
	public List<BoardVO> selectAllBoardReport(int page) {
		BoardVO boardVO = new BoardVO();
		boardVO.setPageStartNumber((page-1)*10+1); 
		boardVO.setPageEndNumber(page*10);
	
		return board.selectAllBoardReport(boardVO);
	}

	@Override
	public int getBoardCountReport() {
		return board.getBoardCountReport();
	}

	@Override
	public List<BoardVO> selectAllBoardTotal(BoardVO boardVO, int page) {
		boardVO.setPageStartNumber((page-1)*10+1); 
		boardVO.setPageEndNumber(page*10);
		
		return board.selectAllBoardTotal(boardVO);
	}

	@Override
	public int getBoardCountTotal(BoardVO boardVO) {
		return board.getBoardCountTotal(boardVO);
	}

	@Override
	public List<BoardVO> selectAllBoardNotice(BoardVO boardVO, int page) {
		boardVO.setPageStartNumber((page-1)*10+1); 
		boardVO.setPageEndNumber(page*10);
		
		return board.selectAllBoardNotice(boardVO);
	}

	@Override
	public int getBoardCountNotice(BoardVO boardVO) {
		return board.getBoardCountNotice(boardVO);
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
	public List<BoardVO> selectBoardComment(BoardVO boardVO, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectBoardReadCount(BoardVO boardVO, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectBoardUp(BoardVO boardVO, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectBoardDown(BoardVO boardVO, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectMyWriteList(MemberVO memberVO, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectMyWriteCount(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
