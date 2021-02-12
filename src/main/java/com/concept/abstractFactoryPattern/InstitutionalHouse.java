package com.concept.abstractFactoryPattern;

public class  InstitutionalHouse extends House {
	
	@Override  
	public void getRate() {   
		houseRate = 5.50;  
	}
	
	public int add(int a, int b) {
		
		return a + b;
	}
	
	public String findName(String str) {
		
		return str + "-123-IH";
	}
}