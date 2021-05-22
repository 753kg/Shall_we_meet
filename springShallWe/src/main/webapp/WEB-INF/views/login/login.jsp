<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${cpath }/frontDesign/css/animate.css">   
    <link rel="stylesheet" href="${cpath }/frontDesign/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${cpath }/frontDesign/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${cpath }/frontDesign/css/magnific-popup.css">
    <link rel="stylesheet" href="${cpath }/frontDesign/css/flaticon.css">
    <link rel="stylesheet" href="${cpath }/frontDesign/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
body{
background-image: url('${cpath }/frontDesign/imageSource/배경6.png');
    background-size : cover;
}
</style>
</head>
<body>
	<jsp:include page="../mainView/header.jsp">
		<jsp:param name="pageName" value="로그인"/>
	</jsp:include>
	
	<section>
   <div class="content25">
   
	<div class="login_area">
	<form id="login_form" name="login_form" method="post" class="billing-form">
		<div class="form-group"><input type="text" id="memberid" name="memberid" placeholder="ID"></div>
		<div class="form-group"><input type="password" id="memberpw" name="memberpw"  placeholder="Password"></div>
		<div id="id_check"></div>
		<input id="login_submit" type="button" value="로그인">
	</form>
	</div>
	
	<div class="register_area">
		<div>아직 회원이 아니신가요?  <a href="${cpath }/register.do">회원가입 click!</a></div>
	</div>
	
	</div>
    </section>
    	
	 <jsp:include page="../mainView//footer.jsp">
		<jsp:param name="top" value="400"/>
	</jsp:include>
</body>
	
	<script>
		// 아이디 유효성 검사(1 = 중복 / 0 != 중복)
		$("#login_submit").click(function() {
			var formData = $('#login_form').serialize();
			$.ajax({
				// 아이디 체크하는 서블릿??
				url : 'login.do',
				type : 'post',
				cache: false,
				data: formData,
				success : function(data) {
					console.log("1 = 중복o / 0 = 중복x : " + data);

					if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						location.href = "main.do";
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
</html>
	