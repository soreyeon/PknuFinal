<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 글쓰기</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
	<h2 style="text-align:center"> 자료실 새글 쓰기</h2>
	<!-- 메뉴부분 -->
	<%@ include file="/WEB-INF/include/menu.jspf" %>
	<br/>
	<br/>
	
	<!-- 자료입력부분 -->
	<form action="/Pds/Write" method="post" enctype="multipart/form-data">
		<table border="1" cellpadding="0" cellspacing="0" width="500" align="center">
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="writer" size="15" />
				 </td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" size="15" />
				 </td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="cont" style="width:400px;height:150px"></textarea>
				 </td>
			</tr>
			<tr>
				<td width="100" align="center">파일</td>
				<td width="400">
					<input type="file" name="upfile" id="orgfile" size="50" />
					<input type="file" name="upfile2" id="orgfile2" size="50" />
					<input type="file" name="upfile3" id="orgfile3" size="50" />
					<input type="file" name="upfile4" id="orgfile4" size="50" />
				</td>
			</tr>
			<tr>
				<td width="500" align="center" colspan="2">
					<input type="submit" value="작성" />
				</td>
			</tr>
			<tr>
				<td width="500" align="right" colspan="2">
					<a href="/Pds/List?menu_id=<c:out value='${ map.menu_id }' />">목록</a>
					<a href="/Pds/List?menu_id=${ map.menu_id }">목록</a>
				</td>
			</tr>
		</table>
		<!-- 받은 정보를 다음 페이지(/Pds/Write)로 전송 -->
		<input type="hidden" name="menu_id" value="<c:out value='${ map.menu_id }' />" />	
		<input type="hidden" name="bnum"    value="<c:out value='${ map.bnum }' />" />	
		<input type="hidden" name="lvl"     value="<c:out value='${ map.lvl }' />" />	
		<input type="hidden" name="step"    value="<c:out value='${ map.step }' />" />	
		<input type="hidden" name="nref"    value="<c:out value='${ map.nref }' />" />
			
		<input type="hidden" name="nowpage"       value="<c:out value='${ map.nowpage }' />" />	
		<input type="hidden" name="pagegrpnum"    value="<c:out value='${ map.pagegrpnum }' />" />	
	</form>
</body>
</html>