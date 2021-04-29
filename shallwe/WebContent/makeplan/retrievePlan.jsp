<%@page import="shallWe.VO.PlanVO"%>
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
<title>약속조회</title>
<style>
   .plans { border: 1px solid black; }
</style>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>
   <c:forEach var="plan" items="${planlist }">
      <div class="plans">
         <p id="plan_id">plan_id : ${plan.plan_id }</p>
         <p>plan_name : ${plan.plan_name }</p>
         <p>host_id : ${plan.host_id }</p>
         <p>fixed_date : ${plan.fixed_date }</p>
         <p>hotplace_name : ${plan.hotplace_name }</p>
         <p>numbers : ${plan.numbers }</p>
         <button type="button" id="test" onclick="goToSelectLocationbyMember('${plan.plan_id }')">장소 선택하기</button>
         <button type="button" id="middle" onclick="goToCalculator('${plan.plan_id }')">중간거리 확인!</button>
         <button type="button" id="test" onclick="goToSelectDatebyMember('${plan.plan_id }')">날짜 선택하기</button>
         <button type="button" id="middle" onclick="goToCalculator('${plan.plan_id }')">중간거리 확인!</button>
      </div>
   </c:forEach>
   
   
   <button type="button" id="btn_makePlan">약속만들기</button>
   <hr>
   <form id="hlist" action="AcivitySelect">
   </form>
   
   <script type="text/javascript">
      btn_makePlan.onclick = toMakePlanPage;
      
      
      hotplaces = ['홍대', '이태원', '잠실'];
      makeBtn(hotplaces);
      
      function toMakePlanPage(){
         location.href = "Makeplan";
      }
      
      function makeBtn(hosplaces){
         
       for(let i=0; i<hotplaces.length; i++){
            var atr = hotplaces[i];
            var newBtn = document.createElement("input");
            newBtn.type = "submit";
            newBtn.value = atr;
            newBtn.name = "location_name";
            hlist.appendChild(newBtn);
         }
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
      
   </script>
</body>
</html>