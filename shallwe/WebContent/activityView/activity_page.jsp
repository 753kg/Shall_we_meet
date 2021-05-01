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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div id="activityList">
		<c:forEach var="a" items="${alist }">
			<div class="activities">
				<h3 class="actName">${a.activity_name }</h3>
				<div class="mainAct">${a.main_activity }</div>
			</div>
		</c:forEach>
	</div>

		
		<script>
		
		</script>
</body>
</html>