package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Instructors;
import com.qa.persistence.domain.Members;
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
		Instructors ainstructor = j1.getObjectForJSON(Instructors, Instructors.class);
		manager.persist(ainstructor);
		return "{\"message\": \"Instructor has been successfully added\"}";	
	}

	@Override
	public String getAllInstructors() {
		Query query =  manager.createQuery("SELECT i FROM Instructors i");
		return j1.getJSONForObject(query.getResultList());
	}

	@Override
	public String findInstructor(int instructorid) {
		return j1.getJSONForObject(manager.find(Instructors.class, instructorid));
	}

	@Override
	public String updateInstructor(int instructorid, String Instructors) {
    Instructors oldinstructor = manager.find(Instructors.class, instructorid);
    Instructors newinstructor = j1.getObjectForJSON(Instructors, Instructors.class);
		    if (oldinstructor != null) {
		    	oldinstructor.setFirstname(newinstructor.getFirstname());
		    	oldinstructor.setLastname(newinstructor.getLastname());
		    	manager.persist(oldinstructor);
		    	return "{\"message\": \"Instructor successfully updated\"}";
		    }
		    else {
		    	return "{\"message\": \"No instructor found with this id\"}";
		    }
			}

	@Override
	@Transactional(REQUIRED)
	public String deleteInstructor(int instructorid) {
		Instructors instructor = manager.find(Instructors.class, instructorid);
		
		if (manager.contains(instructor)) {
			manager.remove(instructor);
			return "{\"message\": \"Instructor sucessfully deleted " + instructorid + " \"}";
		}
		else {
			return "{\"message\": \"No instructor found with this id" + instructor + "\"}";
		}
		}
	}



