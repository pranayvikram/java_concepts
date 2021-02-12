package com.concept.NumberAlgorithms;

public class Fibonacci {

	public static void main(String...strings) {
		
		Fibonacci test = new Fibonacci();
		test.printFibonacci();
	}
	
	private void printFibonacci( ) {
		
		int num = 10000;
		int count = 1;
		for (int i = 0; i < num; i++) {
			boolean isFibonacci = true;
			for (int j = 2; j < i; j++) {
				if (i%j == 0) {
					isFibonacci = false;
					break;
				}
			}
			if (isFibonacci) {
				System.out.println("Fibonacci No:" + count + " " + i);
				count++;
			}
		}
	}
}
