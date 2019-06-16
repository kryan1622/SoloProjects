package com.qa.MapTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Instructors;
import com.qa.persistence.repository.InstructorMapRepository;

public class InstructorsMapTests {
//	
//	private InstructorMapRepository imr;
//	private Instructors in1;
//    private Instructors in2;
//
//	@Before
//	public void setup() {
//	imr = new InstructorMapRepository();
//	in1 = new Instructors("Monica", "Mistry");
//	in2= new Instructors("Josh", "Brookes");
//}
//	
//	@Test
//	public void addInstructorTest() {
//		imr.createInstructor("{\"instructorid\":1,\"firstname\":\"Monica\",\"lastname\":\"Mistry\"}");
//		assertEquals(1, imr.getinstructorsMap().size());
//		assertEquals("Monica", imr.getinstructorsMap().get(1).getFirstname());
//	}	
//	
//	@Test
//	public void add2InstructorsTest() {
//		imr.createInstructor("{\"instructorid\":1,\"firstname\":\"Monica\",\"lastname\":\"Mistry\"}");
//		imr.createInstructor("{\"instructorid\":2,\"firstname\":\"Josh\",\"lastname\":\"Brookes\"}");
//		assertEquals(2, imr.getinstructorsMap().size());
//		assertEquals("Josh", imr.getinstructorsMap().get(2).getFirstname());
//	}
//	
//
//	@Test
//	public void getAllInstructors() {
//		imr.createInstructor("{\"instructorid\":1,\"firstname\":\"Monica\",\"lastname\":\"Mistry\"}");
//		imr.createInstructor("{\"instructorid\":2,\"firstname\":\"Josh\",\"lastname\":\"Brookes\"}");
//		assertEquals("[{\"instructorid\":1,\"firstname\":\"Monica\",\"lastname\":\"Mistry\"},{\"instructorid\":2,\"firstname\":\"Josh\",\"lastname\":\"Brookes\"}]",imr.getAllInstructors());
//	}
//	
//	@Test
//	public void findInstructor() {
//		imr.createInstructor("{\"instructorid\":1,\"firstname\":\"Monica\",\"lastname\":\"Mistry\"}");
//		assertEquals("{\"instructorid\":1,\"firstname\":\"Monica\",\"lastname\":\"Mistry\"}",imr.findInstructor(1));
//	}
//	
//	@Test
//	public void updateInstructor() {
//		imr.getinstructorsMap().put(1, in1);
//		imr.updateInstructor(1, "{\"instructorid\":1,\"firstname\":\"Sarah\",\"lastname\":\"Mistry\"}");
//		assertEquals("Sarah", imr.getinstructorsMap().get(1).getFirstname());
//	}
//	
//	@Test
//	public void updateInstructorThatDoesntExist() {
//		imr.getinstructorsMap().put(1, in1);
//		assertEquals("Instructor failed to update", imr.updateInstructor(3, "{\"instructorid\":3,\"firstname\":\"Owen\",\"lastname\":\"Miller\"}"));	
//	}
//	
//	@Test
//	public void removeInstructorTest() {
//
//		imr.getinstructorsMap().put(1, in1);
//		imr.deleteInstructor(1);
//		assertEquals(0, imr.getinstructorsMap().size());
//	}
//	
//	@Test
//	public void remove2InstructorsTest() {
//		imr.getinstructorsMap().put(1, in1);
//		imr.getinstructorsMap().put(2, in2);
//		imr.deleteInstructor(1);
//		imr.deleteInstructor(2);
//		assertEquals(0, imr.getinstructorsMap().size());
//	}
//	
//	@Test
//	public void remove2InstructorsAnd1ThatDoesntExistTest() {
//		imr.getinstructorsMap().put(1, in1);
//		imr.getinstructorsMap().put(2, in2);
//		imr.deleteInstructor(1);
//		imr.deleteInstructor(2);
//		imr.deleteInstructor(3);
//		assertEquals(0, imr.getinstructorsMap().size());
//	}

}
