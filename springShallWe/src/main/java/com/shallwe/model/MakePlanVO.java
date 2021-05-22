package com.shallwe.model;

import java.util.List;

public class MakePlanVO {
	private String host_id;
	private String plan_name;
	private String membercount;
	private String host_place;
	private String host_lat;
	private String host_lon;
	private String host_dates;
	private List<String> friendlist;
	public String getHost_id() {
		return host_id;
	}
	public void setHost_id(String host_id) {
		this.host_id = host_id;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public String getMembercount() {
		return membercount;
	}
	public void setMembercount(String membercount) {
		this.membercount = membercount;
	}
	public String getHost_place() {
		return host_place;
	}
	public void setHost_place(String host_place) {
		this.host_place = host_place;
	}
	public String getHost_lat() {
		return host_lat;
	}
	public void setHost_lat(String host_lat) {
		this.host_lat = host_lat;
	}
	public String getHost_lon() {
		return host_lon;
	}
	public void setHost_lon(String host_lon) {
		this.host_lon = host_lon;
	}
	public String getHost_dates() {
		return host_dates;
	}
	public void setHost_dates(String host_dates) {
		this.host_dates = host_dates;
	}
	public List<String> getFriendlist() {
		return friendlist;
	}
	public void setFriendlist(List<String> friendlist) {
		this.friendlist = friendlist;
	}
	@Override
	public String toString() {
		return "MakePlanVO [host_id=" + host_id + ", plan_name=" + plan_name + ", membercount=" + membercount
				+ ", host_place=" + host_place + ", host_lat=" + host_lat + ", host_lon=" + host_lon + ", host_dates="
				+ host_dates + ", friendlist=" + friendlist + "]";
	}
	
	
}
