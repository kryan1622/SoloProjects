package com.qa.business.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.ClassesDatabaseRepository;
import com.qa.util.JSONUtil;


@RunWith(MockitoJUnitRunner.class)
public class ClassesServiceTest {

	
	@InjectMocks
	private ClassesServiceImpl service;
	
	@Mock
	private ClassesDatabaseRepository repo;
	
	@Mock
	private JSONUtil j1;
	
	private static final String CLASS1 = "[{\"classid\":1,\"classname\":\"Zumba\"}]";
    private static final String CLASSOBJECT = "{\"classid\":1,\"classname\":\"Zumba\"}";
	
	@Test
	public void getAllClassesTest() {
		Mockito.when(repo.getAllClasses()).thenReturn("{\"message\": \"No classes found\"}");
		Assert.assertEquals("{\"message\": \"No classes found\"}", service.getAllClasses());
		
	}
	
	@Test
	public void createClassTest() {
		Mockito.when(repo.createClass(CLASS1)).thenReturn("{\"message\": \"Class has been successfully added\"}");
		Assert.assertEquals("{\"message\": \"Class has been successfully added\"}", service.createClass(CLASS1));
	}
	
	@Test
	public void findClassTest() {
		Mockito.when(repo.findClass(1)).thenReturn(CLASSOBJECT);
		Assert.assertEquals(CLASSOBJECT, service.findClass(1));
	}
	
	@Test
	public void deleteClassTest() {
		Mockito.when(repo.deleteClass(1)).thenReturn(CLASSOBJECT);

		Assert.assertEquals(CLASSOBJECT, service.deleteClass(1));

	}
	
	@Test
	public void updateClassTest() {
		String updated = ("HIIT");
		Mockito.when(repo.updateClass(1, updated)).thenReturn(updated);

		Assert.assertEquals(updated, service.updateClass(1, updated));
		
	}
}
