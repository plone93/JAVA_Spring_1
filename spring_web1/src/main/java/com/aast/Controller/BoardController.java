package com.aast.Controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aast.Domain.BoardVO;
import com.aast.Domain.CommentVO;
import com.aast.Domain.CountVO;
import com.aast.Domain.PageVO;
import com.aast.Service.BoardService;
import com.aast.Service.CommentService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	
	//파일 업로드 경로
	@Resource(name = "uploadPath")
	String uploadPath;
	
	private BoardService board;
	private CommentService comment;
	
	HttpSession session;
	HttpServletRequest request;
	HttpServletResponse response;
	
	Model model;
	MultipartFile file;
	
	//게시판 리스트 @RequestParam("boardId")String boardId
	@RequestMapping(value="boardList", method = {RequestMethod.GET})
	public String boardList(BoardVO boardVO) {
		String url = "";
		int page = 1;/*페이지*/
		int boardCount = 0;/*게시판에 검색된 수*/
		
		/*현재 페이지 값을 받아와서 null이 아니면 page변수에 대입 */
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		PageVO pageVO = new PageVO();
		pageVO.setPage(page);
		
		List<BoardVO> boardList = board.selectAllBoard(boardVO, page);/*게시글을 저장할 리스트 생성*/
		pageVO.setTotalCount(board.getBoardCount(boardVO));
		boardCount = pageVO.getTotalCount();
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("pageVO", pageVO);
		
		/*최상단 공지사항*/
		String noticeBoardId = "";
		List<BoardVO> noticeBoardList = board.selectAllBoardNotice(page, noticeBoardId);
		model.addAttribute("noticeBoardList", noticeBoardList);
		
		/*날아온 message가 있다면 model을 통해서 다시 JSP에 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		return url;
	}
	
	//게시판 리스트_댓글순 @RequestParam("boardId") String boardId
	@RequestMapping(value="boardListComment", method = {RequestMethod.GET})
	public String boardListComment(BoardVO boardVO) {
		
		String url = "";
		int page = 1;/*페이지*/
		int boardCount = 0;/*게시판에 검색된 수*/
		
		/*현재 페이지 값을 받아와서 null이 아니면 page변수에 대입 */
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		PageVO pageVO = new PageVO();
		pageVO.setPage(page);
		
		List<BoardVO> boardList = board.selectBoardComment(boardVO, page);/*게시글을 저장할 리스트 생성*/
		pageVO.setTotalCount(board.getBoardCount(boardVO));
		boardCount = pageVO.getTotalCount();
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("boardVO", boardVO);
		
		/*최상단 공지사항*/
		String noticeBoardId = "";
		List<BoardVO> noticeBoardList = board.selectAllBoardNotice(page, noticeBoardId);
		model.addAttribute("noticeBoardList", noticeBoardList);
		
		/*날아온 message가 있다면 model을 통해서 다시 JSP에 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		return url;
	}
	
	//게시판 리스트_조회수순 @RequestParam("boardId")String boardId
	@RequestMapping(value="boardListReadCount", method = {RequestMethod.GET})
	public String boardListReadCount(BoardVO boardVO) {
		String url = "";
		int page = 1;/*페이지*/
		int boardCount = 0;/*게시판에 검색된 수*/
		
		/*현재 페이지 값을 받아와서 null이 아니면 page변수에 대입 */
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		PageVO pageVO = new PageVO();
		pageVO.setPage(page);
		
		List<BoardVO> boardList = board.selectBoardReadCount(boardVO, page);/*게시글을 저장할 리스트 생성*/
		pageVO.setTotalCount(board.getBoardCount(boardVO));
		boardCount = pageVO.getTotalCount();
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("boardVO", boardVO); 
		
		/*최상단 공지사항*/
		String noticeBoardId = "";
		List<BoardVO> noticeBoardList = board.selectAllBoardNotice(page, noticeBoardId);
		model.addAttribute("noticeBoardList", noticeBoardList);
		
		/*날아온 message가 있다면 model을 통해서 다시 JSP에 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;
	}
	
	//게시판 리스트_추천 @RequestParam("boardId")String boardId
	@RequestMapping(value="boardListUp", method = {RequestMethod.GET})
	public String boardListUp(BoardVO boardVO) {
		String url = "";/*날아갈 주소(경로)*/
		int page = 1;/*페이지*/
		int boardCount = 0;/*게시판에 검색된 수*/
		
		/*현재 페이지 값을 받아와서 null이 아니면 page변수에 대입 */
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		PageVO pageVO = new PageVO();/*PageVO 생성*/
		pageVO.setPage(page);/*페이지 저장*/
		
		List<BoardVO> boardList = board.selectBoardUp(boardVO, page);/*게시글을 저장할 리스트 생성*/
		pageVO.setTotalCount(board.getBoardCount(boardVO));
		boardCount = board.getBoardCount(boardVO);
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("boardVO", boardVO); 
		
		/*최상단 공지사항*/
		String noticeBoardId = "";
		List<BoardVO> noticeBoardList = board.selectAllBoardNotice(page, noticeBoardId);
		model.addAttribute("noticeBoardList", noticeBoardList);
		
		/*날아온 message가 있다면 model을 통해서 다시 JSP에 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;
	}
	
	//게시판 리스트_비추천  @RequestParam("BoardId")String boardId
	@RequestMapping(value="boardListDown", method = {RequestMethod.GET})
	public String boardListDown(BoardVO boardVO) {
		String url = "";/*날아갈 주소(경로)*/
		int page = 1;/*페이지*/
		int boardCount = 0;/*게시판에 검색된 수*/
		
		/*현재 페이지 값을 받아와서 null이 아니면 page변수에 대입 */
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		PageVO pageVO = new PageVO();/*PageVO 생성*/
		pageVO.setPage(page);/*페이지 저장*/
		
		List<BoardVO> boardList = board.selectBoardDown(boardVO, page);/*게시글을 저장할 리스트 생성*/
		pageVO.setTotalCount(board.getBoardCount(boardVO));
		boardCount = board.getBoardCount(boardVO);
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		model.addAttribute("boardVO", boardVO); 
		
		/*최상단 공지사항*/
		String noticeBoardId = "";
		List<BoardVO> noticeBoardList = board.selectAllBoardNotice(page, noticeBoardId);
		model.addAttribute("noticeBoardList", noticeBoardList);
		
		/*날아온 message가 있다면 model을 통해서 다시 JSP에 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;
	}
	
	//게시글 보기(클릭한 글 보기)
	@RequestMapping(value="viewBoard", method = {RequestMethod.GET})
	public String viewBoard(BoardVO boardVO) {
		String url = "";/*날아갈 주소(경로)*/
		int page = 1;/*페이지*/
		
		/*현재 페이지 값을 받아와서 null이 아니면 page변수에 대입 */
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			model.addAttribute("page", page);
		}
		
		List<CommentVO> commentList = comment.selectComment(boardVO.getBoardNumber());
		int readCount = board.getReadCount(boardVO);
		board.updateReadCount(boardVO.getBoardNumber());/*해당글 클릭시 readCount + 1*/
		boardVO = board.viewBoard(boardVO.getBoardNumber());
		//String writer = board.selectWriter(boardVO.getBoardNumber());
		
		/*줄바꿈*/
		String content = boardVO.getContent();
		content = content.replace("\r\n", "<br>"); /*기존 해당 문자열 -> 해당 문자열로 변환*/
		boardVO.setContent(content);
		
		/*jsp로 객체를 전송*/
		model.addAttribute("commentList", commentList);
		model.addAttribute("readCount", readCount);
		model.addAttribute("boardVO", boardVO);
		//model.addAttribute("writer", writer);
		
		/*날아온 message가 있다면 model을 통해서 다시 JSP에 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		
		return url;
	}
	
	//게시글 작성 @RequestParam("boardId")String boardId
	@RequestMapping(value="writeBoard", method = {RequestMethod.GET})
	public String writeBoard(BoardVO boardVO) {
		String url = "";/*날아갈 주소(경로)*/
		model.addAttribute("boardVO", boardVO);
		
		return url;
	}
	
	//게시글 작성 완료  @RequestParam("boardId")String boardId,
	/*spring은 인자에 VO를 기입하면 jsp페이지 변수와 일치하는 값을 VO에 자동 기입해줌*/
	@RequestMapping(value="writedBoard", method = {RequestMethod.GET})
	public String writedBoard(BoardVO boardVO) {
		String url = "";/*날아갈 주소(경로)*/
		String image;
		
		try {
			if(file.getOriginalFilename() != null) {
				image = file.getOriginalFilename();
				boardVO.setImage(image);
				File target = new File(uploadPath, image);
				FileCopyUtils.copy(file.getBytes(), target);/*int, out*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//boardVO.setBoardId(boardId);
		board.insertBoard(boardVO);
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardVO", boardVO);
		
		return url;
	}
	
	//게시글 수정 @RequestParam("boardNumber")int boardNumber,@RequestParam("boardId")String boardId,
	@RequestMapping(value="editBoard", method = {RequestMethod.GET})
	public String editBoard(BoardVO boardVO,
							@RequestParam("page")String page) {
		String url = "";/*날아갈 주소(경로)*/
		boardVO = board.viewBoard(boardVO.getBoardNumber());
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("page", page);
		
		return url;
	}
	
	//게시글 수정 완료 @RequestParam("boardNumber")int boardNumber,@RequestParam("boardId")String boardId,
	@RequestMapping(value="editedBoard", method = {RequestMethod.GET})
	public String editedBoard(BoardVO boardVO,
							  @RequestParam("page")int page) {
		String url = "";/*날아갈 주소(경로)*/
		int result = board.updateBoard(boardVO);
		
		if(result == 1) {/* 1:업데이트 성공*/
			model.addAttribute("message", "갱신완료");
		} else { /*업데이트 실패*/
			model.addAttribute("message", "갱신실패");
		}
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("page", page);
		
		return url;
	}
	
	//게시글 삭제  @RequestParam("boardNumber")int boardNumber,@RequestParam("boardId")String boardId,
	@RequestMapping(value="deleteBoard", method = {RequestMethod.GET})
	public String deleteBoard(BoardVO boardVO,
							  @RequestParam("page")int page) {
		String url = "";/*날아갈 주소(경로)*/
		board.deleteBoard(boardNumber);
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("page", page);
		model.addAttribute("message", "실패했습니다");
		
		return url;
	}
	
	//게시글 추천 @RequestParam("boardNumber")int boardNumber,@RequestParam("boardId")String boardId,
	@RequestMapping(value="upBoard", method = {RequestMethod.GET})
	public String upBoard(BoardVO boardVO,
						  @RequestParam("page")int page) {
		String url = "";/*날아갈 주소(경로)*/
		
		/*쿠키*/
		boolean found = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();/*쿠키를 웹브라우저에서 전부 가져와서 리스트에 넣음*/
		
		/*쿠키 유무 검사*/
		for(int i=0; i < cookies.length; i++) {
			info = cookies[i];
			
			/*해당 게시글과 동일한 쿠키가 있는지 검사*/
			if(info.getName().equals("aastUp"+boardVO.getBoardNumber())) {
				found = true; /*동일한 쿠키를 찾음*/
				break;
			}
		}
		
		String str = ""+System.currentTimeMillis();
		
		if(found) {/*쿠키가 있다면 알림창, found가 true라면 아래 message를 띄움*/
			model.addAttribute("message", "이미 클릭함");
		} else if(!found) {/*쿠키가 없다면*/
			info = new Cookie("aastUp"+boardVO.getBoardNumber(), str);/*두번째 변수 값을 첫번째 변수에 저장(이름, 값)*/
			info.setMaxAge(24*60*60);/*쿠키 유효시간 설정 : 1일(24시간*60분*60초)*/
			response.addCookie(info); /*쿠키 객체를 웹브라우저로 보냄*/
			board.updateUpCount(boardVO.getBoardNumber());
		}
		
		CountVO countVO = board.getTotalCount(boardVO.getBoardNumber());
		
		/*jsp로 객체를 전송*/
		model.addAttribute("countVO", countVO);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("page", page);
		
		return url;
	}
	
	//게시글 비추천
	@RequestMapping(value="downBoard", method = {RequestMethod.GET})
	public String downBoard(BoardVO boardVO,
						    @RequestParam("page")int page) {
		String url = "";/*날아갈 주소(경로)*/
		
		/*쿠키*/
		boolean found = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();/*쿠키를 웹브라우저에서 전부 가져와서 리스트에 넣음*/
		
		/*쿠키 유무 검사*/
		for(int i=0; i < cookies.length; i++) {
			info = cookies[i];
			
			/*해당 게시글과 동일한 쿠키가 있는지 검사*/
			if(info.getName().equals("aastDown"+boardVO.getBoardNumber())) {
				found = true; /*동일한 쿠키를 찾음*/
				break;
			}
		}
		
		String str = ""+System.currentTimeMillis();
		
		if(found) {/*쿠키가 있다면 알림창, found가 true라면 아래 message를 띄움*/
			model.addAttribute("message", "이미 클릭함");
		} else if(!found) {/*쿠키가 없다면*/
			info = new Cookie("aastDown"+boardVO.getBoardNumber(), str);/*두번째 변수 값을 첫번째 변수에 저장(이름, 값)*/
			info.setMaxAge(24*60*60);/*쿠키 유효시간 설정 : 1일(24시간*60분*60초)*/
			response.addCookie(info); /*쿠키 객체를 웹브라우저로 보냄*/
			board.updateDownCount(boardVO.getBoardNumber());
		}
		
		CountVO countVO = board.getTotalCount(boardVO.getBoardNumber());
		
		/*jsp로 객체를 전송*/
		model.addAttribute("countVO", countVO);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("page", page);
		
		return url;
	}
	
	//게시글 신고
	@RequestMapping(value="reportBoard", method = {RequestMethod.GET})
	public String reportBoard(BoardVO boardVO,
							  @RequestParam("page")int page) {
		String url = "";/*날아갈 주소(경로)*/
		
		/*쿠키*/
		boolean found = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();/*쿠키를 웹브라우저에서 전부 가져와서 리스트에 넣음*/
		
		/*쿠키 유무 검사*/
		for(int i=0; i < cookies.length; i++) {
			info = cookies[i];
			
			/*해당 게시글과 동일한 쿠키가 있는지 검사*/
			if(info.getName().equals("aastReport"+boardVO.getBoardNumber())) {
				found = true; /*동일한 쿠키를 찾음*/
				break;
			}
		}
		
		String str = ""+System.currentTimeMillis();
		
		if(found) {/*쿠키가 있다면 알림창, found가 true라면 아래 message를 띄움*/
			model.addAttribute("message", "이미 클릭함");
		} else if(!found) {/*쿠키가 없다면*/
			info = new Cookie("aastReport"+boardVO.getBoardNumber(), str);/*두번째 변수 값을 첫번째 변수에 저장(이름, 값)*/
			info.setMaxAge(24*60*60);/*쿠키 유효시간 설정 : 1일(24시간*60분*60초)*/
			response.addCookie(info); /*쿠키 객체를 웹브라우저로 보냄*/
			board.updateReportCount(boardVO.getBoardNumber());
		}
		
		CountVO countVO = board.getTotalCount(boardVO.getBoardNumber());
		
		/*jsp로 객체를 전송*/
		model.addAttribute("countVO", countVO);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("page", page);
		
		return url;
	}
}
