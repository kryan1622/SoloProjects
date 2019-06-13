package com.qa.persistence.repository;

public interface InstructorRepository {
	
	public String createInstructor(String Instructors);
	public String getAllInstructors();
	public String findInstructor(int instructorid);
	public String updateInstructor(int instructorid, String Instructors);
	public String deleteInstructor(int instructorid);

}
