import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Vector;



public class AppointmentsTest {

	@Test
	public void CreateAppointmentTest() {
		Appointments appointments = new Appointments();
		assertTrue(appointments.CreateAppointment(20181224, "Jisoo", "SMWU"));

	}
	@Test
	public void UpdateAppointmentTest() {
	   Appointments appointments = new Appointments();
	   Vector<Word> v= new Vector<Word>();
	   int sizeAppointment=v.size();
	   appointments.ViewAppointment();
	   assertEquals(sizeAppointment, v.size());
	}


}
