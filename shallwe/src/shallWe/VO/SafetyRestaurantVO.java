package shallWe.VO;

public class SafetyRestaurantVO {
	int restaurant_id;
	String location_name;
	String restaurant_name;
	String category;
	String full_address;
	double lat;
	double lon;
	
	public SafetyRestaurantVO() {}

	public SafetyRestaurantVO(int restaurant_id, String location_name, String restaurant_name, String category,
			String full_address, double lat, double lon) {
		super();
		this.restaurant_id = restaurant_id;
		this.location_name = location_name;
		this.restaurant_name = restaurant_name;
		this.category = category;
		this.full_address = full_address;
		this.lat = lat;
		this.lon = lon;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFull_address() {
		return full_address;
	}

	public void setFull_address(String full_address) {
		this.full_address = full_address;
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
		return "SafetyRestaurantVO [restaurant_id=" + restaurant_id + ", location_name=" + location_name
				+ ", restaurant_name=" + restaurant_name + ", category=" + category + ", full_address=" + full_address
				+ ", lat=" + lat + ", lon=" + lon + "]";
	}
	
	
}
