package com.cn.model;

import java.sql.Timestamp;

public class Appraise {
	private int id;
	private int goodsid;
	private int userid;
	private String content;
	private Timestamp contentdata;
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getContentdata() {
		return contentdata;
	}
	public void setContentdata(Timestamp contentdata) {
		this.contentdata = contentdata;
	}
	public Appraise(int id, int goodsid, int userid, String content, Timestamp contentdata) {
		super();
		this.id = id;
		this.goodsid = goodsid;
		this.userid = userid;
		this.content = content;
		this.contentdata = contentdata;
	}
	public Appraise() {
		super();
	}
	
	
}
