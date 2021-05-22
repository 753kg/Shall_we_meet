<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>만날 장소 추천</title>
<!-- 전체 Design -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../frontDesign/css/animate.css">   
    <link rel="stylesheet" href="../frontDesign/css/owl.carousel.min.css">
    <link rel="stylesheet" href="../frontDesign/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../frontDesign/css/magnific-popup.css">
    <link rel="stylesheet" href="../frontDesign/css/flaticon.css">
    <link rel="stylesheet" href="../frontDesign/css/style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css" />
<%--주희 --%>
<%--<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e4f8aeb0d5079a18f159c0c6462fa4de&libraries=services"></script> --%>
<%--유연 --%>
<%--<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35d879296edd941fd4f9bdae91769fa4&libraries=services"></script> --%>
<%--채연 --%>
 <script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=45af73bc6fe5e770ab55284433281c70"></script>
</head>
<style>
	body{
		background-image: url('../frontDesign/imageSource/배경2.png');
    	background-size : cover;
	}

	#map{
	top:500px;
	left: 50%;
	transform: translate( -50%, -50% );
	 font-family: 'IBMPlexSansKR-Regular';
	}
	#memberdistance{
	    position: absolute;
	    font-family: 'IBMPlexSansKR-Regular';
	    top:1200px;
	    left: 400px;
	}
	#confirmLocation{
	    position: absolute;
	    top:1200px;
	    left: 850px;
	}
	#activity-text{
	    position: absolute;
	    font-family: 'IBMPlexSansKR-Regular';
	    top:1250px;
	    left: 400px;
	}
	#activity_view{
	position: relative;
	top:300px;
	}
	#footer{
	visibility: hidden;}

</style>
<body>
 <jsp:include page="../mainView/header_plan.jsp">
		<jsp:param name="pageName" value="내약속보기"/>
	</jsp:include>

	
<!-- 본문 시작 --> 
	<section>
   <div class="content25">
	<img src="../frontDesign/imageSource/만날장소를확인하세요.png" id="text-image25" style="height: 150px; width:auto; left:630px;">     
	

	<div id="map" style="width: 1100px; height: 500px;"></div>
	<div id="memberinfo">
      <p id="memberdistance"></p>
      <p id="confirmLocation"></p>
   </div>
	
	<p id="activity-text">선택한 지역의 맛집, 놀거리를 확인해보세요!</p>
	<div id="hlist"></div>
	<div id="activity_view"></div>
</div>
    </section>
    
    <!-- footer -->
    <div id="footer">
    <jsp:include page="../mainView/footer.jsp">
		<jsp:param name="top" value="500"/>
	</jsp:include>
	</div>

</body>
	<script>	
	

		/* for(var vs=0;vs<3;vs++){
			console.log(hotlist[hotlist].lat)
		} */
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		mapOption = {
			center : new kakao.maps.LatLng(${hotplaceList[0].lat}, ${hotplaceList[0].lon}), // 지도의 중심좌표
			level : 6
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		// 마커를 표시할 위치와 title 객체 배열입니다 
		var positions = [ {
			title : '${hotplaceList[0].hotplace_name}',
			latlng : new kakao.maps.LatLng(${hotplaceList[0].lat}, ${hotplaceList[0].lon})
		}, {
			title : '${hotplaceList[1].hotplace_name}',
			latlng : new kakao.maps.LatLng(${hotplaceList[1].lat}, ${hotplaceList[1].lon})
		}, {
			title : '${hotplaceList[2].hotplace_name}',
			latlng : new kakao.maps.LatLng(${hotplaceList[2].lat}, ${hotplaceList[2].lon})
		}

		];
	
		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

		

			// 마커 이미지의 이미지 크기 입니다
			var imageSize = new kakao.maps.Size(24, 35);

			// 마커 이미지를 생성합니다    
			var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

			// 마커를 생성합니다
			var marker1 = new kakao.maps.Marker({
				map : map, // 마커를 표시할 지도
				position : positions[0].latlng, // 마커를 표시할 위치
				title : positions[0].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
				image : markerImage
			// 마커 이미지 
			});
			var marker2 = new kakao.maps.Marker({
				map : map, // 마커를 표시할 지도
				position : positions[1].latlng, // 마커를 표시할 위치
				title : positions[1].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
				image : markerImage
			// 마커 이미지 
			});
			var marker3 = new kakao.maps.Marker({
				map : map, // 마커를 표시할 지도
				position : positions[2].latlng, // 마커를 표시할 위치
				title : positions[2].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
				image : markerImage
			// 마커 이미지 
			});
			
			var markers = [marker1, marker2, marker3];
			
			var arr = [];
			var arr2 = [];
			<c:forEach var="hlist" items="${hotplaceList}">
			   arr.push("${hlist.hotplace_name}");
			</c:forEach>
			
			<c:forEach var="dis" items="${distances}">
			   arr2.push("${dis}");
			</c:forEach>
			
			console.log(arr2);
			markers.forEach(function(element,index){
			    console.log(element);
					kakao.maps.event.addListener(element, 'click', function() {
						//거리 계산
						console.log(index)
						memberdistance.innerHTML=`${memberid}님의 출발지에서 ` + arr[index] + `까지의 거리는 ` +arr2[index]+`km 입니다.`;	
						confirmLocation.innerHTML=`<a href="confirmHotplace.do?plan_id=${plan_id }&hotplace_name=`
		                     + arr[index] 
		                     + `">`
		                     + arr[index]
		                     +`(으)로 장소 확정하기</a>`;
						$.ajax({
	            			url : "activitylist.do?location_name=" + element.Fb,
	            			type : "get",
	            			success : function(responsedata) {
	            				
	            				$("#activity_view").html(responsedata);
	            			},
	            			error : function() {
	            				console.log("ajax error")
	            			}
	            	});
			});
        
 			});
			/* for(i=0;i<markers.length;i++){
			
				kakao.maps.event.addListener(markers[i], 'click', function() {        
               			alert(markers[i]);
                
         		});
			} */

			var iwContent1 = '<div style="padding:5px; "><a>${hotplaceList[0].hotplace_name}</a><br><a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:#44A28C" target="_blank">가는 길 찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			iwPosition1 = new kakao.maps.LatLng(${hotplaceList[0].lat}, ${hotplaceList[0].lon}); //인포윈도우 표시 위치입니다
			

			var iwContent2 = '<div style="padding:5px;"><a>${hotplaceList[1].hotplace_name}</a><br><a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:#44A28C" target="_blank">가는 길 찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			iwPosition2 = new kakao.maps.LatLng(${hotplaceList[1].lat}, ${hotplaceList[1].lon}); //인포윈도우 표시 위치입니다
			

			var iwContent3 = '<div style="padding:5px;"><a>${hotplaceList[2].hotplace_name}</a><br><a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:#44A28C" target="_blank">가는 길 찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			iwPosition3 = new kakao.maps.LatLng(${hotplaceList[2].lat}, ${hotplaceList[2].lon}); //인포윈도우 표시 위치입니다
			// 인포윈도우를 생성합니다
			var infowindow1 = new kakao.maps.InfoWindow({
				position : iwPosition1,
				content : iwContent1
			});
			var infowindow2 = new kakao.maps.InfoWindow({
				position : iwPosition2,
				content : iwContent2
			});
			var infowindow3 = new kakao.maps.InfoWindow({
				position : iwPosition3,
				content : iwContent3
			});



			// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
			infowindow1.open(map, marker1);
			infowindow2.open(map, marker2);
			infowindow3.open(map, marker3);
		
	</script>

</html>