package com.human.ex;
class Account{//계좌 클래스
	public static int totalCount=0;
	public int money=0;//예금액
	public String id=null;
	public String pw=null;
	
	public Account() {
		totalCount++;//전체 계정개수
	}
	public Account(String id, String pw) {
		this();//자기자신을 호출 totalCount++가 실행 된 후에 실행됨
		this.id=id;
		this.pw=pw;
	}
	//사용자입력을 받아 id,pw가 일치하는지 확인
	public boolean isLogin(String id,String pw) {//return 값은 하나만 있는 것을 권장
		boolean returnValue=false;
		if(this.id.equals(id)&&this.pw.equals(pw)) {
			returnValue=true;
		}//아이디와 패스워드가 같은 사람이 존재하면 true를 리턴한다
		
		return returnValue;
	}
	public void display() {//조회
		System.out.println("--------------");
		System.out.println("총 계정수: "+Account.totalCount);//클래스 이름 명시(Static접근)
		System.out.println("아이디: "+id);
		System.out.println("money: "+money);
		System.out.println("--------------");
	}
	public void add(int money) {//입금
		this.money=this.money+money;
		
	}
	public void minus(int money) {//출금
		this.money=this.money-money;
	}
	public void menu() {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		String inputString=null;
		boolean flag=true;
		
		while(flag) {//while(!inputString.equals("3") 문자열 비교시 .equals("")를 사용 **대신 inputString에 null값 못씀
			System.out.println(this.id+"  1.입금  2.출금  3.종료");
			inputString=sc.nextLine();
			switch(inputString) {
			case "1":
				display();
				System.out.println("입금액을 입력하세요>>");
				int money=Integer.parseInt(sc.nextLine());
				add(money);
				display();
				break;
			case "2":
				display();
				System.out.println("출금액을 입력하세요>>");
				money=Integer.parseInt(sc.nextLine());
				minus(money);
				display();
				break;
			case "3":
				System.out.println("사용을 종료합니다");
				flag=false;
				break;
			default:
				System.out.println("잘못된 입력입니다");
				break;
			}
		}
	}
}
class Bank{
	public static int totalCount=0;
	public String name=null;
	//여러명의 회원을 등록 -> Account를 배열로 받는 account를 생성
	public Account [] account=new Account[10];//배열을 저장할 공간 10개 생성
	public int accountCount=0;
	public int accountCurrent=-1;//로그인하지 않은 상태  //로그인하면 해당 index로 변경
	public Bank() {
		totalCount++;
	}
	public Bank(String name) {
		totalCount++;
		this.name=name;
	}
	public void accountAdd() {//account 배열에 데이터를 넣는다는 뜻
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("원하는 아이디를 입력하세요>>");
		String id=sc.nextLine();
		if(isId(id)) {//특정함수를 호출해서 아이디 중복을 체크 //중복은 어떻게 체크? account 배열안에서 id가 같은게 있는지?
			System.out.println("중복된 아이디입니다");
			return;
		}
		System.out.println("원하는 비밀번호를 입력하세요>>");
		String pw=sc.nextLine();
		account[accountCount++]=new Account(id,pw);//account[0],[1] ... 순차적으로 데이터를 넣기위해 accountCount를 씀	
	}
	public void delete(String pw) {//로그인한 상태에서 계정삭제
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
		if(flag) {//찾으면 삭제 //totalCount-1, accountCount-1, 
			for(int i=accountCurrent;i+1<accountCount;i++) {
				account[i]=account[i+1]; //삭제될 account[i]자리에 그 다음배열의 데이터를 집어넣음
			}
			Account.totalCount--;
			accountCount--;
			accountCurrent=-1; //다른 데이터에 접근하지 않기위해
			//배열 마지막데이터에는 접근할 수 없지만 공간은 남아있음
			//배열을 추가할 때 데이터가 바뀌니 상관없음
			System.out.println("삭제되었습니다.");
			
		}else {
			System.out.println("삭제 실패");
		}
	}
	private boolean isId(String id) {//사용자가 입력한 id값과 같은지 체크
		boolean returnValue=false;
		for(int i=0;i<accountCount;i++) {
			if(account[i].id.equals(id)) { //id가 private이라면 getId 메소드를 이용
				returnValue=true;
			}
		}
		return returnValue;
	}
	public void logout() {
		accountCurrent=-1;
		System.out.println("로그아웃 되었습니다.");
	}
	public boolean login(String id,String pw) {
		//Account의 isLogin(id,pw)
		//아이디와 패스워드가 같은 사람이 존재하면 true를 리턴한다
		//true가 나오면 login 됨, false면 안됨
		boolean returnValue=false;
		for(int i=0;i<accountCount;i++) {
			if(account[i].isLogin(id, pw)) { //id가 private이라면 getId 메소드를 이용
				returnValue=true;
				accountCurrent=i;
				break;
			}
		}
		return returnValue;
	}
	public void display() {//조회
		System.out.println(name);
	}
	public void displayAll() {
		System.out.println("총 은행수: "+Bank.totalCount);
		System.out.println("현재 은행이름: "+name);
		for(int i=0;i<accountCount;i++) {
			account[i].display();
		}
	}
	public void useAccount() {
		if(accountCurrent!=-1) {//accountCurrent가 -1이 아닐때만 작동할 수 있도록 설정
			account[accountCurrent].menu();
		}else {
			System.out.println("잘못된 로그인");
		}
	}
	public void menu() {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		boolean flag=true;
		//bank의 메뉴
		while(flag) {
			System.out.println("1.계정등록  2.모든 계정 출력  3.계정 로그인  4.로그아웃   5.계정삭제  6.종료");
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
				//로그인의 의미
				//1. 사용자에게 id와 pw를 입력받는다
				//2. 기존 사용자가 맞는지 확인한다
				//3. 로그인한 사용자가 사용할 수 있도록 설정한다.
				//account 배열중에 어떤 account를 사용할 것인지 선택   ->accountCurrent를 인덱스로 사용
				//4. 로그인 사용자 계정 사용
				
				System.out.println("아이디를 입력하세요>>");
				String id=sc.nextLine();
				System.out.println("비밀번호를 입력하세요>>");
				String pw=sc.nextLine();
				//아이디와 패스워드가 같은 사람이 존재하면 true를 리턴한다
				if(login(id, pw)) {
					System.out.println("로그인 되었습니다.");
					//로그인이 되면? accountCurrent를 설정
					useAccount(); //계정 사용할 수 있게하는 메소드
				}else {
					System.out.println("로그인 실패");
				}
				break;
			case "4":
				logout();
				break;
			case "5":
				if(accountCurrent!=-1) {
					System.out.println("삭제할 아이디의 비밀번호를 입력>>");
					pw=sc.nextLine();
					delete(pw);
					break;
				}else {
					System.out.println("로그인 하세요.");
				}
				break;
			case "6":
				System.out.println("프로그램을 종료합니다.");
				flag=false;
				break;
			default:
				System.out.println("잘못된 입력입니다");
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
		System.out.println("추가할 은행을 입력하세요");
		String inputBank=sc.nextLine();
		if(isBank(inputBank)) {
			System.out.println("이미 등록된 은행입니다.");
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
		if(bankCurrentIndex!=-1) {//accountCurrent가 -1이 아닐때만 작동할 수 있도록 설정
			bank[bankCurrentIndex].menu();
		}else {
			System.out.println("잘못된 접근");
		}
	}
	public void displayBank() {
		System.out.println("총 은행수: "+bankCount);
		for(int i=0;i<bankCount;i++) {
			bank[i].display();
		}
		
	}
	public void menu() {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("1.은행 추가  2.은행 선택  3.모든 은행정보  4.종료");
			String inputString=sc.nextLine();
			switch(inputString) {
			case "1":
				addBank();
				break;
			case "2":
				System.out.println("이용할 은행을 입력>>");
				String bankName=sc.nextLine();
				if(isBank(bankName)) {
					selectBank();
				}
				else {
					System.out.println("잘못된 입력입니다.");
				}
				break;
			case "3":
				displayBank();
				break;
			case "4":
				System.out.println("프로그램을 종료합니다.");
				flag=false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
	
	
}
public class BankPr {

	public static void main(String[] args) {
		//Account a를 기준으로 작업함
		//account가 늘어나면? =>처리하기위해 Bank 클래스를 만듦
		Atm atm = new Atm();
		atm.menu();
		//Bank의 개수가 늘어나면?
		
		
		
	}

}
