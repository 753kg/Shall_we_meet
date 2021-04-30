package shallWe.VO;

import java.sql.Date;

public class DateVO {
	String plan_id;
	String member_id;
	String select_date;

	public DateVO() {}
	
	public DateVO(String plan_id, String select_date) {
		this.plan_id = plan_id;
		this.select_date = select_date;
	}

	public DateVO(String plan_id, String member_id, String select_date) {
		this.plan_id = plan_id;
		this.member_id = member_id;
		this.select_date = select_date;
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

	public String getSelect_date() {
		return select_date;
	}

	public void setSelect_date(String select_date) {
		this.select_date = select_date;
	}

	@Override
	public String toString() {
		return "DateVO [member_id=" + member_id + ", plan_id=" + plan_id + ", select_date=" + select_date + "]";
	}
	
	
}
