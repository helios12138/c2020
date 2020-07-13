package com.cn.model;

import java.sql.Timestamp;

public class Order {
	private int id;
	private int userid;
	private Double orgprice;
	private Double payprice;
	private int couponid;
	private Timestamp ordertime;
	private int addressid;
	private String orderstate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Double getOrgprice() {
		return orgprice;
	}
	public void setOrgprice(Double orgprice) {
		this.orgprice = orgprice;
	}
	public Double getPayprice() {
		return payprice;
	}
	public void setPayprice(Double payprice) {
		this.payprice = payprice;
	}
	public int getCouponid() {
		return couponid;
	}
	public void setCouponid(int couponid) {
		this.couponid = couponid;
	}
	public Timestamp getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public Order() {
		super();
	}
	public Order(int id, int userid, Double orgprice, Double payprice, int couponid, Timestamp ordertime, int addressid,
			String orderstate) {
		super();
		this.id = id;
		this.userid = userid;
		this.orgprice = orgprice;
		this.payprice = payprice;
		this.couponid = couponid;
		this.ordertime = ordertime;
		this.addressid = addressid;
		this.orderstate = orderstate;
	}
	
	
}
