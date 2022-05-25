<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>

	<div align="center" style="margin-top: 150px">
		<h1>Spring MVC Training</h1><br><br>
		<a href="${contextPath}/board/boardList"><img alt="boardBasic" src="${contextPath }/resources/img/boardBasic.PNG" width="200" height="200"></a>&emsp;&emsp;
		<a href="${contextPath}/member/main"><img alt="member" src="${contextPath }/resources/img/member.PNG" width="200" height="200"></a>&emsp;&emsp;
		<a href="${contextPath}/boardAdvance/boardList"><img alt="boardAdvance" src="${contextPath }/resources/img/boardAdvance.PNG" width="200" height="200"></a>&emsp;&emsp;
		<h3>BoardBasic &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; Member &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; BoardAdvance</h3>
	</div>

</body>
</html>