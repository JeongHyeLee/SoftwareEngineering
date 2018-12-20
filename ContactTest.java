import static org.junit.Assert.*;
import java.util.Vector;
import org.junit.Test;

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
