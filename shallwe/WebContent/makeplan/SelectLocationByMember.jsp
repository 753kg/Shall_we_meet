<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출발지 선택하기</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../frontDesign/css/animate.css">   
    <link rel="stylesheet" href="../frontDesign/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../frontDesign/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../frontDesign/css/magnific-popup.css">
    <link rel="stylesheet" href="../frontDesign/css/flaticon.css">
    <link rel="stylesheet" href="../frontDesign/css/style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=45af73bc6fe5e770ab55284433281c70&libraries=services"></script>
<style>
 #makePlanForm{
	top:500px;
	left: 50%;
	transform: translate( -50%, -50% );
	width:1100px;
 }
 #btn_submit{
	float:right;}
 #select_place{
	position:absolute;
	top:650px;
	left:25.3%;
}
 #host_place{
	width:400px;
	}
 #btn_submit{
 	width: 100px;}

</style>
</head>

<body>
	<jsp:include page="../frontDesign/header.jsp">
		<jsp:param name="pageName" value="출발지입력하기"/>
	</jsp:include>



   <section>
   
   <div class="content25">


      <div id ="ajaxTest" style="top:850px;"></div>
     
      <form id="makePlanForm" action="FindDeparture" method="post" >  
       <img src="../frontDesign/imageSource/지도에서출발지를선택해주세요.png" style="width:1100px;">      
      <div id="select_place" >
         <label for="host_place"></label>
         <span>선택한 출발지가 맞으면 확인을 눌러주세요.</span>
         <input type="text" id="host_place" name="host_place" placeholder="선택된 장소">
      	<button type="submit" id="btn_submit">확인</button>
      </div>
      <%-- hidden 으로 보내기 --%>
      <div>
         <input type="hidden" id="member_id" name="member_id" value="${memberid }">
         <input type="hidden" id="plan_id" name="plan_id" value="${planid }">
         <input type="hidden" id="member_lat" name="member_lat" value="">
         <input type="hidden" id="member_lon" name="member_lon" value="">
      </div>
      
      <!-- <input type="submit" value="완료"> -->
   <!-- <form id="aa" action="FindDeparture" method="post">
      <input type="text" name="location" id="location" value=""> 
       <input type="submit" value="수정하기"> -->
   </form>
   
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
</div>
    </section>
    
    <jsp:include page="../frontDesign/footer.jsp">
		<jsp:param name="top" value="800"/>
	</jsp:include>

</body>
</html>