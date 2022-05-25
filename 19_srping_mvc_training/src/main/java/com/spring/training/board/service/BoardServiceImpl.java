package com.spring.training.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training.board.dao.BoardDao;
import com.spring.training.board.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public void insertBoard(BoardDto boardDto) {
		boardDao.insert(boardDto);
	}

	@Override
	public List<BoardDto> getBoardList() {
		return boardDao.selectAll();
	}

	@Override
	public BoardDto getOneBoard(int num) {
		boardDao.increaseReadCount(num);
		return boardDao.selectOne(num);
	}

	@Override
	public boolean updateBoard(BoardDto boardDto) {
		
		boolean isUpdate = false;
		
		if (boardDao.validateUserCheck(boardDto) != null) {
			boardDao.update(boardDto);
			isUpdate = true;
		}
		
		return isUpdate;
		
	}

	@Override
	public boolean deleteBoard(BoardDto boardDto) {
		
		boolean isDelete = false;
		
		if (boardDao.validateUserCheck(boardDto) != null) {
			boardDao.delete(boardDto.getNum());
			isDelete = true;
		}
		
		return isDelete;
		
	}
	
	
	
	
}
