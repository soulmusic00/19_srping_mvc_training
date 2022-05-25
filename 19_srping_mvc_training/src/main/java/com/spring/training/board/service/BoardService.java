package com.spring.training.board.service;

import java.util.List;

import com.spring.training.board.dto.BoardDto;

public interface BoardService {

	public void insertBoard(BoardDto boardDto);
	public List<BoardDto> getBoardList();
	public BoardDto getOneBoard(int num);
	public boolean updateBoard(BoardDto boardDto);
	public boolean deleteBoard(BoardDto boardDto);
	
}




