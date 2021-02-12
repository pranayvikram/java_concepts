package com.concept.allClasses;

import java.util.Scanner;

public class Queen {

	int n, sn = 1;
	int[] x = new int[100];

	Scanner s = new Scanner(System.in);

	public void queen() {

		int k = 1;

		System.out.println(" Enter the no. of queens(greater than 3 & less than 100) : ");
		n = Integer.parseInt(s.nextLine());

		if (n < 100)
			nQueen(k, n);
		else
			System.out.println(" Sorry please execute again !");
	}

	public void nQueen(int k, int n) {

		for (int i = 1; i <= n; i++) {
			if (place(k, i)) {
				x[k] = i;

				if (k == n) {
					System.out.println();
					System.out.println(" Adjacent House number : " + sn++);

					for (int j = 1; j <= n; j++) {
						for (int l = 1; l <= n; l++) {
							System.out.print(" " + (l == x[j] ? 1 : 0) + " ");
						}
						System.out.println();
					}
				} else {
					nQueen(k + 1, n);
				}
			}
		}
		return;
	}

	public boolean place(int k, int i) {

		int j;

		for (j = 1; j <= k; j++) {

			if ((x[j] == i) || (Math.abs(x[j] - i) == Math.abs(j - k)))

				return false;
		}
		return true;
	}

	public static void main(String... string) {

		Queen queen = new Queen();
		queen.queen();
	}
}