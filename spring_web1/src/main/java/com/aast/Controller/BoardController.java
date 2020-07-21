package com.aast.Controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	
	//파일 업로드 경로
	@Resource(name = "uploadPath")
	String uploadPath;
	
	private BoardService board;
	private CommentService comment;
	
	//게시판 리스트
	@RequestMapping(value="boardList", method = {RequestMethod.GET})
	public String boardList() {
		
	}
	
	//게시판 리스트_댓글
	@RequestMapping(value="boardListComment", method = {RequestMethod.GET})
	public String boardListComment() {
		
	}
	
	//게시판 리스트_조회수
	@RequestMapping(value="boardListReadCount", method = {RequestMethod.GET})
	public String boardListReadCount() {
		
	}
	
	//게시판 리스트_추천
	@RequestMapping(value="boardListUp", method = {RequestMethod.GET})
	public String boardListUp() {
		
	}
	
	//게시판 리스트_비추천
	@RequestMapping(value="boardListDown", method = {RequestMethod.GET})
	public String boardListDown() {
		
	}
	
	//게시글 보기(클릭한 글 보기)
	@RequestMapping(value="viewBoard", method = {RequestMethod.GET})
	public String viewBoard() {
		
	}
	
	//게시글 작성
	@RequestMapping(value="writeBoard", method = {RequestMethod.GET})
	public String writeBoard() {
		
	}
	
	//게시글 작성 완료
	@RequestMapping(value="writedBoard", method = {RequestMethod.GET})
	public String writedBoard() {
		
	}
	
	//게시글 수정
	@RequestMapping(value="editBoard", method = {RequestMethod.GET})
	public String editBoard() {
		
	}
	
	//게시글 수정 완료
	@RequestMapping(value="editedBoard", method = {RequestMethod.GET})
	public String editedBoard() {
		
	}
	
	//게시글 삭제
	@RequestMapping(value="deleteBoard", method = {RequestMethod.GET})
	public String deleteBoard() {
		
	}
	
	//게시글 추천
	@RequestMapping(value="upBoard", method = {RequestMethod.GET})
	public String upBoard() {
		
	}
	
	//게시글 비추천
	@RequestMapping(value="downBoard", method = {RequestMethod.GET})
	public String downBoard() {
		
	}
	
	//게시글 신고
	@RequestMapping(value="reportBoard", method = {RequestMethod.GET})
	public String reportBoard() {
		
	}
}
