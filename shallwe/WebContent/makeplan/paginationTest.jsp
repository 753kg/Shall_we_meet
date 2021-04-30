<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css"/>
</head>
<body>
<div>
		<button type="button" id="restaurants">식당1</button>
		<button type="button" id="cafes">카페1</button>
		<button type="button" id="activities">액티비티1</button>
    <section>
        <div id="data-container"></div>
        <div id="pagination"></div>
    </section>
</div>

<script>
		
		var container = $('#pagination');
		console.log(container);
		$("#restaurants").click(function(){
	        container.pagination({
	            dataSource: JSON.parse('${rlist}'),
	            pageSize: 5,
	            callback: function (data, pagination) {
	                var dataHtml = '<ul>';
									
	                $.each(data, function (index, item) {
	                    dataHtml += '<li><h2>' + item.restaurant_name + '</h2></li>';
	                    dataHtml += '<li><img src="' + item.image + '"></li>';
	                    dataHtml += '<li>' + item.main_food + '</li>';
	                    dataHtml += '<li>' + item.full_address + '</li>';
	                    dataHtml += '<li>' + item.likes + '</li>';
	                });

	                dataHtml += '</ul>';

	                $("#data-container").html(dataHtml);
	            }
	        })
		});
		
		$("#cafes").click(function(){
			
	        container.pagination({
	            dataSource: JSON.parse('${clist}'),
	            pageSize: 5,
	            callback: function (data, pagination) {
	                var dataHtml = '<ul>';
									
	                $.each(data, function (index, item) {
	                    dataHtml += '<li><h2>' + item.cafe_name + '</h2></li>';
	                    dataHtml += '<li><img src="' + item.image + '"></li>';
	                    dataHtml += '<li>' + item.main_food + '</li>';
	                    dataHtml += '<li>' + item.full_address + '</li>';
	                    dataHtml += '<li>' + item.likes + '</li>';
	                });

	                dataHtml += '</ul>';

	                $("#data-container").html(dataHtml);
	            }
	        })
		});
		
		$("#activities").click(function(){
	        container.pagination({
	            dataSource: JSON.parse('${alist}'),
	            pageSize: 5,
	            callback: function (data, pagination) {
	                var dataHtml = '<ul>';
									
	                $.each(data, function (index, item) {
	                    dataHtml += '<li><h2>' + item.activity_name + '</h2></li>';
	                    dataHtml += '<li>' + item.main_activity + '</li>';
	                });

	                dataHtml += '</ul>';

	                $("#data-container").html(dataHtml);
	            }
	        })
		});
		
		restaurants.click();
</script>
</body>
</html>