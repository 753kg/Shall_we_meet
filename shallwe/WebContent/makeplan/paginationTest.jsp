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
<style>
	#paging .pag {
		display: block;
		border: 1px solid black;
		float: left;
	}
	#paging .pageBtn{
		position: relative;
		margin-top: 100px;
	}
	#paging button {
		padding: 0px;
		margin: 0px;
		width: 100px;
		height: 100px;
	}
</style>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
</head>
<body>
<div>
		<div id="listType">
			<button type="button" class="typeBtn" id="restaurants">식당</button>
			<button type="button" class="typeBtn" id="cafes">카페</button>
			<button type="button" class="typeBtn" id="activities">놀거리</button>
			<button type="button" class="typeBtn" id="safety">안심먹거리</button>
		</div>
    <div id="paging">
    	<div class="pag pageBtn"><button type="button" id="btn_prev"><i class="fas fa-chevron-left"></i></button></div>
    	<div class="pag viewPage" id="view"></div>
    	<div class="pag pageBtn"><button type="button" id="btn_next"><i class="fas fa-chevron-right"></i></button></div>
    </div>
   
<script>
		$("#restaurants").click(function(){
			showActivity(1, '${location_name}', "r");
		});
		
		$("#cafes").click(function(){
			showActivity(1, '${location_name}', "c");
		});
		
		$("#activities").click(function(){
			showActivity(1, '${location_name}', "a");
		});
		
		$("#safety").click(function(){
			showActivity(1, '${location_name}', "s");
		});
		
		function showActivity(currentPage, location_name, type){
			var totalPage = 0;
			$.ajax({
    			url : "../activityView/CountPage?type=" + type + "&location_name=" + location_name,
    			type : "get",
    			async: false,
    			success : function(data) {
    				totalPage = data;
    			},
    			error : function() {
    				console.log("paginationTest >> ajax error")
    			}
    	});
			alert('type: ' + type + ' totalPage: ' + totalPage);
			btnCheck(currentPage, totalPage);
			getNPage(location_name, currentPage, type);
			
			btn_next.onclick = function(){
				currentPage++;
				if(currentPage <= 1) currentPage = 0;
				btnCheck(currentPage, totalPage);
				getNPage(location_name, currentPage, type);
			};
			
			btn_prev.onclick = function(){
				currentPage--;
				if(currentPage >= totalPage) currentPage = totalPage;
				btnCheck(currentPage, totalPage);
				getNPage(location_name, currentPage, type);
			};
			
			function btnCheck(page, finalPage){
				btn_prev.disabled = false;
				if(page <= 1) btn_prev.disabled = true;
				
				btn_next.disabled = false;
				if(page >= finalPage) btn_next.disabled = true;
			}
			
			function getNPage(location_name, page, type){
				$.ajax({
	    			url : "../activityView/SelectNPage",
	    			type : "get",
	    			data : { "type": type, "location_name": location_name, "page": page },
	    			success : function(responsedata) {
	    				
	    				$("#view").html(responsedata);
	    			},
	    			error : function() {
	    				console.log("paginationTest >> ajax error")
	    			}
	    	});
			}
		}
		

		$("#restaurants").click();
</script>
</body>
</html>