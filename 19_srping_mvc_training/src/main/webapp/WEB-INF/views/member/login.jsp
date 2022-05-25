<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h1>Login</h1>
	<br>
	<form action="${contextPath}/member/login" method="post">
		<table border="1">
			<tr>
				<td align="center">아이디</td>
				<td><input name="memberId" type="text" placeholder="아이디를 입력하세요." /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input name="memberPw" type="password" placeholder="비밀번호를 입력하세요." /></td>
			</tr>
		</table>
		<p>
			<input type="button" value="회원가입" onClick="location.href='${contextPath}/member/join'">
			<input type="submit" value="로그인">
		</p>
	</form>
</body>
</html>