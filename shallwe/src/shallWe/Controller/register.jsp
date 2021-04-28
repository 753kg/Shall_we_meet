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
	<form action="Register" method="post">
		<div>
			<h3><label for="register_id">아이디</label></h3>
			<input type="text" id="register_id" name="register_id">
		</div>
		<div>
			<h3><label for="register_pw">비밀번호</label></h3>
			<input type="password" id="register_pw" name="register_pw">
		</div>
		<div>
			<h3><label for="register_name">이름</label></h3>
			<input type="text" id="register_name" name="register_name">
		</div>
		<div>
			<h3><label for="register_email">이메일</label></h3>
			<input type="email" id="register_email" name="register_email">
		</div>
		<div>
			<h3><label for="register_phone">전화번호</label></h3>
			<input type="text" id="register_phone" name="register_phone">
		</div>
		<div>
			<h3><label for="register_security">본인확인용 질문</label></h3>
			<p>나의 보물 1호는?</p>
			<input type="text" id="register_security" name="register_security" placeholder="답">
		</div>
		<div>
			<input type="submit" value="가입하기">
		</div>
	</form>
</body>
</html>