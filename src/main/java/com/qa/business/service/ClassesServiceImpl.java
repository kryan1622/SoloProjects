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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteClass(int classid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateClass(int classid, String classes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createClass(String classes) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
