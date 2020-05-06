package com.human.ex;
class VIPCustomer extends Customer{
	public double sale=0.1;
	@Override
	public double getRate() {
		return rate-sale;
	}
}
class GOLDCustomer extends Customer{
	public double sale=0.2;
	@Override
	public double getRate() {
		return rate-sale;
	}
}
//각각의 클래스에 프로덕트의 이름과 가격을 추가할 수 있게 변경
class TV extends Product{
	public double tax=0.11;
	public TV(String productName, int price) {
		this.productName=productName;
		this.price=price;
	}
	@Override
	public double getPrice() {
		return price*(1+tax);
	}
}
class Cellphone extends Product{
	public double tax=0.11;
	public Cellphone(String productName, int price) {
		this.productName=productName;
		this.price=price;
	}
	@Override
	public double getPrice() {
		return price*(1+tax);
	}
}
class Radio extends Product{
	public double tax=0.12;
	public Radio(String productName, int price) {
		this.productName=productName;
		this.price=price;
	}
	@Override
	public double getPrice() {
		return price*(1+tax);
	}
}

public class Calculator {
	//모든 고객의 할인율을 받아서 모든 제품들을 계산
	public static double productCalculator(Customer c, Product []p) {
		double totalPrice=0;
		double totalRate=0;
		totalRate=c.getRate();
		if(p!=null) {
			for(Product pr:p) {
				if(pr!=null) {
					totalPrice+=pr.getPrice();
				}
				
			}
		}
		return totalPrice*totalRate;//리턴값 = 총 구매물품금액 * 고객할인율
	}
	
	private static double productCalculator(Customer c, Product product) {
		double totalPrice=0;
		double totalRate=0;
		totalRate=c.getRate();
		totalPrice=product.getPrice();
		return totalRate*totalPrice;
	}
	public static void main(String[] args) {
		Customer c = new Customer();
		Customer vip = new VIPCustomer();
		Customer gold = new GOLDCustomer();
		
		Product[]pr=new Product[5];
		pr[0]=new TV("model_1",500000);
		pr[1]=new Radio("model_1",40000);
		pr[2]=new Cellphone("model_1",200000);
		
		System.out.println("TV model_1 고객별 금액");
		System.out.println("일반고객: "+(int)Calculator.productCalculator(c, pr[0]));
		System.out.println("VIP고객: "+(int)Calculator.productCalculator(vip, pr[0]));
		System.out.println("GOLD고객: "+(int)Calculator.productCalculator(gold, pr[0]));
		System.out.println("\nRadio model_1 고객별 금액");
		System.out.println("일반고객: "+(int)Calculator.productCalculator(c, pr[1]));
		System.out.println("VIP고객: "+(int)Calculator.productCalculator(vip, pr[1]));
		System.out.println("GOLD고객: "+(int)Calculator.productCalculator(gold, pr[1]));
		System.out.println("\nCellphone model_1 고객별 금액");
		System.out.println("일반고객: "+(int)Calculator.productCalculator(c, pr[2]));
		System.out.println("VIP고객: "+(int)Calculator.productCalculator(vip, pr[2]));
		System.out.println("GOLD고객: "+(int)Calculator.productCalculator(gold, pr[2]));
	}
	

}
