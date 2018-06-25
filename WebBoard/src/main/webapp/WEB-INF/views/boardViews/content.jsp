<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<HTML>
	<HEAD>
		<link rel="stylesheet" type="text/css" href="/resources/theme/css/font.css">
		<link rel="stylesheet" type="text/css" href="/resources/theme/css/write.css">
		<script type="text/javascript" src="/resources/theme/js/board.js"></script>
	</HEAD>
	
	<BODY>
		<div class="titleWrapper"><h1>Double Write</h1></div>
	
		<form:form method="POST" action="../modify" modelAttribute="boardContent">
			<div class="tableWrapper">
				<table>
					<tr>
						<th>제목</th>
						<td><form:input path="title" value="${title}"/></td>
						<th>작성자</th>
						<td><form:input path="writer" value="${writer}" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<form:textarea path="content" value="${content}"/>
							<form:hidden path="pkn" value="${pkn}" />
						</td>
					</tr>
				</table>
			</div>
			
			<div class="buttonWrapper">
				<input class="modifyButton" id="modifyBtn" type="submit" value="수정">
				<input class="deleteButton" id="deleteBtn" type="button" value="삭제">
				<input class="showListButton" id="showListBtn" type="button" value="목록보기">
				<input type="hidden" id="refererURL" value="${refererURL}">
			</div>
		</form:form>
	</BODY>
</HTML>