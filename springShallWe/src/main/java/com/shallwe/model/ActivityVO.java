package com.shallwe.model;

public class ActivityVO {
	String activity_name;
	String main_activity;
	String location_name;
	int activity_id;
	
	public ActivityVO() {}

	public ActivityVO(String activity_name, String main_activity, String location_name, int activity_id) {
		super();
		this.activity_name = activity_name;
		this.main_activity = main_activity;
		this.location_name = location_name;
		this.activity_id = activity_id;
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public String getMain_activity() {
		return main_activity;
	}

	public void setMain_activity(String main_activity) {
		this.main_activity = main_activity;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public int getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}

	@Override
	public String toString() {
		return "ActivityVO [activity_name=" + activity_name + ", main_activity=" + main_activity + ", location_name="
				+ location_name + ", activity_id=" + activity_id + "]";
	}
	
	
}
