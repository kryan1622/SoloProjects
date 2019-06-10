package com.qa.persistence.repository;

public interface ClassesRepository {
	public String createClass(String Classes);
	public String getAllClasses();
	public String findClass(int classid);
	public String updateClass(int classid, String Class);
	public String deleteClass(int classid);

}
