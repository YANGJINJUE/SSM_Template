package com.tgb.model;

public class Material {
	private String id;
	private String mat_type;//材料类型
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMat_type() {
		return mat_type;
	}
	public void setMat_type(String mat_type) {
		this.mat_type = mat_type;
	}
	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Material(String id, String mat_type) {
		super();
		this.id = id;
		this.mat_type = mat_type;
	}
	
	
}
