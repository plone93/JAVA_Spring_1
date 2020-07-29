package com.aast.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aast.Service.BoardService;
import com.aast.Service.CommentService;
import com.aast.Service.LoginService;
import com.aast.Service.MemberService;
import com.aast.Service.SearchService;

import lombok.AllArgsConstructor;
import www.aast.Domain.BoardVO;
import www.aast.Domain.CommentVO;

@Controller
@AllArgsConstructor
public class CommentController {
	
	private LoginService login;
	private MemberService member;
	private BoardService board;
	private SearchService search;
	private CommentService comment;
	
	HttpSession session;
	HttpServletRequest request;
	HttpServletResponse response;
	
	Model model;
	
	//댓글 작성
	@RequestMapping(value = "writeComment", method = {RequestMethod.GET})
	public String writeComment(@RequestParam("boardNumber")String boardNumber,
							   @RequestParam("boardId")String boardId,
							   @RequestParam("Page")String page,
							   CommentVO commentVO,
							   Model model) {
		String url = "";/*날아갈 주소(경로)*/
		int result = 0;
		int commentCount = 0;
		
		commentVO.setBoardId(boardId);/*commentVO에 boardId를 입력*/
		result = comment.writeComment(commentVO);/*댓글작성함수 호출, 성공시 SQL에서 resultType= int 1반환*/
		if(result == 1) {
			commentCount = comment.getCommentCount(boardNumber);/*해당 글에 몇개의 댓글이 작성됐는지 검색해서  VO에 넣음 */
			comment.updateCommentCount(commentCount, boardNumber);
			model.addAttribute("message", "댓글작성 성공");
		} else {
			model.addAttribute("message", "댓글작성 실패");
		}
		
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardNumber", boardNumber);
		model.addAttribute("page", page);
		
		return url;
		
	}
	
	//댓글 수정
	@RequestMapping(value = "editComment", method = {RequestMethod.GET})
	public String editComment(@RequestParam("boardNumber")String boardNumber,
							  @RequestParam("boardId")String boardId,
							  @RequestParam("commentNumber")String commentNumber,
							  @RequestParam("page")String page) {
		String url = "";/*날아갈 주소(경로)*/
		
		int readCount = board.getReadCount(boardNumber);/*해당 board의 조회수를 가져와서 변수에 저장*/
		board.updateReadCount(boardNumber);/*조회수 업데이트*/
		BoardVO boardVO = board.viewBoard(boardNumber);
		CommentVO commentVO = comment.viewComment(commentNumber);
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardNumber", boardNumber);
		model.addAttribute("boardVO", boardVO);
		model.addAttribute("commentVO", commentVO);
		model.addAttribute("boardId", boardId);
		model.addAttribute("readCount", readCount);
		model.addAttribute("page", page);
		
		return url;
	}
	
	//댓글 수정완료
	@RequestMapping(value = "editedComment", method = {RequestMethod.POST})
	public String editedComment(@RequestParam("boardNumber")String boardNumber,
								@RequestParam("boardId")String boardId,
								@RequestParam("commentNumber")String commentNumber,
								@RequestParam("page")String page,
								CommentVO commentVO) {
		String url = "";/*날아갈 주소(경로)*/
		
		comment.updateComment(commentVO, commentNumber);/*댓글 수정 실행*/
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardNumber", boardNumber);
		model.addAttribute("page", page);
		
		return url;
	}
	
	//댓글 수정완료
	@RequestMapping(value = "editedComment", method = {RequestMethod.POST})
	public String deleteComment(@RequestParam("boardNumber")String boardNumber,
								@RequestParam("boardId")String boardId,
								@RequestParam("commentNumber")String commentNumber) {
		
		String url = "";/*날아갈 주소(경로)*/
		int result = 0;
		int commentCount = 0;
		
		/*SQL이 실행되면 resultType int 결과 값에 따라 int형이 반환됨*/
		result = comment.deleteComment(commentNumber);
		
		if(result == 1) {/*댓글 삭제 성공*/
			commentCount = comment.getCommentCount(boardNumber);/*현재 commentCount를 가져와서*/
			comment.updateCommentCount(commentCount, boardNumber);/*commentCount를 +1*/
			model.addAttribute("message", "댓글삭제 성공");
		} else {/*댓글 삭제 실패*/
			model.addAttribute("message", "댓글삭제 실패");
		}
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardId", boardId);
		model.addAttribute("boardNumber", boardNumber);
		
		return url;
	}
}
