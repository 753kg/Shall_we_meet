<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
   href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>I날짜 확정하기</title>
<style>
@font-face {
    font-family: 'IBMPlexSansKR-Regular';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/IBMPlexSansKR-Regular.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
body{
font-family: 'IBMPlexSansKR-Regular';
text-align:center;
position: absolute;
left:40%;
}
#date-btn{
font-family: 'IBMPlexSansKR-Regular';
position:absolute;
left:50px;
top:360px;
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

</style>
</head>
<script>
   var arr = [];
   var farr = [];

   $(function() {
      console.log($("input[name='dt']"));
      $("input[name='dt']").each(function(idx, item) {
         arr.push($(item).val());
      });

      $('#datepicker').datepicker({
         startDate : new Date(),
         multidate : true,
         dateFormat : "yy/mm/dd",
         daysOfWeekHighlighted : "5,6",
         language : 'en',
         beforeShowDay : available,
         minDate : 0,

         onSelect : function(date, aa) {
            farr.push(date);
            alert(farr);
            $(aa).toggleClass('ui-state-highlight');
         }
      });

   });

   function available(date) {
      console.log(date);
      var thismonth = date.getMonth() + 1;
      var thisday = date.getDate();
      if (thismonth < 10) {
         thismonth = "0" + thismonth;
      }
      if (thisday < 10) {
         thisday = "0" + thisday;
      }
      ymd = date.getFullYear() + "-" + thismonth + "-" + thisday;

      if ($.inArray(ymd, arr) >= 0) {
         return [ true, "", "" ];
      } else {
         return [ false, "", "" ];
      }
   }

   function call(planid) {
      location.href = "updateFixDate.do?dates=" + farr.toString() + "&plan_id="
            + planid;

   }
</script>
<body>
   <h3>가장 많은 친구들이 선택한 날짜입니다.</h3>
   <c:forEach var="dates" items="${mdall.date}"> 
       이 날짜에 가능한 친구 수 : ${mdall.count}명
    <input type="hidden" name="dt"
         value="${fn:substring(mdall.date,0,10)}" />
   </c:forEach>

   <div class="input-group date form-group" id="datepicker">
      <input type="text" class="form-control" id="Dates" name="Dates"
         placeholder="Select days" required style="visibility: hidden;" /> 
         <span
         class="input-group-addon"> <i         class="glyphicon glyphicon-calendar"></i> <span class="count">
      </span>
      </span>
   </div>
   <button id="date-btn" onclick="call('${plan_id}');">이 날짜로 확정하기</button>
</body>
<script type="text/javascript">
   
</script>
</html>