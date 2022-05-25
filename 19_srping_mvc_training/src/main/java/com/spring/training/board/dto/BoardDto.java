package com.spring.training.board.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BoardDto {

	private int num;
	private String writer;
	private String email;
	private String subject;
	private String password;
	private Date regDate;
	private int readCount;
	private String content;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", writer=" + writer + ", email=" + email + ", subject=" + subject
				+ ", password=" + password + ", regDate=" + regDate + ", readCount=" + readCount + ", content="
				+ content + "]";
	}
	
}
