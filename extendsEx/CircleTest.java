package com.human.extendsEx;
class Color{
	public int radius;
	public String color;
	Color(){}
	Color(int radius){
		this.radius=radius;
	}
	Color(int radius, String color){
		this.radius=radius;
		this.color=color;
	}
	public void show() {}
}


class Circle extends Color{
	Circle(int radius){
		super.radius=radius;
	}
	public void show() {
		System.out.println("반지름이 "+radius+"인 원이다.");
	}
	
}

class ColoredCircle extends Color{
	ColoredCircle(int radius, String color){
		super.radius=radius;
		super.color=color;
	}
	public void show() {
		System.out.println("반지름이 "+radius+"인 "+color+" 원이다.");
	}
}
public class CircleTest {

	public static void main(String[] args) {
		Color c1=new Circle(5);
		c1.show();
		
		Color c2=new ColoredCircle(10,"빨간색");
		c2.show();
	}

}
