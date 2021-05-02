<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>Shall We Meet?</h1>
	<form action="Register" method="post">
		<div class="id_area">
			<h3><label for="register_id">아이디</label></h3>
			<input type="text" id="register_id" name="register_id" required>
			<div id="id_check"></div>
		</div>
		<div>
			<h3><label for="register_pw">비밀번호</label></h3>
			<input type="password" id="register_pw" name="register_pw" required>
		</div>
		<div>
			<h3><label for="register_name">이름</label></h3>
			<input type="text" id="register_name" name="register_name">
		</div>
		<div>
			<h3><label for="register_email">이메일</label></h3>
			<input type="email" id="register_email" name="register_email" required>
		</div>
		<div>
			<h3><label for="register_phone">전화번호</label>
			</h3><input type="text" id="register_phone" name="register_phone">
		</div>
		<div>
			<h3><label for="register_security">본인확인용 질문</label></h3>
			<p>나의 보물 1호는?</p>
			<input type="text" id="register_security" name="register_security" placeholder="답" required>
		</div>
		<div>
			<input id="reg_submit" type="submit" value="가입하기">
		</div>
	</form>

	<script>
		// 아이디 중복 체크
		$("#register_id").keyup(function() {
			var register_id = $('#register_id').val();
			$.ajax({
				// 아이디 체크하는 서블릿으로 이동
				url : 'IDCheck?member_id=' + register_id,
				type : 'get',
				success : function(data) {
					if (data == 1) { // 1 : 아이디 중복
						$("#id_check").text("사용중인 아이디입니다.");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
							if(register_id == ""){
								$("#id_check").text("아이디를 입력하세요");
								$("#id_check").css("color", "red");
								$("#reg_submit").attr("disabled", true);
							} else {
								$("#id_check").text("사용 가능한 아이디입니다");
								$("#id_check").css("color", "green");
								$("#reg_submit").attr("disabled", false);
							}
					}
				},
				error : function() {
					console.log("로그인 실패");
				}
			});
		});
	</script>
</body>
</html>