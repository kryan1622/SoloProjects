package com.qa.MapTests;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.qa.persistence.repository.MembersMapRepository;

public class MembersMapTests {
	
	private MembersMapRepository mmr;

	@Before
	public void setup() {
	mmr = new MembersMapRepository();
}
	
	@Test
	public void addMemberTest() {
		mmr.createMember("{\"memberid\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}");
		assertEquals(1, mmr.getmembersMap().size());
		assertEquals("Krystal", mmr.getmembersMap().get(1).getFirstname());
	}	
	
	@Test
	public void add2MembersTest() {
		mmr.createMember("{\"memberid\":1,\"firstname\":\"Krystal\",\"lastname\":\"Ryan\"}");
		mmr.createMember("{\"memberid\":2,\"firstname\":\"Jack\",\"lastname\":\"Ryan\"}");
		assertEquals(2, mmr.getmembersMap().size());
		assertEquals("Jack", mmr.getmembersMap().get(2).getFirstname());
	}
}
