package com.qa.persistence.repo;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.qa.persistence.domain.Members;
import com.qa.persistence.repository.MembersMapRepository;

public class MembersMapTests {
	
	private MembersMapRepository mmr;
	private Members mem1;
	private Members mem2;

	@Before
	public void setup() {
	mmr = new MembersMapRepository();
	mem1 = new Members(1,"Krystal", "Ryan");
	mem2= new Members(2,"Jack", "Ryan");
}
	
	@Test
	public void addMemberTest() {
		mmr.createMember(Constants.MEMBEROBJECT);
		assertEquals(1, mmr.getmembersMap().size());
		assertEquals("Krystal", mmr.getmembersMap().get(1).getFirstname());
	}	
	
	@Test
	public void add2MembersTest() {
		mmr.createMember(Constants.MEMBEROBJECT);
		mmr.createMember(Constants.MEMBER2OBJECT);
		assertEquals(2, mmr.getmembersMap().size());
		assertEquals("Jack", mmr.getmembersMap().get(2).getFirstname());
	}
	

	@Test
	public void getAllMembers() {
		mmr.createMember(Constants.MEMBEROBJECT);
		mmr.createMember(Constants.MEMBER2OBJECT);	
		assertEquals("[{\"memberid\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"},{\"memberid\":2,\"firstname\":\"Jack\",\"lastname\":\"Ryan\"}]",mmr.getAllMembers());
	}
	
	@Test
	public void findMember() {
		mmr.createMember(Constants.MEMBEROBJECT);
		assertEquals(Constants.MEMBEROBJECT,mmr.findMember(1));
	}
	
	@Test
	public void updateMember() {
		mmr.getmembersMap().put(1, mem1);
		mmr.updateMember(1, "{\"memberid\":1,\"firstname\":\"Jack\",\"lastname\":\"Ryan\"}");
		assertEquals("Jack", mmr.getmembersMap().get(1).getFirstname());
	}
	
	@Test
	public void updateMemberThatDoesntExist() {
		mmr.getmembersMap().put(1, mem1);
		assertEquals("Member failed to update", mmr.updateMember(3, "{\"memberid\":3,\"firstname\":\"Megan\",\"lastname\":\"Ryan\"}"));	
	}
	
	@Test
	public void removeMemberTest() {

		mmr.getmembersMap().put(1, mem1);

		mmr.deleteMember(1);
		assertEquals(0, mmr.getmembersMap().size());
	}
	
	@Test
	public void remove2MembersTest() {
		mmr.getmembersMap().put(1, mem1);
		mmr.getmembersMap().put(2, mem2);
		mmr.deleteMember(1);
		mmr.deleteMember(2);
		assertEquals(0, mmr.getmembersMap().size());
	}
	
	@Test
	public void remove2MembersAnd1ThatDoesntExistTest() {
		mmr.getmembersMap().put(1, mem1);
		mmr.getmembersMap().put(2, mem2);
		mmr.deleteMember(1);
		mmr.deleteMember(2);
		mmr.deleteMember(3);
		assertEquals(0, mmr.getmembersMap().size());
	}
}
