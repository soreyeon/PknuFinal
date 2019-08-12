<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="loginPanel">
    <form action="/Login/Login" method="POST">
    <input type="hidden" name="cp" value="${cp}" />
		<table>
			
			<tr>
				<td colspan="2">
					<label>로그인</label>
				</td>
			</tr>
			<tr>
			   <td colspan="2"><input type="text" id="Id" name="userid" placeholder="ID" ></td>
			</tr>
			<tr>
			   <td colspan="2"><input type="password" id="Pw" name="userpwd" placeholder="PASSWORD" ></td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="msg" align="center">
					</div>
				</td>
			</tr>
			<tr align="center">
				<td><button type="submit" class="btn btn-outline-dark" style="width:100px;">로그인</button></td>
				<td><a class="btn btn-outline-dark" style="width:100px;" href="/Join">회원가입</a></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>
</html>