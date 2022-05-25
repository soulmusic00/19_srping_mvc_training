<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <div class="sb-sidenav-menu-heading">Core</div>
                <a class="nav-link" href="${contextPath}/boardAdvance/boardList">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    BoardList
                </a>
          	</div>
        </div>
        <div class="sb-sidenav-footer">
            <div class="small">sb-amdin</div>
            With Bootstrap Thema
        </div>
    </nav>
</body>
</html>