iamport java.io.*;
import java.util.*;

public class note {

	note noteList[] = new note[100];
	
	int numberOfNote=0;	

	public static void main(String[] args) {
		System.out.println("Note ���� ���α׷��Դϴ�.");
		System.out.println("1.��Ʈ ���� 2.��Ʈ Ȯ�� 3.��Ʈ����  4.��Ʈ����");
		System.out.print("���ϴ� �޴��� �����ϼ��� : ");
		
		Scanner scan = new Scanner(System.in);
		int menu = scan.nextInt();
		
		if(menu==1)CreateNote(null,null);
		else if(menu==2)ViewNote();
		else if(menu==3)UpdateNote();
		else if(menu==4)DeleteNote();
		
		
	}

	
	public String CreateNote(String date, String title) {
		//boolean retry = false;
		Scanner scan = new Scanner(System.in);
		
		for (int i=0;i<noteList.length;i++) {
			if(noteList[i]==null) {numberOfNote=i;break;}
			if(i==noteList.length) {
				System.out.println("���̻� ��Ʈ�� �ۼ��� �� �����ϴ�."); 
				return "Note Create failed";
				}			
			}
		
		System.out.println("Note�� ����ϴ�.");
		System.out.println("�ۼ���¥: ");
		date = scan.nextLine();
		
		System.out.println("���� : ");
		title = scan.nextLine();
		
		System.out.println("���� : ");
		memo = scan.nextLine();
		
		note note = new note(date,title,memo);
		
		if(numberOfNote<noteList.length) {
			noteList[numberOfNote]=note;
			}		
		return ("�ۼ���¥: "+date+" ����: "+title+"��Ʈ�� �����Ǿ����ϴ�.");
	}

	public void ViewNote() {
		System.out.println("�ۼ��� ��Ʈ�� Ȯ���ϼ���");
		Scanner scan = new Scanner(System.in);
		int j=0;
		for(j=0;j<noteList.length;j++) {
			if(noteList[j] != null) {
				System.out.print(j+1+".");
				System.out.print("��¥ : "+noteList[j].getDate());
				System.out.println("���� : "+noteList[j].getTitle());
				System.out.println("���� : "+noteList[j].getMemo());
			}
		}
	} 
	public String UpdateNote(int number) {
		System.out.println("�����޴� �Դϴ� ");
		Scanner scan = new Scanner(System.in);
		ViewNote();
		System.out.print("������ ��Ʈ�� ��ȣ�� �����ϼ���: ");
		number = scan.nextInt();
		CreateNote(noteList[number-1].getDate(), noteList[number-1].getTitle());
		return "dhksfy";
		
	} 
	public Boolean DeleteNote(int number) {
		System.out.print("�����޴� �Դϴ�.");
		Scanner scan = new Scanner(System.in);
		ViewNote();
		System.out.print("������ ��Ʈ�� ��ȣ�� �����ϼ���:");
		number=scan.nextInt();
		noteList[number-1]=null;
		if(noteList[number-1]==null)
			return true;
		else
			return false;
	}
	
	
	private String date;
	private String title;
	private String memo;
	
	note(){}
	note(String date,String title,String memo){
		this.date=date;
		this.title=title;
		this.memo=memo;
	}
	
	public String getDate() {return date;}
	public String getTitle() {return title;}
	public String getMemo() {return memo;}
	
}
