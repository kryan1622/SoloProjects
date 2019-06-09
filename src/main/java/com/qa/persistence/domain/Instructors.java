package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Instructors {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int instructorid;
	@Column(length=200)
	private String instructorfirstname;
	@Column(length=200)
	private String instructorlastname;

	public Instructors() {
		
	}

	public int getInstructorid() {
		return instructorid;
	}

	public void setInstructorid(int instructorid) {
		this.instructorid = instructorid;
	}

	public String getInstructorfirstname() {
		return instructorfirstname;
	}

	public void setInstructorfirstname(String instructorfirstname) {
		this.instructorfirstname = instructorfirstname;
	}

	public String getInstructorlastname() {
		return instructorlastname;
	}

	public void setInstructorlastname(String instructorlastname) {
		this.instructorlastname = instructorlastname;
	}

	public Instructors(String instructorfirstname, String instructorlastname) {
		this.instructorfirstname=instructorfirstname;
		this.instructorlastname=instructorlastname;
	}
}
