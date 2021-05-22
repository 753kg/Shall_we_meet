<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<link href="${cpath }/frontDesign/css/activityView.css" rel="stylesheet">
</head>
<body>
	<div id="activityList">
		<c:forEach var="r" items="${rlist }">
			<div class="activities">
				<h3 class="actName">${r.restaurant_name }</h3>
				<div><img src="${r.image}"></div>
				<div class="mainAct">${r.main_food }</div>
				<div class="actAddr">${r.full_address }</div>
				<div class="actLike">${r.likes }</div>
			</div>
		</c:forEach>
	</div>

		
		<script>
		
		</script>
</body>
</html>