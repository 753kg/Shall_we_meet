package shallWe.VO;

public class MemberPlanVO {
	String member_id;
	String plan_id;
	double lat;
	double lon;
	
	public MemberPlanVO() {}

	public MemberPlanVO(String member_id, String plan_id, double lat, double lon) {
		super();
		this.member_id = member_id;
		this.plan_id = plan_id;
		this.lat = lat;
		this.lon = lon;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
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
		return "MemberPlanVO [member_id=" + member_id + ", plan_id=" + plan_id + ", lat=" + lat + ", lon=" + lon + "]";
	}
	
	
}
