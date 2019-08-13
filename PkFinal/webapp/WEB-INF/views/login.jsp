<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	login.jsp
	<form action="/Members/LoginAction" method="post">
		id : <input type="text" name="m_uid" value="aaaaaa"><br/>
		pw : <input type="text" name="m_pwd" value="aaaaaa"><br/>
		<input type="submit" value="login">
		<input type="button" value="exit" onclick="javascript:history.back()">
	</form>
</body>
</html>