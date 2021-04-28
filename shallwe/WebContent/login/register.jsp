<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../frontDesign/css/animate.css">   
    <link rel="stylesheet" href="../frontDesign/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../frontDesign/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../frontDesign/css/magnific-popup.css">
    <link rel="stylesheet" href="../frontDesign/css/flaticon.css">
    <link rel="stylesheet" href="../frontDesign/css/style.css">
</head>

<body>

	<%@include file="../frontDesign/header.jsp" %>
	
    
    <section class="hero-wrap hero-wrap-2" style="background-image: url('../frontDesign/imageSource/배경이미지.png');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate mb-5 text-center">
          	<p class="breadcrumbs mb-0"><span class="mr-2"><a href="../mainView/main.jsp">Home <i class="fa fa-chevron-right"></i></a></span> </p>
            <img class="header-title25" src ="../frontDesign/imageSource/회원가입.png"> 
          </div>
        </div>
      </div>
    </section>


   <section>
   
   <div class="content25">
   
	<form action="Register" method="post" class="billing-form" style="width:400px;">
		<div id="register25">
		<div class="form-group">
			<label for="register_id">아이디</label>
			<input type="text" id="register_id" name="register_id"  >
		</div>
 		<div class="form-group">
			<label for="register_pw">비밀번호</label>
			<input type="password" id="register_pw" name="register_pw" >
		</div>
		<div class="form-group">
			<label for="register_name">이름</label>
			<input type="text" id="register_name" name="register_name">
		</div>
		<div class="form-group">
			<label for="register_email">이메일</label>
			<input type="email" id="register_email" name="register_email" >
		</div>
		<div class="form-group">
			<label for="register_phone">전화번호</label>
			<input type="text" id="register_phone" name="register_phone">
		</div>
		<div class="form-group">
			<label for="register_security" style="float:right; font-size:14px;">본인확인용 질문</label>
			<span style="float:left;">나의 보물 1호는?</span>
			<input type="text" id="register_security" name="register_security" placeholder="답">
		</div>
		<div class="form-group">
			<input type="submit" value="가입하기" id="btn_submit">
		</div>
	</div>
	</form>
</div>
    </section>


	<section class="footer25" style="position:relative; top:800px;">
	<%@include file="../frontDesign/footer.jsp" %>

</body>
</html>