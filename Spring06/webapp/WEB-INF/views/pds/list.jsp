<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
	<h2>자료실</h2>
	<%@ include file="/WEB-INF/include/menu.jspf" %>
	
	<table style="width:800px;">
		<caption><h2>자료실 게시판</h2></caption>
		<tr>
			<td style="width:50px; height:30px; text-align:center">번호</td>
			<td style="width:350px; height:30px; text-align:center">글제목</td>
			<td style="width:100px; height:30px; text-align:center">글쓴이</td>
			<td style="width:100px; height:30px; text-align:center">작성일</td>
			<td style="width:100px; height:30px; text-align:center">파일수</td>
			<td style="width:100px; height:30px; text-align:center">조회수</td>
		</tr>
		<c:forEach var="pdsVo" items="${ pdsList }">
		<tr>
			<td style="width:50px; height:30px; text-align:center">
				<c:choose>
					<c:when test="${ pdsVo.lvl eq 0 }">
						${ pdsVo.bnum }
					</c:when>
					<c:otherwise>
						&nbsp;					
					</c:otherwise>
				</c:choose>
			</td>
			<td style="width:350px; height:30px; text-align:center; padding-left:${ pdsVo.lvl*30 }px">
				<c:choose>
				<%-- 새글부분 --%>
					<c:when test="${ pdsVo.lvl eq 0 }">
						<c:choose>
							<c:when test="${ pdsVo.delnum eq 0 }">
								<a href="/Pds/Content?idx=${ pdsVo.idx }&menu_id=${ menu_id }&nowpage=${ pagePdsVo.nowpage }&pagegrpnum=${ pagePdsVo.pagegrpnum }">
									${ pdsVo.title }
								</a>
							</c:when>
							<c:otherwise>
								<s>삭제된 글입니다.</s>
							</c:otherwise>
						</c:choose>
					</c:when>
				<%-- 답글부분 --%>
					<c:otherwise>
						<c:choose>
							<c:when test="${ pdsVo.delnum eq 0 }">
								<a href="/Pds/Content?idx=${ pdsVo.idx }&menu_id=${ menu_id }">
									[Re]: ${ pdsVo.title }
								</a>
							</c:when>
							<c:otherwise>
								[Re]: <s>삭제된 글입니다.</s>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</td>
			<td style="width:100px; height:30px; text-align:center">${ pdsVo.writer }</td>
			<td style="width:100px; height:30px; text-align:center">${ pdsVo.regdate }</td>
			
			<td style="width:100px; height:30px; text-align:center">
				<c:choose>
					<c:when test="${ pdsVo.filescount eq 0 }">
						파일없음
					</c:when>
					<c:otherwise>
						${ pdsVo.filescount }개 
					</c:otherwise>
				</c:choose>
			</td>
			
			<td style="width:100px; height:30px; text-align:center">${ pdsVo.readcount }</td>
		</tr>
		</c:forEach>
		<tr>
			<td style="height:30px; text-align:right" colspan="6">
				<a href="/Pds/WriteForm?menu_id=${ menu_id }&bnum=0&lvl=0&step=0&nref=0&nowpage=${ pagePdsVo.nowpage }&pagegrpnum=${ pagePdsVo.pagegrpnum }">
					글쓰기
				</a>
			</td>
		</tr>
		
		<%@ include file="/WEB-INF/include/paging.jspf" %>
		
	</table>
</body>
</html>