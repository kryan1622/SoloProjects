package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class InstructorDatabaseRepository implements InstructorRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil j1;

	@Override
	public String createInstructor(String Instructors) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllInstructors() {
		Query query =  manager.createQuery("SELECT i FROM Instructors i");
		return j1.getJSONForObject(query.getResultList());
	}

	@Override
	public String findInstructor(int instructorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateInstructor(int instructorid, String Instructors) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteInstructor(int instructorid) {
		// TODO Auto-generated method stub
		return null;
	}


}
