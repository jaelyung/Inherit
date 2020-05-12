package com.human.extendsEx;
class Vehicle{
	public String color;
	public int speed;
	public Vehicle() {}
	public Vehicle(String color, int speed) {
		this.color=color;
		this.speed=speed;
	}
	public void show() {
		System.out.println("color : "+color+ ", speed : "+speed);
	}
}
class Car extends Vehicle{
	public int displacement;
	public int gears;
	public Car() {}
	public Car(String color, int speed, int displacement, int gears) {
		super.color=color;
		super.speed=speed;
		this.displacement=displacement;
		this.gears=gears;
	}
	public void show() {
		System.out.println("color : "+color+ ", speed : "+speed+", displacement : "+displacement+", gears : "+gears);
	}
}
public class OverrideTest {

	public static void main(String[] args) {
		Car c=new Car("ÆÄ¶û", 200, 1000, 5);
		c.show();
		
		System.out.println();
		Vehicle v = c;
		v.show();
	}

}
