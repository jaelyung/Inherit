package com.human.ex;
class Account{//���� Ŭ����
	public static int totalCount=0;
	public int money=0;//���ݾ�
	public String id=null;
	public String pw=null;
	
	public Account() {
		totalCount++;//��ü ��������
	}
	public Account(String id, String pw) {
		this();//�ڱ��ڽ��� ȣ�� totalCount++�� ���� �� �Ŀ� �����
		this.id=id;
		this.pw=pw;
	}
	//������Է��� �޾� id,pw�� ��ġ�ϴ��� Ȯ��
	public boolean isLogin(String id,String pw) {//return ���� �ϳ��� �ִ� ���� ����
		boolean returnValue=false;
		if(this.id.equals(id)&&this.pw.equals(pw)) {
			returnValue=true;
		}//���̵�� �н����尡 ���� ����� �����ϸ� true�� �����Ѵ�
		
		return returnValue;
	}
	public void display() {//��ȸ
		System.out.println("--------------");
		System.out.println("�� ������: "+Account.totalCount);//Ŭ���� �̸� ���(Static����)
		System.out.println("���̵�: "+id);
		System.out.println("money: "+money);
		System.out.println("--------------");
	}
	public void add(int money) {//�Ա�
		this.money=this.money+money;
		
	}
	public void minus(int money) {//���
		this.money=this.money-money;
	}
	public void menu() {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		String inputString=null;
		boolean flag=true;
		
		while(flag) {//while(!inputString.equals("3") ���ڿ� �񱳽� .equals("")�� ��� **��� inputString�� null�� ����
			System.out.println(this.id+"  1.�Ա�  2.���  3.����");
			inputString=sc.nextLine();
			switch(inputString) {
			case "1":
				display();
				System.out.println("�Աݾ��� �Է��ϼ���>>");
				int money=Integer.parseInt(sc.nextLine());
				add(money);
				display();
				break;
			case "2":
				display();
				System.out.println("��ݾ��� �Է��ϼ���>>");
				money=Integer.parseInt(sc.nextLine());
				minus(money);
				display();
				break;
			case "3":
				System.out.println("����� �����մϴ�");
				flag=false;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�");
				break;
			}
		}
	}
}
class Bank{
	public static int totalCount=0;
	public String name=null;
	//�������� ȸ���� ��� -> Account�� �迭�� �޴� account�� ����
	public Account [] account=new Account[10];//�迭�� ������ ���� 10�� ����
	public int accountCount=0;
	public int accountCurrent=-1;//�α������� ���� ����  //�α����ϸ� �ش� index�� ����
	public Bank() {
		totalCount++;
	}
	public Bank(String name) {
		totalCount++;
		this.name=name;
	}
	public void accountAdd() {//account �迭�� �����͸� �ִ´ٴ� ��
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("���ϴ� ���̵� �Է��ϼ���>>");
		String id=sc.nextLine();
		if(isId(id)) {//Ư���Լ��� ȣ���ؼ� ���̵� �ߺ��� üũ //�ߺ��� ��� üũ? account �迭�ȿ��� id�� ������ �ִ���?
			System.out.println("�ߺ��� ���̵��Դϴ�");
			return;
		}
		System.out.println("���ϴ� ��й�ȣ�� �Է��ϼ���>>");
		String pw=sc.nextLine();
		account[accountCount++]=new Account(id,pw);//account[0],[1] ... ���������� �����͸� �ֱ����� accountCount�� ��	
	}
	public void delete(String pw) {//�α����� ���¿��� ��������
		delete(account[accountCurrent].id,pw);
	}
	public void delete(String id, String pw){
		boolean flag=false;
		for(int i=0;i<accountCount;i++) {
			if(account[i].isLogin(id, pw)) {
				accountCurrent=i;
				flag=true;
				break;
			}
		}
		if(flag) {//ã���� ���� //totalCount-1, accountCount-1, 
			for(int i=accountCurrent;i+1<accountCount;i++) {
				account[i]=account[i+1]; //������ account[i]�ڸ��� �� �����迭�� �����͸� �������
			}
			Account.totalCount--;
			accountCount--;
			accountCurrent=-1; //�ٸ� �����Ϳ� �������� �ʱ�����
			//�迭 �����������Ϳ��� ������ �� ������ ������ ��������
			//�迭�� �߰��� �� �����Ͱ� �ٲ�� �������
			System.out.println("�����Ǿ����ϴ�.");
			
		}else {
			System.out.println("���� ����");
		}
	}
	private boolean isId(String id) {//����ڰ� �Է��� id���� ������ üũ
		boolean returnValue=false;
		for(int i=0;i<accountCount;i++) {
			if(account[i].id.equals(id)) { //id�� private�̶�� getId �޼ҵ带 �̿�
				returnValue=true;
			}
		}
		return returnValue;
	}
	public void logout() {
		accountCurrent=-1;
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
	}
	public boolean login(String id,String pw) {
		//Account�� isLogin(id,pw)
		//���̵�� �н����尡 ���� ����� �����ϸ� true�� �����Ѵ�
		//true�� ������ login ��, false�� �ȵ�
		boolean returnValue=false;
		for(int i=0;i<accountCount;i++) {
			if(account[i].isLogin(id, pw)) { //id�� private�̶�� getId �޼ҵ带 �̿�
				returnValue=true;
				accountCurrent=i;
				break;
			}
		}
		return returnValue;
	}
	public void display() {//��ȸ
		System.out.println(name);
	}
	public void displayAll() {
		System.out.println("�� �����: "+Bank.totalCount);
		System.out.println("���� �����̸�: "+name);
		for(int i=0;i<accountCount;i++) {
			account[i].display();
		}
	}
	public void useAccount() {
		if(accountCurrent!=-1) {//accountCurrent�� -1�� �ƴҶ��� �۵��� �� �ֵ��� ����
			account[accountCurrent].menu();
		}else {
			System.out.println("�߸��� �α���");
		}
	}
	public void menu() {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		boolean flag=true;
		//bank�� �޴�
		while(flag) {
			System.out.println("1.�������  2.��� ���� ���  3.���� �α���  4.�α׾ƿ�   5.��������  6.����");
			String stringInput=sc.nextLine();
			switch(stringInput) {
			case "1":
				accountAdd();
				displayAll();
				break;
			case "2":
				displayAll();
				break;
			case "3":
				//�α����� �ǹ�
				//1. ����ڿ��� id�� pw�� �Է¹޴´�
				//2. ���� ����ڰ� �´��� Ȯ���Ѵ�
				//3. �α����� ����ڰ� ����� �� �ֵ��� �����Ѵ�.
				//account �迭�߿� � account�� ����� ������ ����   ->accountCurrent�� �ε����� ���
				//4. �α��� ����� ���� ���
				
				System.out.println("���̵� �Է��ϼ���>>");
				String id=sc.nextLine();
				System.out.println("��й�ȣ�� �Է��ϼ���>>");
				String pw=sc.nextLine();
				//���̵�� �н����尡 ���� ����� �����ϸ� true�� �����Ѵ�
				if(login(id, pw)) {
					System.out.println("�α��� �Ǿ����ϴ�.");
					//�α����� �Ǹ�? accountCurrent�� ����
					useAccount(); //���� ����� �� �ְ��ϴ� �޼ҵ�
				}else {
					System.out.println("�α��� ����");
				}
				break;
			case "4":
				logout();
				break;
			case "5":
				if(accountCurrent!=-1) {
					System.out.println("������ ���̵��� ��й�ȣ�� �Է�>>");
					pw=sc.nextLine();
					delete(pw);
					break;
				}else {
					System.out.println("�α��� �ϼ���.");
				}
				break;
			case "6":
				System.out.println("���α׷��� �����մϴ�.");
				flag=false;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�");
				break;
			}
		}
	}
}
class Atm{
	public static int totalCount=0;
	public int bankCount=0;
	public Bank [] bank = new Bank[10];
	public int bankCurrentIndex=-1;
	public String atm="";
	public Atm() {
		totalCount++;
	}
	public Atm(String atm) {
		this();
		this.atm=atm;
	}
	public void addBank() {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("�߰��� ������ �Է��ϼ���");
		String inputBank=sc.nextLine();
		if(isBank(inputBank)) {
			System.out.println("�̹� ��ϵ� �����Դϴ�.");
			return;
		}
		bank[bankCount++]=new Bank(inputBank);
	}
	
	private boolean isBank(String inputBank) {
		boolean returnValue=false;
		for(int i=0;i<bankCount;i++) {
			if(bank[i].name.equals(inputBank)) { 
				returnValue=true;
				bankCurrentIndex=i;
			}
		}
		return returnValue;
	}
	public void selectBank() {
		if(bankCurrentIndex!=-1) {//accountCurrent�� -1�� �ƴҶ��� �۵��� �� �ֵ��� ����
			bank[bankCurrentIndex].menu();
		}else {
			System.out.println("�߸��� ����");
		}
	}
	public void displayBank() {
		System.out.println("�� �����: "+bankCount);
		for(int i=0;i<bankCount;i++) {
			bank[i].display();
		}
		
	}
	public void menu() {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1.���� �߰�  2.���� ����  3.��� ��������  4.����");
			String inputString=sc.nextLine();
			switch(inputString) {
			case "1":
				addBank();
				break;
			case "2":
				System.out.println("�̿��� ������ �Է�>>");
				String bankName=sc.nextLine();
				if(isBank(bankName)) {
					selectBank();
				}
				else {
					System.out.println("�߸��� �Է��Դϴ�.");
				}
				break;
			case "3":
				displayBank();
				break;
			case "4":
				System.out.println("���α׷��� �����մϴ�.");
				flag=false;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}
	
	
}
public class BankPr {

	public static void main(String[] args) {
		//Account a�� �������� �۾���
		//account�� �þ��? =>ó���ϱ����� Bank Ŭ������ ����
		Atm atm = new Atm();
		atm.menu();
		//Bank�� ������ �þ��?
		
		
		
	}

}
