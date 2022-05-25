package com.spring.training.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.training.board.dto.BoardDto;
import com.spring.training.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/boardWrite" , method=RequestMethod.GET)
	public ModelAndView boardwrite() {
		return new ModelAndView("board/bWrite");
	}
	
	@RequestMapping(value="/boardWrite" , method=RequestMethod.POST)
	public ModelAndView boardwrite(BoardDto boardDto) {
		
		boardService.insertBoard(boardDto);
		//return new ModelAndView("board/bList");	   // jsp파일로 포워딩
		return new ModelAndView("redirect:boardList"); // redirect:이후 url로 이동
		
	}
	
	@RequestMapping(value="/boardList" , method=RequestMethod.GET)
	public ModelAndView boardList() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/bList");
		mv.addObject("boardList" , boardService.getBoardList());
		
		return mv;
		
	}
	
	@RequestMapping(value="boardInfo" , method=RequestMethod.GET)
	public ModelAndView boardInfo(@RequestParam("num") int num) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/bInfo");
		mv.addObject("boardDto" , boardService.getOneBoard(num));
		
		return mv;
		
	}
	
	@RequestMapping(value="/boardUpdate" , method=RequestMethod.GET)
	public ModelAndView boardUpdate(@RequestParam("num") int num) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/bUpdate");
		mv.addObject("boardDto" , boardService.getOneBoard(num));
		
		return mv;
		
	}
	
	@RequestMapping(value="/boardUpdate" , method=RequestMethod.POST)
	public @ResponseBody String boardUpdate(BoardDto boardDto , HttpServletRequest request) {
		
		String htmlBody = "";
		if (boardService.updateBoard(boardDto)) {
			htmlBody = "<script>";
			htmlBody += "alert('It is changed');";
			htmlBody += "location.href='" + request.getContextPath() + "/board/boardList';";
			htmlBody += "</script>";
		}
		else {
			htmlBody = "<script>";
			htmlBody += "alert('Check your Id and Password');";
			htmlBody += "history.go(-1);";
			htmlBody += "</script>";
		}
		
		return htmlBody;
		
	} 
	
	@RequestMapping(value="/boardDelete" , method=RequestMethod.GET)
	public ModelAndView boardDelete(@RequestParam("num") int num) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/bDelete");
		mv.addObject("boardDto" , boardService.getOneBoard(num));
		
		return mv;
		
	}
	
	@RequestMapping(value="/boardDelete" , method=RequestMethod.POST)
	public @ResponseBody String boardDelete(BoardDto boardDto , HttpServletRequest request) {
		
		String htmlBody = "";
		if (boardService.deleteBoard(boardDto)) {
			htmlBody = "<script>";
			htmlBody += "alert('It has been deleted.');";
			htmlBody += "location.href='" + request.getContextPath() + "/board/boardList';";
			htmlBody += "</script>";
		}
		else {
			htmlBody = "<script>";
			htmlBody += "alert('Check your Id and Password');";
			htmlBody += "history.go(-1);";
			htmlBody += "</script>";
		}
		
		return htmlBody;
	}
	
	
}