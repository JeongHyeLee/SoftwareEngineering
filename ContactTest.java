import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void CreateContactTest() {
		Contact contact = new Contact();
		assertTrue(contact.CreateContact("jung", "010-1234-5678", "jung@naver.com"));
	}
	
	@Test
	void DeleteContactTest() {
		Contact contact = new Contact();
		assertFalse(contact.DeleteContact("kim"));
	}
}
