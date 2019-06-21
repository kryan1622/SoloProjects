package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.InstructorRepository;


public class InstructorsServiceImpl implements InstructorsService{

	@Inject
	private InstructorRepository ir;

	@Override
	public String getAllInstructors() {
		return ir.getAllInstructors();
	}

	@Override
	public String findInstructor(int instructorid) {
		return ir.findInstructor(instructorid);
	}

	@Override
	public String deleteInstructor(int instructorid) {
		return ir.deleteInstructor(instructorid);
	}

	@Override
	public String updateInstructor(int instructorid, String Instructors) {
	return ir.updateInstructor(instructorid, Instructors);
	}

	@Override
	public String createInstructor(String Instructors) {
	return ir.createInstructor(Instructors);
	}
	


}
