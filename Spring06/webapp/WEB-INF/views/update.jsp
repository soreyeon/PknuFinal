<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
	<form action="/Board/Update" method="POST">
	<%-- <input type="hidden" name="menu_id" value="${boardVo.menu_id }" /> --%>
		<table>
		<caption><h2>${ boardVo.menu_id }글수정</h2></caption>
			<tr>
				<td style="width:60px; text-align:center">메뉴명</td>
				<td><input type="text" name="menu_id" value="${ boardVo.menu_id }" style="width:250px" readonly /></td>
			</tr>
			<tr>
				<td style="width:60px; text-align:center">글번호</td>
				<td><input type="text" name="idx" value="${ boardVo.idx }" style="width:250px" readonly /></td>
			</tr>
			<tr>
				<td style="width:60px; text-align:center">작성자</td>
				<td><input type="text" name="writer" value="${ boardVo.writer }" style="width:250px" readonly /></td>
			</tr>
			<tr>
				<td style="width:60px; text-align:center">작성일</td>
				<td><input type="text" name="regdate" value="${ boardVo.regdate }" style="width:250px" readonly/></td>
			</tr>
			<tr>
				<td style="width:60px; text-align:center">글제목</td>
				<td><input type="text" name="title" value="${ boardVo.title }" style="width:250px" /></td>
			</tr>
			<tr>
				<td style="width:60px; text-align:center">내용</td>
				<td><input type="text" name="cont" value="${ boardVo.cont }" style="width:250px" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center">
					<input type="submit" value="수정" />
					<a href="/Board/List?menu_id=${ menu_id }">목록</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>