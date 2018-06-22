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
		
		<c:import url="table-row.jsp">
			<c:param name="boardTableRows" value="${boardTableRows}"></c:param>
		</c:import>
		
		<!-- 페이징 처리 -->
		<div class="paginationWrapper">
			<!-- 현재 페이지 블록에 따라서 [이전] 혹은 [다음] 보여줄지 여부 결정 -->
			<c:if test="${pageInfo.currentPageBlock != pageInfo.beginPageBlock}">
				<a href="<c:url value = "./prev?pageBlock=${pageInfo.currentPageBlock}"/>" class="direction prev">이전</a>
			</c:if>
			
			<!-- 페이지 번호 -->
			<c:forEach var="page" begin="${pageInfo.startPage}" end="${pageInfo.lastPage}" step="1">
				<c:if test="${page <= pageInfo.endPage}">
					<a id="pagePos${page}" href="<c:url value = "./${page}" />">${page}</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${pageInfo.currentPageBlock != pageInfo.endPageBlock}">
				<a href="<c:url value = "./next?pageBlock=${pageInfo.currentPageBlock}"/>" class="direction next">다음</a>
			</c:if>
		</div>
	</BODY>
</HTML>