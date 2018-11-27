iamport java.io.*;
import java.util.*;

public class note {

	note noteList[] = new note[100];
	
	int numberOfNote=0;	

	public static void main(String[] args) {
		System.out.println("Note 관리 프로그램입니다.");
		System.out.println("1.노트 생성 2.노트 확인 3.노트수정  4.노트삭제");
		System.out.print("원하는 메뉴를 선택하세요 : ");
		
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
				System.out.println("더이상 노트를 작성할 수 없습니다."); 
				return "Note Create failed";
				}			
			}
		
		System.out.println("Note를 만듭니다.");
		System.out.println("작성날짜: ");
		date = scan.nextLine();
		
		System.out.println("제목 : ");
		title = scan.nextLine();
		
		System.out.println("내용 : ");
		memo = scan.nextLine();
		
		note note = new note(date,title,memo);
		
		if(numberOfNote<noteList.length) {
			noteList[numberOfNote]=note;
			}		
		return ("작성날짜: "+date+" 제목: "+title+"노트가 생성되었습니다.");
	}

	public void ViewNote() {
		System.out.println("작성한 노트를 확인하세요");
		Scanner scan = new Scanner(System.in);
		int j=0;
		for(j=0;j<noteList.length;j++) {
			if(noteList[j] != null) {
				System.out.print(j+1+".");
				System.out.print("날짜 : "+noteList[j].getDate());
				System.out.println("제목 : "+noteList[j].getTitle());
				System.out.println("내용 : "+noteList[j].getMemo());
			}
		}
	} 
	public String UpdateNote(int number) {
		System.out.println("수정메뉴 입니다 ");
		Scanner scan = new Scanner(System.in);
		ViewNote();
		System.out.print("수정할 노트의 번호를 선택하세요: ");
		number = scan.nextInt();
		CreateNote(noteList[number-1].getDate(), noteList[number-1].getTitle());
		return "dhksfy";
		
	} 
	public Boolean DeleteNote(int number) {
		System.out.print("삭제메뉴 입니다.");
		Scanner scan = new Scanner(System.in);
		ViewNote();
		System.out.print("삭제할 노트의 번호를 선택하세요:");
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
