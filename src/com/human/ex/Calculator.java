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
class TV extends Product{
	public double tax=0.1;
	@Override
	public double getPrice() {
		return price*(1+tax);
	}
}
class Cellphone extends Product{
	public double tax=0.11;
	@Override
	public double getPrice() {
		return price*(1+tax);
	}
}
class Radio extends Product{
	public double tax=0.12;
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
	public static void main(String[] args) {
		Customer c = new Customer();
		Customer vip = new VIPCustomer();
		Customer gold = new GOLDCustomer();
		
		Product[]pr=new Product[5];
		pr[0]=new TV();
		pr[1]=new Radio();
		pr[2]=new Cellphone();
		
		System.out.println("일반고객: "+Calculator.productCalculator(c, pr));
		System.out.println("VIP고객: "+Calculator.productCalculator(vip, pr));
		System.out.println("GOLD고객: "+Calculator.productCalculator(gold, pr));
	}

}
