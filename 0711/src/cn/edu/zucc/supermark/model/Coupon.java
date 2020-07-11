package cn.edu.zucc.supermark.model;

import java.sql.Timestamp;
import java.util.Date;

public class Coupon {
	private int id;
	private String content;
	private Double useamount;
	private Double creditamount;
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
	public Double getUseamount() {
		return useamount;
	}
	public void setUseamount(Double useamount) {
		this.useamount = useamount;
	}
	public Double getCreditamount() {
		return creditamount;
	}
	public void setCreditamount(Double creditamount) {
		this.creditamount = creditamount;
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
	public Coupon(int id, String content, Double useamount, Double creditamount, Timestamp begindate,
			Timestamp enddate) {
		super();
		this.id = id;
		this.content = content;
		this.useamount = useamount;
		this.creditamount = creditamount;
		this.begindate = begindate;
		this.enddate = enddate;
	}
	public Coupon() {
		super();
	}
	
	
	
}
