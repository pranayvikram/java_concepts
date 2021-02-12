package com.concept.NumberAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AandBCubeEqualsCandDCube {
	
	public static void main(String...strings) {
	
		AandBCubeEqualsCandDCube call = new AandBCubeEqualsCandDCube();
		call.checkEquals();
	}
	
	private void checkEquals() {
		
		Integer range = 100;
		Map<String, Integer> tempMap = new HashMap<>();
		for(int i = 1; i < range; i++) {
			for(int j = 1; j < range; j++) {
				String key = i > j ? ""+i+"-"+j : ""+j+"-"+i;
				tempMap.put(key, i*i*i + j*j*j);
			}
		}
		List<Integer> sumlist = new ArrayList<>();
		List<Integer> dupVal = new ArrayList<>();
		for (String key : tempMap.keySet()) {
			Integer element = tempMap.get(key);
			if (!sumlist.contains(element)) {
				sumlist.add(element);
			} else {
				dupVal.add(element);
			}
		}
		Map<Integer, List<String>> resultMap = new HashMap<>();
		for (String key : tempMap.keySet()) {
			Integer element = tempMap.get(key);
			if (dupVal.contains(element)) {
				if (resultMap.get(element) == null) {
					List<String> resultList = new ArrayList<>();
					resultList.add(key);
					resultMap.put(element, resultList);
				} else {
					resultMap.get(element).add(key);
				}
			}
		}
		resultMap.keySet().forEach(e -> System.out.println(resultMap.get(e)));
	}
}
