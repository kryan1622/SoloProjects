package com.qa.persistence.repo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Assert;
import org.junit.Before;
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
	
	private Instructors instructor;
	
		
	@Before 
	public void setup() {
		repo.setManager(manager);
		j1 = new JSONUtil();
		repo.setJ1(j1);
		instructor = new Instructors(1, "Josh", "Brookes");
		
	}
	
	@Test
	public void getAllInstructorsTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Instructors> instructors = new ArrayList<Instructors>();
		instructors.add(instructor);
		Mockito.when(query.getResultList()).thenReturn(instructors);
		Assert.assertEquals(Constants.INSTRUCTOR1,repo.getAllInstructors());
		
	}
	
	@Test
	public void findInstructorTest() {
		List<Instructors> instructors = new ArrayList<Instructors>();
		instructors.add(instructor);
		Mockito.when(manager.find(Instructors.class,1)).thenReturn(instructor);
		Assert.assertEquals(Constants.INSTRUCTOROBJECT, repo.findInstructor(1));
	}
	
	@Test
	public void createInstructorTest() {
		Assert.assertEquals("{\"message\": \"Instructor has been successfully added\"}",repo.createInstructor(Constants.INSTRUCTOROBJECT));
	}
	
	
	@Test
	public void updateInstructorTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Instructors> instructors = new ArrayList<Instructors>();
		Mockito.when(query.getResultList()).thenReturn(instructors);
		Mockito.when(manager.find(Instructors.class,1)).thenReturn(instructor);
		String reply = repo.updateInstructor(1, j1.getJSONForObject(instructor));
		Assert.assertEquals("{\"message\": \"Instructor successfully updated\"}",reply);
	}
	
	@Test
	public void updateInstructorThatDoesntExistTest() {
	Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
	List<Instructors> instructors = new ArrayList<Instructors>();
	Mockito.when(query.getResultList()).thenReturn(instructors);
	Mockito.when(manager.find(Instructors.class,1)).thenReturn(instructor);
	String reply = repo.updateInstructor(3, j1.getJSONForObject(instructor));
	Assert.assertEquals("{\"message\": \"No instructor found with this id\"}",reply);
}
}
