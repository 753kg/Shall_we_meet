<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String top = request.getParameter("top");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
    
    <section class="footer25" style="position:relative; top:<%=top%>px;">
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