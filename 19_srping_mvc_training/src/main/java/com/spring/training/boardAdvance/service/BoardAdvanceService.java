package com.spring.training.boardAdvance.service;

import java.util.List;
import java.util.Map;

import com.spring.training.boardAdvance.dto.BoardAdvanceDto;

public interface BoardAdvanceService {
	
	public List<BoardAdvanceDto> getSearchBoard(Map<String, Object> searchInfo) throws Exception;
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception;
	public BoardAdvanceDto getOneBoard(int num) throws Exception;
	public void insertBoard(BoardAdvanceDto boardAdvanceDto) throws Exception;
	public void insertReplyBoard(BoardAdvanceDto boardAdvanceDto) throws Exception;
	public boolean updateBoard(BoardAdvanceDto boardAdvanceDto) throws Exception;
	public boolean deleteBoard(BoardAdvanceDto boardAdvanceDto) throws Exception;
	public void makeDummyData() throws Exception;
	
}
