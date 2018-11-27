import java.util.ArrayList;
import java.util.Scanner;

public class Contacts01{
	String name;
	String phonenum;
	String email;
	
	public Contacts01(String name, String phonenum, String email) {
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList contacts = new ArrayList();	
		int pick;
		Contacts add = new Contacts();
		while(true) {
			System.out.print("1. create 2. view 3. update 4. delete 5. exit\n원하는 작업을 선택하세요:");
			pick = scan.nextInt();
			if(pick == 1) {
				System.out.print("name: ");
				String name = scan.next();
				System.out.print("phone number: ");
				String phonenum = scan.next();
				System.out.print("email: ");
				String email = scan.next();
				
				add.CreateContact(name, phonenum, email);
				
				System.out.print("추가 완료!\n");
			}		
			else if(pick == 2) {
				add.ViewContact();
			}
			else if(pick == 3) {
				System.out.print("contact of name to update: ");
				String name = scan.next();
				add.UpdateContact(name);
				System.out.print("수정 완료!\n");
				}
			else if(pick == 4) {
				System.out.print("contact of name to delete: ");
				String name = scan.next();
				add.DeleteContact(name);
				System.out.print("삭제 완료!\n");
			}
			else
				break;		
		}
		scan.close();
	}
}


class Contacts {
	Scanner scan = new Scanner(System.in);
	ArrayList<Contacts01> contacts;
	
	public Contacts() {
		contacts = new ArrayList<Contacts01>();
	}
	public Boolean CreateContact(String name, String phonenum, String email) {
		Contacts01 c = new Contacts01(name, phonenum, email);
		contacts.add(c);
		return(true);
	}
	
	public Boolean UpdateContact(String name) {
		for(int i=0;i<contacts.size(); i++) {
			Contacts01 c = (Contacts01)contacts.get(i);
			if(name.equals(c.name)) {
				contacts.remove(c);
				
				System.out.print("name: ");
				String newname = scan.next();
				System.out.print("phone number: ");
				String phonenum = scan.next();
				System.out.print("email: ");
				String email = scan.next();
				
				CreateContact(newname, phonenum, email);
			}
		}
		return (true);
	}

	public Boolean DeleteContact(String name) {
		for(int i=0;i<contacts.size(); i++) {
			Contacts01 c = (Contacts01)contacts.get(i);
			if(name.equals(c.name)) {
				contacts.remove(c);
			}
		}
		return (true);
	}
	
	public void ViewContact() {
		for(int i=0;i<contacts.size(); i++) {
			Contacts01 c = (Contacts01)contacts.get(i);
			System.out.print(c.name+"\t"+c.phonenum+"\t"+c.email+"\n");
		}
	}
}
