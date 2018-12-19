import java.io.*;
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
	
	public void ManageNotes() {
		
		Note aNote = new Note();
		int menu = 0;
		System.out.println("Note 관리 프로그램입니다.");
		
		while(menu!=5) {
			System.out.println("1.create 2.view 3.update 4.delete 5.exit");
			System.out.print("원하는 메뉴를 선택하세요 : ");
			
			Scanner scan = new Scanner(System.in);
			menu = scan.nextInt();
			
			if(menu==1) {
				
				System.out.print("작성날짜(yy-mm-dd):");
				date=scan.next();
				System.out.print("제목:");
				title=scan.next();
				
				String result = aNote.CreateNote(date, title);
				System.out.println(result);
			}
			else if(menu==2)aNote.ViewNote();
			else if(menu==3) {
				aNote.ViewNote();				
				System.out.print("수정할 노트의 번호를 선택하세요: ");
				int numberOfselectedNote = scan.nextInt();
				String resultOfUpdate=aNote.UpdateNote(numberOfselectedNote);
				System.out.println(resultOfUpdate);
			}
			else if(menu==4) {
				aNote.ViewNote();
				System.out.print("삭제할 노트의 번호를 선택하세요:");
				int numberOfselectedNote=scan.nextInt();
				Boolean resultOfDelete = aNote.DeleteNote(numberOfselectedNote);
				if(resultOfDelete==true)
					System.out.println("삭제되었습니다.");
				else 
					System.out.println("삭제되지 않았습니다.");
			}
			else if(menu==5) { 
				menu=0; 
				break; 	
			}
			else System.out.println("1~5사이의 숫자를 입력하세요");
		}
		
	}
}
class Note{
	ArrayList<Notes> noteList= new ArrayList<Notes>();
	Scanner scan = new Scanner(System.in);
	
	int numberOfnote=0;
	
	public Note() {	}
		
	public String CreateNote(String date, String title) {
		
		if (date == null && title == null) {
			System.out.println("작성날짜(yy-mm-dd): ");
			date = scan.nextLine();
			System.out.println("제목 : ");
			title = scan.nextLine();
		}
		
		System.out.print("내용 : ");
		String memo = scan.nextLine();
		
		Notes note = new Notes(date, title, memo);
		noteList.add(note);
		
		numberOfnote++;
		
		return ("작성날짜: "+date+" 제목: "+title+"노트가 생성되었습니다.\n");
	}

	public void ViewNote() {
		System.out.println("작성한 노트를 확인하세요\n");
		
		for(int i=0;i<noteList.size();i++) {
			Notes note = (Notes)noteList.get(i);	
			System.out.print("<"+(i+1)+">");
			System.out.print("날짜 :"+note.getDate());
			System.out.print(" 제목 :"+note.getTitle());
			System.out.println(" 내용 :"+note.getMemo()+"\n");
			}
	}

	public String UpdateNote(int number) {
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
		
		System.out.print("선택하신 노트를 정말로 삭제하시겠습니까?(yes/no): ");
		String reply = scan.next();
		if(reply.equals("yes")) {
			if (number<=noteList.size()){
				noteList.remove(number-1);
				return true;
			}
			return false;
		}
		else 
			return false;
	}
					
}
