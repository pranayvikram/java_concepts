package com.concept.NumberAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Greatest common divisor & Lowest common multiple
 */
public class GreatestCommonDivisor {

	public static void main(String... args) {
		
		List<Integer> input = new ArrayList<Integer>();
		input.addAll(Arrays.asList(12, 24, 48, 72, 36, 120, 240));
		GreatestCommonDivisor instance = new GreatestCommonDivisor();
		int gcm = instance.calculateGCM(input);
		System.out.println(gcm);
		int lcm = instance.calculateLCM(input);
		System.out.println(lcm);
	}

	private int calculateGCM(List<Integer> input) {
		Map<Integer, List<Integer>> resultMap = new HashMap<>();
		for (int intVal : input) {
			List<Integer> divisors = new ArrayList<Integer>();
			for (int j=1; j<=intVal; j++) {
				if (intVal % j == 0)
				divisors.add(j);
			}
			resultMap.put(intVal, divisors);
		}
		List<Integer> commonDivisorList = findCommonElement(resultMap);
		int result = Collections.max(commonDivisorList);
		return result;
	}
	
	private List<Integer> findCommonElement(Map<Integer, List<Integer>> resultMap) {	
		List<Integer> commonDivisorList = new ArrayList<>();
		for (Integer key : resultMap.keySet()) {
			for (Integer div : resultMap.get(key)) {
				boolean itIsCommon = true;
				for (Integer sameKey : resultMap.keySet()) {
					if (!key.equals(sameKey)) {
						if (!resultMap.get(sameKey).contains(div)) {
							itIsCommon = false;
							break;
						}
					}
				}
				if (itIsCommon) {
					commonDivisorList.add(div);
				}
			}
		}
		return commonDivisorList;
	}

	private int calculateLCM(List<Integer> input) {
		
		Map<Integer, List<Integer>> resultMap = new HashMap<>();
		List<Integer> commonDivisorList = new ArrayList<Integer>();
		int incrementer = 1;
		while (commonDivisorList.isEmpty()) {
			for (Integer intVal : input) {
				if (resultMap.get(intVal) == null) {
					List<Integer> multiples = new ArrayList<Integer>();
					resultMap.put(intVal, multiples);
				}
				resultMap.get(intVal).add(intVal * incrementer);
			}
			incrementer++;
			commonDivisorList = findCommonElement(resultMap);
		}
		int result = commonDivisorList.get(0);
		return result;
	}
}
