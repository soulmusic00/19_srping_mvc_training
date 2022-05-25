package com.spring.training.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.training.member.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public void insert(MemberDto memberDto) throws Exception {
		sqlSession.insert("mapper.member.joinMember" , memberDto);
	}
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		return sqlSession.selectOne("mapper.member.loginMember" , memberDto);
	}
	
	@Override
	public MemberDto overlapped(String memberId) throws Exception {
		return sqlSession.selectOne("mapper.member.duplicatedMemberCheck" , memberId);
	}
	
	
	@Override
	public List<MemberDto> selectAllMember() throws Exception {
		return sqlSession.selectList("mapper.member.showAllMember");
	}

	
	@Override
	public MemberDto selectOneMember(String memberId) throws Exception {
		return sqlSession.selectOne("mapper.member.showOneMember" , memberId);
	}

	
	@Override
	public void deleteMember(String memberId) throws Exception {
		sqlSession.delete("mapper.member.deleteMember" , memberId);
	}

	
	@Override
	public void updateMember(MemberDto memberDto) throws Exception {
		sqlSession.update("mapper.member.updateMember" , memberDto);
	}
	
}
