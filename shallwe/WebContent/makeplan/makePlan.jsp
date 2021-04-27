<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 약속 만들기</title>

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
		        	<p class="mb-0"><a href="#" class="mr-2">Sign Up</a> <a href="../login/login.jsp">LogIn</a></p>
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
          	<p class="breadcrumbs mb-0"><span class="mr-2"><a href="../mainView/main.jsp">Home <i class="fa fa-chevron-right"></i></a></span> <span>약속 <i class="fa fa-chevron-right"></i></span></p>
            <img class="header-title25" src ="../frontDesign/imageSource/새약속만들기.png"> 
          </div>
        </div>
      </div>
    </section>


   <section>
   <div class="content25">
   	<div class="host-select25">
   		<button id="btn_date"><img src="../frontDesign/imageSource/selectdate2.png" style="width:300px"></button>
   		<button id="btn_place"><img src="../frontDesign/imageSource/selectplace2.png" style="width:300px"></button>
   		<br>
   		<button id="btn_datePlace"><img src="../frontDesign/imageSource/selectboth2.png" style="width:605px"></button>
   	</div>
   	
   	<form id="makePlanForm" action="Makeplan" method="post" class="billing-form" >
		<div class="form-group">
			<label for="plan_name">약속 이름</label>
			<input type="text" class="form-control" id="plan_name" name="plan_name" style="width:300px;"  placeholder="약속의 이름을 입력해주세요.">
		</div>
		<%-- 장소 버튼 누르면 사라짐 --%>
		<div id="select_date" class="form-group">
			<label for="host_date">가능한 날짜</label>
			<input type="date" class="form-control" id="host_date" name="host_date" placeholder="날짜를 선택해주세요.">
		</div>
		<%-- 날짜 버튼 누르면 사라짐 --%>
		<div id="select_place" class="form-group">
			<label for="host_place">출발지</label>
			<input type="text" class="form-control" id="host_place" name="host_place" placeholder="출발지를 선택해주세요.">
		</div>
		<button type="button" id="btn_invite" style="width:300px;"  >친구 추가하기</button>
		<div id="friend_list">
		</div>
		<%-- hidden 으로 보내기 --%>
		<div class="form-group">
			<input type="hidden" id="host_id" name="host_id" value="${memberid }">
		</div>
		<button type="button" id="btn_submit" style="width:300px; background-color: black; color:white;"  >완료</button>
		<!-- <input type="submit" value="완료"> -->
 	</form>
  

		
	
	
	<script>
		btn_date.onclick = form1;
		btn_place.onclick = form2;
		btn_datePlace.onclick = form3;
		btn_invite.onclick = inviteFriend;
		btn_submit.onclick = submitForm;
		
		function form1(){
			document.getElementById("select_date").style.display = "block";
			document.getElementById("select_place").style.display = "none";
		}
		
		function form2(){
			document.getElementById("select_date").style.display = "none";
			document.getElementById("select_place").style.display = "block";
		}
		
		function form3(){
			document.getElementById("select_date").style.display = "block";
			document.getElementById("select_place").style.display = "block";
		}
		
		var flist = document.getElementById("friend_list");
		var count = 1;
		var i = 1;
		function inviteFriend(){
			var atr = "friend" + i;
			
			var newDIV = document.createElement("div");
			newDIV.className = atr;
			
			var newInput = document.createElement("input");
			newInput.type = "text";
			newInput.style ="width:250px; margin:10px 0;";
			//newInput.id = atr;
			newInput.name = atr;
			newInput.placeholder = "친구의 아이디를 입력해주세요.";
			
			var newBtn = document.createElement("input");
			newBtn.type = "button";
			//newBtn.id = "btn_delete" + i;
			newBtn.value = "삭제";
			newBtn.onclick = deleteFriend;
						
			newDIV.appendChild(newInput);
			newDIV.appendChild(newBtn);
			flist.appendChild(newDIV);
			
			
			i = i + 1;
			count = count + 1;
			console.log(count);
		}
		
		function deleteFriend(){
			var parent = this.parentNode;
			parent.parentNode.removeChild(parent);
			count = count - 1;
			console.log(count);
		}
		
		function submitForm(){
			var cdiv = document.createElement("div");
			var cinput = document.createElement("input");
			cinput.type = "hidden";
			cinput.name = "membercount";
			cinput.value = count;
			cdiv.appendChild(cinput);
			makePlanForm.appendChild(cdiv);
			makePlanForm.submit();
		}
	</script>
    </div>
    </section>


    <section class="footer25" style="position:relative; top:900px;">
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




