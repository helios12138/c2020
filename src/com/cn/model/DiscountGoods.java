package com.cn.model;

import java.sql.Timestamp;

public class DiscountGoods {
	private int id;
	private int discountid;
	private int goodsid;
	private Timestamp begindate;
	private Timestamp enddate;
	public DiscountGoods(int id, int discountid, int goodsid, Timestamp begindate, Timestamp enddate) {
		super();
		this.id = id;
		this.discountid = discountid;
		this.goodsid = goodsid;
		this.begindate = begindate;
		this.enddate = enddate;
	}
	public DiscountGoods() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiscountid() {
		return discountid;
	}
	public void setDiscountid(int discountid) {
		this.discountid = discountid;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
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
	
	
}
