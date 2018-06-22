<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	</BODY>
</HTML>
