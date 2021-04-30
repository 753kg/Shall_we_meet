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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css"/>
<%--유연 --%>
	<!-- <script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=35d879296edd941fd4f9bdae91769fa4&libraries=services"></script> -->
	<%--채연 --%>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=45af73bc6fe5e770ab55284433281c70"></script>
</head>
<body>
	<h1>만날 장소 추천!</h1>

	<div id="map" style="width: 100%; height: 350px;"></div>
	<div id="memberinfo">
	<h5>ㅇㅇ님의 ㅇㅇ까지의 거리는 ㅇㅇKM입니다</h5>
	</div>


	<hr>
  <div id="hlist"></div>
	<div id="activity_view"></div>




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
			title : '1',
			latlng : new kakao.maps.LatLng(${hotplaceList[0].lat}, ${hotplaceList[0].lon})
		}, {
			title : '2',
			latlng : new kakao.maps.LatLng(${hotplaceList[1].lat}, ${hotplaceList[1].lon})
		}, {
			title : '3',
			latlng : new kakao.maps.LatLng(${hotplaceList[2].lat}, ${hotplaceList[2].lon})
		}

		];

		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

		for (var i = 0; i < positions.length; i++) {

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

			var iwContent1 = '<div style="padding:5px;"><a>${hotplaceList[0].hotplace_name}</a><br><a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			iwPosition1 = new kakao.maps.LatLng(${hotplaceList[0].lat}, ${hotplaceList[0].lon}); //인포윈도우 표시 위치입니다
			

			var iwContent2 = '<div style="padding:5px;"><a>${hotplaceList[1].hotplace_name}</a><br><a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			iwPosition2 = new kakao.maps.LatLng(${hotplaceList[1].lat}, ${hotplaceList[1].lon}); //인포윈도우 표시 위치입니다
			

			var iwContent3 = '<div style="padding:5px;"><a>${hotplaceList[2].hotplace_name}</a><br><a href="https://map.kakao.com/link/to/Hello World!,33.450701,126.570667" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
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
		}
	</script>


	<script>
	hotplaces = ['홍대', '이태원', '잠실'];
    makeBtn(hotplaces);
    function makeBtn(hosplaces){
    	
        for(let i=0; i<hotplaces.length; i++){
             var atr = hotplaces[i];
             var newBtn = document.createElement("input");
             newBtn.type = "button";
             newBtn.value = atr;
             newBtn.name = "location_name";
             newBtn.onclick = function(){
            	 $.ajax({
            			url : "AcivitySelect?location_name=" + hotplaces[i],
            			type : "get",
            			success : function(responsedata) {
            				
            				$("#activity_view").html(responsedata);
            			},
            			error : function() {
            				console.log("에이젝스 ㅠㅠ")
            			}
            		});
            	 //location.href = "AcivitySelect?location_name=홍대";
             };
             hlist.appendChild(newBtn);
          }
       }
	
	</script>
</body>
</html>