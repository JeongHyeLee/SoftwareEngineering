import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		
		/*----------Variables----------*/
		int mainMenuSelect;
		boolean mainIsWork = true;
		/*-----------------------------*/
		
		/*----------Constructor----------*/
		ToDoList ToDoList = new ToDoList();
		Contacts Contacts = new Contacts(null, null, null);
		Notes Note = new Notes();
		/*-----------------------------*/
		
		Scanner scan = new Scanner(System.in);

		while(mainIsWork) {
			System.out.println();
			System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
			System.out.println("*                ���� Management ���α׷��Դϴ�.               *");
			System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
			System.out.print("\n���ϴ� �۾��� �����ϼ���.\n1.Contacts, 2.To-Do List, 3.Appointments, 4.Notes, 5.Quit\n\n(���� 1~5 �� �ϳ� ����) > ");
			
			mainMenuSelect = scan.nextInt();
			
			switch(mainMenuSelect) {
				case 1:
					System.out.println();
					Contacts.AddressBook();
					break;
					
				case 2:
					System.out.println();
					ToDoList.ToDoList();
					break;
					
				case 3:
					System.out.println();
					System.out.println("(���� ) : ��� ����");
					break;
					
				case 4:
					System.out.println("editing note class");
					Notes.note();
					break;
					
				case 5:
					System.out.println();
					System.out.println("���� Management ���α׷� ����");
					mainIsWork = false;
			}
		}
	}
}
