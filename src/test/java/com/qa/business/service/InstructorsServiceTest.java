package com.qa.business.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.persistence.repository.InstructorDatabaseRepository;
import com.qa.util.JSONUtil;


@RunWith(MockitoJUnitRunner.class)
public class InstructorsServiceTest {
	
	@InjectMocks
	private InstructorsServiceImpl service;
	
	@Mock
	private InstructorDatabaseRepository repo;
	
	@Mock
	private JSONUtil j1;
	
	private static final String INSTRUCTOR1 = "[{\"instructorid\":1,\"firstname\":\"Josh\",\"lastname\":\"Brookes\"}]";
    private static final String INSTRUCTOROBJECT = "{\"instructorid\":1,\"firstname\":\"Josh\",\"lastname\":\"Brookes\"}";
	
	@Test
	public void getAllInstructorTest() {
		Mockito.when(repo.getAllInstructors()).thenReturn("{\"message\": \"No instructors found\"}");
		Assert.assertEquals("{\"message\": \"No instructors found\"}", service.getAllInstructors());
		
	}
	
	@Test
	public void createInstructorTest() {
		Mockito.when(repo.createInstructor(INSTRUCTOR1)).thenReturn("{\"message\": \"Instructor has been successfully added\"}");
		Assert.assertEquals("{\"message\": \"Instructor has been successfully added\"}", service.createInstructor(INSTRUCTOR1));
	}
	
	@Test
	public void findInstructorTest() {
		Mockito.when(repo.findInstructor(1)).thenReturn(INSTRUCTOROBJECT);
		Assert.assertEquals(INSTRUCTOROBJECT, service.findInstructor(1));
	}
	
	@Test
	public void deleteInstructorTest() {
		Mockito.when(repo.deleteInstructor(1)).thenReturn(INSTRUCTOROBJECT);

		Assert.assertEquals(INSTRUCTOROBJECT, service.deleteInstructor(1));

	}
	
	@Test
	public void updateInstructorTest() {
		String updated = ("Rich, Harris");
		Mockito.when(repo.updateInstructor(1, updated)).thenReturn(updated);

		Assert.assertEquals(updated, service.updateInstructor(1, updated));
		
	}

}
