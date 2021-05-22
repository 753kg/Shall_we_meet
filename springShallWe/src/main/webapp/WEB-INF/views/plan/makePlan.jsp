<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<title>새 약속 만들기</title>
<!-- 전체 Design -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${cpath }/frontDesign/css/animate.css">   
    <link rel="stylesheet" href="${cpath }/frontDesign/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${cpath }/frontDesign/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${cpath }/frontDesign/css/magnific-popup.css">
    <link rel="stylesheet" href="${cpath }/frontDesign/css/flaticon.css">
    <link rel="stylesheet" href="${cpath }/frontDesign/css/style.css">
<!-- jquery, ajax -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- kakaomap api -->
	<%-- 유연이 --%>
	<%-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35d879296edd941fd4f9bdae91769fa4&libraries=services"></script> --%>
	<%--채연 --%>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=45af73bc6fe5e770ab55284433281c70&libraries=services"></script>
	<%--주희 --%>
	<%--<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e4f8aeb0d5079a18f159c0c6462fa4de&libraries=services"></script> --%>

<style>
body{
background-image: url('${cpath }/frontDesign/imageSource/배경2.png');
    background-size : cover;
}
	#friend_list > input {
		display: block;
	}
	html {
 		 scroll-behavior: smooth;
 	}
#btn_invite{
border-radius: 10px;
}
#btn_invite:hover{
color:#A5D9CD;
 background-color: black;
}	
</style>
</head>

<body>
	<jsp:include page="../mainView/header_plan.jsp">
		<jsp:param name="pageName" value="새약속만들기"/>
	</jsp:include>

<!-- 본문 시작 --> 
<section>
   <div class="content25">
   <!-- 버튼 : 날짜만 or 장소만 or 둘 다 -->
   	<div class="host-select25">
   		<button id="btn_date"><img src="${cpath }/frontDesign/imageSource/selectdate2.png" style="width:300px"></button>
   		<button id="btn_place"><img src="${cpath }/frontDesign/imageSource/selectplace2.png" style="width:300px"></button>
   		<br>
   		<button id="btn_datePlace"><img src="${cpath }/frontDesign/imageSource/selectboth2.png" style="width:605px"></button>
   	</div>
   	
   	<!-- 폼 -->
   	<form id="makePlanForm" action="makeplan.do" method="post" class="billing-form" >
		<div class="form-group">
			<label for="plan_name">약속 이름</label><br>
			<input type="text" id="plan_name" name="plan_name" style="width:300px;"  placeholder="약속의 이름을 입력해주세요.">
		</div>
		<%-- 장소 버튼 누르면 사라짐 --%>
		<div id="select_date" class="form-group">
		</div>
		<%-- 날짜 버튼 누르면 사라짐 --%>
		<div id="select_place" class="form-group">
			<label for="host_place">출발지</label><br>
			<a href="#ajaxTest" >
			<input type="text" id="host_place" name="host_place" placeholder="아래 지도에서 출발지를 검색해주세요.">
			</a>
		</div>
		<button type="button" id="btn_invite" style="width:300px;"  >친구 추가하기</button>
		<div id="friend_list">
		</div>
		<%-- hidden 으로 보내기 --%>
		<div class="form-group">
			<input type="hidden" id="host_id" name="host_id" value="${memberid }">
			<input type="hidden" id="host_lat" name="host_lat">
			<input type="hidden" id="host_lon" name="host_lon">
			<input type="hidden" id="host_dates" name="host_dates">
		</div>
		<div class="form-group">
		
		<button type="button" id="btn_submit" style="float:none;">완료</button>
		</div>
		
 	</form>
 	</div>
	<div id ="ajaxTest"></div>
	</section>

<!-- footer -->
    <jsp:include page="../mainView/footer.jsp">
		<jsp:param name="top" value="1400"/>
	</jsp:include>

	<script>
		var arr = [];
		
		btn_date.click();
		
		function dateAJAX(){
			$.ajax({
				url : "showCalendar.do",
				type : "get",
				success : function(responsedata) {

					$("#select_date").html(responsedata);
				},
				error : function() {
				}
			});
		}
		
		function mapAJAX(){
			$.ajax({
				url : "showMap.do",
				type : "get",
				success : function(responsedata) {
					$("#ajaxTest").html(responsedata);
				},
				error : function() {
				}
			});
		}
		
		$("#btn_date").on("click", function() {
			document.getElementById("select_date").style.display = "block";
			document.getElementById("select_place").style.display = "none";
			document.getElementById("ajaxTest").style.display = "none";
			dateAJAX();
		});
		
		$("#btn_place").on("click", function() {
			document.getElementById("select_date").style.display = "none";
			document.getElementById("select_place").style.display = "block";
			document.getElementById("ajaxTest").style.display = "block";
			mapAJAX();
		});
		
		$("#btn_datePlace").on("click", function() {
			document.getElementById("select_date").style.display = "block";
			document.getElementById("select_place").style.display = "block";
			document.getElementById("ajaxTest").style.display = "block";
			dateAJAX();
			mapAJAX();
		});

		btn_invite.onclick = inviteFriend;
		btn_submit.onclick = submitForm;

		var flist = document.getElementById("friend_list");
		var count = 1;
		var i = 1;
		function inviteFriend() {
			var atr = "friend" + i;

			var newDIV = document.createElement("div");
			newDIV.className = atr;

			var newInput = document.createElement("input");
			newInput.type = "text";
			newInput.name = atr;
			newInput.style = "width:250px; margin:10px 0;padding:5px;";
			newInput.placeholder = "친구아이디입력";
			newInput.onkeyup = idCheck;

			var newBtn = document.createElement("input");
			newBtn.type = "button";
			newBtn.value = "삭제";
			newBtn.style = "width:44px; margin-left:4px; padding:1px;";
			newBtn.onclick = deleteFriend;

			var newText = document.createElement("div");
			newText.className = "id_check";

			newDIV.appendChild(newInput);
			newDIV.appendChild(newBtn);
			newDIV.appendChild(newText);

			flist.appendChild(newDIV);

			i = i + 1;
			count = count + 1;
			console.log(count);
		}

		function deleteFriend() {
			var parent = this.parentNode;
			parent.parentNode.removeChild(parent);
			count = count - 1;
			console.log(count);
		}

		function submitForm() {
			var cdiv = document.createElement("div");
			var cinput = document.createElement("input");
			cinput.type = "hidden";
			cinput.name = "membercount";
			cinput.value = count;
			cdiv.appendChild(cinput);
			makePlanForm.appendChild(cdiv);

			//console.log(arr === null);
			//console.log(arr.toString());
			host_dates.value = arr.toString();

			makePlanForm.submit();
		}

		function idCheck() {
			var friend_id = $(this).val();
			var input = $(this);

			$.ajax({
						// 아이디 체크하는 서블릿
						url : '../idCheck.do/' + friend_id,
						type : 'get',
						success : function(data) {
							console.log("1 = 중복o / 0 = 중복x : " + data);

							if (data == 1) { // 1 : 아이디가 존재하면
								$(input).siblings(".id_check").text("초대가능");
								$(input).siblings(".id_check").css("color", "green");
							} else {

								if (friend_id == "") {
									$(input).siblings(".id_check").text("친구의 아이디를 입력해주세요.");
									$(input).siblings(".id_check").css("color","red");
								} else {
									$(input).siblings(".id_check").text("존재하지 않는 아이디입니다.");
									$(input).siblings(".id_check").css("color","red");
								}
							}
						},
						error : function() {
							console.log("실패");
						}
					});

		}
	</script>
	

</body>
</html>