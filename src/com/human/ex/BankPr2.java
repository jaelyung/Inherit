package com.human.ex;
import java.util.*;
class Account2{
	public static int totalCount=0;
	public int money=0;
	public String id=null;
	public String pw=null;
	
	public Account2() {
		totalCount++;
	}
	public Account2(String id, String pw) {
		this();
		this.id=id;
		this.pw=pw;
	}
	public void display() {
		System.out.println("�� ������: "+Account.totalCount);
		System.out.println("���̵�: "+id);
		System.out.println("��й�ȣ: "+pw);
	}
	public void add(int money) {
		this.money=this.money+money;
	}
	public void minus(int money) {
		this.money=this.money-money;
	}
	public void menu() {
		Scanner sc=new Scanner(System.in);
		String inputString=null;
		boolean flag=true;
		
		while(flag) {
			System.out.println("1.�Ա�  2.���  3.����");
			inputString=sc.nextLine();
			switch(inputString) {
			case "1":
				display();
				System.out.println("�Ա��� �ݾ� �Է�>>");
				int money=Integer.parseInt(sc.nextLine());
				add(money);
				display();
				break;
			case "2":
				display();
				System.out.println("����� �ݾ� �Է�>>");
				money=Integer.parseInt(sc.nextLine());
				display();
				break;
			case "3":
				System.out.println("��� ����");
				flag=false;
				break;
			default:
				break;
			}
		}
	}
}

class Bank2{
	public static int totalCount=0;
	public String name=null;
	public Account [] account = new Account[10];
	public int accountCount=0;
	public int accountCurrent=-1;
	public Bank2() {
		totalCount++;
	}
	public Bank2(String name) {
		totalCount++;
		this.name=name;
	}
	public void accountAdd() {
		Scanner sc=new Scanner(System.in);
		System.out.println("���ϴ� ���̵� �Է�>>");
		String id=sc.nextLine();
		if(isId(id)) {
			System.out.println("�ߺ��� ���̵��Դϴ�.");
			return;
		}
		System.out.println("���ϴ� ��й�ȣ �Է�>>");
		String pw=sc.nextLine();
		account[accountCount++]=new Account(id,pw);
	}
	private boolean isId(String id) {
		boolean returnValue=false;
		for(int i=0;i<accountCount;i++) {
			if(account[i].id.equals(id)) {
				returnValue=true;
			}
		}
		return returnValue;
	}
	public void logout() {
		accountCurrent=-1;
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
	}
	public boolean login(String id, String pw) {
		boolean returnValue=false;
		for(int i=0;i<accountCount;i++) {
			if(account[i].isLogin(id, pw)) {
				returnValue=true;
				accountCurrent=i;
				break;
			}
		}
		return returnValue;
	}
	public void displayAll() {
		System.out.println("�� �����: "+Bank.totalCount);
		System.out.println("���� �����̸�: "+name);
		for(int i=0;i<accountCount;i++) {
			account[i].display();
		}
	}
	public void useAccount() {
		if(accountCurrent!=-1) {
			account[accountCurrent].menu();
		}else {
			System.out.println("�߸��� �α���");
		}
	}
	public void menu() {
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1.������� 2.��������� 3.�����α��� 4.�α׾ƿ� 5.����");
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
				System.out.println("���̵� �Է�>>");
				String id=sc.nextLine();
				System.out.println("��й�ȣ �Է�>>");
				String pw=sc.nextLine();
				if(login(id,pw)) {
					System.out.println("�α��� �Ǿ����ϴ�.");
					useAccount();
				}else {
					System.out.println("�α��� ����");
				}
				break;
			case "4":
				logout();
				break;
			case "5":
				System.out.println("���α׷��� �����մϴ�");
				flag=false;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}
}


public class BankPr2 {
	public static void main(String[] args) {
		Bank2 bk=new Bank2("����");
		bk.menu();
	}
}
