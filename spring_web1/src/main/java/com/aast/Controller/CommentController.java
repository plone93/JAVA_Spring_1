package com.aast.Controller;

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
import www.aast.Domain.CommentVO;

@Controller
@AllArgsConstructor
public class CommentController {
	
	private LoginService login;
	private MemberService member;
	private BoardService board;
	private SearchService search;
	private CommentService comment;
	
	//댓글 작성
	@RequestMapping(value = "writecomment", method = {RequestMethod.GET})
	public String writeComment(@RequestParam("boardNumber")String boardNumber,
							   @RequestParam("boardId")String boardId,
							   @RequestParam("Page")String page,
							   CommentVO commentVO,
							   Model model) {
		String url = "redirect:viewBoard";
		int result = 0;
		int commentCount = 0;
		
		if(result == 1) {
			
		}
		
		return url;
		
	}
}
