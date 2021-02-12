package com.concept.abstractFactoryPattern;

/**
 * Define an interface or abstract class for creating an object 
 * but let the subclasses decide which class to instantiate.
 * @author User
 *
 */

abstract class House {

	protected double houseRate;
	abstract void getRate();
	abstract int add(int a, int b);
	abstract String findName(String str);
	
	public void calculateBill(int units) {
		
		System.out.println(units * houseRate);  
	}
}