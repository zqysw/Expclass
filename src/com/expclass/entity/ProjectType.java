package com.expclass.entity;

public class ProjectType {
	private int projecttypeid;
	private String projecttypename;
	private int typeimg;
	
	public ProjectType() {
		super();
	}
	public ProjectType(int projecttypeid, String projecttypename,int typeimg) {
		super();
		this.projecttypeid = projecttypeid;
		this.projecttypename = projecttypename;
		this.typeimg = typeimg;
	}
	public int getTypeimg() {
		return typeimg;
	}
	public void setTypeimg(int typeimg) {
		this.typeimg = typeimg;
	}
	public int getProjecttypeid() {
		return projecttypeid;
	}
	public void setProjecttypeid(int projecttypeid) {
		this.projecttypeid = projecttypeid;
	}
	public String getProjecttypename() {
		return projecttypename;
	}
	public void setProjecttypename(String projecttypename) {
		this.projecttypename = projecttypename;
	}
}
