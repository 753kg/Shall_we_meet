<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String pageName = request.getParameter("pageName");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<title>Insert title here</title>
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
		        	<p class="mb-0"><a href="${cpath }/register.do" class="mr-2">Sign Up</a>
		        	<% String memberid = (String) session.getAttribute("memberid"); %>
					<% if(memberid == null) {%>
						<a href="${cpath }/login.do">LogIn</a>
					<%} else { %>
						<a href="${cpath }/logout.do">LogOut</a></p>
					<%}%>
		        </div>
					</div>
				</div>
			</div>
		</div>
    
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="${cpath }/main.do">Shall <span>We </span>Meet</a>
	      
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="${cpath }/main.do" class="nav-link" >Home</a></li>
	          <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">약속</a>
              <div class="dropdown-menu" aria-labelledby="dropdown04" style="font-family: 'IBMPlexSansKR-Regular';
    font-size: 12.5px;">
              	<a class="dropdown-item" href="${cpath }/plan/makeplan.do" >새 약속 만들기</a>
                <a class="dropdown-item" href="${cpath }/plan/planlist.do">내 약속 보기</a>
              </div>
            </li>
	          <li class="nav-item"><a href="${cpath }/plan/planlist.do" class="nav-link">날짜 입력하기</a></li>
	          <li class="nav-item"><a href="${cpath }/plan/planlist.do" class="nav-link">출발지 입력하기</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
   <section class="hero-wrap hero-wrap-2" style="background-image: url('${cpath }/frontDesign/imageSource/배경이미지.png');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate mb-5 text-center">
          	<p class="breadcrumbs mb-0"><span class="mr-2"><a href="${cpath }/main.do">Home <i class="fa fa-chevron-right"></i></a></span> <span>약속 <i class="fa fa-chevron-right"></i></span></p>
            <img class="header-title25" src ="${cpath }/frontDesign/imageSource/<%=pageName%>.png"/> 
          </div>
        </div>
      </div>
    </section>
 
</body>
</html>