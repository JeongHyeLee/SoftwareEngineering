import java.util.*;

public class ToDoList {

	int MAX_TDL_LIST = 100;
	
	String[] strCreate = new String[MAX_TDL_LIST];
	String[] strDue = new String[MAX_TDL_LIST];
	String[] strDescrip = new String[MAX_TDL_LIST];
	
	String createDate, dueDate, description;
	
	int num = 0, bound = 0, keyNumber = 0, viewFlag = 0;
	boolean TDLnotWorked = true;
	Scanner scan = new Scanner(System.in);
	
	public void ToDoList() {
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println("*            To-Do List Management 프로그램입니다.            *");
		System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		
		
		if(TDLnotWorked) {
			for(int i = 0; i < MAX_TDL_LIST; i++) {
				strCreate[i] = "-1";
				strDue[i] = "-1";
				strDescrip[i] = "-1";
			}
			TDLnotWorked = false;
		}
		
		while(num != 5) {
			System.out.print("\n원하는 작업을 선택하세요.\n1.create(생성), 2.view(보기), 3.update(업데이트), 4.delete(삭제), 5.exit(나가기)\n\n(숫자 1~5 중 하나 선택) > ");
			num = scan.nextInt();
			System.out.println();
			switch(num) {
				case 1:
					System.out.print("\n생성 날짜를 입력하세요.(YYYY-MM-DD): ");
					createDate = scan.next();
					System.out.print("만료 날짜를 입력하세요.(YYYY-MM-DD): ");
					dueDate = scan.next();
					scan.nextLine();
					System.out.print("내용을 입력하세요. : ");
					description = scan.nextLine();
					
					if(this.CreateList(createDate, dueDate, description))
						System.out.println("저장 성공");
					else
						System.out.println("문제 발생!");
					
					break;
					
				case 2:
					this.ViewList();
					break;
					
				case 3:
					System.out.print("업데이트를 원하는 To-Do 리스트의 keyNumber를 입력하세요.(keyNumber는 2.view(보기)에서 확인 가능) :\n> ");
					keyNumber = scan.nextInt();
					if(this.UpdateList(keyNumber)) {
						System.out.println("< keyNumber #" + keyNumber + "번 > To-Do List 업데이트 성공!");
					}
					else
						System.out.println("< keyNumber #" + keyNumber + "번 > To-Do List 업데이트 실패!");
					break;
					
				case 4:
					System.out.print("삭제를 원하는 To-Do 리스트의 keyNumber를 입력하세요.(keyNumber는 2.view(보기)에서 확인 가능) :\n> ");
					keyNumber = scan.nextInt();
					if(this.DeleteList(keyNumber)) {
						System.out.println("< keyNumber #" + keyNumber + "번 > To-Do List 삭제 성공!");
					}
					else
						System.out.println("< keyNumber #" + keyNumber + "번 > To-Do List 삭제 실패!");
					break;
			}
		}
		num = 0;
	}
	
	public boolean CreateList(String createDate, String dueDate, String description) {
		while (bound < MAX_TDL_LIST) { 
			strCreate[bound] = createDate;
			strDue[bound] = dueDate;
			strDescrip[bound] = description;
			bound++; 
		    return true; 
		} 
		return false; 
	}
	
	public void ViewList() {
		for(int i = 0; i < MAX_TDL_LIST; i++) {
			if(strCreate[i] != "-1" && strDue[i] != "-1" && strDescrip[i] != "-1") {
				viewFlag = 1;
				System.out.println("< keyNumber #" + i + "번 > To-Do List : ");
				System.out.print("생성 날짜 : ");
				System.out.println(strCreate[i]);
				System.out.print("만료 날짜 : ");
				System.out.println(strDue[i]);
				System.out.print("내용 : ");
				System.out.println(strDescrip[i]);
				System.out.print("\n");
			}
		}
		if(viewFlag == 0)
			System.out.println("작성된 To-Do 리스트가 없습니다.");
		viewFlag = 0;
	}
	
	public boolean UpdateList(int keyNumber) {
		if(strCreate[keyNumber] != "-1" && strDue[keyNumber] != "-1" && strDescrip[keyNumber] != "-1") {
			System.out.println("수정 전 생성 날짜 : " + strCreate[keyNumber]);
			System.out.print("new 생성 날짜를 입력하세요.(YYYY-MM-DD): ");
			strCreate[keyNumber] = scan.next();
			
			System.out.println("수정 전 만료 날짜 : " + strDue[keyNumber]);
			System.out.print("new 만료 날짜를 입력하세요.(YYYY-MM-DD): ");
			strDue[keyNumber] = scan.next();

			scan.nextLine();
			System.out.println("수정 전 내용 : " + strDescrip[keyNumber]);
			System.out.print("new 내용을 입력하세요. : ");
			strDescrip[keyNumber] = scan.nextLine();
			return true;
		}
		else
			return false;
	}
	
	public boolean DeleteList(int keyNumber) {
		if(strCreate[keyNumber] != "-1" && strDue[keyNumber] != "-1" && strDescrip[keyNumber] != "-1") {
			strCreate[keyNumber] = "-1";
			strDue[keyNumber] = "-1";
			strDescrip[keyNumber] = "-1";
			return true;
		}
		else
			return false;
	}
}





















