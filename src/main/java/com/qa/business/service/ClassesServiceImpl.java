package com.qa.business.service;
import javax.inject.Inject;
import com.qa.persistence.repository.ClassesRepository;


public class ClassesServiceImpl implements ClassesService{

	@Inject
	private ClassesRepository cr;
	
	
	@Override
	public String getAllClasses() {
		return cr.getAllClasses();
	}

	@Override
	public String findClass(int classid) {
		return cr.findClass(classid);
	}

	@Override
	public String deleteClass(int classid) {
	return cr.deleteClass(classid);
	}

	@Override
	public String updateClass(int classid, String Classes) {
	return cr.updateClass(classid, Classes);
	}

	@Override
	public String createClass(String Classes) {
		return cr.createClass(Classes);
	}

}
