<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Shall We Meet?</h1>
	
	<div class="login_area">
	<form action="Login" method="post">
		<div><input type="text" name="memberid" value="mem1" placeholder="아이디"></div>
		<div><input type="password" name="memberpw" value="1234" placeholder="비밀번호"></div>
		<input type="submit" value="로그인">
	</form>
	</div>
	
	<div class="register_area">
		<div><a href="register.jsp">회원가입</a></div>
	</div>
</body>
</html>