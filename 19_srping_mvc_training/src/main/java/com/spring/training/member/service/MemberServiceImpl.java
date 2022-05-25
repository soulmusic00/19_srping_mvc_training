package com.spring.training.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.training.member.dao.MemberDao;
import com.spring.training.member.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void joinMember(MemberDto memberDto) throws Exception {
		memberDto.setMemberPw(passwordEncoder.encode(memberDto.getMemberPw())); 
		memberDao.insert(memberDto);
	}

	@Override
	public String overlapped(String memberId) throws Exception {
		
		String isOverLapped = "true";
		
		if (memberDao.overlapped(memberId) == null) {
			return "false";
		}
		
		return isOverLapped;
		
	}
	
	@Override
	public MemberDto loginMember(MemberDto memberDto) throws Exception {
		
		MemberDto dbMemberDto = memberDao.login(memberDto);
		
		if (dbMemberDto != null) {
			if (passwordEncoder.matches(memberDto.getMemberPw(), dbMemberDto.getMemberPw())) {
				return memberDto;
			} 
		}
		
		return null;
		
	}
	
	@Override
	public List<MemberDto> showAllMember() throws Exception {
		return memberDao.selectAllMember();
	}
	
	@Override
	public MemberDto showOneMember(String memberId) throws Exception {
		return memberDao.selectOneMember(memberId);
	}

	@Override
	public boolean updateMember(MemberDto memberDto) throws Exception {
		
		MemberDto dbMemberDto = memberDao.login(memberDto);
		
		if (passwordEncoder.matches(memberDto.getMemberPw(), dbMemberDto.getMemberPw())) {
			memberDao.updateMember(memberDto);
			return true;
		}
		
		return false;
		
	}
	
	@Override
	public boolean deleteMember(MemberDto memberDto) throws Exception {
		
		MemberDto dbMemberDto = memberDao.login(memberDto);
		
		if (passwordEncoder.matches(memberDto.getMemberPw(), dbMemberDto.getMemberPw())) {
			memberDao.deleteMember(memberDto.getMemberId());
			return true;
		}
		
		return false;
		
	}

	
}
