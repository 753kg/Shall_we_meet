<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
<style>
#text-image25{
	position:absolute; 
	width:1100px;top:550px;left: 50%;
	transform: translate( -50%, -50% );
	}
#register25{
	width:400px;
	top:960px;}	

body{
background-image: url('${cpath }/frontDesign/imageSource/배경6.png');
    background-size : cover;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>

	<jsp:include page="../mainView/header.jsp">
		<jsp:param name="pageName" value="회원가입"/>
	</jsp:include>

   <section>
   <div class="content25">
	<form action="register.do" method="post" class="billing-form">
	<img src="${cpath }/frontDesign/imageSource/환영합니다.png" id="text-image25" style="width: 400px;">     
		
		<div id="register25" >
		<div class="id_area form-group">
				<label for="register_id">아이디</label>
			<input type="text" id="register_id" name="member_id" placeholder="아이디를 입력해주세요." required>
			<div id="id_check"></div>
		</div>
 		<div class="form-group">
				<label for="register_pw">비밀번호</label>
			<input type="password" id="register_pw" name="password" placeholder="아이디를 입력해주세요." required>
		</div>
 		<div class="form-group">
				<label for="register_name">이름</label>
				<span>* 필수 항목입니다.</span>
			<input type="text" id="register_name" name="name" placeholder="사이트에서 사용할 이름을 입력해주세요.">
		</div>
 		<div class="form-group">
				<label for="register_email">이메일</label>
				<span>* 필수 항목입니다.</span>
			<input type="email" id="register_email" name="email" required>
		</div>
 		<div class="form-group">
				<label for="register_phone">전화번호</label>
			<input type="text" id="register_phone" name="phone_number">
		</div>
 		<div class="form-group">
			<label for="register_security" >나의 보물 1호는?</label>
			<span>본인확인용 질문입니다.</span>
			<input type="text" id="register_security" name="security"
				placeholder="비밀번호 분실 시 사용됩니다." required>
		</div>
		<div class="form-group">
			<input id="reg_submit" type="submit" value="가입하기">
		</div>
	</div>
	</form>
	</div>
    </section>
    
    <jsp:include page="../mainView/footer.jsp">
		<jsp:param name="top" value="920"/>
	</jsp:include>

	<script>
		// 아이디 유효성 검사(1 = 중복 / 0 != 중복)
		$("#register_id").keyup(function() {
			// id = "id_reg" / name = "userId"
			var register_id = $('#register_id').val();
			$.ajax({
				// 아이디 체크하는 서블릿??
				url : 'idCheck.do/' + register_id,
				type : 'get',
				success : function(data) {
					console.log("1 = 중복o / 0 = 중복x : " + data);

					if (data == 1) {
						// 1 : 아이디가 중복되는 문구
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
					console.log("실패");
				}
			});
		});
	</script>
</body>
</html>