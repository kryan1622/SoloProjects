package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classes;
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
		Collection <Classes> classes = (Collection<Classes>) query.getResultList();
		
		if (classes.isEmpty()) {
			return "{\"message\": \"No classes found\"}";
		}
		return j1.getJSONForObject(query.getResultList());
	}

	@Override
	@Transactional(REQUIRED)
	public String createClass(String Class) {
		Classes newclass = j1.getObjectForJSON(Class, Classes.class);
		manager.persist(newclass);
		return "{\"message\": \"Class has been successfully added\"}";
	}

	@Override
	@Transactional(SUPPORTS)
	public String findClass(int classid) {
		return j1.getJSONForObject(manager.find(Classes.class, classid));
	}

	@Override
	@Transactional(REQUIRED)
	public String updateClass(int classid, String Classes) {
    Classes oldclass = manager.find(Classes.class, classid);
    Classes newclass = j1.getObjectForJSON(Classes, Classes.class);
    if (oldclass != null) {
    	oldclass.setClassname(newclass.getClassname());
    	manager.persist(oldclass);
    	return "{\"message\": \"Class successfully updated\"}";
    }
    else {
    	return "{\"message\": \"No class found with this id\"}";
    }
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteClass(int classid) {
    Classes c1 = manager.find(Classes.class, classid);
    if (manager.contains(c1)) {
		manager.remove(c1);
		return "{\"message\": \"Class sucessfully deleted " + classid + " \"}";
	}
	else {
		return "{\"message\": \"No Class found with this id\"}";
	}
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getJ1() {
		return j1;
	}

	public void setJ1(JSONUtil j1) {
		this.j1 = j1;
	}
	
	
}
