package cn.edu.zucc.supermark.model;

import java.sql.Timestamp;
import java.util.Date;

public class User {
	private int id;
	private String username;
	private String sex;
	private String password;
	private String phone;
	private String email;
	private String city;
	private Timestamp signtime;
	private String ismember;
	private Timestamp membertime;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Timestamp getSigntime() {
		return signtime;
	}
	public void setSigntime(Timestamp signtime) {
		this.signtime = signtime;
	}
	public String getIsmember() {
		return ismember;
	}
	public void setIsmember(String ismember) {
		this.ismember = ismember;
	}
	public Timestamp getMembertime() {
		return membertime;
	}
	public void setMembertime(Timestamp membertime) {
		this.membertime = membertime;
	}
	

	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username, String sex, String password, String phone, String email, String city,
			Timestamp signtime, String ismember) {
		super();
		this.username = username;
		this.sex = sex;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.signtime = signtime;
		this.ismember = ismember;
	}
	public User(String username, String sex, String password, String phone, String email, String city,
			Timestamp signtime, String ismember, Timestamp membertime) {
		super();
		this.username = username;
		this.sex = sex;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.signtime = signtime;
		this.ismember = ismember;
		this.membertime = membertime;
	}
	public User(String username, String password, String phone, String email, String city) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.city = city;
	}
	
	
	
	
	
	
		
}
