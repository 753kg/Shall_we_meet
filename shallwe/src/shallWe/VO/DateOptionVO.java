package shallWe.VO;

import java.util.Date;

public class DateOptionVO {

	String plan_id;
	String host_date;
	
	public DateOptionVO() {}

	public DateOptionVO(String plan_id, String host_date) {
		super();
		this.plan_id = plan_id;
		this.host_date = host_date;
	}

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public String getHost_date() {
		return host_date;
	}

	public void setHost_date(String host_date) {
		this.host_date = host_date;
	}

	@Override
	public String toString() {
		return "DateOptionVO [plan_id=" + plan_id + ", host_date=" + host_date + "]";
	}
	
	
}
