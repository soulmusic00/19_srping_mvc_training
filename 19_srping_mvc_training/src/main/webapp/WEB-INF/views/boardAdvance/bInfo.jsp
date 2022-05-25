<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bInfo</title>
</head>
<body>
	<div align="center" style="padding-top: 100px">
		<div class="bs-docs-section">
			<div class="row">
				<div class="col-lg-12">
					<div class="page-header" align="center">
						<h1>Board Info</h1>
						<br>
					</div>
					<div class="bs-component">
						<table class="table table-hover" style="width: 700px; text-align: center">
							<colgroup>
								<col width="20%" >
								<col width="80%">
							</colgroup>
							<tr class="table-default">
								<td>Board Number</td>
								<td>${boardAdvanceDto.num}</td>
							</tr>
							<tr class="table-default">
								<td>ReadCount</td>
								<td>${boardAdvanceDto.readCount}</td>
							</tr>
							<tr class="table-default">
								<td>Writer</td>
								<td>${boardAdvanceDto.writer}</td>
							</tr>
							<tr class="table-default">
								<td>RegDate</td>
								<td><fmt:formatDate value="${boardAdvanceDto.regDate}" pattern="yyyy-MM-dd"/></td>
							</tr>
							<tr class="table-default">
								<td>E-mail</td>
								<td>${boardAdvanceDto.email}</td>
							</tr>
							<tr class="table-default">
								<td>Subject</td>
								<td>${boardAdvanceDto.subject}</td>
							</tr>
							<tr class="table-default">
								<td>Content</td>
								<td>${boardAdvanceDto.content}</td>
							</tr>
							<tr class="table-default">
								<td colspan="2">
									<input type="button" class="btn btn-primary btn-sm" value="Reply" onclick="location.href='${contextPath }/boardAdvance/boardReplyWrite?num=${boardAdvanceDto.num}'"> 
									<input type="button" class="btn btn-primary btn-sm" value="Update" onclick="location.href='${contextPath }/boardAdvance/boardUpdate?num=${boardAdvanceDto.num}'">
									<input type="button" class="btn btn-primary btn-sm" value="Delete" onclick="location.href='${contextPath }/boardAdvance/boardDelete?num=${boardAdvanceDto.num}'">
									<input type="button" class="btn btn-primary btn-sm" value="Main" onclick="location.href='${contextPath }/boardAdvance/boardList'">
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>