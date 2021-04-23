package shallWe.VO;

import java.sql.Date;

public class DateOptionVO {

	int plan_id;
	Date host_date;
	
	public DateOptionVO() {}

	public DateOptionVO(int plan_id, Date host_date) {
		super();
		this.plan_id = plan_id;
		this.host_date = host_date;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public Date getHost_date() {
		return host_date;
	}

	public void setHost_date(Date host_date) {
		this.host_date = host_date;
	}

	@Override
	public String toString() {
		return "DateOptionVO [plan_id=" + plan_id + ", host_date=" + host_date + "]";
	}
	
	
}
