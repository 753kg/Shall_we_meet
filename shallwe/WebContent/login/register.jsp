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
		<label for="register_id">아이디</label>
		<input type="text" id="register_id" name="register_id">
		<label for="register_pw">비밀번호</label>
		<input type="password" id="register_pw" name="register_pw">
		<label for="register_name">이름</label>
		<input type="text" id="register_name" name="register_name">
		<label for="register_email">이메일</label>
		<input type="text" id="register_email" name="register_email">
		<label for="register_phone">전화번호</label>
		<input type="text" id="register_phone" name="register_phone">
		<label for="register_security">본인확인용 질문</label>
		<p>질문</p>
		<input type="text" id="register_security" name="register_security" placeholder="답">
		<input type="submit" value="가입하기">
	</form>
</body>
</html>