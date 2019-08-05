<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 게시물 수정</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
	<h2 style="text-align:center">자료실 게시물 수정</h2>
	
	<!-- 메뉴 목록 -->
	<%@ include file="/WEB-INF/include/menu.jspf" %>
	<br/>
	<br/>
	
	<form action="/Pds/Update" method="post">
	<input type="hidden" name="menu_id"    value="<c:out value='${ map.menu_id }' />" />
	<input type="hidden" name="idx"        value="<c:out value='${ pdsVo.idx }' />" />
	<input type="hidden" name="nowpage"    value="<c:out value='${ map.nowpage }' />" />
	<input type="hidden" name="pagegrpnum" value="<c:out value='${ map.pagegrpnum }' />" />
		<table>
			<tr>
				<td style="width:100px; height:30px; text-align:center">작성자</td>
				<td style="width:150px; height:30px; text-align:center">
					<input type="text" value="${ pdsVo.writer }" readonly />
 				</td>
 				<td style="width:100px; height:30px; text-align:center">작성일</td>
				<td style="width:150px; height:30px; text-align:center">
					<input type="text" value="${ pdsVo.regdate }" readonly />
 				</td>
			</tr>
			<tr>
				<td style="width:100px; height:30px; text-align:center">글번호</td>
				<td style="width:150px; height:30px; text-align:center">
					<input type="text" value="${ pdsVo.bnum }" readonly />
 				</td>
 				<td style="width:100px; height:30px; text-align:center">조회수</td>
				<td style="width:150px; height:30px; text-align:center">
					<input type="text" value="${ pdsVo.readcount }" readonly />
 				</td>
			</tr>
			<tr>
				<td style="width:100px; height:30px; text-align:center">제목</td>
				<td style="height:30px;" colspan="3">
					<input type="text" name="title" value="${ pdsVo.bnum }" />
 				</td>
			</tr>
			<tr>
				<td style="width:100px; height:30px; text-align:center">내용</td>
				<td style="width:400px; height:300px;" colspan="3">
					<textarea name="cont" style="width:400px; height:300px;">${pdsVo.cont }</textarea>
 				</td>
			</tr>
			<tr>
				<td style="width:100px; height:30px; text-align:center">파일</td>
				<td style="height:30px; vertical-align:top" colspan="3">
					<c:forEach var="file" items="${ fileList }">
						<div>
							<a href="<c:out value='/download/external/${ file.filename }' />">${ file.filename }</a>
						</div>
					</c:forEach>
 				</td>
			</tr>
			<tr>
				<td style="width:500px; height:30px; text-align:center" colspan="4">
					<input type="submit" value="수정" />&nbsp;&nbsp;
					<a href="/Pds/List?menu_id=${ map.menu_id }&nowpage=${ map.nowpage }&pagegrpnum=${ map.pagegrpnum }">목록</a>		
 				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>