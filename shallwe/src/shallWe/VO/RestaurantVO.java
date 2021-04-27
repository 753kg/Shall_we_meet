package shallWe.VO;

public class RestaurantVO {
	String restaurant_name;
	String location_name;
	String full_address;
	String main_food;
	int likes;
	String image;
	int restaurant_id;
	
	public RestaurantVO() {	}

	public RestaurantVO(String restaurant_name, String location_name, String full_address, String main_food, int likes,
			String image, int restaurant_id) {
		super();
		this.restaurant_name = restaurant_name;
		this.location_name = location_name;
		this.full_address = full_address;
		this.main_food = main_food;
		this.likes = likes;
		this.image = image;
		this.restaurant_id = restaurant_id;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public String getFull_address() {
		return full_address;
	}

	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}

	public String getMain_food() {
		return main_food;
	}

	public void setMain_food(String main_food) {
		this.main_food = main_food;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	@Override
	public String toString() {
		return "RestaurantVO [restaurant_name=" + restaurant_name + ", location_name=" + location_name
				+ ", full_address=" + full_address + ", main_food=" + main_food + ", likes=" + likes + ", image="
				+ image + ", restaurant_id=" + restaurant_id + "]";
	}
	
	
}
