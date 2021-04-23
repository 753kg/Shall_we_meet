package shallWe.VO;

public class CafeVO {

	String cafe_name;
	String location_name;
	String full_address;
	String main_food;
	int likes;
	String image;
	int cafe_id;
	
	public CafeVO() {}

	public CafeVO(String cafe_name, String location_name, String full_address, String main_food, int likes,
			String image, int cafe_id) {
		super();
		this.cafe_name = cafe_name;
		this.location_name = location_name;
		this.full_address = full_address;
		this.main_food = main_food;
		this.likes = likes;
		this.image = image;
		this.cafe_id = cafe_id;
	}

	public String getCafe_name() {
		return cafe_name;
	}

	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
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

	public int getCafe_id() {
		return cafe_id;
	}

	public void setCafe_id(int cafe_id) {
		this.cafe_id = cafe_id;
	}

	@Override
	public String toString() {
		return "CafeVO [cafe_name=" + cafe_name + ", location_name=" + location_name + ", full_address=" + full_address
				+ ", main_food=" + main_food + ", likes=" + likes + ", image=" + image + ", cafe_id=" + cafe_id + "]";
	}
	
	

}
