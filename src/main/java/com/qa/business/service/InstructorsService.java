package com.qa.business.service;

public interface InstructorsService {
	String getAllInstructors();
	String findInstructor(int instructorid);
	String deleteInstructor(int instructorid);
	String updateInstructor(int instructorid, String instructors);
	String createInstructor(String instructors);

}
