package com.human.extendsEx;
class Parent{
	public String name="����";
	public void print() {
		System.out.println(name);
	}
}
class Child extends Parent{
	public String name="�絵����";
	public void print() {
		System.out.println("���� "+name+"�̴�.");
	}
}
public class OvershadowTest {

	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p.name);
		p.print();

	}

}
