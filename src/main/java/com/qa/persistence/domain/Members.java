package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Members {

	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int memberid;
	@Column(length=200)
	private String firstname;
	@Column(length=200)
	private String lastname;
	
	public Members() {
		
	}
	
	

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
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

	public Members(int memberid, String firstname, String lastname) {
		this.memberid=memberid;
		this.firstname=firstname;
		this.lastname=lastname;
	}
}
