package com.human.extendsEx;
class Person{
	public String name;
	public int age;
	Person(){}
	Person(String name, int age){
		this.name=name;
		this.age=age;
	}
	public void show() {
		System.out.println("���[�̸� : "+name+", ���� : "+age+" ]");
	}
}
class Student extends Person{
	public int studentNum;
	Student(){}
	Student(String name, int age, int studentNum){
		super.name=name;
		super.age=age;
		this.studentNum=studentNum;
	}
	public void show() {
		System.out.println("�л�[�̸� : "+name+", ���� : "+age+", �й� : "+studentNum+" ]");
	}
}
class ForeignStudent extends Student{
	public String nationality;
	ForeignStudent(){}
	ForeignStudent(String name, int age, int studentNum, String nationality){
		super.name=name;
		super.age=age;
		super.studentNum=studentNum;
		this.nationality=nationality;
	}
	public void show() {
		System.out.println("�ܱ��л�[�̸� : "+name+", ���� : "+age+", �й� : "+studentNum+", ���� : "+nationality+" ]");
	}
}
public class StudentTest {

	public static void main(String[] args) {
		Person p1=new Person("�浿��",22);
		Person p2=new Student("Ȳ����",23,100);
		Person p3=new ForeignStudent("Amy",30,200,"U.S.A");
		p1.show();
		p2.show();
		p3.show();
	}

}
