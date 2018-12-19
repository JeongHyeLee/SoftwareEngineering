import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NotesTest {
	@Test
	void TestGetTitle() {
		Notes notes = new Notes("19-01-01", "title", "memo");
		assertEquals(notes.getTitle(),"title");
	}
	
	@Test
	void TestCheckOfListSize() {
		Note note = new Note();
		assertTrue(note.CheckOfListSize(-1));
	}
}
