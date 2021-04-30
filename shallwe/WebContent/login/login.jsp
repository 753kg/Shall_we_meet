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
	
	<div class="login_area">
	<form id="login_form" name="login_form" method="post">
		<div><input type="text" id="memberid" name="memberid" value="mem1" placeholder="아이디"></div>
		<div><input type="password" id="memberpw" name="memberpw" value="1234" placeholder="비밀번호"></div>
		<div id="id_check"></div>
		<input id="login_submit" type="button" value="로그인">
	</form>
	</div>
	
	<div class="register_area">
		<div><a href="Register">회원가입</a></div>
	</div>
	
	<script>
		// 아이디 유효성 검사(1 = 중복 / 0 != 중복)
		$("#login_submit").click(function() {
			var formData = $('#login_form').serialize();
			$.ajax({
				// 아이디 체크하는 서블릿??
				url : 'Login',
				type : 'post',
				cache: false,
				data: formData,
				success : function(data) {
					console.log("1 = 중복o / 0 = 중복x : " + data);

					if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						location.href = "../mainView/main.jsp";
					} else {
						
						if(memberid == ""){
							$("#id_check").text("아이디를 입력하세요");
							$("#id_check").css("color", "red");
						} else {
							$("#id_check").text("아이디나 비밀번호가 잘못되었습니다.");
							$("#id_check").css("color", "red");
						}
					}
				},
				error : function() {
					console.log("실패");
				}
			});
		});
	</script>
</body>
</html>