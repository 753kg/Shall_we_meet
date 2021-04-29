<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	var arr = [];
	$(function() {
		$('#datepicker').datepicker({
			startDate : new Date(),
			multidate : true,
			dateFormat : "yy/mm/dd",
			daysOfWeekHighlighted : "5,6",
			language : 'en',
			onSelect : function(date, aa) {
			arr.push(date);
			alert(arr);
			console.log(aa);
			$(aa).toggleClass('ui-state-highlight');
			
			}
		});
	//	$("#datepicker").datepicker("option","dateFormat","yy-mm-dd");
	
	});
	
	
	/*
	function call(){
		location.href = "masterSelectDate?dates="+arr.toString();
	}
	*/
</script>
</head>
<body>
	<div class="input-group date form-group" id="datepicker">
		<input type="text" class="form-control" id="Dates" name="Dates" placeholder="Select days" required /> 
			<span class="input-group-addon">
			 <i class="glyphicon glyphicon-calendar"></i>
			 <span class="count">
			</span>
		 </span>
	</div>
	 
</body>
=======
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	var arr = [];
	$(function() {
		$('#datepicker').datepicker({
			startDate : new Date(),
			multidate : true,
			dateFormat : "yy/mm/dd",
			daysOfWeekHighlighted : "5,6",
			language : 'en',
			minDate : 0,
			
			onSelect : function(date, aa) {
			arr.push(date);
			alert(arr);
			console.log(aa);
			$(aa).toggleClass('ui-state-highlight');
			
			}
		});
	//	$("#datepicker").datepicker("option","dateFormat","yy-mm-dd");
	});
	
	function call(){
		location.href = "../masterSelectDate?dates="+arr.toString();
	}
</script>
</head>
<body>
	<h3>가능하신 날짜를 선택해주세요</h3>
	<div class="input-group date form-group" id="datepicker">
		<input type="text" class="form-control" id="Dates" name="Dates" placeholder="Select days" required /> 
			<span class="input-group-addon">
			 <i class="glyphicon glyphicon-calendar"></i>
			 <span class="count">
			</span>
		 </span>
	</div>
	 
	 <button onclick="call();">확인</button> 
	 
</body>
>>>>>>> refs/remotes/origin/hyunbin
</html>