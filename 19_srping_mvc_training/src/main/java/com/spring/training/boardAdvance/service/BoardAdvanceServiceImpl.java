package com.spring.training.boardAdvance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.training.boardAdvance.dao.BoardAdvanceDao;
import com.spring.training.boardAdvance.dto.BoardAdvanceDto;

@Service		
public class BoardAdvanceServiceImpl implements BoardAdvanceService {

	@Inject				
	private BoardAdvanceDao boardAdvanceDao;

	@Override
	public List<BoardAdvanceDto> getSearchBoard(Map<String, Object> searchInfo) throws Exception{
		return boardAdvanceDao.getSearchBoard(searchInfo);
	}
	 
	
	@Override
	public BoardAdvanceDto getOneBoard(int num) throws Exception{
		boardAdvanceDao.increaseReadCount(num);
		return boardAdvanceDao.getOneBoard(num);
	}
	
	
	@Override
	public void insertBoard(BoardAdvanceDto boardAdvanceDto) throws Exception {
		boardAdvanceDao.insertBoard(boardAdvanceDto);
	}
	
	
	@Override
	public boolean updateBoard(BoardAdvanceDto boardAdvanceDto) throws Exception {
		boolean isSuccess = false;
		if (boardAdvanceDao.validateUserCheck(boardAdvanceDto) != null) {
			isSuccess = true;
			boardAdvanceDao.updateBoard(boardAdvanceDto);
		}
		return isSuccess;
	}

	
	@Override
	public boolean deleteBoard(BoardAdvanceDto boardAdvanceDto) throws Exception {
		boolean isSuccess = false;
		if (boardAdvanceDao.validateUserCheck(boardAdvanceDto) != null) {
			boardAdvanceDao.deleteBoard(boardAdvanceDto.getNum());
			isSuccess = true;
		}
		return isSuccess;
	}

	
	@Override
	public void makeDummyData() throws Exception {
		
		Random ran = new Random();
		
		List<BoardAdvanceDto> dummyDataList = new ArrayList<BoardAdvanceDto>();
	
		String[] word = {"가","나","다","라","마","바","사","아","자","차","카","타","파","하"};
		
		BoardAdvanceDto temp = null;
		String writer;
		String password;
		String subject;
		String email;
		String content;
		
		for (int i = 1000; i < 1300; i++) {
			
			writer    = "";
			password  = "1111";
			subject   = "";
			email     = "";
			content   = "";
			for (int j = 0; j < 7; j++) {
				writer  += word[ran.nextInt(word.length)];
				subject += word[ran.nextInt(word.length)];
				content += word[ran.nextInt(word.length)];
				if (j < 4) {
					email += word[ran.nextInt(word.length)];
				}
			}
			email += "@gmail.com";
			
			temp = new BoardAdvanceDto();
			temp.setNum(i);		
			temp.setWriter(writer);
			temp.setEmail(email);
			temp.setSubject(subject);
			temp.setPassword(password);
			temp.setRef(i);
			temp.setReLevel(1);
			temp.setReStep(1);
			temp.setReadCount(0);
			temp.setContent(content);
			
			dummyDataList.add(temp);
			
		}
		
		boardAdvanceDao.makeDummyData(dummyDataList);
		
	}

	
	@Override
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception {
		return boardAdvanceDao.getAllBoardCount(searchCountInfo);
	}

	
	@Override
	public void insertReplyBoard(BoardAdvanceDto boardAdvanceDto) throws Exception {
		boardAdvanceDao.updateBoardReplyStep(boardAdvanceDto);
		boardAdvanceDao.insertReplyBoard(boardAdvanceDto);
	}
	
}
