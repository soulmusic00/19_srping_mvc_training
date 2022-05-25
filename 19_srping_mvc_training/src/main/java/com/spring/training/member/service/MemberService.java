package com.spring.training.member.service;

import java.util.List;

import com.spring.training.member.dto.MemberDto;

public interface MemberService {

	public void joinMember(MemberDto memberDto) throws Exception;	
	public MemberDto loginMember(MemberDto memberDto) throws Exception;
	public List<MemberDto> showAllMember() throws Exception;
	public MemberDto showOneMember(String memberId) throws Exception;
	public boolean updateMember(MemberDto memberDto) throws Exception;
	public boolean deleteMember(MemberDto memberDto) throws Exception;
	public String overlapped(String memberId) throws Exception; 
	
}
