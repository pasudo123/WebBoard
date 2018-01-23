<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL을 쓰기 위해서 jsp 페이지 앞에 선언해줌. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>boardList</title>
</head>

<body>
	<div>
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			
			<form></form>
			<c:forEach items="${boardContent}" var="boardContent">
			<tr>
				<td>${boardContent.contentNum}</td>
				
				<td>
					<a href="boardList/boardContentView?contentNum=${boardContent.contentNum}">${boardContent.contentTitle}</a>
				</td>
				
				<td>${boardContent.contentWriter}</td>
				<td>${boardContent.contentDate}</td>
				<td>${boardContent.contentHit}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div>
	<p><a href="boardWriteView">작성하기</a>
	</div>
</body>

</html>