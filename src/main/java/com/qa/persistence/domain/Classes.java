package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classes {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int classid;
	@Column(length=100)
	private String classname;
	@Column(length=10)
	private int instructorid;
	
	public Classes() {
		
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public int getInstructorid() {
		return instructorid;
	}

	public void setInstructorid(int instructorid) {
		this.instructorid = instructorid;
	}
	
	public Classes(String classname, int instructorid) {
		this.classname=classname;
		this.instructorid=instructorid;
	}
	
}
