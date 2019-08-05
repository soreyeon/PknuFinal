<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
	<form action="/Menu/Update" method="POST">
		<table>
		<caption><h2>메뉴수정</h2></caption>
			<tr>
				<td style="height:30px; width:100px; text-align:center">메뉴아이디</td>
				<td style="text-align:center">
					<input type="text" name="menu_id" value="${ menuVo.menu_id }" style="width:350px" readonly />
				</td>
			</tr>
			<tr>
				<td style="height:30px; width:100px; text-align:center">메뉴이름</td>
				<td style="text-align:center">
					<input type="text" name="menu_name" value="${ menuVo.menu_name }" style="width:350px" />
				</td>
			</tr>
			<tr>
				<td style="height:30px; width:100px; text-align:center">메뉴순번</td>
				<td style="text-align:center">
					<input type="text" name="menu_seq" value="${ menuVo.menu_seq }" style="width:350px" />
				</td>
			</tr>
			<tr>
				<td style="text-align:center" colspan="2">
					<input type="submit" value="수정" />
					<a href="/Menu/List">목록으로</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>