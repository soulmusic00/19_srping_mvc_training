<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<h1>회원탈퇴</h1>
	<br>
	<form action="${contextPath}/member/delete" method="post" >
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId" value="${sessionScope.loginUser}" readonly/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="memberPw" placeholder="비밀번호를 입력하세요." /></td>
			</tr>
			<tr >
				<td colspan="2" align="right">
					<input type="submit" value="삭제">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>