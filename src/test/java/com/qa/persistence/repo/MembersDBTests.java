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

import com.qa.persistence.domain.Members;
import com.qa.persistence.repository.MembersDatabaseRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class MembersDBTests {

	@InjectMocks
	private MembersDatabaseRepository repo;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private JSONUtil j1;
	
	@Mock
	private Query query;
	
	private static final String MEMBER1 = "[{\"memberid\":0,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}]";
	
	@Before 
	public void setup() {
		repo.setManager(manager);
		j1 = new JSONUtil();
		repo.setJ1(j1);
	}
	
	@Test
	public void getAllMembers() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Members> members = new ArrayList<Members>();
		members.add(new Members("Krystal","Ryan"));
		Mockito.when(query.getResultList()).thenReturn(members);
		System.out.println(repo.getAllMembers());
		Assert.assertEquals(MEMBER1,repo.getAllMembers());
		
	}
}
