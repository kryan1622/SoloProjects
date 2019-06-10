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
	private String firstname;
	@Column(length=200)
	private String lastname;

	public Instructors() {
		
	}

	public int getInstructorid() {
		return instructorid;
	}

	public void setInstructorid(int instructorid) {
		this.instructorid = instructorid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Instructors(String firstname, String lastname) {
		this.firstname=firstname;
		this.lastname=lastname;
	}
}
