<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출발지 입력</title>

<!-- 전체 Design -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../frontDesign/css/animate.css">   
    <link rel="stylesheet" href="../frontDesign/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../frontDesign/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../frontDesign/css/magnific-popup.css">
    <link rel="stylesheet" href="../frontDesign/css/flaticon.css">
    <link rel="stylesheet" href="../frontDesign/css/style.css">
<!-- jquery, ajax -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- kakaomap api -->
	<%--주희꼬 --%>
	<script type="text/javascript"		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e4f8aeb0d5079a18f159c0c6462fa4de&libraries=services"></script>
	<%--유연이꺼 --%>
	<%-- <script type="text/javascript"		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35d879296edd941fd4f9bdae91769fa4&libraries=services"></script>--%>
	<%--채여니꼬 --%>
	<!-- <script type="text/javascript"		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=45af73bc6fe5e770ab55284433281c70&libraries=services"></script> -->
<style>
body{
background-image: url('../frontDesign/imageSource/배경1.png');
    background-size : cover;
}
#ajaxTest{
	top:900px;
	position: absolute;
   
    left: 52.5%;
    transform: translate( -50%, -50% );
    width: 1100px;
	
	}
#makePlanForm{
	top:1230px;
	left: 65%;
	transform: translate( -50%, -50% );

	}
#makePlanForm span{
	float:right;
	
	}
#text-image25{
	position:absolute; 
	width:1100px;top:550px;left: 50%;
	transform: translate( -50%, -50% );
	}
#host_place{
width: 400px;}
#btn_submit{
width: 400px;}



</style>
</head>

<body>
	<jsp:include page="../frontDesign/header.jsp">
		<jsp:param name="pageName" value="출발지입력하기"/>
	</jsp:include>
	
	<section>
   <div class="content25">
   <img src="../frontDesign/imageSource/출발지를입력해주세요.png" id="text-image25" style="height: 125px; width:auto; left:630px;">     
	<form id="makePlanForm" class="form-group" action="FindDeparture" method="post">  
		
		<div id="select_place">
			<label for="host_place"></label>
			<span style="color:black;">선택하신 장소가 이 곳이 맞나요? </span>
			<input type="text" id="host_place" name="host_place" placeholder="선택된 장소입니다">
		</div>
		<%-- hidden 으로 보내기 --%>
		<div>
			<input type="hidden" id="member_id" name="member_id" value="${memberid }">
			<input type="hidden" id="plan_id" name="plan_id" value="${plan_id }">
			<input type="hidden" id="member_lat" name="member_lat" value="">
			<input type="hidden" id="member_lon" name="member_lon" value="">
		</div>
		<button type="submit" id="btn_submit">이 장소로 입력하기</button>
		<!-- <input type="submit" value="완료"> -->
	<!-- <form id="aa" action="FindDeparture" method="post">
		<input type="text" name="location" id="location" value=""> 
		 <input type="submit" value="수정하기"> -->
	</form>
	<div id ="ajaxTest"></div>
	
		</div>
    </section>
	
	 <jsp:include page="../frontDesign/footer.jsp">
		<jsp:param name="top" value="930"/>
	</jsp:include>
</body>


<script type="text/javascript">

$(function() {
		$.ajax({
			url:"locationRetrieveBySearch.jsp",
			type:"get",
			success:function(responsedata){
				$("#ajaxTest").html(responsedata);
				
			},
			error:function(){}
		}); 
		
	})
</script>
</html>
