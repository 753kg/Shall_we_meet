package shallWe.VO;

import java.sql.Date;

public class DateVO {
	String member_id;
	int plan_id;
	Date select_date;
	
	public DateVO() {}

	public DateVO(String member_id, int plan_id, Date select_date) {
		super();
		this.member_id = member_id;
		this.plan_id = plan_id;
		this.select_date = select_date;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public Date getSelect_date() {
		return select_date;
	}

	public void setSelect_date(Date select_date) {
		this.select_date = select_date;
	}

	@Override
	public String toString() {
		return "DateVO [member_id=" + member_id + ", plan_id=" + plan_id + ", select_date=" + select_date + "]";
	}
	
	
}
