package com.shallwe.model;

public class MemberVO {
	String member_id;
	String password;
	String name;
	String email;
	String phone_number;
	String security;
	
	public MemberVO() {}

	public MemberVO(String member_id, String password, String name, String email, String phone_number,
			String security) {
		super();
		this.member_id = member_id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.security = security;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	@Override
	public String toString() {
		return "MemberVO [member_id=" + member_id + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", phone_number=" + phone_number + ", security=" + security + "]";
	}
	
	
}
