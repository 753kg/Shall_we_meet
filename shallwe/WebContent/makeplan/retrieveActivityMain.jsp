<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${location_name }의 액티비티 조회 페이지</h1>
	<button id="btn_restaurants">식당</button>
	<button id="btn_cafes">카페</button>
	<button id="btn_activities">액티비티</button>
	
	<div id="activities"></div>
	
	<script>
	btn_restaurants.onclick = function(){
		activities.innerHTML = `
			<c:forEach var="r" items="${rlist }">
			<div class="list">
				<p><img src="${r.image }"></p>
				<p>${r.restaurant_name }</p>
				<p>${r.main_food }</p>
				<p>${r.full_address }</p>
				<p>${r.likes }</p>
			</div>
		</c:forEach>
		`;
	};
	
	btn_cafes.onclick = function(){
		activities.innerHTML = `
			<c:forEach var="c" items="${clist }">
			<div class="list">
				<p><img src="${c.image }"></p>
				<p>${c.cafe_name }</p>
				<p>${c.main_food }</p>
				<p>${c.full_address }</p>
				<p>${c.likes }</p>
			</div>
			</c:forEach>
		`;
	};
	
	btn_activities.onclick = function(){
		activities.innerHTML = `
			<c:forEach var="a" items="${alist }">
			<div class="list">
				<p>${a.activity_name }</p>
				<p>${a.main_activity }</p>
			</div>
		</c:forEach>
		`;
	};
	</script>
</body>
</html>