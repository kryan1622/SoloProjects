package com.qa.rest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.business.service.MembersServiceImpl;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class MembersControllerTest {

	@InjectMocks
	private MemberController con;
	
	@Mock
	private MembersServiceImpl service;
	
	@Mock
	private JSONUtil j1;
	
	
	private static final String MEMBER1 = "[{\"memberid\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}]";
    private static final String MEMBEROBJECT = "{\"memberid\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}";

    @Test
	public void getAllMembersTest() {
		Mockito.when(service.getAllMembers()).thenReturn("{\"message\": \"No members found\"}");
		Assert.assertEquals("{\"message\": \"No members found\"}", con.getAllMembers());
	}
    
    @Test
	public void createMemberTest() {
		Mockito.when(service.createMember(MEMBER1)).thenReturn("{\"message\": \"Member has been successfully added\"}");
		Assert.assertEquals("{\"message\": \"Member has been successfully added\"}", con.createMember(MEMBER1));
	}
    
    @Test
	public void findMemberTest() {
		Mockito.when(service.findMember(1)).thenReturn(MEMBEROBJECT);
		Assert.assertEquals(MEMBEROBJECT, con.findMember(1));
	}

    @Test
	public void deleteMemberTest() {
		Mockito.when(service.deleteMember(1)).thenReturn(MEMBEROBJECT);
		Assert.assertEquals(MEMBEROBJECT, con.deleteMember(1));
	}
    
    @Test
	public void updateMemberTest() {
		String updated = ("Jack, Ryan");
		Mockito.when(service.updateMember(1, updated)).thenReturn(updated);

		Assert.assertEquals(updated, con.updateMember(1, updated));
		
	}
}
