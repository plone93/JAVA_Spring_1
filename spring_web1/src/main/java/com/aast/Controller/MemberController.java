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
import org.springframework.web.bind.annotation.ResponseBody;

import com.aast.Domain.BoardVO;
import com.aast.Domain.MemberVO;
import com.aast.Domain.PageVO;
import com.aast.Service.BoardService;
import com.aast.Service.CommentService;
import com.aast.Service.LoginService;
import com.aast.Service.MemberService;
import com.aast.Service.SearchService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemberController {
	
	private LoginService login;
	private MemberService member;
	private BoardService board;
	private SearchService search;
	private CommentService comment;
	
	HttpSession session;
	HttpServletRequest request;
	HttpServletResponse response;
	
	Model model;
	
	/*멤버 회원가입*/
	@RequestMapping(value = "insertMember", method = {RequestMethod.GET})
	public String insetMember() {
		String url = "";/*날아갈 주소(경로)*/	
		
		return url;
	}
	
	/*멤버 회원가입 완료*/
	@RequestMapping(value = "insertedMember", method = {RequestMethod.POST})
	public String insetedMember(MemberVO memberVO) {
		String url = "";/*날아갈 주소(경로)*/	
		member.insertMember(memberVO);
		
		/*jsp로 객체를 전송*/
		model.addAttribute("message", "회원가입 성공");
		
		return url;
	}
	
	/*멤버 로그인*/
	@RequestMapping(value = "loginMember", method = {RequestMethod.GET})
	public String loginMember() {
		String url = "";/*날아갈 주소(경로)*/	
		
		return url;
	}
	
	/*멤버 로그인 완료*/
	@RequestMapping(value = "loginedMember", method = {RequestMethod.GET})
	public String loginedMember(@RequestParam("memberId")String memberId,
								@RequestParam("memberPass")String memberPass) {
		String url = "";/*날아갈 주소(경로)*/	
		int result = 0;
		
		result = login.loginMember(memberId, memberPass);/*성공시 1이상의 값이 반환됨*/
		
		if(result >= 1) {/*로그인에 성공했다면*/
			MemberVO memberVO = member.getMember(memberId);/*원래는 고유값인 number를 이용해서 가져와야함*/
			session = request.getSession();/*session을 요청*/
			session.setAttribute("loginMember", memberVO);/*session에 loginMember이름으로 memberVO를 등록*/
			
			/*jsp로 객체를 전송*/
			model.addAttribute("message", " 로그인했습니다");
		} else if(result == 0){/*로그인 실패시*/
			/*jsp로 객체를 전송*/
			model.addAttribute("message", "ID나 비밀번호를 확인해주세요");
			url = "";/*로그인 화면으로 url 변경*/
		}
		
		return url;
	}
	
	/*멤버 정보 수정(수정필요)*/
	@RequestMapping(value = "editMemberProfile", method = {RequestMethod.GET})
	public String editMemberProfile(@RequestParam("memberNumber")String memberNumber) {
		String url = "";/*날아갈 주소(경로)*/	
		MemberVO memberVO = member.getMember(memberNumber);
		
		/*jsp로 객체를 전송*/
		model.addAttribute("memberVO", memberVO);
		
		return url;
	}
	
	/*멤버 정보 수정 완료(수정필요)*/
	@RequestMapping(value = "editedMemberProfile", method = {RequestMethod.POST})
	public String editedMemberProfile(@RequestParam("memberNumber")int memberNumber,
									  MemberVO memberVO) {
		String url = "";/*날아갈 주소(경로)*/	
		int result = 0;
		result = member.updateMember(memberVO, memberNumber);
		
		if(result == 1) { /*정보 수정 갱신에 성공*/
			model.addAttribute("message", "");/*jsp로 객체를 전송*/
		} else if(result == 0) { /*정보수정 갱신에 실패*/
			model.addAttribute("message", "");/*jsp로 객체를 전송*/
		}
		
		return url;
	}
	
	/*내가 작성한글(수정필요)*/
	@RequestMapping(value = "myWriteList", method = {RequestMethod.GET})
	public String myWriteList(@RequestParam("memberNumber")int memberNumber) {
		String url = "";/*날아갈 주소(경로)*/	
		int page = 1;
		int boardCount = 0;
		
		/*현재 페이지 값을 받아와서 null이 아니면 page변수에 대입 */
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			model.addAttribute("page", page);
		}
		
		PageVO pageVO = new PageVO();
		pageVO.setPage(page);
		
		List<BoardVO> boardList = board.selectMyWriteList(page, memberNumber);
		pageVO.setTotalCount(board.selectMyWriteCount(memberNumber));
		boardCount = pageVO.getTotalCount();
		
		/*jsp로 객체를 전송*/
		model.addAttribute("boardList", boardList);
		model.addAttribute("boardCount", boardCount);
		model.addAttribute("pageVO", pageVO);
		
		/*날아온 message가 있다면 model을 통해서 다시 JSP에 보냄*/
		if(request.getParameter("message") != null) {
			model.addAttribute("message", request.getParameter("message"));
		}
		return url;
	}
	
	/*멤버탈퇴*/
	@RequestMapping(value = "deleteMember", method = {RequestMethod.GET})
	public String deleteMember() {
		String url = "";/*날아갈 주소(경로)*/	
		
		return url;
	}
	
	/*멤버탈퇴 완료*/
	@RequestMapping(value = "deletedMember", method = {RequestMethod.POST})
	public String deletedMember(@RequestParam("memberNumber")int memberNumber,
								@RequestParam("memberPass")String memberPass,
								@RequestParam("inputPass")String inputPass) {
		String url = "";/*날아갈 주소(경로)*/	
		
		if(memberPass == inputPass) {/*비밀번호 재입력 값과 세션에 있는 로그인 비밀번호가 일치하면*/
			member.deleteMember(memberNumber);/**/
			model.addAttribute("message", "계정삭제 완료");/*jsp로 객체를 전송*/
		} else {
			model.addAttribute("message", "계정삭제 실패");/*jsp로 객체를 전송*/
		}
		
		return url;
	}
	/*로그아웃*/
	@RequestMapping(value = "logout", method = {RequestMethod.GET})
	public String logout() {
		String url = "";/*날아갈 주소(경로)*/	
		
		session = request.getSession();/*세션을 가져와서 변수에 입력*/
		session.invalidate();/*가져온 세션을 삭제*/
		
		/*jsp로 객체를 전송*/
		model.addAttribute("message", "로그아웃했습니다");/*jsp로 객체를 전송*/
		
		return url;
	}
	
	/*멤버아이디 중복 체크*/
	@ResponseBody
	@RequestMapping(value = "checkId", method = {RequestMethod.POST})
	public int checkId(@RequestParam("memberId")String memberId) {
		int check = 0;
		int result = 0;/*jsp에서 ajax를 통해 결과를 알려줄 변수*/
		
		/*아이디 중복체크 메소드를 실행해서 결과를 리턴*/
		check = member.checkId(memberId);
		
		if(check == 1) {/*중복된 아이디가 검색되었다면*/
			result = 1;/* 1이면 중복된 이메일 검색되서 1이상이 리턴됐으므로 사용불가, 검색된 행의 갯수를 리턴함 */
		} else if(check == 0) {/*중복된 아이디가 검색되지 않았다면*/
			
		}
		
		return result;
	}
	
	/*멤버이름 중복 체크*/
	@ResponseBody
	@RequestMapping(value = "checkName", method = {RequestMethod.POST})
	public int checkName(@RequestParam("memberName")String memberName) {
		int check = 0;
		int result = 0;/*jsp에서 ajax를 통해 결과를 알려줄 변수*/
		
		/*이름 중복체크 메소드를 실행해서 결과를 리턴*/
		check = member.checkName(memberName);
		
		if(check == 1) {/*중복된 아이디가 검색되었다면*/
			result = 1;/* 1이면 중복된 이메일 검색되서 1이상이 리턴됐으므로 사용불가, 검색된 행의 갯수를 리턴함 */
		} else if(check == 0) {/*중복된 아이디가 검색되지 않았다면*/
			/*갱신*/
		}
		
		return result;
	}
	
	/*이메일 중복체크 후 갱신*/
	@ResponseBody
	@RequestMapping(value = "updateEmail", method = {RequestMethod.POST})
	public int updateEmail(@RequestParam("memberNumber")int memberNumber,
						   @RequestParam("memberEmail")String memberEmail) {
		int check = 0;
		int result = 0;/*jsp에서 ajax를 통해 결과를 알려줄 변수*/
		
		/*이메일 중복체크 메소드를 실행해서 결과를 리턴*/
		check = member.checkEmail(memberEmail);
		
		if(check == 1) {/*중복된 아이디가 검색되었다면*/
			result = 1;/* 1이면 중복된 이메일 검색되서 1이상이 리턴됐으므로 사용불가, 검색된 행의 갯수를 리턴함 */
		} else if(check == 0) {/*중복된 아이디가 검색되지 않았다면*/
			member.updateEmail(memberNumber, memberEmail);/*갱신*/
		}
		
		return result;
	}
	

	
	/*닉네임 중복체크후 갱신  수정필요*/
	@ResponseBody
	@RequestMapping(value = "updateNickName", method = {RequestMethod.POST})
	public int updateNickName(@RequestParam("memberNumber")int memberNumber,
							  @RequestParam("memberNickName")String memberNickName) {
		int check = 0;
		int result = 0;/*jsp에서 ajax를 통해 결과를 알려줄 변수*/
		
		/*이메일 중복체크 메소드를 실행해서 결과를 리턴*/
		//check = member.checkName(memberNickName);
		
		if(check == 1) {/*중복된 아이디가 검색되었다면*/
			result = 1;/* 1이면 중복된 이메일 검색되서 1이상이 리턴됐으므로 사용불가, 검색된 행의 갯수를 리턴함 */
		} else if(check == 0) {/*중복된 아이디가 검색되지 않았다면*/
		//	member.updateNickName(memberNumber, memberNickName);/*갱신*/
		}
		
		return result;
	}
	

	
	/*비밀번호 갱신*/
	@ResponseBody
	@RequestMapping(value = "updatePass", method = {RequestMethod.POST})
	public int updatePass(@RequestParam("memberNumber")int memberNumber,
						   @RequestParam("memberPass")String memberPass) {
		int check = 0;
		int result = 0;/*jsp에서 ajax를 통해 결과를 알려줄 변수*/
		
		/*비밀번호 갱신, 성공시 result에 값이 반영됨*/
		result = member.updatePass(memberNumber, memberPass);
		
		return result;
	}
	
	/*이름 갱신*/
	@ResponseBody
	@RequestMapping(value = "updateName", method = {RequestMethod.POST})
	public int updateName(MemberVO memberVO) {/*VO를 인자로 받으면  멤버필드에 선언된 변수에 맞는 값을 자동으로 입력*/
		int check = 0;
		int result = 0;/*jsp에서 ajax를 통해 결과를 알려줄 변수*/
		
		/*이름 갱신, 성공시 result에 값이 반영됨*/
		result = member.updateName(memberVO.getMemberNumber(),
								   memberVO.getMemberName());
		
		return result;
	}
	
	/*주소 갱신*/
	@ResponseBody
	@RequestMapping(value = "updateAddress", method = {RequestMethod.POST})
	public int updateAddress(MemberVO memberVO) {/*VO를 인자로 받으면  멤버필드에 선언된 변수에 맞는 값을 자동으로 입력*/
		int check = 0;
		int result = 0;/*jsp에서 ajax를 통해 결과를 알려줄 변수*/
		
		/*이름 갱신, 성공시 result에 값이 반영됨*/
		result = member.updateAddress(memberVO.getMemberNumber(),
									  memberVO.getAddressA(),
									  memberVO.getAddressB());
		
		return result;
	}
	
	/*전화번호 갱신*/
	@ResponseBody
	@RequestMapping(value = "updatePhoneNumber", method = {RequestMethod.POST})
	public int updatePhoneNumber(MemberVO memberVO) {/*VO를 인자로 받으면  멤버필드에 선언된 변수에 맞는 값을 자동으로 입력*/
		int check = 0;
		int result = 0;/*jsp에서 ajax를 통해 결과를 알려줄 변수*/
		
		/*이름 갱신, 성공시 result에 값이 반영됨*/
		result = member.updatePhoneNumber(memberVO.getMemberNumber(),
										  memberVO.getPhoneNumber());
		
		return result;
	}
}
