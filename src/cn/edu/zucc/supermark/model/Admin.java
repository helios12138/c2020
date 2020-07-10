package cn.edu.zucc.supermark.model;

public class Admin {
	private int id;
	private String adminname;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin() {
		super();
	}
	public Admin(String adminname, String password) {
		super();
		this.adminname = adminname;
		this.password = password;
	}
	
	
}
