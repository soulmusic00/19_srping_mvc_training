<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bDelete</title>
</head>
<body>
	<div align="center" style="padding-top: 100px">
		<form action="boardDelete" method="post">
			<div class="bs-docs-section">
				<div class="row">
					<div class="col-lg-12">
						<div class="page-header" align="center">
							<h1>Delete Board</h1>
							<br>
						</div>
						<div class="bs-component">
							<table class="table table-hover" style="width: 700px">
								<tr class="table-default">
									<td>Writer</td>
									<td>${boardAdvanceDto.writer}</td>
								</tr>
								<tr class="table-default">
									<td>RegDate</td>
									<td><fmt:formatDate value="${boardAdvanceDto.regDate}" pattern="yyyy-MM-dd"/></td>
								</tr>
								<tr class="table-default">
									<td>Subject</td>
									<td>${boardAdvanceDto.subject}</td>
								</tr>
								<tr class="table-default">
									<td><span style="color: red">*</span> Password</td>
									<td><input type="password" class="form-control" name="password" size="60"></td>
								</tr>
								<tr class="table-default" align="right">
									<td colspan="4">
										<input type="hidden" name="num" value="${boardAdvanceDto.num }">
										<input type="submit" class="btn btn-primary btn-sm" value="delete">
										<input type="button" class="btn btn-primary btn-sm" onclick="location.href='${contextPath }/boardAdvance/boardList'" value="Main">
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>