package com.cn.model;

import java.sql.Timestamp;

public class Discount {
	private int id;
	private String content;
	private int goodsnum;
	private Double discount;
	private Timestamp begindate;
	private Timestamp enddate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getGoodsnum() {
		return goodsnum;
	}
	public void setGoodsnum(int goodsnum) {
		this.goodsnum = goodsnum;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Timestamp getBegindate() {
		return begindate;
	}
	public void setBegindate(Timestamp begindate) {
		this.begindate = begindate;
	}
	public Timestamp getEnddate() {
		return enddate;
	}
	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}
	public Discount() {
		super();
	}
	public Discount(int id, String content, int goodsnum, Double discount, Timestamp begindate, Timestamp enddate) {
		super();
		this.id = id;
		this.content = content;
		this.goodsnum = goodsnum;
		this.discount = discount;
		this.begindate = begindate;
		this.enddate = enddate;
	}
	
	
	
}
