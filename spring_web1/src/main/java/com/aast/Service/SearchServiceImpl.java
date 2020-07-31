package com.aast.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aast.Domain.BoardVO;
import com.aast.Domain.MemberVO;
import com.aast.Domain.SearchVO;
import com.aast.Mapper.SearchMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {
	
	SearchMapper search;
	HashMap<String, Object> map;
	int startNumber;
	int endNumber;
	
	@Override
	public List<BoardVO> search(int page, SearchVO searchVO, String boardId) {
		map = new HashMap<String, Object>();
		startNumber = (page-1)*10+1;
		endNumber = page*10;
		
		map.put("startNumber", startNumber);
		map.put("endNumber", endNumber);
		map.put("searchVO", searchVO);
		map.put("boardId", boardId);
		
		return search.search(map);
	}

	@Override
	public int searchCount(SearchVO searchVO, String boardId) {
		map = new HashMap<String, Object>();
		
		map.put("searchVO", searchVO);
		map.put("boardId", boardId);
		
		return search.searchCount(map);
	}

	@Override
	public List<BoardVO> searchNotice(String boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> searchCountNotice(String boardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> searchUp(int page, SearchVO searchVO, int hitCount) {
		map = new HashMap<String, Object>();
		startNumber = (page-1)*10+1;
		endNumber = page*10;
		
		map.put("startNumber", startNumber);
		map.put("endNumber", endNumber);
		map.put("searchVO", searchVO);
		map.put("hitCount", hitCount);
		
		return search.searchUp(map);
	}

	@Override
	public int searchUpCount(SearchVO searchVO, int hitCount) {
		map = new HashMap<String, Object>();
		
		map.put("searhVO", searchVO);
		map.put("hitCount", hitCount);
		
		return search.searchUpCount(map);
	}

	@Override
	public List<BoardVO> searchDown(int page, SearchVO searchVO, int hitCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchDownCount(SearchVO searchVO, int hitCount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> searchReport(int page, SearchVO searchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchReportCount(SearchVO searchVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> searchTotal(int page, SearchVO searchVO) {
		map = new HashMap<String, Object>();
		startNumber = (page-1)*10+1;
		endNumber = page*10;
		
		map.put("startNumber", startNumber);
		map.put("endNumber", endNumber);
		map.put("searchVO", searchVO);

		return search.searchTotal(map);
	}

	@Override
	public int searchTotalCount(SearchVO searchVO) {
		map = new HashMap<String, Object>();
	
		map.put("searchVO", searchVO);

		return search.searchTotalCount(map);
	}

	@Override
	public List<MemberVO> searchMember(int page, SearchVO searchVO) {
		map = new HashMap<String, Object>();
		startNumber = (page-1)*10+1;
		endNumber = page*10;
		
		map.put("startNumber", startNumber);
		map.put("endNumber", endNumber);
		map.put("searchVO", searchVO);
		
		return search.searchMember(map);
	}

	@Override
	public int searchMemberCount(SearchVO searchVO) {
		map = new HashMap<String, Object>();
		
		map.put("searchVO", searchVO);
		
		return search.searchMemberCount(map);
	}

	@Override
	public List<BoardVO> searchProduct(int page, SearchVO searchVO, String board_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchProductCount(SearchVO searchVO, String board_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
 