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
		return IR.findInstructor(instructorid);
	}

	@Override
	public String deleteInstructor(int instructorid) {
		return IR.deleteInstructor(instructorid);
	}

	@Override
	public String updateInstructor(int instructorid, String Instructors) {
	return IR.updateInstructor(instructorid, Instructors);
	}

	@Override
	public String createInstructor(String Instructors) {
	return IR.createInstructor(Instructors);
	}
	


}
