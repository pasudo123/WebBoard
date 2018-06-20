<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<HTML>
	<HEAD>
	<META charset="UTF-8">
		<link rel="stylesheet" type="text/css"href="/resources/theme/css/font.css">
		<link rel="stylesheet" type="text/css"href="/resources/theme/css/pagination.css">
		<link rel="stylesheet" type="text/css"href="/resources/theme/css/list.css">
		<script type="text/javascript" src="/resources/theme/js/board.js"></script>
	</HEAD>
	<BODY>
		<div class="titleWrapper">
			<h1>Double Board</h1>
		</div>
	
		<div class="buttonWrapper">
			<a class="writeBtn" id="doWriteBtn" href="<c:url value = "../write"/>">작성하기</a>
		</div>
	
		<div class="tableWrapper">
			<table>
				<tr class="tableColumnHeader">
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>추천수</th>
				</tr>
				
				<c:forEach items="${boardTableRows}" var="boardTableRow">
					<tr class="tableColumnData">
						<!-- hidden -->
						<td>${boardTableRow.pkn}</td>
						<td>${pagePosition}</td>
						
						<!-- show -->						
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

		<div class="paginationWrapper">
			<a href="<c:url value = "./prev"/>" class="direction prev">이전</a>
			<a id="pagePos${1}" href="<c:url value = "./${1}" />">1</a>
			<a id="pagePos${2}" href="<c:url value = "./${2}" />">2</a>
			<a id="pagePos${3}" href="<c:url value = "./${3}" />">3</a>
			<a id="pagePos${4}" href="<c:url value = "./${4}" />">4</a>
			<a id="pagePos${5}" href="<c:url value = "./${5}" />">5</a>
			<a href="<c:url value = "./next"/>" class="direction next">다음</a>
		</div>
	</BODY>
</HTML>