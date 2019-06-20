package com.qa.persistence.repo;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.qa.persistence.domain.Classes;
import com.qa.persistence.repository.ClassesMapRepository;


public class ClassesMapTests {
	
	private ClassesMapRepository cmr;
	private Classes class1;
	private Classes class2;

	@Before
	public void setup() {
	cmr = new ClassesMapRepository();
	class1 = new Classes(1, "Balletfit", null);
	class2= new Classes(2, "Zumba", null);
}
	
	@Test
	public void addClassTest() {
		cmr.createClass("{\"classid\":1,\"classname\":\"Balletfit\"}");
		assertEquals(1, cmr.getclassMap().size());
		assertEquals("Balletfit", cmr.getclassMap().get(1).getClassname());
	}	
	
	@Test
	public void add2ClassesTest() {
		cmr.createClass("{\"classid\":1,\"classname\":\"Balletfit\"}");
		cmr.createClass("{\"classid\":2,\"classname\":\"Zumba\"}");
		assertEquals(2, cmr.getclassMap().size());
		assertEquals("Zumba", cmr.getclassMap().get(2).getClassname());
	}
	
	@Test
	public void getAllMembers() {
		cmr.createClass("{\"classid\":1,\"classname\":\"Balletfit\"}");
		cmr.createClass("{\"classid\":2,\"classname\":\"Zumba\"}");	
		assertEquals("[{\"classid\":1,\"classname\":\"Balletfit\"},{\"classid\":2,\"classname\":\"Zumba\"}]",cmr.getAllClasses());
	}
	
	@Test
	public void findClass() {
		cmr.createClass("{\"classid\":1,\"classname\":\"Balletfit\"}");
		assertEquals("{\"classid\":1,\"classname\":\"Balletfit\"}",cmr.findClass(1));
	}
	
	@Test
	public void updateClass() {
		cmr.getclassMap().put(1, class1);
		cmr.updateClass(1, "{\"classid\":1,\"classname\":\"Spin\"}");
		assertEquals("Spin", cmr.getclassMap().get(1).getClassname());
	}
	
	@Test
	public void updateClassThatDoesntExist() {
		cmr.getclassMap().put(1, class1);
		assertEquals("Class failed to update", cmr.updateClass(3, "{\"classid\":3,\"classname\":\"HIIT\"}"));	
	}
	
	@Test
	public void removeClassTest() {

		cmr.getclassMap().put(1, class1);
		cmr.deleteClass(1);
		assertEquals(0, cmr.getclassMap().size());
	}
	
	@Test
	public void remove2ClassesTest() {
		cmr.getclassMap().put(1, class1);
		cmr.getclassMap().put(2, class2);
		cmr.deleteClass(1);
		cmr.deleteClass(2);
		assertEquals(0, cmr.getclassMap().size());
	}
	
	@Test
	public void remove2ClassesAnd1ThatDoesntExistTest() {
		cmr.getclassMap().put(1, class1);
		cmr.getclassMap().put(2, class2);
		cmr.deleteClass(1);
		cmr.deleteClass(2);
		cmr.deleteClass(3);
		assertEquals(0, cmr.getclassMap().size());
	}

}
