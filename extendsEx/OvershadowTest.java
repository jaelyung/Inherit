package com.human.extendsEx;
class Parent{
	public String name="영조";
	public void print() {
		System.out.println(name);
	}
}
class Child extends Parent{
	public String name="사도세자";
	public void print() {
		System.out.println("나는 "+name+"이다.");
	}
}
public class OvershadowTest {

	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p.name);
		p.print();

	}

}
