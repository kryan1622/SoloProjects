package com.qa.business.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.MembersDatabaseRepository;
import com.qa.util.JSONUtil;


@RunWith(MockitoJUnitRunner.class)
public class MembersServiceTest {

	@InjectMocks
	private MembersServiceImpl service;
	
	@Mock
	private MembersDatabaseRepository repo;
	
	@Mock
	private JSONUtil j1;
	
	private static final String MEMBER1 = "[{\"memberid\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}]";
    private static final String MEMBEROBJECT = "{\"memberid\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}";
	
	@Test
	public void getAllMembers() {
		Mockito.when(repo.getAllMembers()).thenReturn("{\"message\": \"No members found\"}");
		Assert.assertEquals("{\"message\": \"No members found\"}", service.getAllMembers());
		
	}
	
	@Test
	public void createMember() {
		Mockito.when(repo.createMember(MEMBER1)).thenReturn("{\"message\": \"Member has been successfully added\"}");
		Assert.assertEquals("{\"message\": \"Member has been successfully added\"}", service.createMember(MEMBER1));
	}
	
	@Test
	public void findMember() {
		Mockito.when(repo.findMember(1)).thenReturn(MEMBEROBJECT);
		Assert.assertEquals(MEMBEROBJECT, service.findMember(1));
	}
	
	@Test
	public void deleteMemberTest() {
		Mockito.when(repo.deleteMember(1)).thenReturn(MEMBEROBJECT);

		Assert.assertEquals(MEMBEROBJECT, service.deleteMember(1));

	}
	
	@Test
	public void updateMemberTest() {
		String updated = ("Jack, Ryan");
		Mockito.when(repo.updateMember(1, updated)).thenReturn(updated);

		Assert.assertEquals(updated, service.updateMember(1, updated));
		
	}
}
