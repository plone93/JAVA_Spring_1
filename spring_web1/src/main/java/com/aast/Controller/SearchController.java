package com.aast.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aast.Domain.BoardVO;
import com.aast.Domain.PageVO;
import com.aast.Domain.SearchVO;
import com.aast.Service.BoardService;
import com.aast.Service.CommentService;
import com.aast.Service.LoginService;
import com.aast.Service.MemberService;
import com.aast.Service.SearchService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SearchController {
	private LoginService login;
	private MemberService member;
	private BoardService board;
	private SearchService search;
	private CommentService comment;
	
	HttpSession session;
	HttpServletRequest request;
	HttpServletResponse response;
	
	Model model;
	
	/*검색*/
	@RequestMapping(value = "searchBoard", method = {RequestMethod.POST})
	public String searchBoard(@RequestParam("boardId")String boardId,
							  SearchVO searchVO) {
		String url = "";/*날아갈 주소(경로)*/	
		int page = 1;/*페이지*/
		int boardCount = 0;/*게시판에 검색된 수*/
		
		/*현재 페이지 값을 받아와서 null이 아니면 page변수에 대입 */
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		PageVO pageVO = new PageVO();/*PageVO 생성*/
		pageVO.setPage(page);/*페이지 저장*/
		
		List<BoardVO> boardList = search.search(page, searchVO, boardId);
		pageVO.setTotalCount(search.searchCount(searchVO, boardId));
		boardCount = pageVO.getTotalCount();
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("boardId", boardId);
			
		/*최상단 공지사항*/
		String noticeBoardId = "";
		List<BoardVO> noticeBoardList = board.selectAllBoardNotice(page, noticeBoardId);
		model.addAttribute("noticeBoardList", noticeBoardList);
		
		/*리다이렉트로 날아온 메세지가 있다면 jsp로 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		return url;
	}
	
	/*토탈 검색*/
	@RequestMapping(value = "searchBoardTotal", method = {RequestMethod.POST})
	public String searchBoardTotal() {
		String url = "";/*날아갈 주소(경로)*/	
		int page = 1;/*페이지*/
		int boardCount = 0;/*게시판에 검색된 수*/
		
		/*현재 페이지 값을 받아와서 null이 아니면 page변수에 대입 */
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		PageVO pageVO = new PageVO();/*PageVO 생성*/
		pageVO.setPage(page);/*페이지 저장*/
		
		
		return url;
	}
}
