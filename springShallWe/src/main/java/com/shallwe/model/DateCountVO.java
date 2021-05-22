package com.shallwe.model;

public class DateCountVO {
	String count;
	String date;
	String planid;
	
	public DateCountVO() {
		// TODO Auto-generated constructor stub
	}

	public DateCountVO(String count, String date, String planid) {
		this.count = count;
		this.date = date;
		this.planid = planid;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DateCountVO [count=").append(count).append(", date=").append(date).append(", planid=")
				.append(planid).append("]");
		return builder.toString();
	}
	
}
