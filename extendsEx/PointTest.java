package com.human.extendsEx;
class Point{
	protected int x,y;
	Point(){}
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
class MovablePoint extends Point{
	private int xSpeed, ySpeed;
	MovablePoint(){}
	MovablePoint(int x,int y, int xSpeed, int ySpeed){
		super.x=x;
		super.y=y;
		this.xSpeed=xSpeed;
		this.ySpeed=ySpeed;
		
	}
	@Override
	public String toString() {
		return "MovablePoint [x= " + x + ", y= " + y + ", xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + "]";
	}
	
}
public class PointTest {

	public static void main(String[] args) {
		Point p1=new MovablePoint(3,2,100,200);
		System.out.println(p1.toString());

	}

}
