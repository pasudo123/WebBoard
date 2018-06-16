<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm -->

<!DOCTYPE HTML>
<HTML>
<HEAD>
<META charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/resources/theme/css/font.css">
<link rel="stylesheet" type="text/css"
	href="/resources/theme/css/list.css">
</HEAD>
<BODY>
	<div class="titleWrapper">
		<h1>Double Board</h1>
	</div>

	<div class="buttonWrapper">
		<a id="doWriteBtn" href="<c:url value = "./write"/>">작성하기</a>
	</div>

	<div class="tableWrapper">
		<table>
			<tr class="tableColumn">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>

			<tr class="tableColumn">
				<td>TEST</td>
				<td>TEST</td>
				<td>TEST</td>
				<td>TEST</td>
				<td>TEST</td>
				<td>TEST</td>
			</tr>

			<c:forEach items="${boardTableRows}" var="boardTableRow">
				<tr class="tableColumn">
					<td>${boardTableRow.num}</td>
					<td>${boardTableRow.title}</td>
					<td>${boardTableRow.writer}</td>
					<td>${boardTableRow.writeDate}</td>
					<td>${boardTableRow.read}</td>
					<td>${boardTableRow.hit}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</BODY>
</HTML>