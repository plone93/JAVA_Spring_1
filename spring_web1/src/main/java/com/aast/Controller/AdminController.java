package com.aast.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aast.Service.BoardService;
import com.aast.Service.CommentService;
import com.aast.Service.LoginService;
import com.aast.Service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AdminController {
	
	private LoginService login;
	private MemberService member;
	private BoardService board;
	private CommentService comment;
	
	//관리자 로그인
	@RequestMapping(value = "/getList", method = {RequestMethod.GET})
	public String loginAdmin() {
		String url = "";
		return url;
	}
	
	//관리자 로그인 완료
	@RequestMapping(value = "/loginAdmin", method = {RequestMethod.GET})
	public String loginedAdmin(@RequestParam("adminId")String adminId,
							   @RequestParam("adminPass")String adminPass,
							   Model model) {
		String url = "redirect:/main";
		int result = 0;
		return url;
	}
	
	//관리자 이메일 갱신
	@ResponseBody
	@RequestMapping(value = "/updateAdminEmail", method = {RequestMethod.POST})
	public int UpdateAdminEmail() {
		
	}
	
	//관리자 닉네임 변경
	@ResponseBody
	@RequestMapping(value="updateAdminNickName", method = {RequestMethod.POST})
	public int UpdateAdminNickName() {
		
	}
	
	//관리자 비밀번호 변경
	@ResponseBody
	@RequestMapping(value="updateAdminPass", method = {RequestMethod.POST})
	public int UpdateAdminPass() {
		
	}

}
