package com.expclass.entity;

import java.io.Serializable;

public class Project implements Serializable{
	private String id;
	private String name;
	private String address;
	private String demo;
	private String abs;  //“ªæ‰ª∞ΩÈ…‹
	private String detail;
	private String[] members;
	
	public Project() {
		super();
	}
	
	
	public Project(String id, String name, String address, String demo,
			String abs, String detail, String[] members) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.demo = demo;
		this.abs = abs;
		this.detail = detail;
		this.members = members;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDemo() {
		return demo;
	}
	public void setDemo(String demo) {
		this.demo = demo;
	}
	
	public String getAbs() {
		return abs;
	}


	public void setAbs(String abs) {
		this.abs = abs;
	}


	public String[] getMembers() {
		return members;
	}


	public void setMembers(String[] members) {
		this.members = members;
	}


	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	
}
