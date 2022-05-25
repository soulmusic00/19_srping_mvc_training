package com.spring.training.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.training.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(BoardDto boardDto) {
		sqlSession.insert("boardMapper.insertBoard" , boardDto);
	}

	@Override
	public List<BoardDto> selectAll() {
		return sqlSession.selectList("boardMapper.getAllBoard");
	}

	@Override
	public BoardDto selectOne(int num) {
		return sqlSession.selectOne("boardMapper.getOneBoard" , num);
	}

	@Override
	public void increaseReadCount(int num) {
		sqlSession.update("boardMapper.updateReadCount" , num);
	}

	@Override
	public BoardDto validateUserCheck(BoardDto boardDto) {
		return sqlSession.selectOne("boardMapper.validateUserCheck" , boardDto);
	}

	@Override
	public void update(BoardDto boardDto) {
		sqlSession.update("boardMapper.updateBoard" , boardDto);
	}

	@Override
	public void delete(int num) {
		sqlSession.delete("boardMapper.deleteBoard" , num);
	}
	
	
}
