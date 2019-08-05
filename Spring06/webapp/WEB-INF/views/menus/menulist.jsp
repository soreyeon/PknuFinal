<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴목록</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
	<table>
	<caption><h2>메뉴목록</h2></caption>
		<tr>
			<td style="text-align:right" colspan="5">
				<a href="/Menu/WriteForm">메뉴추가</a>
			</td>
		</tr>
		<tr>
			<td style="height:30px; width:100px; text-align:center">메뉴아이디</td>
			<td style="height:30px; width:200px; text-align:center">메뉴이름</td>
			<td style="height:30px; width:100px; text-align:center">메뉴순번</td>
			<td style="height:30px; width:50px; text-align:center">수정</td>
			<td style="height:30px; width:50px; text-align:center">삭제</td>
		</tr>
		
		<c:forEach var="menu" items="${ menuList }">
			<tr>
				<td style="height:30px; width:100px; text-align:center">${ menu.menu_id }</td>
				<td style="height:30px; width:200px; text-align:center">${ menu.menu_name }</td>
				<td style="height:30px; width:100px; text-align:center">${ menu.menu_seq }</td>
				<td style="height:30px; width:50px; text-align:center">
					<a href="/Menu/UpdateForm?menu_id=${ menu.menu_id }">수정</a>
				</td>
				<td style="height:30px; width:50px; text-align:center">
					<a href="/Menu/Delete?menu_id=${ menu.menu_id }">삭제</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td style="text-align:center" colspan="5">
				<a href="/">메인화면</a>
			</td>
		</tr>
	</table>
	
</body>
</html>