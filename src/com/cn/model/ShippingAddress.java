package com.cn.model;

public class ShippingAddress {
	private int id;
	private String userid;
	private String province;
	private String city;
	private String area;
	private String address;
	private String username;
	private String phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ShippingAddress() {
		super();
	}
	public ShippingAddress(int id, String userid, String province, String city, String area, String address,
			String username, String phone) {
		super();
		this.id = id;
		this.userid = userid;
		this.province = province;
		this.city = city;
		this.area = area;
		this.address = address;
		this.username = username;
		this.phone = phone;
	}
	
	
	
}
