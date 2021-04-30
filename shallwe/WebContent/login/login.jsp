<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
	<jsp:include page="../frontDesign/header.jsp">
		<jsp:param name="pageName" value="로그인"/>
	</jsp:include>


   <section>
   <div class="content25">
	
		<div class="login_area">
		<form action="Login" method="post" class="billing-form">
			<div class="form-group"><input type="text" name="memberid" value="mem1" placeholder="ID" style="width:300px;"></div>
			<div class="form-group"><input type="password" name="memberpw" value="1234" placeholder="PASSWORD" style="width:300px;"></div>
			<input type="submit" value="로그인" id="btn_submit">
		</form>
		</div>
		

	</div>
    </section>

    <jsp:include page="../frontDesign/footer.jsp">
		<jsp:param name="top" value="400"/>
	</jsp:include>

</body>
</html>