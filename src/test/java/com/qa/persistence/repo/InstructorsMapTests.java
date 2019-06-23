package com.qa.persistence.repo;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.qa.persistence.domain.Instructors;
import com.qa.persistence.repository.InstructorMapRepository;

public class InstructorsMapTests {
	
	private InstructorMapRepository imr;
	private Instructors in1;
    private Instructors in2;

	@Before
	public void setup() {
	imr = new InstructorMapRepository();
	in1= new Instructors(1, "Josh", "Brookes");
	in2 = new Instructors(2, "Monica", "Mistry");
	
}
	
	@Test
	public void addInstructorTest() {
		imr.createInstructor(Constants.INSTRUCTOROBJECT);
		assertEquals(1, imr.getinstructorsMap().size());
		assertEquals("Josh", imr.getinstructorsMap().get(1).getFirstname());
	}	
	
	@Test
	public void add2InstructorsTest() {
		imr.createInstructor(Constants.INSTRUCTOROBJECT);
		imr.createInstructor(Constants.INSTRUCTOR2OBJECT);
		assertEquals(2, imr.getinstructorsMap().size());
		assertEquals("Monica", imr.getinstructorsMap().get(2).getFirstname());
	}
	

	@Test
	public void getAllInstructors() {
		imr.createInstructor(Constants.INSTRUCTOROBJECT);
		imr.createInstructor(Constants.INSTRUCTOR2OBJECT);
		assertEquals("[{\"instructorid\":1,\"firstname\":\"Josh\",\"lastname\":\"Brookes\"},{\"instructorid\":2,\"firstname\":\"Monica\",\"lastname\":\"Mistry\"}]",imr.getAllInstructors());
	}
	
	@Test
	public void findInstructor() {
		imr.createInstructor(Constants.INSTRUCTOROBJECT);
		assertEquals(Constants.INSTRUCTOROBJECT,imr.findInstructor(1));
	}
	
	@Test
	public void updateInstructor() {
		imr.getinstructorsMap().put(1, in1);
		imr.updateInstructor(1, "{\"instructorid\":1,\"firstname\":\"Sarah\",\"lastname\":\"Mistry\"}");
		assertEquals("Sarah", imr.getinstructorsMap().get(1).getFirstname());
	}
	
	@Test
	public void updateInstructorThatDoesntExist() {
		imr.getinstructorsMap().put(1, in1);
		assertEquals("Instructor failed to update", imr.updateInstructor(3, "{\"instructorid\":3,\"firstname\":\"Owen\",\"lastname\":\"Miller\"}"));	
	}
	
	@Test
	public void removeInstructorTest() {

		imr.getinstructorsMap().put(1, in1);
		imr.deleteInstructor(1);
		assertEquals(0, imr.getinstructorsMap().size());
	}
	
	@Test
	public void remove2InstructorsTest() {
		imr.getinstructorsMap().put(1, in1);
		imr.getinstructorsMap().put(2, in2);
		imr.deleteInstructor(1);
		imr.deleteInstructor(2);
		assertEquals(0, imr.getinstructorsMap().size());
	}
	
	@Test
	public void remove2InstructorsAnd1ThatDoesntExistTest() {
		imr.getinstructorsMap().put(1, in1);
		imr.getinstructorsMap().put(2, in2);
		imr.deleteInstructor(1);
		imr.deleteInstructor(2);
		imr.deleteInstructor(3);
		assertEquals(0, imr.getinstructorsMap().size());
	}

}
