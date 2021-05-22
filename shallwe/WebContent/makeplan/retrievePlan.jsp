
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 약속 보기</title>
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
	<%--주희 --%>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e4f8aeb0d5079a18f159c0c6462fa4de&libraries=services"></script>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	body{
		background-image: url('../frontDesign/imageSource/배경2.png');
    	background-size : cover;
	}
   .plans { 
   		float:left;
   		border: 1px solid pink;
   		border-left:none; 
   		border-right:none; 
   		border-bottom:none; 
   		width:450px;
   		margin:10px;
   		padding:20px 0 50px 0;
   		text-align: center;
   		}
   	#retrieve-plan{
   	position:relative;
   	width:940px;
   	margin: 0px auto;
   	top:250px;
   	}
   	#btn_makePlan{
  
  
  background-color:  rgb(255,220,104); /* Green */
  border: none;
  border-radius: 4px;
  color: black;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
   	}
   	.btn_makePlan:hover {
  background-color:rgb(39,39,39);
  color: white;
  letter-spacing: 5px;
  font-family: 'IBMPlexSansKR-Regular';
}
#text-image25{
	position:absolute; 
	width:1100px;top:550px;left: 50%;
	transform: translate( -50%, -50% );
	}
#makePlanbtn-actlistbtn{
float:none;
	   	top:600px;
	right:5%;
	position:fixed;
	}
button{
border-radius: 10px;
}
button:hover{
color:#A5D9CD;
 background-color: black;
}
.plans span{
font-family: 'Wemakeprice-Bold';
font-size: 18px; }
#planname{
padding:5px 10px;
border-radius: 5px;
 font-family: 'Binggrae-Bold';
 background-color: pink;
 width:450px;
 display: inline-block;
 }
	#footer{
	visibility: hidden;}</style>
</head>

<body>
   <jsp:include page="../frontDesign/header_plan.jsp">
		<jsp:param name="pageName" value="내약속보기"/>
	</jsp:include>
	
<!-- 본문 시작 --> 
	<section>
   <div class="content25">
   <img src="../frontDesign/imageSource/약속을확인하세요.png" id="text-image25" style="height: 125px; width:auto; left:630px;">     
	
   <div id="retrieve-plan">
   <c:forEach var="plan" items="${planlist }">
      <div class="plans" >
         <!-- 
         <p id="plan_id">plan_id : ${plan.plan_id }</p>
          -->
         <p><span id="planname">${plan.plan_name }</span>  </p>
         <p><span>주최자     </span>   ${plan.host_id }</p>
         <p><span>날짜     </span>   ${plan.fixed_date }</p>
         <p><span>장소     </span>   ${plan.hotplace_name }</p>
         <!-- 
         <p>numbers : ${plan.numbers }</p>
          -->
         <button type="button" id="test" onclick="goToSelectLocationbyMember('${plan.plan_id }')">출발지 입력</button>
         <button type="button" id="selectDate" onclick="goToSelectDatebyMember('${plan.plan_id }')">날짜 입력</button>
         <button type="button" id="middle" onclick="goToCalculator('${plan.plan_id }')">장소 추천받기</button>
         <button type="button" id="fixDate" onclick="goToFixDate('${plan.plan_id }')">날짜 추천받기 </button>
      </div>
     
   </c:forEach>
    </div>
   
	<div id="makePlanbtn-actlistbtn">
   <button type="button" id="btn_makePlan">새 약속 만들기</button>

   </div>
   </div>
    </section>
	
    <!-- footer -->
    <div id="footer">
    <jsp:include page="../frontDesign/footer.jsp">
		<jsp:param name="top" value="800"/>
	</jsp:include>
	</div>

   
   <script type="text/javascript">
      btn_makePlan.onclick = toMakePlanPage;
      
      
      
      
      function toMakePlanPage(){
         location.href = "Makeplan";
      }
      
     
      function goToSelectLocationbyMember(planid) {
         location.href ="FindDeparture?plan_id="+planid;
      }
      function goToCalculator(planid) {
         location.href = "calculator?plan_id="+planid;
      }
      function goToSelectDatebyMember(planid) {
         location.href ="../masterDateList?plan_id="+planid;
      }
      function goToFixDate(planid) {
         location.href ="../memberDateList?plan_id="+planid;
      }
      
   </script>
</body>
</html>