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
		<%-- 장소 버튼 누르면 사라짐 --%>
		<div id="select_date">
			<label for="host_date"></label>
			<input type="date" id="host_date" name="host_date" placeholder="날짜선택">
		</div>
		<%-- 날짜 버튼 누르면 사라짐 --%>
		<div id="select_place">
			<label for="host_place"></label>
			<input type="text" id="host_place" name="host_place" placeholder="장소선택">
		</div>
		<button type="button" id="btn_invite">친구초대</button>
		<div id="friend_list">
		</div>
		<%-- hidden 으로 보내기 --%>
		<div id="hiddenlist">
			<input type="hidden" id="host_id" name="host_id" value="${memberid }">
			<input type="hidden" id="host_lat" name="host_lat">
			<input type="hidden" id="host_lon" name="host_lon">
			<input type="hidden" id="host_dates" name="host_dates">
			
		</div>
		<button type="button" id="btn_submit">완료</button>
		<!-- <input type="submit" value="완료"> -->
 </form>
	<div id ="ajaxTest"></div>
	<script>
		var arr =[];
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
			newInput.name = atr;
			newInput.placeholder = "친구아이디입력";
			newInput.onblur = idCheck;
			
			var newBtn = document.createElement("input");
			newBtn.type = "button";
			//newBtn.id = "btn_delete" + i;
			newBtn.value = "삭제";
			newBtn.onclick = deleteFriend;
			
			var newText = document.createElement("div");
			newText.className = "id_check";
			$(newText).text("아이디체크칸22");
						
			newDIV.appendChild(newInput);
			newDIV.appendChild(newBtn);
			newDIV.appendChild(newText);
			
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
			
			//console.log(arr === null);
			//console.log(arr.toString());
			host_dates.value = arr.toString();
			
			makePlanForm.submit();
		}
		
		$(function() {
		$("#btn_place").on("click", function() {
			$.ajax({
				url:"locationRetrieveBySearch.jsp",
				type:"get",
				success:function(responsedata){
					$("#ajaxTest").html(responsedata);
				},
				error:function(){}
			}); 
			});
		})
		
		$(function() {
		$("#btn_date").on("click", function() {
			$.ajax({
				url:"../date/masterSelectDate.jsp",
				type:"get",
				success:function(responsedata){
					$("#select_date").html(responsedata);
				},
				error:function(){}
			}); 
			});
		})
		
		$(function() {
		$("#btn_datePlace").on("click", function() {
			$.ajax({
				url:"locationRetrieveBySearch.jsp",
				type:"get",
				success:function(responsedata){
					$("#ajaxTest").html(responsedata);
				},
				error:function(){}
			}); 
		
			$.ajax({
				url:"../date/masterSelectDate.jsp",
				type:"get",
				success:function(responsedata){
					$("#select_date").html(responsedata);
				},
				error:function(){}
			}); 
			});
		})
		
		function idCheck() {
			var register_id = $(this).val();
			var input = $(this);
			console.log("this: " + register_id);
			console.log($(this).siblings(".id_check").text());
			
			$.ajax({
				// 아이디 체크하는 서블릿??
				url : '../login/IDCheck?register_id=' + register_id,
				type : 'get',
				success : function(data) {
					console.log("1 = 중복o / 0 = 중복x : " + data);

					if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						console.log("초대가능");
						$(input).siblings(".id_check").text("초대가능");
						$(input).siblings(".id_check").css("color", "green");
						$("#btn_submit").attr("disabled", false);
					} else {
						
						if(register_id == ""){
							console.log("친구아이디를 입력하세요");
							$(input).siblings(".id_check").text("친구아이디를 입력하세요");
							$(input).siblings(".id_check").css("color", "red");
							$("#btn_submit").attr("disabled", true);
						} else {
							console.log("존재하지 않는 아이디입니다.");
							$(input).siblings(".id_check").text("존재하지 않는 아이디입니다.");
							$(input).siblings(".id_check").css("color", "red");
							$("#btn_submit").attr("disabled", true);
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