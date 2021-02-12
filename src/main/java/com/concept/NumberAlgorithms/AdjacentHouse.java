package com.concept.NumberAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacentHouse {

	public static void main(String...strings) {
			
		int days = 7;
		Integer[] ip = new Integer[] {1,1,0,0,1,1,0,1,0,1};
		List<Integer> ipList = new ArrayList<>();
		ipList.addAll(Arrays.asList(ip));
		
		AdjacentHouse sol = new AdjacentHouse();
		for (int i = 0; i <= days; i++ ) {
			List<Integer> nextDayStatus =	sol.statusAfterNdays(ipList, i);
			System.out.print("Day:" + i + " - ");
			System.out.println(nextDayStatus);
		}
	}
	
	public List<Integer> statusAfterNdays(List<Integer> state, int days) {
		int length = state.size();
		List<Integer> previousStates = state;
		int allDays = days;
		while(allDays > 0) {
			List<Integer> newStates = new ArrayList<>();
			for (int i=0; i<length; i++) {
				int value = 0;
				if (i == 0) {
					value = previousStates.get(i+1);
				} else if (i > 0 && i < length-1) {
					value = previousStates.get(i-1) ^ previousStates.get(i+1);
				} else if (i == length-1) {
					value = previousStates.get(i-1); 
				}
				newStates.add(i, value); 
			}
			previousStates = newStates;
			allDays--;
		}
		return previousStates;
	}
}
