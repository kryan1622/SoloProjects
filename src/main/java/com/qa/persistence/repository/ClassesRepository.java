package com.qa.persistence.repository;

public interface ClassesRepository {
	public String createClass(String classes);
	public String getAllClasses();
	public String findClass(int classid);
	public String updateClass(int classid, String classes);
	public String deleteClass(int classid);

}
