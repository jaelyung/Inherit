package com.human.extendsEx;

class Girl{
	protected String name;
	public void show() {
		System.out.println(name+"�� �ڹ� �ʺ����̴�.");
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
		System.out.println(name+"�� �ڹٸ� �� �ȴ�.");
	}
	
}
class BestGirl extends GoodGirl{
	BestGirl(){}
	BestGirl(String name){
		super.name=name;
	}
	public void show() {
		System.out.println(name+"�� �ڹٸ� �����ϰ� �� �ȴ�.");
	}
	
}
public class GirlTest {
	public static void main(String[] args) {
		Girl[] girls = {new Girl("������"), new GoodGirl("����"), new BestGirl("Ȳ����")};
		
		for(Girl g: girls) {
			g.show();
		}
		
	}
}
