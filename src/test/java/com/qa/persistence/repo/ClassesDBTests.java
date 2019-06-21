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

import com.qa.persistence.domain.Classes;
import com.qa.persistence.repository.ClassesDatabaseRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ClassesDBTests {




		@InjectMocks
		private ClassesDatabaseRepository repo;
		
		@Mock
		private EntityManager manager;
		
		@Mock
		private JSONUtil j1;
		
		@Mock
		private Query query;
	
		private static final String CLASS1 = "[{\"classid\":1,\"classname\":\"Zumba\"}]";
	    private static final String CLASSOBJECT = "{\"classid\":1,\"classname\":\"Balletfit\"}";
		
		
	@Before 
	public void setup() {
		repo.setManager(manager);
		j1 = new JSONUtil();
		repo.setJ1(j1);
	}
		
	
	@Test
	public void getAllClassesTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Classes> classes = new ArrayList<Classes>();
		classes.add(new Classes(1,"Zumba"));
		Mockito.when(query.getResultList()).thenReturn(classes);
		Assert.assertEquals(CLASS1,repo.getAllClasses());
		
	}
	
	@Test
	public void findClassTest() {
		List<Classes> classes = new ArrayList<Classes>();
		Classes class1 = new Classes(1, "Balletfit");
		classes.add(class1);
		Mockito.when(manager.find(Classes.class,1)).thenReturn(class1);
		Assert.assertEquals(CLASSOBJECT, repo.findClass(1));
	}


		@Test
		public void createMemberTest() {
		Assert.assertEquals("{\"message\": \"Class has been successfully added\"}",repo.createClass(CLASSOBJECT));
		}
		
		
		@Test
		public void deleteClassTest() {
			List<Classes> classes = new ArrayList<>();
			Classes class1 = new Classes(1,"Zumba");
			classes.add(class1);
			Mockito.when(manager.find(Classes.class,1)).thenReturn(class1);
			Mockito.when(manager.contains(class1)).thenReturn(true);
			String reply = repo.deleteClass(1);
			Assert.assertEquals("{\"message\": \"Class sucessfully deleted 1 \"}",reply);
}
		@Test
		public void updateClassTest() {
			Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
			List<Classes> classes = new ArrayList<Classes>();
			Classes class2 = new Classes(1, "Zumba");
			Mockito.when(query.getResultList()).thenReturn(classes);
			Mockito.when(manager.find(Classes.class,1)).thenReturn(class2);
			String reply = repo.updateClass(1, j1.getJSONForObject(class2));
			Assert.assertEquals("{\"message\": \"Class successfully updated\"}",reply);
		}
		
		@Test
		public void updateClassThatDoesntExistTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Classes> classes = new ArrayList<Classes>();
		Classes class3 = new Classes(1, "Balletfit");
		Mockito.when(query.getResultList()).thenReturn(classes);
		Mockito.when(manager.find(Classes.class,1)).thenReturn(class3);
		String reply = repo.updateClass(3, j1.getJSONForObject(class3));
		Assert.assertEquals("{\"message\": \"No class found with this id\"}",reply);
	}	
		
}
