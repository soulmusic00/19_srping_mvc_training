package com.spring.training.member.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MemberDto {

	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGender;
	private String memberBirthY;
	private String memberBirthM;
	private String memberBirthD;
	private String memberBirthGn;
	private String hp1;
	private String hp2;
	private String hp3;
	private String smsstsYn;
	private String email;
	private String emailstsYn;
	private String zipcode;
	private String roadAddress;
	private String jibunAddress;
	private String namujiAddress;
	private Date joinDate;
	private String etc;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberBirthY() {
		return memberBirthY;
	}
	public void setMemberBirthY(String memberBirthY) {
		this.memberBirthY = memberBirthY;
	}
	public String getMemberBirthM() {
		return memberBirthM;
	}
	public void setMemberBirthM(String memberBirthM) {
		this.memberBirthM = memberBirthM;
	}
	public String getMemberBirthD() {
		return memberBirthD;
	}
	public void setMemberBirthD(String memberBirthD) {
		this.memberBirthD = memberBirthD;
	}
	public String getMemberBirthGn() {
		return memberBirthGn;
	}
	public void setMemberBirthGn(String memberBirthGn) {
		this.memberBirthGn = memberBirthGn;
	}
	public String getHp1() {
		return hp1;
	}
	public void setHp1(String hp1) {
		this.hp1 = hp1;
	}
	public String getHp2() {
		return hp2;
	}
	public void setHp2(String hp2) {
		this.hp2 = hp2;
	}
	public String getHp3() {
		return hp3;
	}
	public void setHp3(String hp3) {
		this.hp3 = hp3;
	}
	public String getSmsstsYn() {
		return smsstsYn;
	}
	public void setSmsstsYn(String smsstsYn) {
		this.smsstsYn = smsstsYn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailstsYn() {
		return emailstsYn;
	}
	public void setEmailstsYn(String emailstsYn) {
		this.emailstsYn = emailstsYn;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}
	public String getJibunAddress() {
		return jibunAddress;
	}
	public void setJibunAddress(String jibunAddress) {
		this.jibunAddress = jibunAddress;
	}
	public String getNamujiAddress() {
		return namujiAddress;
	}
	public void setNamujiAddress(String namujiAddress) {
		this.namujiAddress = namujiAddress;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}

	
	
}
