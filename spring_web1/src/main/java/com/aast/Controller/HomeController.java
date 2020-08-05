package com.aast.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.aast.Domain.BoardVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		int number = 1111;
		String str = "aaa";
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardNumber(1);
		boardVO.setBoardId("abc");
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("boardVO", boardVO);
		
		return "home";
	}
	//RequestMapping(value = "test", method = RequestMethod.POST)// Spring ver2~
	@ResponseBody
	@PostMapping(value="test",consumes="application/json")
	public String test(@RequestBody BoardVO boardVO,
					   Model model) {
		
		//boardVO.setBoardNumber(Integer.parseInt(request.getParameter("boardNumber")));
		//boardVO.setBoardId(request.getParameter("boardId"));

		System.out.println(boardVO);

		model.addAttribute("number", boardVO);//ObjectをJSPに転送
		return "home";
	}
	
}
