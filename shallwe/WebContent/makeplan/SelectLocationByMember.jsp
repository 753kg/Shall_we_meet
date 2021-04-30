<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%--유연 --%>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35d879296edd941fd4f9bdae91769fa4&libraries=services"></script>
	<%--채연 --%>
	<!-- <script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=45af73bc6fe5e770ab55284433281c70&libraries=services"></script> -->
</head>
<body>
<h1>장소선택하기</h1>
	<form id="makePlanForm" action="FindDeparture" method="post">  
		<%-- 날짜 버튼 누르면 사라짐 --%>
		<div id="select_place">
			<label for="host_place"></label>
			<input type="text" id="host_place" name="host_place" placeholder="장소선택">
		</div>
		<%-- hidden 으로 보내기 --%>
		<div>
			<input type="hidden" id="member_id" name="member_id" value="${memberid }">
			<input type="hidden" id="plan_id" name="plan_id" value="${plan_id }">
			<input type="hidden" id="member_lat" name="member_lat" value="">
			<input type="hidden" id="member_lon" name="member_lon" value="">
		</div>
		<button type="submit" id="btn_submit">완료</button>
		<!-- <input type="submit" value="완료"> -->
	<!-- <form id="aa" action="FindDeparture" method="post">
		<input type="text" name="location" id="location" value=""> 
		 <input type="submit" value="수정하기"> -->
	</form>
	<div id ="ajaxTest"></div>
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
</body>
</html>