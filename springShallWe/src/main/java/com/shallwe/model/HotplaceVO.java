package com.shallwe.model;



public class HotplaceVO {

	String hotplace_name;
	double lat;
	double lon;
	
	public HotplaceVO() {}

	public HotplaceVO(String hotplace_name, double lat, double lon) {
		super();
		this.hotplace_name = hotplace_name;
		this.lat = lat;
		this.lon = lon;
	}

	public String getHotplace_name() {
		return hotplace_name;
	}

	public void setHotplace_name(String hotplace_name) {
		this.hotplace_name = hotplace_name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "HotplaceVO [hotplace_name=" + hotplace_name + ", lat=" + lat + ", lon=" + lon + "]";
	}
	
	

}
