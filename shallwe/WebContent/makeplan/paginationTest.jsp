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
    <section>
        <div id="data-container"></div>
        <div id="pagination"></div>
    </section>
</div>

<script>
    $(function () {
        let container = $('#pagination');
        container.pagination({
            dataSource: JSON.parse('${rlist}'),
            pageSize: 5,
            callback: function (data, pagination) {
                var dataHtml = '<ul>';
								
                $.each(data, function (index, item) {
                    dataHtml += '<li>' + item.restaurant_name + '</li>';
                });

                dataHtml += '</ul>';

                $("#data-container").html(dataHtml);
            }
        })
    })
</script>
</body>
</html>