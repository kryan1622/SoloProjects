package com.qa.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.ClassesServiceImpl;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassesControllerTest {

	
	
	@InjectMocks
	private ClassesController con;
	
	@Mock
	private ClassesServiceImpl service;
	
	@Mock
	private JSONUtil j1;
	
	private static final String CLASS1 = "[{\"classid\":1,\"classname\":\"Zumba\"}]";
    private static final String CLASSOBJECT = "{\"classid\":1,\"classname\":\"Zumba\"}";
    
	@Test
	public void getAllClassesTest() {
		Mockito.when(service.getAllClasses()).thenReturn("{\"message\": \"No classes found\"}");
		Assert.assertEquals("{\"message\": \"No classes found\"}", con.getAllClasses());
	}
	
	@Test
	public void createClassTest() {
		Mockito.when(service.createClass(CLASS1)).thenReturn("{\"message\": \"Class has been successfully added\"}");
		Assert.assertEquals("{\"message\": \"Class has been successfully added\"}", con.createClass(CLASS1));
	}
	
	@Test
	public void findClassTest() {
		Mockito.when(service.findClass(1)).thenReturn(CLASSOBJECT);
		Assert.assertEquals(CLASSOBJECT, con.findClass(1));
	}
	
	@Test
	public void deleteClassTest() {
		Mockito.when(service.deleteClass(1)).thenReturn(CLASSOBJECT);
		Assert.assertEquals(CLASSOBJECT, con.deleteClass(1));
	}
	
	@Test
	public void updateClassTest() {
		String updated = ("HIIT");
		Mockito.when(service.updateClass(1, updated)).thenReturn(updated);
		Assert.assertEquals(updated, con.updateClass(1, updated));
		
	}
}
