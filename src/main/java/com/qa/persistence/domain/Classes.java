package com.qa.persistence.domain;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Classes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="classid")
	private int classid;
	@Column(length=100)
	private String classname;
	
@ManyToOne
private Instructors instructors;
	

	
	public Instructors getInstructors() {
	return instructors;
}

public void setInstructors(Instructors instructors) {
	this.instructors = instructors;
}

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


	public Classes(int classid, String classname, Instructors instructors) {
		super();
		this.classid = classid;
		this.classname = classname;
		
	}

	




	
}
