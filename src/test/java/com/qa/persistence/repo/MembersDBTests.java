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
	
	private static final String MEMBER1 = "[{\"memberid\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}]";
    private static final String MEMBEROBJECT = "{\"memberid\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}";	
	@Before 
	public void setup() {
		repo.setManager(manager);
		j1 = new JSONUtil();
		repo.setJ1(j1);
	}
	
	
	@Test
	public void getAllMembersTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Members> members = new ArrayList<Members>();
		members.add(new Members(1,"Krystal","Ryan"));
		Mockito.when(query.getResultList()).thenReturn(members);
		Assert.assertEquals(MEMBER1,repo.getAllMembers());
		
	}
	
	@Test
	public void findMemberTest() {
		List<Members> members = new ArrayList<Members>();
		Members member = new Members(1, "Krystal","Ryan");
		members.add(member);
		Mockito.when(manager.find(Members.class,1)).thenReturn(member);
		Assert.assertEquals(MEMBEROBJECT, repo.findMember(1));
	}
	
	
	@Test
	public void createMemberTest() {
		Assert.assertEquals("{\"message\": \"Member has been successfully added\"}",repo.createMember(MEMBEROBJECT));
	}
	
	
	
	@Test
	public void deleteMemberTest() {
		List<Members> members = new ArrayList<>();
		Members member = new Members(1,"Krystal", "Ryan");
		members.add(member);
		Mockito.when(manager.find(Members.class,1)).thenReturn(member);
		Mockito.when(manager.contains(member)).thenReturn(true);
		String reply = repo.deleteMember(1);
		Assert.assertEquals("{\"message\": \"Member sucessfully deleted 1 \"}",reply);
		
	}
	
	@Test
	public void updateMemberTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Members> members = new ArrayList<Members>();
		Members member = new Members(1, "Krystal","Ryan");
		Mockito.when(query.getResultList()).thenReturn(members);
		Mockito.when(manager.find(Members.class,1)).thenReturn(member);
		String reply = repo.updateMember(1, j1.getJSONForObject(member));
		Assert.assertEquals("{\"message\": \"Member successfully updated\"}",reply);
	}
	
	@Test
	public void updateMemberThatDoesntExistTest() {
	Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
	List<Members> members = new ArrayList<Members>();
	Members member = new Members(1, "Krystal","Ryan");
	Mockito.when(query.getResultList()).thenReturn(members);
	Mockito.when(manager.find(Members.class,1)).thenReturn(member);
	String reply = repo.updateMember(3, j1.getJSONForObject(member));
	Assert.assertEquals("{\"message\": \"No member found with this id\"}",reply);
}
}
