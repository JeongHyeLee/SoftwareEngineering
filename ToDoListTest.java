import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class ToDoListTest {

	@Test
	void CreateListTest() {
		ToDoList toDoList = new ToDoList();
		assertSame(toDoList.CreateList("2018-12-01", "2018-12-21", "����Ʈ���� ���� Homework #3 ������!"), true);
	}
	
	@Test
	void DeleteListTest() {
		ToDoList toDoList = new ToDoList();
		assertFalse(toDoList.DeleteList(10) == false);
	}
}