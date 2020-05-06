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
		System.out.println("총 계정수: "+Account.totalCount);
		System.out.println("아이디: "+id);
		System.out.println("비밀번호: "+pw);
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
			System.out.println("1.입금  2.출금  3.종료");
			inputString=sc.nextLine();
			switch(inputString) {
			case "1":
				display();
				System.out.println("입금할 금액 입력>>");
				int money=Integer.parseInt(sc.nextLine());
				add(money);
				display();
				break;
			case "2":
				display();
				System.out.println("출금할 금액 입력>>");
				money=Integer.parseInt(sc.nextLine());
				display();
				break;
			case "3":
				System.out.println("사용 종료");
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
		System.out.println("원하는 아이디 입력>>");
		String id=sc.nextLine();
		if(isId(id)) {
			System.out.println("중복된 아이디입니다.");
			return;
		}
		System.out.println("원하는 비밀번호 입력>>");
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
		System.out.println("로그아웃 되었습니다.");
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
		System.out.println("총 은행수: "+Bank.totalCount);
		System.out.println("현재 은행이름: "+name);
		for(int i=0;i<accountCount;i++) {
			account[i].display();
		}
	}
	public void useAccount() {
		if(accountCurrent!=-1) {
			account[accountCurrent].menu();
		}else {
			System.out.println("잘못된 로그인");
		}
	}
	public void menu() {
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1.계정등록 2.모든계정출력 3.계정로그인 4.로그아웃 5.종료");
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
				System.out.println("아이디 입력>>");
				String id=sc.nextLine();
				System.out.println("비밀번호 입력>>");
				String pw=sc.nextLine();
				if(login(id,pw)) {
					System.out.println("로그인 되었습니다.");
					useAccount();
				}else {
					System.out.println("로그인 실패");
				}
				break;
			case "4":
				logout();
				break;
			case "5":
				System.out.println("프로그램을 종료합니다");
				flag=false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
}


public class BankPr2 {
	public static void main(String[] args) {
		Bank2 bk=new Bank2("은행");
		bk.menu();
	}
}
