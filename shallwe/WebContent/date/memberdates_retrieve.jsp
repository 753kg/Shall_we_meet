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
<title>Insert title here</title>
</head>
<script>
var arr = [];
var fdate;

$(function() {
	console.log($("input[name='dt']"));
	$("input[name='dt']").each(function(idx, item){
		arr.push($(item).val());
	});
	
   // alert(arr.toString());
	$('#datepicker').datepicker({
		startDate : new Date(),
		multidate : true,
		dateFormat : "yy/mm/dd",
		daysOfWeekHighlighted : "5,6",
		language : 'en',
		beforeShowDay: available ,
		minDate : 0,
		
		onSelect : function(date, aa) {
			fdate = date;
			alert(fdate);
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
	location.href = "masterFixDate?dates="+fdate+"&plan_id=" + planid;
}
</script>
<body>
<h3>최종 날짜를 멤버들이 선택한 날짜중에 골라주세요</h3>
  <c:forEach var="dates" items="${mdall}"> 
 <!--   	<td>${dates.select_date}</td><br>-->
    <input type="hidden" name="dt" value="${fn:substring(dates.select_date,0,10)}"/>
   </c:forEach>

	<div class="input-group date form-group" id="datepicker">
		<input type="text" class="form-control" id="Dates" name="Dates" placeholder="Select days" required /> 
			<span class="input-group-addon">
			 <i class="glyphicon glyphicon-calendar"></i>
			 <span class="count">
			</span>
		 </span>
	</div>
	 	<button onclick="call('${plan_id}');">확인</button> 
</body>
<script type="text/javascript">
</script>
</html>