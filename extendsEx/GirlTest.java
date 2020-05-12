package com.human.extendsEx;

class Girl{
	protected String name;
	public void show() {
		System.out.println(name+"는 자바 초보자이다.");
	}
	Girl(){}
	Girl(String name){
		this.name=name;
	}
}

class GoodGirl extends Girl{
	GoodGirl(){}
	GoodGirl(String name){
		super.name=name;
	}
	public void show() {
		System.out.println(name+"는 자바를 잘 안다.");
	}
	
}
class BestGirl extends GoodGirl{
	BestGirl(){}
	BestGirl(String name){
		super.name=name;
	}
	public void show() {
		System.out.println(name+"는 자바를 무지하게 잘 안다.");
	}
	
}
public class GirlTest {
	public static void main(String[] args) {
		Girl[] girls = {new Girl("갑순이"), new GoodGirl("콩쥐"), new BestGirl("황진이")};
		
		for(Girl g: girls) {
			g.show();
		}
		
	}
}
