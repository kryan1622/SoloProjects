package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.InstructorRepository;


public class InstructorsServiceImpl implements InstructorsService{

	@Inject
	private InstructorRepository IR;

	@Override
	public String getAllInstructors() {
		return IR.getAllInstructors();
	}

	@Override
	public String findInstructor(int instructorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteInstructor(int instructorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateInstructor(int instructorid, String instructors) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createInstructor(String instructors) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
