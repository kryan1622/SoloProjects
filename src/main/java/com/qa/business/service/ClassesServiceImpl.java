package com.qa.business.service;
import javax.inject.Inject;
import com.qa.persistence.repository.ClassesRepository;


public class ClassesServiceImpl implements ClassesService{

	@Inject
	private ClassesRepository CR;
	
	
	@Override
	public String getAllClasses() {
		return CR.getAllClasses();
	}

	@Override
	public String findClass(int classid) {
		return CR.findClass(classid);
	}

	@Override
	public String deleteClass(int classid) {
	return CR.deleteClass(classid);
	}

	@Override
	public String updateClass(int classid, String Classes) {
	return CR.updateClass(classid, Classes);
	}

	@Override
	public String createClass(String Classes) {
		return CR.createClass(Classes);
	}

	
	

}
