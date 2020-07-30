package com.aast.Service;

import java.util.List;

import www.aast.Domain.BoardVO;
import www.aast.Domain.MemberVO;
import www.aast.Domain.SearchVO;

public interface SearchService {
	/*일반게시판 검색*/
	public List<BoardVO> search(int page, SearchVO searchVO, String boardId);
	public int searchCount(SearchVO searchVO, String boardId);
	
	/*공지사항게시판 검색*/
	public List<BoardVO> searchNotice(String boardId);
	public List<BoardVO> searchCountNotice(String boardId);
	
	/*추천  검색*/
	public List<BoardVO> searchUp(int page, SearchVO searchVO, String hitCount); //추천,비추천 게시판 내 검색 후 해당 게시글 리스트 
	public int searchUpCount(SearchVO searchVO, String hitCount); //추천,비추천 게시판 내 검색 후 몇건 검색 됐는지
	
	/*비추천  검색*/
	public List<BoardVO> searchDown(int page, SearchVO searchVO, String hitCount); //추천,비추천 게시판 내 검색 후 해당 게시글 리스트 
	public int searchDownCount(SearchVO searchVO, String hitCount); //추천,비추천 게시판 내 검색 후 몇건 검색 됐는지
	
	/*신고 검색*/
	public List<BoardVO> searchReport(int page, SearchVO searchVO);
	public int searchReportCount(SearchVO searchVO);
	
	/*통합 게시판 검색*/
	public List<BoardVO> searchTotal(int page, SearchVO searchVO);
	public int searchTotalCount(SearchVO searchVO);
	
	/*회원관리 검색*/
	public List<MemberVO> searchMember(int page, SearchVO searchVO);
	public int searchMemberCount(SearchVO searchVO);
	
	/*상품 게시판 검색*/
	public List<BoardVO> searchProduct(int page, SearchVO searchVO, String board_id); // 게시판 내 검색
	public int searchProductCount(SearchVO searchVO, String board_id); // 검색한 내용으로 몇개 검색 됐는지 가져옴
}
