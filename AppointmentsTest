import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

class AppointmentsTest {

	@Test
	void CreateAppointmentTest() {
		Appointments appointments = new Appointments();
		assertTrue(appointments.CreateAppointment(20181224, "Jisoo", "SMWU"));
	}
	
	@Test
	void DeleteAppointmentTest() {
		int Appointmentsize;
		Appointments appointments = new Appointments();
		Vector<Word> v= new Vector<Word>();
		Appointmentsize=v.size();
		appointments.DeleteAppointment(20181224, "Jisoo", "SMWU");
		assertEquals(Appointmentsize-1,v.size());
	}

}
