package com.concept.NumberAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class Armstrong {

	public static void main(String... string) {
		
		Armstrong armstrong = new Armstrong();
		armstrong.checkArmstrong();
		System.out.println(armstrong.reverse(1534236469));
		/////////////////////////////////////1056389759
	}
	
	private void checkArmstrong() {
		List<Integer> numList = new ArrayList<>();
		numList.add(121);
		numList.add(153);
		numList.add(370);
		numList.add(1000);
		for (Integer num : numList) {
			System.out.println(num + " - is armstrong ? " + isArmstrong(num));
		}
	}
	
	private boolean isArmstrong(int num) {
		
		int sum = 0;
		int armNum = num;
		
		while(armNum > 0) {
			int i = armNum%10;
			sum += (i*i*i);
			armNum = armNum/10;
		}
		return num == sum;
	}
	
    public int reverse(int x) {
        int result = 0;
        int y = x;
        int MAX = (int)Math.pow(2, 30);
        while(y != 0) {
            result = result * 10 + y%10;
            y = y/10;
            
            if (result < (-MAX) || result >= MAX) {
                return 0;
            }
        }
        return result;
    }
	  
}
