package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Classes {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int classid;
	@Column(length=100)
	private String classname;
	
	 @ManyToOne
	    @JoinColumn(name = "instructorid")
	    private Instructors instructors;
	
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

	
	public Classes(String classname) {
		this.classname=classname;
	}
	
}
