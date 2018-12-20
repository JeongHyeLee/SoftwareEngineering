import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AppointmentsTest {
	@Test
	void testGetLocation() {
		Appointments appointments= new Appointments(20181224, "jisoo", "house");
		assertEquals(appointments.getLocation(), "house");
		
	}
	@Test
	void CreateContactTest() {
		Appointment appointment= new Appointment();
		assertTrue(appointment.checkVectorSize(-1));
		
	}
}
