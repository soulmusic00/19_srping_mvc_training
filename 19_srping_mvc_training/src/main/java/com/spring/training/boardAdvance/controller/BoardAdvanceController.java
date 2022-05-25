package com.spring.training.boardAdvance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.training.boardAdvance.dto.BoardAdvanceDto;
import com.spring.training.boardAdvance.service.BoardAdvanceService;


@Controller
@RequestMapping("boardAdvance")
public class BoardAdvanceController {

	@Autowired								
	private BoardAdvanceService boardAdvanceService;		
	
	@RequestMapping(value="/boardList" , method=RequestMethod.GET)
	public ModelAndView boardList(@RequestParam(name = "onePageViewCount"  , defaultValue = "10")    int onePageViewCount,
								  @RequestParam(name = "currentPageNumber" , defaultValue = "1")     int currentPageNumber,
								  @RequestParam(name = "searchKeyword"     , defaultValue = "total") String searchKeyword,
								  @RequestParam(name = "searchWord"        , defaultValue = "")      String searchWord) throws Exception {
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardAdvance/boardList");
		
		
		// 페이지의 시작 게시글 인덱스
		int startBoardIdx =  (currentPageNumber -1) * onePageViewCount + 1;
		if (currentPageNumber == 1) startBoardIdx = 0;
		
		
		// 관련 정보 Map 생성 ( 한페이지에 보여줄 게시글 숫자 , 시작페이지의 인덱스 , 검색 키워드 , 검색어 ) 
		Map<String, Object> searchInfo = new HashMap<String, Object>();
		searchInfo.put("onePageViewCount", onePageViewCount);
		searchInfo.put("startBoardIdx", startBoardIdx);
		searchInfo.put("searchKeyword", searchKeyword);
		searchInfo.put("searchWord", searchWord);
		List<BoardAdvanceDto> boardList = boardAdvanceService.getSearchBoard(searchInfo);
		
		// 게시글의 전체 개수를 반환하는 관련정보 Map 생성 ( 검색 키워드 , 검색어 ) 
		Map<String, String> searchCountInfo = new HashMap<String, String>();
		searchCountInfo.put("searchKeyword", searchKeyword);
		searchCountInfo.put("searchWord", searchWord);
		
		// 전체페이지 개수 = 전체게시글 수 / 한페이지에서 보여지는 글수
		int totalBoardCount = boardAdvanceService.getAllBoardCount(searchCountInfo);
		int addPage = totalBoardCount % onePageViewCount == 0 ? 0 : 1; 		// 나머지가 0이면 추가 x , 나머지가 0이 아니면 +1 페이지 처리
		int totalPageCount = totalBoardCount / onePageViewCount + addPage;
		
		
		// 시작페이지
		int startPage = 1;
		
		if (currentPageNumber % 10 == 0) startPage = (currentPageNumber / 10 - 1) * 10 + 1;
		else 							 startPage = (currentPageNumber / 10) * 10 + 1;							
		
		/*
		 
			[ 예시 ]  
			
			currentPage가 10페이면 시작페이지는 1  		<>		currentPage가 2페이지면  시작페이지는 1  
			currentPage가 20페이면 시작페이지는 11  	<>		currentPage가 12페이지면 시작페이지는 11  
			currentPage가 30페이면 시작페이지는 21 		<>		currentPage가 22페이지면 시작페이지는 21  
			
		*/
		
	
		
		// 끝페이지
		int endPage = startPage + 9;
			
		// 끝페이지가 전체 페이지 개수보다 크다면 
		if (endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		// 게시물이 한페이지에 보여지는 것보다 작다면
		if (onePageViewCount > totalBoardCount) {
			startPage = 1;
			endPage = 0;
		}
		
				
		mv.addObject("startPage"         , startPage);
		mv.addObject("endPage"           , endPage);
		mv.addObject("totalBoardCount"   , totalBoardCount);
		mv.addObject("onePageViewCount"  , onePageViewCount);
		mv.addObject("currentPageNumber" , currentPageNumber);
		mv.addObject("searchKeyword"     , searchKeyword);
		mv.addObject("searchWord"        , searchWord);
		mv.addObject("boardList"         , boardList);		
		
		/*
		System.out.println("====================================");
		System.out.println("startPage : "         + startPage);
		System.out.println("endPage : "           + endPage);
		System.out.println("totalBoardCount : "   + totalBoardCount);
		System.out.println("onePageViewCount : "  + onePageViewCount);
		System.out.println("currentPageNumber : " + currentPageNumber);
		System.out.println("searchKeyword : "     + searchKeyword);
		System.out.println("searchWord : "        + searchWord);
		System.out.println("====================================\n");
		*/
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/boardWrite" , method=RequestMethod.GET)
	public ModelAndView boardWrite() throws Exception{
		return new ModelAndView("boardAdvance/boardWrite");
	}
	
	
	@RequestMapping(value="/boardWrite" , method=RequestMethod.POST)
	public ModelAndView boardWrite(BoardAdvanceDto boardAdvanceDto) throws Exception{
		boardAdvanceService.insertBoard(boardAdvanceDto);
		return new ModelAndView("redirect:/boardAdvance/boardList");	
	}
	
	
	@RequestMapping(value="/boardReplyWrite" , method=RequestMethod.GET)
	public ModelAndView boardReplyWrite(@RequestParam("num") int num) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardAdvance/boardReply");
		mv.addObject("boardAdvanceDto" , boardAdvanceService.getOneBoard(num));
		
		return mv;
	
	}
	
	
	@RequestMapping(value="/boardReplyWrite" , method=RequestMethod.POST)
	public ModelAndView boardReplyWrite(BoardAdvanceDto boardAdvanceDto) throws Exception{
		boardAdvanceService.insertReplyBoard(boardAdvanceDto);
		return new ModelAndView("redirect:/boardAdvance/boardList");	
	}
	
	
	@RequestMapping(value="/boardInfo"  , method=RequestMethod.GET)
	public ModelAndView boardInfo(@RequestParam("num") int num) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardAdvance/boardInfo");
		mv.addObject("boardAdvanceDto" , boardAdvanceService.getOneBoard(num));
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/boardUpdate" , method=RequestMethod.GET)
	public ModelAndView boardUpdate(@RequestParam("num") int num) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardAdvance/boardUpdate");
		mv.addObject("boardAdvanceDto" , boardAdvanceService.getOneBoard(num));
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/boardUpdate" , method=RequestMethod.POST)
	public ResponseEntity<Object> boardUpdate(BoardAdvanceDto boardAdvanceDto , HttpServletRequest request) throws Exception{
		
		String message = "";
		
		if (boardAdvanceService.updateBoard(boardAdvanceDto)) {
			message = "<script>";
			message += "alert('수정 되었습니다.');";
			message += "location.href='"+ request.getContextPath() +"/boardAdvance/boardList';";
			message += "</script>";
		}
		else {
		   message ="<script>"; 
		   message += "alert('비밀번호를 확인해주세요.');";
		   message += "history.go(-1);";
		   message += "</script>";
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message , responseHeaders , HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/boardDelete" , method=RequestMethod.GET)
	public ModelAndView boardDelete(@RequestParam("num") int num) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("boardAdvance/boardDelete");
		mv.addObject("boardAdvanceDto" , boardAdvanceService.getOneBoard(num));
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/boardDelete" , method=RequestMethod.POST)
	public ResponseEntity<Object> boardDelete(BoardAdvanceDto boardAdvanceDto , HttpServletRequest request) throws Exception{
		
		String message = "";
		
		if (boardAdvanceService.deleteBoard(boardAdvanceDto)) {
			message = "<script>";
			message += "alert('삭제 되었습니다.');";
			message += "location.href='"+ request.getContextPath() +"/boardAdvance/boardList';"; 
			message += "</script>";
		}
		else {
		   message ="<script>"; 
		   message += "alert('비밀번호를 확인해주세요.');";
		   message += "history.go(-1);";
		   message += "</script>";
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message , responseHeaders , HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/makeDummyData" , method=RequestMethod.GET)
	public ModelAndView makeDummyData() throws Exception{
		boardAdvanceService.makeDummyData();
		return new ModelAndView("redirect:/boardAdvance/boardList");
	}
	
	
}
