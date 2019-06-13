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
public class ClassesDatabaseRepository implements ClassesRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil j1;
	
	@Override
	@Transactional(SUPPORTS)
	public String getAllClasses() {
		Query query =  manager.createQuery("SELECT c FROM Classes c");
		return j1.getJSONForObject(query.getResultList());
	}

	@Override
	public String createClass(String Classes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findClass(int classid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateClass(int classid, String Class) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteClass(int classid) {
		// TODO Auto-generated method stub
		return null;
	}
}
