<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="/loginProcess" method="POST">
		<div>
			아이디:<input type="text" name="userid" />
		</div>
		<div>
			암호:<input type="password" name="userpwd" />
		</div>
		<div>
			<input type="submit" value="로그인" />
		</div>
	</form>
</body>
</html>