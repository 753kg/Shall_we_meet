package com.shallwe.model;

public class MemberLocationVO {
	double lat;
	double lon;
	
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
		return "MemberLocationVO [lat=" + lat + ", lon=" + lon + "]";
	}
	
	
}
