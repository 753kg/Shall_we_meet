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
<link href="/shallwe/activityView/activityView.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div id="activityList">
		<c:forEach var="c" items="${clist }">
			<div class="activities">
				<h3 class="actName">${c.cafe_name }</h3>
				<div><img src="${c.image}"></div>
				<div class="mainAct">${c.main_food }</div>
				<div class="actAddr">${c.full_address }</div>
				<div class="actLike">${c.likes }</div>
			</div>
		</c:forEach>
	</div>

		
		<script>
		
		</script>
</body>
</html>