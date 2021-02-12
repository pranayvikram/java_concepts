package com.concept.NumberAlgorithms;

public class Factorial {

	public static void main(String...strings) {
		Factorial factorial = new Factorial();
		factorial.findFactorial(5);
	}
	
	private void findFactorial(int num) {
		int factorialNum = 1;
		int i = num;
		while(i > 0) {
			factorialNum = i * factorialNum;
			i--;
		}
		System.out.println(factorialNum);
	}
}
