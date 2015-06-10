package com.expclass.entity;

import java.io.Serializable;

public class People implements Serializable{
	private String id;
	private String name;
	private String icon;   //Õ∑œÒURLµÿ÷∑
	private String email;
	private String tel;
	private String photo;
	private String tags;
	private String resume;
	private String[] projects;
	
	public People() {
		super();
	}

	

	public People(String id, String name, String icon, String email,
			String tel, String photo, String tags, String resume,
			String[] projects) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
		this.email = email;
		this.tel = tel;
		this.photo = photo;
		this.tags = tags;
		this.resume = resume;
		this.projects = projects;
	}



	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}

	public String[] getProjects() {
		return projects;
	}

	public void setProjects(String[] projects) {
		this.projects = projects;
	}
	
	
}
