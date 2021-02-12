package com.concept.abstractFactoryPattern;

public class  DomesticHouse extends House {

	@Override  
	public void getRate() {
		houseRate = 3.50;              
	}

	public int add(int a, int b) {

		return a + b;
	}

	public String findName(String str) {

		return str + "-123-DH";
	}
	
	@Override
	public void calculateBill(int units) {
		
		System.out.println(units * houseRate);
		System.out.println("This is a over ridden.");
	}
}