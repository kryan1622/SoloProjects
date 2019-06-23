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
	
		private Classes class1;
		private Classes class2;
		
		
	@Before 
	public void setup() {
		repo.setManager(manager);
		j1 = new JSONUtil();
		repo.setJ1(j1);
		class1 = new Classes(1, "Zumba");
		class2 = new Classes(1, "Balletfit");
	}
		
	
	@Test
	public void getAllClassesTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Classes> classes = new ArrayList<Classes>();
		classes.add(class1);
		Mockito.when(query.getResultList()).thenReturn(classes);
		Assert.assertEquals(Constants.CLASS1,repo.getAllClasses());
		
	}
	
	@Test
	public void findClassTest() {
		List<Classes> classes = new ArrayList<Classes>();
		classes.add(class2);
		Mockito.when(manager.find(Classes.class,1)).thenReturn(class2);
		Assert.assertEquals(Constants.CLASSOBJECT, repo.findClass(1));
	}


		@Test
		public void createMemberTest() {
		Assert.assertEquals("{\"message\": \"Class has been successfully added\"}",repo.createClass(Constants.CLASSOBJECT));
		}
		
		
		@Test
		public void deleteClassTest() {
			List<Classes> classes = new ArrayList<>();
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
			Mockito.when(query.getResultList()).thenReturn(classes);
			Mockito.when(manager.find(Classes.class,1)).thenReturn(class1);
			String reply = repo.updateClass(1, j1.getJSONForObject(class1));
			Assert.assertEquals("{\"message\": \"Class successfully updated\"}",reply);
		}
		
		@Test
		public void updateClassThatDoesntExistTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Classes> classes = new ArrayList<Classes>();
		Mockito.when(query.getResultList()).thenReturn(classes);
		Mockito.when(manager.find(Classes.class,1)).thenReturn(class1);
		String reply = repo.updateClass(3, j1.getJSONForObject(class1));
		Assert.assertEquals("{\"message\": \"No class found with this id\"}",reply);
	}	
		
}
