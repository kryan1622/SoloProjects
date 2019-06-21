package com.qa.persistence.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.persistence.domain.Instructors;
import com.qa.persistence.repository.InstructorDatabaseRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class InstructorsDBTests {

	@InjectMocks
	private InstructorDatabaseRepository repo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private JSONUtil j1;
	
	@Mock
	private Query query;
	
	private static final String INSTRUCTOR1 = "[{\"instructorid\":1,\"firstname\":\"Josh\",\"lastname\":\"Brookes\"}]";
    private static final String INSTRUCTOROBJECT = "{\"instructorid\":1,\"firstname\":\"Josh\",\"lastname\":\"Brookes\"}";	
	@Before 
	public void setup() {
		repo.setManager(manager);
		j1 = new JSONUtil();
		repo.setJ1(j1);
	}
	
	@Test
	public void getAllInstructorsTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Instructors> instructors = new ArrayList<Instructors>();
		instructors.add(new Instructors(1,"Josh","Brookes"));
		Mockito.when(query.getResultList()).thenReturn(instructors);
		Assert.assertEquals(INSTRUCTOR1,repo.getAllInstructors());
		
	}
	
	@Test
	public void findInstructorTest() {
		List<Instructors> instructors = new ArrayList<Instructors>();
		Instructors instructor = new Instructors(1, "Josh","Brookes");
		instructors.add(instructor);
		Mockito.when(manager.find(Instructors.class,1)).thenReturn(instructor);
		Assert.assertEquals(INSTRUCTOROBJECT, repo.findInstructor(1));
	}
	
	@Test
	public void createInstructorTest() {
		Assert.assertEquals("{\"message\": \"Instructor has been successfully added\"}",repo.createInstructor(INSTRUCTOROBJECT));
	}
	
	
	@Test
	public void updateInstructorTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Instructors> instructors = new ArrayList<Instructors>();
		Instructors instructor = new Instructors(1, "Josh","Brookes");
		Mockito.when(query.getResultList()).thenReturn(instructors);
		Mockito.when(manager.find(Instructors.class,1)).thenReturn(instructor);
		String reply = repo.updateInstructor(1, j1.getJSONForObject(instructor));
		Assert.assertEquals("{\"message\": \"Instructor successfully updated\"}",reply);
	}
	
	@Test
	public void updateInstructorThatDoesntExistTest() {
	Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
	List<Instructors> instructors = new ArrayList<Instructors>();
	Instructors instructor = new Instructors(1, "Josh","Brookes");
	Mockito.when(query.getResultList()).thenReturn(instructors);
	Mockito.when(manager.find(Instructors.class,1)).thenReturn(instructor);
	String reply = repo.updateInstructor(3, j1.getJSONForObject(instructor));
	Assert.assertEquals("{\"message\": \"No instructor found with this id\"}",reply);
}
}
