package com.cn.model;

public class OrderDetail {
	private int id;
	private int orderid;
	private int goodsid;
	private int ordernum;
	private Double price;
	private Double discount;
	private int discountid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public int getDiscountid() {
		return discountid;
	}
	public void setDiscountid(int discountid) {
		this.discountid = discountid;
	}
	public OrderDetail(int id, int orderid, int goodsid, int ordernum, Double price, Double discount, int discountid) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.goodsid = goodsid;
		this.ordernum = ordernum;
		this.price = price;
		this.discount = discount;
		this.discountid = discountid;
	}
	public OrderDetail() {
		super();
	}
	
	
}
