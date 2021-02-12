package com.concept.abstractFactoryPattern;

public class  CommercialHouse extends House {

	
	@Override
	public void getRate() {   
		houseRate = 7.50;  
	}
	
	public int add(int a, int b) {
		
		return a + b;
	}
	
	public String findName(String str) {
		
		return str + "-123-CH";
	}
}