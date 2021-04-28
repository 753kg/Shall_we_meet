<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
    

  
</body>
</html>