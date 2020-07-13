package com.cn.model;

public class MenuGoods {
	private int id;
	private int goodsid;
	private int menuid;
	private String des;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public MenuGoods(int id, int goodsid, int menuid, String des) {
		super();
		this.id = id;
		this.goodsid = goodsid;
		this.menuid = menuid;
		this.des = des;
	}
	public MenuGoods() {
		super();
	}

	
	
}
