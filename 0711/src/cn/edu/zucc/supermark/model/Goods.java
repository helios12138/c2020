package cn.edu.zucc.supermark.model;

public class Goods {
	private int id;
	private String name;
	private Double price;
	private Double menberprice;
	private int number;
	private String spec;
	private int freshclassid;
	private String details;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getMenberprice() {
		return menberprice;
	}
	public void setMenberprice(Double menberprice) {
		this.menberprice = menberprice;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public int getFreshclassid() {
		return freshclassid;
	}
	public void setFreshclassid(int freshclassid) {
		this.freshclassid = freshclassid;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Goods(int id, String name, Double price, Double menberprice, int number, String spec, int freshclassid,
			String details) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.menberprice = menberprice;
		this.number = number;
		this.spec = spec;
		this.freshclassid = freshclassid;
		this.details = details;
	}
	public Goods() {
		super();
	}
	
	
}
