package com.concept.junitTest;

public class Elephant extends Animal {

	
	public static void main(String...strings) {
		
		System.out.println("Hello Elephant");
		
		Animal animal = new Animal();
		String msg = animal.animalHello();
		System.out.println(msg);
	}

	public String animalHello(Boolean flag) {
		
		System.out.println("Hello Animal from Elephant");
		
		return "";
	}

	private String elephantlHello() {
	
		System.out.println("Elephant Hello");
	
		return "";
	}
	
	
	
}
