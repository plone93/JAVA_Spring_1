package com.aast.Service;

import java.util.List;

import www.aast.Domain.BoardVO;
import www.aast.Domain.SearchVO;

public interface SearchService {
	/*일반게시판 검색*/
	public List<BoardVO> search(int page, SearchVO searchVO, String boardId);
	public int searchCount(SearchVO searchVO, String boardId);
	
	/*공지사항게시판 검색*/
	public List<BoardVO> searchNotice(String boardId);
	public List<BoardVO> searchCountNotice(String boardId); 
}
