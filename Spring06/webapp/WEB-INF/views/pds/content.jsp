<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="idx"         value="${ map.idx }" />
<c:set var="menu_id"     value="${ map.menu_id }" />
<c:set var="nowpage"     value="${ map.nowpage }" />
<c:set var="pagegrpnum"  value="${ map.pagegrpnum }" />

<c:set var="bnum"        value="${ pdsVo.bnum }" />
<c:set var="lvl"         value="${ pdsVo.lvl }" />
<c:set var="step"        value="${ pdsVo.step }" />
<c:set var="nref"        value="${ pdsVo.nref }" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 본문 조회</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
	<h2 style="text-align:center">자료실 본문 조회</h2>
	
	<!-- 메뉴 출력 -->
	<%@ include file="/WEB-INF/include/menu.jspf" %>
	
	<table>
		<tr>
			<td style="width:100px; height:30px; text-align:center">작성자</td>
			<td style="width:150px; height:30px; text-align:center">${ pdsVo.writer }</td>
			<td style="width:100px; height:30px; text-align:center">작성일</td>
			<td style="width:150px; height:30px; text-align:center">${ pdsVo.regdate }</td>
		</tr>
		<tr>
			<td style="width:100px; height:30px; text-align:center">글번호</td>
			<td style="width:150px; height:30px; text-align:center">${ pdsVo.bnum }</td>
			<td style="width:100px; height:30px; text-align:center">조회수</td>
			<td style="width:150px; height:30px; text-align:center">${ pdsVo.readcount }</td>
		</tr>
		<tr>
			<td style="width:100px; height:30px; text-align:center">제목</td>
			<td style="width:400px; height:30px;" colspan="3">${ pdsVo.title }</td>
		</tr>
		<tr>
			<td style="width:100px; height:30px; text-align:center">내용</td>
			<td style="width:400px; height:150px; vertical-align:top;" colspan="3">${ pdsVo.cont }</td>
		</tr>
		
		<tr>
			<td style="width:100px; height:30px; text-align:center">파일</td>
			 <%-- /download/{0}/{1}  --%>	
			 <%-- @PathVariable 인자 2개 값 - 0 : external, 1: 파일명  --%>
			 <%-- jstl 명령안에서(c:forEach 안에서) js 안에서 출력할때 ${ filename } 보다는 
			      <c:out value='${ filename }' />로 출력하라 
			 --%>
			<td style="width:400px;" colspan="3">
				<c:forEach var="file" items="${ fileList }">
				<div>				
					<a href="<c:out value='/download/external/${ file.filename }' />">${ file.filename }</a>			
				</div>
				</c:forEach>
			</td>
		</tr>
		
		<tr>
			<td style="width:500px; text-align:center" colspan="4">
				<a href="/Pds/List?menu_id=${ menu_id }&nowpage=${ nowpage }&pagegrpnum=${ pagegrpnum }">목록</a>&nbsp;&nbsp;
				<a href="/Pds/WriteForm?menu_id=${ menu_id }&nowpage=${ nowpage }&pagegrpnum=${ pagegrpnum }&bnum=0&lvl=0&step=0&nref=0">글쓰기</a>&nbsp;&nbsp;
				<a href="/Pds/WriteForm?menu_id=${ menu_id }&nowpage=${ nowpage }&pagegrpnum=${ pagegrpnum }&bnum=${ bnum }&lvl=${ lvl }&step=${ step }&nref=${ nref }">답글쓰기</a>&nbsp;&nbsp;
				<c:if test="${ sessionScope.login.userid eq pdsVo.writer }">
					<a href="/Pds/UpdateForm?menu_id=${ menu_id }&nowpage=${ nowpage }&pagegrpnum=${ pagegrpnum }&idx=${ idx }">수정</a>&nbsp;&nbsp;
					<a href="/Pds/Delete?menu_id=${ menu_id }&nowpage=${ nowpage }&pagegrpnum=${ pagegrpnum }&idx=${ idx }">삭제</a>
				</c:if> 
			</td>
		</tr>
	</table>
</body>/
</html>