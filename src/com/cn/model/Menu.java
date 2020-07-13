package com.cn.model;

public class Menu {
	private int id;
	private String name;
	private	String materials;
	private String step;
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
	public String getMaterials() {
		return materials;
	}
	public void setMaterials(String materials) {
		this.materials = materials;
	}
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public Menu(int id, String name, String materials, String step) {
		super();
		this.id = id;
		this.name = name;
		this.materials = materials;
		this.step = step;
	}
	public Menu() {
		super();
	}
	
	
	
}
