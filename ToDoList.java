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
		System.out.println("*            To-Do List Management ���α׷��Դϴ�.            *");
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
			System.out.print("\n���ϴ� �۾��� �����ϼ���.\n1.create(����), 2.view(����), 3.update(������Ʈ), 4.delete(����), 5.exit(������)\n\n(���� 1~5 �� �ϳ� ����) > ");
			num = scan.nextInt();
			System.out.println();
			switch(num) {
				case 1:
					System.out.print("\n���� ��¥�� �Է��ϼ���.(YYYY-MM-DD): ");
					createDate = scan.next();
					System.out.print("���� ��¥�� �Է��ϼ���.(YYYY-MM-DD): ");
					dueDate = scan.next();
					scan.nextLine();
					System.out.print("������ �Է��ϼ���. : ");
					description = scan.nextLine();
					
					if(this.CreateList(createDate, dueDate, description))
						System.out.println("���� ����");
					else
						System.out.println("���� �߻�!");
					
					break;
					
				case 2:
					this.ViewList();
					break;
					
				case 3:
					System.out.print("������Ʈ�� ���ϴ� To-Do ����Ʈ�� keyNumber�� �Է��ϼ���.(keyNumber�� 2.view(����)���� Ȯ�� ����) :\n> ");
					keyNumber = scan.nextInt();
					if(this.UpdateList(keyNumber)) {
						System.out.println("< keyNumber #" + keyNumber + "�� > To-Do List ������Ʈ ����!");
					}
					else
						System.out.println("< keyNumber #" + keyNumber + "�� > To-Do List ������Ʈ ����!");
					break;
					
				case 4:
					System.out.print("������ ���ϴ� To-Do ����Ʈ�� keyNumber�� �Է��ϼ���.(keyNumber�� 2.view(����)���� Ȯ�� ����) :\n> ");
					keyNumber = scan.nextInt();
					if(this.DeleteList(keyNumber)) {
						System.out.println("< keyNumber #" + keyNumber + "�� > To-Do List ���� ����!");
					}
					else
						System.out.println("< keyNumber #" + keyNumber + "�� > To-Do List ���� ����!");
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
				System.out.println("< keyNumber #" + i + "�� > To-Do List : ");
				System.out.print("���� ��¥ : ");
				System.out.println(strCreate[i]);
				System.out.print("���� ��¥ : ");
				System.out.println(strDue[i]);
				System.out.print("���� : ");
				System.out.println(strDescrip[i]);
				System.out.print("\n");
			}
		}
		if(viewFlag == 0)
			System.out.println("�ۼ��� To-Do ����Ʈ�� �����ϴ�.");
		viewFlag = 0;
	}
	
	public boolean UpdateList(int keyNumber) {
		if(strCreate[keyNumber] != "-1" && strDue[keyNumber] != "-1" && strDescrip[keyNumber] != "-1") {
			System.out.println("���� �� ���� ��¥ : " + strCreate[keyNumber]);
			System.out.print("new ���� ��¥�� �Է��ϼ���.(YYYY-MM-DD): ");
			strCreate[keyNumber] = scan.next();
			
			System.out.println("���� �� ���� ��¥ : " + strDue[keyNumber]);
			System.out.print("new ���� ��¥�� �Է��ϼ���.(YYYY-MM-DD): ");
			strDue[keyNumber] = scan.next();

			scan.nextLine();
			System.out.println("���� �� ���� : " + strDescrip[keyNumber]);
			System.out.print("new ������ �Է��ϼ���. : ");
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





















