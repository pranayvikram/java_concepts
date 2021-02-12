package com.concept.NumberAlgorithms;

/**
 * Print shape 'X' in a box
 * English flag for only odd numbers: 
 * (i==1 || i==n || j==1 || j==n || i==j || i==n-j+1 || i==n/2+1 || j==n/2+1)  
 * @author User
 *
 */
public class PrintXofGraph {

	public static void main(String[] args) {

		int n = 13;
		PrintXofGraph print = new PrintXofGraph();
		print.printer(n);
	}
	
	private void printer(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i==1 || i==n || j==1 || j==n || i==j || i==n-j+1) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println("");
		}
	}
}
