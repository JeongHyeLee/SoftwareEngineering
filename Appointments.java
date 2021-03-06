import java.io.*;
import java.util.*;



public class Appointments {
	Appointment a=new Appointment();
	Scanner scanner = new Scanner(System.in);
	public int answer;


	private int date;
	private String person;
	private String location;

	
	public int getDate() {
		return date;
	}
	public String getPerson() {
		return person;
	}

	public String getLocation() {
		return location;
	}
	public void updateValues(int date, String person, String location) {
		this.date = date;
		this.person = person;
		this.location = location;
	}

	Appointments() {
		
	}
	Appointments(int date,String person,String location){
		this.date=date;
		this.person=person;
		this.location=location;
		
	}
	

	
			
	public void run() {
		Appointment appointment=new Appointment();
		while(true) {
			System.out.println("1.Create 2.View 3.Update 4.Delete 5.Exit");
			answer=scanner.nextInt();
			if(answer==1) {
				appointment.CreateAppointment(date, person,location);
			}
			else if(answer==2) {
				appointment.ViewAppointment();
			}
			else if(answer==3) {
				appointment.UpdateAppointment( date, person,  location);
			}
			else if(answer==4) {
				appointment.DeleteAppointment ( date, person,location);
			}
			else if(answer==5) {
				System.out.println("종료합니다.");
				break;
			}

		}
	}








}

class Appointment{
	public Vector<Appointments> v= new Vector<Appointments>();
	Scanner scanner = new Scanner(System.in);
	
	public Appointment() {}
	
	public Boolean CreateAppointment(int date, String person, String location) {
		System.out.print("날짜 입력(예시181120): ");
		int answerDate=scanner.nextInt();

		System.out.print("Person 입력: ");
		String answerPerson=scanner.next();

		System.out.print("Location 입력: ");
		String answerLocation=scanner.next();

		v.add(new Appointments(answerDate, answerPerson, answerLocation));

		System.out.println("Create 완료");
		return true;
	}


	public void ViewAppointment() {
		for(int i=0;i<v.size();i++) {
			Appointments wordanswer=v.get(i);
			System.out.print(wordanswer.getDate()+", ");
			System.out.print(wordanswer.getPerson()+", ");
			System.out.print(wordanswer.getLocation()+"\n");
		}	
	}

	public void UpdateAppointment(int date, String person, String location) {
		System.out.println("Appointment를 Update합니다.");
		System.out.print("Update 전 Date 입력(예시181120): ");
		int answerDate=scanner.nextInt();

		System.out.print("Update 전 Person 입력: ");
		String answerPerson=scanner.next();

		System.out.print("Update 전 Location 입력: ");
		String answerLocation=scanner.next();
		
		
		for(int i=0;i<v.size();i++) {
			Appointments wordanswer=v.get(i);
			if(wordanswer.getDate()==answerDate && answerPerson.equals(wordanswer.getPerson()) &&answerLocation.equals(wordanswer.getLocation())) {
				System.out.print("Update 후 Date 입력(예시181120): ");
				answerDate=scanner.nextInt();

				System.out.print("Update 후 Person 입력: ");
				answerPerson=scanner.next();

				System.out.print("Update 후 Location 입력: ");
				answerLocation=scanner.next();
				
				wordanswer.updateValues(answerDate, answerPerson, answerLocation);
				System.out.println("Update 완료");
				return;
			}
			
		}	

	}

	public void DeleteAppointment (int date, String person, String location) {
		System.out.println("Appointment를 Delete합니다.");
		System.out.print("삭제하고 싶은 Date 입력(예시181120): ");
		int answerDate=scanner.nextInt();

		System.out.print("삭제하고 싶은 Person 입력: ");
		String answerPerson=scanner.next();

		System.out.print("삭제하고 싶은 Location 입력: ");
		String answerLocation=scanner.next();
		
		for(int i=0;i<v.size();i++) {
			Appointments wordanswer=v.get(i);
			if(wordanswer.getDate()==answerDate && answerPerson.equals(wordanswer.getPerson()) &&answerLocation.equals(wordanswer.getLocation())) {
				v.remove(i);
				return;
			}
			
		}
		
		System.out.println("삭제 완료");
	}
	
	public Boolean checkVectorSize(int num) {
		if(num<=v.size())
			return true;
		else 
			return false;
	}
	
	
}
