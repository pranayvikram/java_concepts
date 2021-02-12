package com.concept.junitTest;

public class Animal {
	
	public static void main(String...strings) {
		
		System.out.println("Hello All");
		
		Animal animal = new Animal();
		String msg = animal.animalHello();
		System.out.println(msg);
	}
	
	
	protected String animalHello() {
		
		System.out.println("Hello Animal");
		
		return "";
	}
	
}

