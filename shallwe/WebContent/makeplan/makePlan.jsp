<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
	#friend_list > input {
		display: block;
	}
</style>
	<!-- <script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35d879296edd941fd4f9bdae91769fa4&libraries=services"></script> -->
	<%--채연 --%>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=45af73bc6fe5e770ab55284433281c70&libraries=services"></script>


</head>
<body>
	<h1>makePlanPage</h1>
	<button id="btn_date">날짜</button>
	<button id="btn_place">장소</button>
	<button id="btn_datePlace">날짜 + 장소</button>
	
	
	<form id="makePlanForm" action="Makeplan" method="post">  
		<div>
			<label for="plan_name"></label>
			<input type="text" id="plan_name" name="plan_name" placeholder="약속이름">
		</div>
		<div id="select_date">
		</div>
		<div id="select_place">
			<label for="host_place"></label>
			<input type="text" id="host_place" name="host_place" placeholder="장소선택">
		</div>
		<button type="button" id="btn_invite">친구초대</button>
		<div id="friend_list">
		</div>
		<div id="hiddenlist">
			<input type="hidden" id="host_id" name="host_id" value="${memberid }">
			<input type="hidden" id="host_lat" name="host_lat">
			<input type="hidden" id="host_lon" name="host_lon">
			<input type="hidden" id="host_dates" name="host_dates">
			<input type="hidden" id="membercount" name="membercount">
		</div>
		<button type="button" id="btn_submit">완료</button>
 </form>
	<div id ="map_area"></div>
	<script>
		var arr = [];
		btn_submit.onclick = function(){
			membercount.value = count;
			host_dates.value = arr.toString();
			makePlanForm.submit();
		}
		
		function dateAJAX(){
			$.ajax({
				url : "../date/masterSelectDate.jsp",
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
				url : "locationRetrieveBySearch.jsp",
				type : "get",
				success : function(responsedata) {
					$("#map_area").html(responsedata);
				},
				error : function() {
				}
			});
		}
		
		$("#btn_date").on("click", function() {
			$("#select_date").css("display", "block");
			$("#select_place").css("display", "none");
			$("#map_area").css("display", "none");
			dateAJAX();
		});
		
		$("#btn_place").on("click", function() {
			$("#select_date").css("display", "none");
			$("#select_place").css("display", "block");
			$("#map_area").css("display", "block");
			mapAJAX();
		});
		
		$("#btn_datePlace").on("click", function() {
			$("#select_date").css("display", "block");
			$("#select_place").css("display", "block");
			$("#map_area").css("display", "block");
			dateAJAX();
			mapAJAX();
		});
	


		btn_invite.onclick = inviteFriend;
		
		var flist = document.getElementById("friend_list");
		var count = 1;
		var i = 1;
		function inviteFriend() {
			var atr = "friend" + i;

			var newDIV = document.createElement("div");
			newDIV.className = "friends";

			var newInput = document.createElement("input");
			newInput.type = "text";
			newInput.name = atr;
			newInput.placeholder = "친구아이디입력";
			newInput.onkeyup = idCheck;

			var newBtn = document.createElement("input");
			newBtn.type = "button";
			newBtn.value = "삭제";
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

		

		function idCheck() {
			var member_id = $(this).val();
			var input = $(this);
			$.ajax({
						url : '../login/IDCheck?member_id=' + member_id,
						type : 'get',
						success : function(data) {
							if (data == 1) { // 1 : 아이디가 존재하면
								$(input).siblings(".id_check").text("초대가능");
								$(input).siblings(".id_check").css("color", "green");
							} else {
									if (member_id == "") {
										$(input).siblings(".id_check").text("친구아이디를 입력하세요");
										$(input).siblings(".id_check").css("color","red");
									} else {
										$(input).siblings(".id_check").text("존재하지 않는 아이디입니다.");
										$(input).siblings(".id_check").css("color","red");
									}
							}
						},
						error : function() {
							console.log("친구 초대 실패");
						}
					});
		}
	</script>
</body>
</html>