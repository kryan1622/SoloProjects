package com.qa.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.business.service.InstructorsServiceImpl;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class InstructorsControllerTest {

	
	@InjectMocks
	private InstructorsController con;
	
	@Mock
	private InstructorsServiceImpl service;
	
	@Mock
	private JSONUtil j1;
	
	private static final String INSTRUCTOR1 = "[{\"instructorid\":1,\"firstname\":\"Josh\",\"lastname\":\"Brookes\"}]";
    private static final String INSTRUCTOROBJECT = "{\"instructorid\":1,\"firstname\":\"Josh\",\"lastname\":\"Brookes\"}";

    @Test
	public void getAllInstructorTest() {
		Mockito.when(service.getAllInstructors()).thenReturn("{\"message\": \"No instructors found\"}");
		Assert.assertEquals("{\"message\": \"No instructors found\"}", con.getAllInstructors());	
	}
    
    @Test
	public void createInstructorTest() {
		Mockito.when(service.createInstructor(INSTRUCTOR1)).thenReturn("{\"message\": \"Instructor has been successfully added\"}");
		Assert.assertEquals("{\"message\": \"Instructor has been successfully added\"}", con.createInstructor(INSTRUCTOR1));
	}

    @Test
	public void findInstructorTest() {
		Mockito.when(service.findInstructor(1)).thenReturn(INSTRUCTOROBJECT);
		Assert.assertEquals(INSTRUCTOROBJECT, con.findInstructor(1));
	}
    
    @Test
	public void deleteInstructorTest() {
		Mockito.when(service.deleteInstructor(1)).thenReturn(INSTRUCTOROBJECT);
		Assert.assertEquals(INSTRUCTOROBJECT, con.deleteInstructor(1));
	}
    
	@Test
	public void updateInstructorTest() {
		String updated = ("Rich, Harris");
		Mockito.when(service.updateInstructor(1, updated)).thenReturn(updated);
		Assert.assertEquals(updated, con.updateInstructor(1, updated));
		
	}
}
