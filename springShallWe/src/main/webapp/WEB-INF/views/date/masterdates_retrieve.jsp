<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
<title>날짜 입력하기</title>
<style>

 @font-face {
    font-family: 'IBMPlexSansKR-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/IBMPlexSansKR-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {
  font-family: 'LotteMartHappy';
  font-style: normal;
  font-weight: 400;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyMedium.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartHappy/LotteMartHappyMedium.woff') format('woff');
}
body{
font-family: 'IBMPlexSansKR-Regular';
position:absolute;
left:50%;
transform: translate( -50%, -50% );
top:10%;
text-align: center;
}
#calendar{
font-family: 'IBMPlexSansKR-Regular';
}
#date-btn{
font-family: 'IBMPlexSansKR-Regular';
position:absolute;
left:110px;
top:340px;
background-color:  rgb(255,220,104); /* Green */
  border: none;
  border-radius: 4px;
  color: black;
  padding: 10px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}
#date-btn:hover {
  background-color:rgb(39,39,39);
  color: white;
 
  font-family: 'IBMPlexSansKR-Regular';
}
p{
font-weight: bold;
font-family: 'IBMPlexSansKR-Regular';
font-size: 20px;}
#datepicker{
position: absolute;
left:50px;
}
</style>
</head>
<script>
var arr = [];
var marr = [];

$(function() {
	console.log($("input[name='dt']"));
	$("input[name='dt']").each(function(idx, item){
		arr.push($(item).val());
	});
	
  //  alert(arr.toString());
	$('#datepicker').datepicker({
		startDate : new Date(),
		multidate : true,
		dateFormat : "yy/mm/dd",
		daysOfWeekHighlighted : "5,6",
		language : 'en',
		beforeShowDay: available ,
		minDate : 0,
		
		onSelect : function(date, aa) {
			marr.push(date);
			alert(marr);
			$(aa).toggleClass('ui-state-highlight');	
		}
	});
//	$("#datepicker").datepicker("option","dateFormat","yy-mm-dd");
});

function available(date) {
	console.log(date);
	var thismonth = date.getMonth()+1;
	var thisday = date.getDate();
	if(thismonth<10){
		thismonth = "0"+thismonth;
	}
	if(thisday<10){
		thisday = "0"+thisday;
	}
    ymd = date.getFullYear() + "-" + thismonth + "-" + thisday;

    if ($.inArray(ymd, arr) >= 0) {
        return [true,"",""];
    } else {
        return [false,"",""];
    }
}

function call(planid){
	location.href = "insertDate.do?dates="+marr.toString()+"&plan_id=" + planid;
}
</script>
<body>
<div id="calendar">
<p>달력에서 가능한 날짜를 하나씩 선택해주세요.</p>
  <c:forEach var="date_options" items="${hdall}"> 
  <!-- 	<td>${date_options.host_date}</td><br>-->
    <input type="hidden" name="dt" value="${fn:substring(date_options.host_date,0,10)}"/>
   </c:forEach>

	<div class="input-group date form-group" id="datepicker">
		<input type="text" class="form-control" id="Dates" name="Dates" placeholder="Select days" required style="visibility: hidden;"/> 
			<span class="input-group-addon">
			 <i class="glyphicon glyphicon-calendar"></i>
			 <span class="count">
			</span>
		 </span>
	</div>
	 	<button id="date-btn" onclick="call('${plan_id}');">날짜 입력 완료</button> 
	 	</div>
</body>
<script type="text/javascript">


</script>
</html>