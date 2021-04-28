package shallWe.VO;

import java.sql.Date;

public class PlanVO {
	String plan_id;
	Date fixed_date;
	String hotplace_name;
	String plan_name;
	String host_id;
	int numbers;
	
	public PlanVO() {}

	public PlanVO(String plan_id, Date fixed_date, String hotplace_name, String plan_name, String host_id, int numbers) {
		super();
		this.plan_id = plan_id;
		this.fixed_date = fixed_date;
		this.hotplace_name = hotplace_name;
		this.plan_name = plan_name;
		this.host_id = host_id;
		this.numbers = numbers;
	}

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public Date getFixed_date() {
		return fixed_date;
	}

	public void setFixed_date(Date fixed_date) {
		this.fixed_date = fixed_date;
	}

	public String getHotplace_name() {
		return hotplace_name;
	}

	public void setHotplace_name(String hotplace_name) {
		this.hotplace_name = hotplace_name;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public String getHost_id() {
		return host_id;
	}

	public void setHost_id(String host_id) {
		this.host_id = host_id;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		return "PlanVO [plan_id=" + plan_id + ", fixed_date=" + fixed_date + ", hotplace_name=" + hotplace_name
				+ ", plan_name=" + plan_name + ", host_id=" + host_id + ", numbers=" + numbers + "]";
	}
	
	
}
