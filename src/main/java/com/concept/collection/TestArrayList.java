package com.concept.collection;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;


public class TestArrayList {

	public static void main(String[] args) {

		TestObject obj1 = TestObject.builder()
				.firstName("fff")
				.lastName("lll")
				.identifier("101")
				.noUse("123")
				.build();

		TestObject obj2 = TestObject.builder()
				.firstName("ffff")
				.lastName("llll")
				.identifier("202")
				.noUse("124")
				.build();

		TestObject obj3 = TestObject.builder()
				.firstName("fff")
				.lastName("lll")
				.identifier("101")
				.noUse("123")
				.build();
		
		ArrayList<TestObject> testList = new ArrayList<>();
		testList.add(obj1);
		testList.add(obj2);
		testList.add(obj3);
		
		ArrayList<TestObject> cleanList = new ArrayList<>();
		for (TestObject testObj : testList) {
			if (!cleanList.contains(testObj)) {
				cleanList.add(testObj);
			}
		}
		
		System.out.println(cleanList.size());
		if (obj1.equals(obj2)) System.out.println("1==2");
		if (obj2.equals(obj3)) System.out.println("2==3");
		if (obj3.equals(obj1)) System.out.println("3==1");
		
		TestArrayList arrayTest = new TestArrayList();

		arrayTest.testConcurrentModificationExceptionWithCopyOnWriteArrayList();
		arrayTest.testConcurrentModificationExceptionWithArrayList();
		arrayTest.testConcurrentModificationExceptionWithQueue();
		arrayTest.testConcurrentModificationExceptionWithDeque();
		arrayTest.testConcurrentModificationExceptionWithSet();
		arrayTest.testHashMapWithkeySet();
		arrayTest.testHashMapWithEntrySet();
		arrayTest.testMapWithConcurrentHashMap();
	}

	// Solution to Concurrent Modification Exception fixed with DEQUE
	private void testConcurrentModificationExceptionWithCopyOnWriteArrayList() {
		List<String> testList = new CopyOnWriteArrayList<>();
		testList.add("11");
		testList.add("12");
		testList.add("13");
			   
		try {
			for (String str : testList) {
				if (str.equals("12")) {
					testList.add("14");
				}
			}
			System.out.println("No error CopyOnWriteArrayList - " + testList);
		} catch (ConcurrentModificationException cme) {
			System.out.println("ConcurrentModificationException caught - " + testList);
		}
	}
	
	// Solution to Concurrent Modification Exception fixed with DEQUE
	private void testConcurrentModificationExceptionWithArrayList() {
		List<String> testList = new ArrayList<>();
		testList.add("11");
		testList.add("12");
		testList.add("13");
		try {
			for (String str : testList) {
				if (str.equals("12")) {
					testList.add("14");
				}
			}
			System.out.println("No error ArrayList - " + testList);
		} catch (ConcurrentModificationException cme) {
			System.out.println("ConcurrentModificationException caught - " + testList);
		}
	}
	
	// Solution to Concurrent Modification Exception fixed with QUEUE
	private void testConcurrentModificationExceptionWithQueue() {
		Queue<String> testList = new ConcurrentLinkedQueue<>();
		testList.add("11");
		testList.add("12");
		testList.add("13");
		for (String str : testList) {
			if (str.equals("12")) {
				testList.add("14");
			}
		}
		System.out.println(testList);
	}
		
	// Solution to Concurrent Modification Exception fixed with DEQUE
	private void testConcurrentModificationExceptionWithDeque() {
		Deque<String> testList = new ConcurrentLinkedDeque<>();
		testList.add("11");
		testList.add("12");
		testList.add("13");
		for (String str : testList) {
			if (str.equals("12")) {
				testList.add("14");
			}
		}
		System.out.println(testList);
	}
	
	// Solution to Concurrent Modification Exception fixed with SET
	private void testConcurrentModificationExceptionWithSet() {
		Set<String> testList = new ConcurrentSkipListSet<>();
		testList.add("11");
		testList.add("12");
		testList.add("13");
		for (String str : testList) {
			if (str.equals("13")) {
				testList.add("14");
			}
		}
		System.out.println(testList);
	}
	
	// Catch Concurrent Modification Exception fixed with Key SET
	private void testHashMapWithkeySet() {
		Map<String, String> testMap = new HashMap<>();
		testMap.put("11", "11");
		testMap.put("12", "12");
		testMap.put("13", "13");
		try {
			for (String str : testMap.keySet()) {
				if (str.equals("12")) {
					testMap.put("14", "14");
				}
			}
			System.out.println("No error HashMap - " + testMap);
		} catch (ConcurrentModificationException cme) {
			System.out.println("ConcurrentModificationException caught - " + testMap);
		}
	}
	
	// Catch Concurrent Modification Exception fixed with Entry SET
	private void testHashMapWithEntrySet() {
		Map<String, String> testMap = new HashMap<>();
		testMap.put("11", "11");
		testMap.put("12", "12");
		testMap.put("13", "13");
		try {
			for (Entry<String, String> entryMap : testMap.entrySet()) {
				if (entryMap.getKey().equals("12")) {
					testMap.put("14", "14");
				}
			}
			System.out.println("No error HashMap - " + testMap);
		} catch (ConcurrentModificationException cme) {
			System.out.println("ConcurrentModificationException caught - " + testMap);
		}
	}
	
	// Solution to Concurrent Modification Exception fixed with ConcurrentHashMap
	private void testMapWithConcurrentHashMap() {
		ConcurrentMap<String, String> testMap = new ConcurrentHashMap<>();
		testMap.put("11", "11");
		testMap.put("12", "12");
		testMap.put("13", "13");
		try {
			for (Entry<String, String> entryMap : testMap.entrySet()) {
				if (entryMap.getKey().equals("12")) {
					testMap.put("14", "14");
				}
			}
			System.out.println("No error ConcurrentHashMap - " + testMap);
		} catch (ConcurrentModificationException cme) {
			System.out.println("ConcurrentModificationException caught - " + testMap);
		}
	}
}
