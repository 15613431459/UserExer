package com.suixingpay.bean;

import java.io.Serializable;

public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String code;
	
	public Permission() {
		
	}
	
	public Permission(int id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
