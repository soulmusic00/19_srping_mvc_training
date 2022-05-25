package com.spring.training.boardAdvance.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.training.boardAdvance.dto.BoardAdvanceDto;

@Repository				
public class BoardAdvanceDaoImpl implements BoardAdvanceDao {

	
	@Inject							
	private SqlSession sqlSession;		
	
	@Override
	public List<BoardAdvanceDto> getSearchBoard(Map<String, Object> searchInfo) throws Exception{
		return sqlSession.selectList("boardAdvanceMapper.getSearchBoard" , searchInfo);
	}
	
	@Override
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception {
		return sqlSession.selectOne("boardAdvanceMapper.getAllBoardCount" , searchCountInfo);
	}
	
	@Override
	public BoardAdvanceDto getOneBoard(int num) throws Exception{
		return sqlSession.selectOne("boardAdvanceMapper.getOneBoard" , num);
	}
	
	@Override
	public void increaseReadCount(int num) throws Exception {
		sqlSession.update("boardAdvanceMapper.increaseReadCount" , num);
	}
	
	@Override
	public void insertBoard(BoardAdvanceDto boardAdvanceDto) throws Exception{
		sqlSession.insert("boardAdvanceMapper.insertBoard" , boardAdvanceDto);
	}
	
	@Override
	public void insertReplyBoard(BoardAdvanceDto boardAdvanceDto) throws Exception {
		sqlSession.insert("boardAdvanceMapper.insertReplyBoard" , boardAdvanceDto);
	}
	
	@Override
	public void updateBoard(BoardAdvanceDto boardAdvanceDto) throws Exception{
		sqlSession.update("boardAdvanceMapper.updateBoard" , boardAdvanceDto);
	}

	@Override
	public void deleteBoard(int num) throws Exception{
		sqlSession.delete("boardAdvanceMapper.deleteBoard" , num);
	}

	@Override
	public void updateBoardReplyStep(BoardAdvanceDto boardAdvanceDto) throws Exception {
		sqlSession.update("boardAdvanceMapper.updateBoardReplyStep" , boardAdvanceDto);
	}
	
	@Override
	public BoardAdvanceDto validateUserCheck(BoardAdvanceDto boardAdvanceDto) throws Exception {
		return sqlSession.selectOne("boardAdvanceMapper.validateUserCheck" , boardAdvanceDto);
	}

	@Override
	public void makeDummyData(List<BoardAdvanceDto> dataLists) throws Exception {
		sqlSession.insert("boardAdvanceMapper.makeDummyData" , dataLists);
	}



}
