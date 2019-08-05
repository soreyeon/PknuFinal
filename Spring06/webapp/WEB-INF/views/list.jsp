<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답변형 게시판</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
	<table>
		<tr>
			<c:forEach var="menu" items="${ menuList }">
				<td style="width:100px; height:30px; text-align:center">
					<a href="/Board/List?menu_id=${ menu.menu_id }">${ menu.menu_name }</a>
				</td>
			</c:forEach>
		</tr>
	</table>
	
	<table style="width:600px;">
		<caption><h2>게시판</h2></caption>
		<tr>
			<td style="width:100px; height:30px; text-align:center">번호</td>
			<td style="width:200px; height:30px; text-align:center">글제목</td>
			<td style="width:100px; height:30px; text-align:center">글쓴이</td>
			<td style="width:100px; height:30px; text-align:center">작성일</td>
			<td style="width:100px; height:30px; text-align:center">조회수</td>
		</tr>
		<c:forEach var="brd" items="${ boardList }">
		<tr>
			<td style="width:100px; height:30px; text-align:center">
				<c:choose>
					<c:when test="${ brd.lvl eq 0 }">
						${ brd.bnum }
					</c:when>
					<c:otherwise>
						&nbsp;					
					</c:otherwise>
				</c:choose>
			</td>
			<td style="width:200px; height:30px; text-align:center; padding-left:${ brd.lvl*30 }px">
				<c:choose>
				<%-- 새글부분 --%>
					<c:when test="${ brd.lvl eq 0 }">
						<c:choose>
							<c:when test="${ brd.delnum eq 0 }">
								<a href="/Board/Content?idx=${ brd.idx }&menu_id=${ menu_id }">${ brd.title }</a>
							</c:when>
							<c:otherwise>
								<s>삭제된 글입니다.</s>
							</c:otherwise>
						</c:choose>
					</c:when>
				<%-- 답글부분 --%>
					<c:otherwise>
						<c:choose>
							<c:when test="${ brd.delnum eq 0 }">
								<a href="/Board/Content?idx=${ brd.idx }&menu_id=${ menu_id }">[Re]: ${ brd.title }</a>
							</c:when>
							<c:otherwise>
								[Re]: <s>삭제된 글입니다.</s>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</td>
			<td style="width:100px; height:30px; text-align:center">${ brd.writer }</td>
			<td style="width:100px; height:30px; text-align:center">${ brd.regdate }</td>
			<td style="width:100px; height:30px; text-align:center">${ brd.readcount }</td>
		</tr>
		</c:forEach>		
		<tr>
			<td style="height:30px; text-align:right" colspan="5">
				<a href="/Board/WriteForm?menu_id=${ menu_id }&bnum=0&lvl=0&step=0&nref=0">글쓰기</a>
			</td>
		</tr>
	</table>
</body>
</html>