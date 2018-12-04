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
		System.out.println("Note 관리 프로그램입니다.");
		
		while(menu!=5) {
			System.out.println("1.노트 생성 2.노트 확인 3.노트수정  4.노트삭제 5.나가기");
			System.out.print("원하는 메뉴를 선택하세요 : ");
			
			Scanner scan = new Scanner(System.in);
			menu = scan.nextInt();
			
			if(menu==1) {
				/*
				System.out.print("날짜:");
				date=scan.nextLine();
				System.out.print("제목:");
				title=scan.nextLine();
				System.out.print("내용:");
				memo=scan.nextLine();
				*/
				String result = aNote.CreateNote(null,null);
				System.out.println(result);
			}
			else if(menu==2)aNote.ViewNote();
			else if(menu==3)aNote.UpdateNote(menu);
			else if(menu==4)aNote.DeleteNote(menu);
			else if(menu==5) { menu=0; break; }
			else System.out.println("1~5사이의 숫자를 입력하세요");
		}
		
	}
}
class Note{
	ArrayList<Notes> noteList= new ArrayList<Notes>();
	int numberOfnote=0;

	public Note() {	}
		
	public String CreateNote(String date, String title) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Note를 만듭니다.");
		System.out.println("작성날짜: ");
		date = scan.nextLine();
		
		System.out.println("제목 : ");
		title = scan.nextLine();
		
		System.out.println("내용 : ");
		String memo = scan.nextLine();
		
		Notes note = new Notes(date, title, memo);
		noteList.add(note);
		
		numberOfnote++;
		
		return ("작성날짜: "+date+" 제목: "+title+"노트가 생성되었습니다.");
	}

	public void ViewNote() {
		System.out.println("작성한 노트를 확인하세요");
		
		for(int i=0;i<noteList.size();i++) {
			Notes note = (Notes)noteList.get(i);	
			System.out.print("<"+(i+1)+">");
			System.out.print("날짜 :"+note.getDate());
			System.out.print(" 제목 :"+note.getTitle());
			System.out.println(" 내용 :"+note.getMemo());
			}
	}
	

	public String UpdateNote(int number) {
			
		System.out.println("수정메뉴 입니다 ");
		
		Scanner scan = new Scanner(System.in);
		ViewNote();
		
		System.out.print("수정할 노트의 번호를 선택하세요: ");
		number = scan.nextInt();
		
		Notes selectedNote = (Notes)noteList.get(number-1);
		System.out.println("날짜 : "+selectedNote.getDate());
		System.out.println("제목 : "+selectedNote.getTitle());
		System.out.println("내용 : "+selectedNote.getMemo());
		System.out.println("수정할 내용을 입력하세요 ");
		System.out.print("변경할 제목:");
		selectedNote.setTitle(scan.next());
		System.out.print("변경할 내용:");
		selectedNote.setMemo(scan.next());
		
		return "변경된 제목:"+selectedNote.getTitle()+"변경된 내용:"+selectedNote.getMemo();
	}
		
	public Boolean DeleteNote(int number) {
		System.out.print("삭제메뉴 입니다.");
		
		Scanner scan = new Scanner(System.in);
		ViewNote();
		
		System.out.print("삭제할 노트의 번호를 선택하세요:");
		number=scan.nextInt();
		if (number<=noteList.size()){
			noteList.remove(number-1);
			return true;
		}
		return false;			
	}
	
	
	
	
}
