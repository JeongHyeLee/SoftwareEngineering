import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;




public class Requirement {
	Scanner scanner=new Scanner(System.in);
	public static ArrayList<String> dateList=new ArrayList<String>();
	public static ArrayList<String> personList=new ArrayList<String>();
	public static ArrayList<String> locationList=new ArrayList<String>();
	public static int ii;
	//	ArrayList dateList=new ArrayList();
	//	ArrayList personList=new ArrayList();
	//	ArrayList locationList=new ArrayList();
	public Requirement() {
		
	}



	public static boolean CreateAppointment(int date, String person, String location) {

		String strdate=String.valueOf(date);

		dateList.add(strdate);
		personList.add(person);
		locationList.add(location);


		return true;
	}
	public static void ViewAppointment() {

		System.out.println(dateList.size());
		for(int i=0;i<dateList.size();i++) {
			System.out.print(dateList.get(i)+"  "+ personList.get(i)+"  "+locationList.get(i)+"\n");

		}
	}

	public static void UpdateAppointment(int date, String person, String location) {

		String strdate=String.valueOf(date);

		dateList.set(ii, strdate);
		personList.set(ii,person);
		locationList.set(ii,location);


	}




	public static void DeleteAppointment (int date, String person, String location) {
		String strdate=String.valueOf(date);
		for(int i=0;i<dateList.size();i++) {
			if(strdate.equals(dateList.get(i).toString())&& person.equals(personList.get(i).toString())&& location.equals(locationList.get(i).toString())) {
				dateList.remove(i);
				personList.remove(i);
				locationList.remove(i);
				break;


			}



			//		
			//		System.out.println(dateList.size());
			//		for(int i=0;i<dateList.size();i++) {
			//			System.out.print(dateList.get(i)+"  "+ personList.get(i)+"  "+locationList.get(i)+"\n");

		}


	}


	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		while(true) {
			System.out.println("Appointment manage"+"\n"+ "1.Create 2.View 3.Update 4.Delete");

			int answer=scanner.nextInt();

			if(answer==1) {
				System.out.print("날짜(예시:181124), 사람, 위치 순으로 차례로 입력>>");
				int date=scanner.nextInt();
				String person=scanner.next();
				String location=scanner.next();

				CreateAppointment(date,  person,  location) ;
			}
			else if(answer==2) {

				ViewAppointment();



			}
			else if(answer==3) {
				System.out.print("Write appointments' date, person, location to update(ex. 181224 Jisoo SMUnicersity)>>");
				int date=scanner.nextInt();
				String person=scanner.next();
				String location=scanner.next();
				String strdate=String.valueOf(date);

				for(ii=0;ii<dateList.size();ii++) {
					if(strdate.equals(dateList.get(ii).toString())&& person.equals(personList.get(ii).toString())&& location.equals(locationList.get(ii).toString())) {
						System.out.print("Update:");
						date=scanner.nextInt();
						person=scanner.next();
						location=scanner.next();
						UpdateAppointment(date,  person, location);
						break;
					}


				}}
			else if(answer==4) {
				System.out.print("수정할 것 입력:");
				int date=scanner.nextInt();
				String person=scanner.next();
				String location=scanner.next();

				DeleteAppointment ( date,  person,  location);




			}
		}




	}
}


