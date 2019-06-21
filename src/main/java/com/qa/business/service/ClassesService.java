package com.qa.business.service;

public interface ClassesService {
	
	String getAllClasses();
	String findClass(int classid);
	String deleteClass(int classid);
	String updateClass(int classid, String classes);
	String createClass(String classes);

}
