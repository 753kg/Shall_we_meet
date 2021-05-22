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
		<c:forEach var="s" items="${slist }">
			<div class="activities">
				<h3 class="actName">${s.restaurant_name }</h3>
				<div class="mainAct">${s.category }</div>
				<div class="actAddr">${s.full_address }</div>
			</div>
		</c:forEach>
	</div>

		
		<script>
		
		</script>
</body>
</html>