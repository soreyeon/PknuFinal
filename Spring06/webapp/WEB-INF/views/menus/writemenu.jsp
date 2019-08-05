<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴추가</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
	<form action="/Menu/Write" method="POST">
		<table>
		<caption><h2>메뉴추가</h2></caption>
			<tr>
				<td style="height:30px; width:100px; text-align:center">메뉴이름</td>
				<td style="text-align:center">
					<input type="text" name="menu_name" style="width:350px" />
				</td>
			</tr>
			<tr>
				<td style="text-align:center" colspan="2">
					<input type="submit" value="추가" />
					<a href="/Menu/List">목록으로</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>