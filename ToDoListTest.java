import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class ToDoListTest {

	@Test
	void CreateListTest() {
		ToDoList toDoList = new ToDoList();
		assertEquals(true, toDoList.CreateList("2018-12-01", "2018-12-21", "Finish Software Engineering HW3!!!"));
	}
	
	@Test
	void DeleteListTest() {
		ToDoList toDoList = new ToDoList();
		toDoList.Initialize();
		toDoList.CreateList("2018-12-01", "2018-12-21", "this is < keyNumber #0 > To-Do List!");
		assertTrue(toDoList.DeleteList(0));
		assertFalse(toDoList.DeleteList(0));
	}
}