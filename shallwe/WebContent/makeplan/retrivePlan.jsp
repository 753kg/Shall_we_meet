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
</head>
<body>
	<c:forEach var="plan" items="${planlist }">
		<div class="plans">
			<p>plan_id : ${plan.plan_id }</p>
			<p>plan_name : ${plan.plan_name }</p>
			<p>host_id : ${plan.host_id }</p>
			<p>fixed_date : ${plan.fixed_date }</p>
			<p>hotplace_name : ${plan.hotplace_name }</p>
			<p>numbers : ${plan.numbers }</p>
		</div>
	</c:forEach>
	
	<button id="btn_makePlan">약속만들기</button>
	
	<script type="text/javascript">
		btn_makePlan.onclick = toMakePlanPage;
		
		function toMakePlanPage(){
			location.href = "makePlan.jsp";
		}
	</script>
</body>
</html>