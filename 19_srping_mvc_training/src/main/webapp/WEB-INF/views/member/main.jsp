<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>

	<!-- 
	
		# Read Me
		
		- 4가지의 특정 유틸리티가 소스에 반영되어 있습니다.
		- 모르는 부분은 구글링 하여 이해 및 해결하여 새로운 문법을 익히는 힘과 노하우를 기릅니다.
		
		1) ckeditor				 : join.jsp , webapp/resources/ckeditor
 		2) daumpostofficecode	 : join.jsp , myPage.jsp
		3) excel export          : pom.xml , memberList.jsp MemberController.java
		4) BCryptPasswordEncoder : pom.xml , root-context.xml , MemberServiceImpl.java
	
	 -->

	<c:choose>
		<c:when test="${sessionScope.loginUser eq null}">
			<p><a href="${contextPath }/member/memberList">회원 리스트 조회</a></p>
			<p><a href="${contextPath }/member/join">회원가입</a></p>
			<p><a href="${contextPath }/member/login">로그인</a></p>	
		</c:when>
		<c:otherwise>
			<h2>${sessionScope.loginUser }님 반갑습니다.</h2>
			<p><a href="${contextPath }/member/myPage">마이페이지로 이동</a></p>	
			<p><a href="${contextPath }/member/logout">로그아웃</a></p>
			<p><a href="${contextPath }/member/delete">회원탈퇴</a></p>	
		</c:otherwise>
	</c:choose>
</body>
</html>