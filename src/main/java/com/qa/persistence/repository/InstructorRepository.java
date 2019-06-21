package com.qa.persistence.repository;

public interface InstructorRepository {
	
	public String createInstructor(String instructors);
	public String getAllInstructors();
	public String findInstructor(int instructorid);
	public String updateInstructor(int instructorid, String instructors);
	public String deleteInstructor(int instructorid);

}
