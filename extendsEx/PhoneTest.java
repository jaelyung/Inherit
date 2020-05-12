package com.human.extendsEx;
class Phone{
	protected String owner;
	Phone(){}
	Phone(String owner){
		this.owner=owner;
	}
	public void talk() {
		System.out.println(owner+"가 통화 중이다.");
	}
	
}

class Telephone extends Phone{
	private String when;
	Telephone(){}
	Telephone(String owner, String when){
		super.owner=owner;
		this.when=when;
	}
	public void autoAnswering() {
		System.out.println(owner+"가 없다. "+when+" 전화 줄래.");
	}
}

class Smartphone extends Telephone{
	private String game;
	Smartphone(){}
	Smartphone(String owner, String game){
		super.owner=owner;
		this.game=game;
	}
	public void playGame() {
		System.out.println(owner+"가 "+game+" 게임을 하는 중이다.");
	}
}

public class PhoneTest {

	public static void main(String[] args) {
		Phone[] phones = { new Phone("황진이"), new Telephone("길동이","내일"), new Smartphone("민국이","갤러그")};
		
		phones[0].talk();
		((Telephone) phones[1]).autoAnswering();
		((Smartphone) phones[2]).playGame();
	}

}
