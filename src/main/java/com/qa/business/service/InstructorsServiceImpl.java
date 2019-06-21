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
	public String updateInstructor(int instructorid, String instructors) {
	return ir.updateInstructor(instructorid, instructors);
	}

	@Override
	public String createInstructor(String instructors) {
	return ir.createInstructor(instructors);
	}
	


}
