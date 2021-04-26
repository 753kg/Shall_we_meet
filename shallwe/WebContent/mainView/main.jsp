<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shall We Meet?</title>
</head>
<body>
	<ul>
		<% String memberid = (String) session.getAttribute("memberid"); %>
		<% if(memberid == null) {%>
			<li><a href="../login/login.jsp">로그인</a></li>
		<%} else { %>
			<li><a href="../Logout">로그아웃</a></li>
		<%}%>
		<li><a href="../makeplan/PlanSelectServlet">약속조회</a></li>
	</ul>
	
	
</body>
</html>