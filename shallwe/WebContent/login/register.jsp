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

	<div class="wrap">
			<div class="container">
				<div class="row">
					<div class="col-md-6 d-flex align-items-center">
						<p class="mb-0 phone pl-md-2">
							<a href="https://github.com/e-juhee/Shall_we_meet.git"><span class="fa fa-paper-plane mr-1"></span> Shall We Meet ?</a>
						</p>
					</div>
					<div class="col-md-6 d-flex justify-content-md-end">
		        <div class="reg">
		        	<p class="mb-0"><a href="../login/register.jsp" class="mr-2">Sign Up</a> <a href="../login/login.jsp">LogIn</a></p>
		        </div>
					</div>
				</div>
			</div>
		</div>
    
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="../mainView/main.jsp">Shall <span>We </span>Meet</a>
	      
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="../mainView/main.jsp" class="nav-link" >Home</a></li>
	          <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">약속</a>
              <div class="dropdown-menu" aria-labelledby="dropdown04">
              	<a class="dropdown-item" href="../makeplan/makePlan.jsp" >새 약속 만들기</a>
                <a class="dropdown-item" href="#">내 약속 보기</a>
              </div>
            </li>
	          <li class="nav-item"><a href="#" class="nav-link">날짜 입력하기</a></li>
	          <li class="nav-item"><a href="#" class="nav-link">출발지 입력하기</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
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
      <div class="container-fluid px-0 py-5 bg-black">
      	<div class="container">
      		<div class="row">
	          <div class="col-md-12">
		
	            <p class="mb-0" style="color: rgba(255,255,255,.5); text-align:center; ">
					KOSTA Korea Software Technology Association 213 Second project    
					<i class="fa fa-heart color-danger" aria-hidden="true"></i>
					<a href="https://github.com/e-juhee/Shall_we_meet.git" target="_blank">    by 한 번 봐야조 </a>
				</p>
				
	          </div>
	        </div>
      	</div>
      </div>
    </section>
    
    
    
    
  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="../frontDesign/js/jquery.min.js"></script>
  <script src="../frontDesign/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="../frontDesign/js/popper.min.js"></script>
  <script src="../frontDesign/js/bootstrap.min.js"></script>
  <script src="../frontDesign/js/jquery.easing.1.3.js"></script>
  <script src="../frontDesign/js/jquery.waypoints.min.js"></script>
  <script src="../frontDesign/js/jquery.stellar.min.js"></script>
  <script src="../frontDesign/js/owl.carousel.min.js"></script>
  <script src="../frontDesign/js/jquery.magnific-popup.min.js"></script>
  <script src="../frontDesign/js/jquery.animateNumber.min.js"></script>
  <script src="../frontDesign/js/scrollax.min.js"></script>
  <script src="../frontDesign/js/main.js"></script>
</body>
</html>