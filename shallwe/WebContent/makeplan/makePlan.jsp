<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 약속 만들기</title>
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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	
<!-- 친구 추가 input 박스 -->
	<style>
		#friend_list > input {
			display: block;
		}
	</style>

<!-- API -->
   <!-- <script type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35d879296edd941fd4f9bdae91769fa4&libraries=services"></script> -->
   <%--채연 --%>
   <script type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=45af73bc6fe5e770ab55284433281c70&libraries=services"></script>
</head>


<body>
	<jsp:include page="../frontDesign/header_plan.jsp">
		<jsp:param name="pageName" value="새약속만들기"/>
	</jsp:include>

<!-- 본문 시작 --> 
   <section>
   <div class="content25">
   <!-- 버튼 : 날짜만 or 장소만 or 둘 다 -->
   	<div class="host-select25">
   		<button id="btn_date"><img src="../frontDesign/imageSource/selectdate2.png" style="width:300px"></button>
   		<button id="btn_place"><img src="../frontDesign/imageSource/selectplace2.png" style="width:300px"></button>
   		<br>
   		<button id="btn_datePlace"><img src="../frontDesign/imageSource/selectboth2.png" style="width:605px"></button>
   	</div>
   	
   	<!-- 폼 -->
   	<form id="makePlanForm" action="Makeplan" method="post" class="billing-form" >
		<div class="form-group">
			<label for="plan_name">약속 이름</label>
			<input type="text" class="form-control" id="plan_name" name="plan_name" style="width:300px;"  placeholder="약속의 이름을 입력해주세요.">
		</div>
		<%-- 장소 버튼 누르면 사라짐 --%>
		<div id="select_date" class="form-group">
			<label for="host_date">가능한 날짜</label>
			<input type="date" class="form-control" id="host_date" name="host_date" placeholder="날짜를 선택해주세요.">
		</div>
		<%-- 날짜 버튼 누르면 사라짐 --%>
		<div id="select_place" class="form-group">
			<label for="host_place">출발지</label>
			<input type="text" class="form-control" id="host_place" name="host_place" placeholder="아래 지도에서 출발지를 검색해주세요.">
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
		<button type="button" id="btn_submit" style="width:300px; background-color: black; color:white;"  >완료</button>
		<!-- <input type="submit" value="완료"> -->
 	</form>


	<div id ="ajaxTest"></div>
   <script>
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
         
         var newBtn = document.createElement("input");
         newBtn.type = "button";
         //newBtn.id = "btn_delete" + i;
         newBtn.value = "삭제";
         newBtn.onclick = deleteFriend;
                  
         newDIV.appendChild(newInput);
         newDIV.appendChild(newBtn);
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
         host_dates.value = arr.toString();
         makePlanForm.submit();
      }
      
      //출발지 선택 지도
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
      
      //방장 날짜 선택 달력
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
   </script>
   </div>
   </section>



<!-- footer -->
    <jsp:include page="../frontDesign/footer.jsp">
		<jsp:param name="top" value="1400"/>
	</jsp:include>

</body>
</html>




