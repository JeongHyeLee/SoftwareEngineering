import java.io.*;
import java.util.*;
import java.util.*;
import java.util.*;

public class Notes {

	private String date;
	private String title;
	private String memo;
	
	Notes(){}
	Notes(String date,String title,String memo){
		this.date=date;
		this.title=title;
		this.memo=memo;
	}
	
	public String getDate() {return date;}
	public String getTitle() {return title;}
	public String getMemo() {return memo;}
	public void setTitle(String title) {this.title=title;}
	public void setMemo(String memo) {this.memo=memo;}
	
	
	public void NoteManagement() {
		
		Note aNote = new Note();
		int menu = 0;
		System.out.println("Note ���� ���α׷��Դϴ�.");
		
		while(menu!=5) {
			System.out.println("1.��Ʈ ���� 2.��Ʈ Ȯ�� 3.��Ʈ����  4.��Ʈ���� 5.������");
			System.out.print("���ϴ� �޴��� �����ϼ��� : ");
			
			Scanner scan = new Scanner(System.in);
			menu = scan.nextInt();
			
			if(menu==1) {
				/*
				System.out.print("��¥:");
				date=scan.nextLine();
				System.out.print("����:");
				title=scan.nextLine();
				System.out.print("����:");
				memo=scan.nextLine();
				*/
				String result = aNote.CreateNote(null,null);
				System.out.println(result);
			}
			else if(menu==2)aNote.ViewNote();
			else if(menu==3)aNote.UpdateNote(menu);
			else if(menu==4)aNote.DeleteNote(menu);
			else if(menu==5) { menu=0; break; }
			else System.out.println("1~5������ ���ڸ� �Է��ϼ���");
		}
		
	}
}
class Note{
	ArrayList<Notes> noteList= new ArrayList<Notes>();
	int numberOfnote=0;

	public Note() {	}
		
	public String CreateNote(String date, String title) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Note�� ����ϴ�.");
		System.out.println("�ۼ���¥: ");
		date = scan.nextLine();
		
		System.out.println("���� : ");
		title = scan.nextLine();
		
		System.out.println("���� : ");
		String memo = scan.nextLine();
		
		Notes note = new Notes(date, title, memo);
		noteList.add(note);
		
		numberOfnote++;
		
		return ("�ۼ���¥: "+date+" ����: "+title+"��Ʈ�� �����Ǿ����ϴ�.");
	}

	public void ViewNote() {
		System.out.println("�ۼ��� ��Ʈ�� Ȯ���ϼ���");
		
		for(int i=0;i<noteList.size();i++) {
			Notes note = (Notes)noteList.get(i);	
			System.out.print("<"+(i+1)+">");
			System.out.print("��¥ :"+note.getDate());
			System.out.print(" ���� :"+note.getTitle());
			System.out.println(" ���� :"+note.getMemo());
			}
	}
	

	public String UpdateNote(int number) {
			
		System.out.println("�����޴� �Դϴ� ");
		
		Scanner scan = new Scanner(System.in);
		ViewNote();
		
		System.out.print("������ ��Ʈ�� ��ȣ�� �����ϼ���: ");
		number = scan.nextInt();
		
		Notes selectedNote = (Notes)noteList.get(number-1);
		System.out.println("��¥ : "+selectedNote.getDate());
		System.out.println("���� : "+selectedNote.getTitle());
		System.out.println("���� : "+selectedNote.getMemo());
		System.out.println("������ ������ �Է��ϼ��� ");
		System.out.print("������ ����:");
		selectedNote.setTitle(scan.next());
		System.out.print("������ ����:");
		selectedNote.setMemo(scan.next());
		
		return "����� ����:"+selectedNote.getTitle()+"����� ����:"+selectedNote.getMemo();
	}
		
	public Boolean DeleteNote(int number) {
		System.out.print("�����޴� �Դϴ�.");
		
		Scanner scan = new Scanner(System.in);
		ViewNote();
		
		System.out.print("������ ��Ʈ�� ��ȣ�� �����ϼ���:");
		number=scan.nextInt();
		if (number<=noteList.size()){
			noteList.remove(number-1);
			return true;
		}
		return false;			
	}
	
	
	
	
}
