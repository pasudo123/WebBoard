<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<HTML>
	<HEAD>
		<link rel="stylesheet" type="text/css" href="/resources/theme/css/font.css">
		<link rel="stylesheet" type="text/css" href="/resources/theme/css/write.css">
	</HEAD>
	
	<BODY>
		<div class="titleWrapper"><h1>Double Write</h1></div>
	
		<form:form method="POST" action="./write/data" modelAttribute="boardContent">
			<div class="tableWrapper">
				<table>
					<tr>
						<th>제목</th>
						<td><form:input path="title" /></td>
						<th>작성자<th>
						<td><form:input path="writer" value="Doubler" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="5">
							<form:textarea path="content" rows="15" />
						</td>
					</tr>
				</table>
			</div>
			
			<div class="buttonWrapper">
				<input class="writeButton" id="writeBtn" type="submit" value="작성">
			</div>
		</form:form>
	</BODY>
</HTML>