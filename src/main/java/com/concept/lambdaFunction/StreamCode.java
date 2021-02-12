package com.concept.lambdaFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class StreamCode {

	public static void main(String... str) {
		
		StreamCode stream = new StreamCode();
		
		//stream.printListUsingForLoopAndForEach();
		//stream.printListUsingFilters();
		//stream.sortElementsByName();
		//stream.findMatchingWordLines();
		stream.findAllWordsCount();
		//stream.findAllWordsCountInJobs();
	}
	
	public void printListUsingForLoopAndForEach() {

		List<String> strList = new ArrayList<String>();
		strList.addAll(Arrays.asList("el1", "el2", "el3", "el4", "el5"));
		strList.add("el9");
		for(String str : strList) {
			System.out.println("The element is: " + str);
		}
		
		// Print all elements using Stream
		strList.stream().forEach(str -> 
			System.out.println("The element is: " + str));
		
		// Print all elements using parallel Stream
		//strList.stream().parallel()..
		strList.parallelStream().forEach(
				(str) -> {
				System.out.println("The element is: " + str);
		});
		
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);
		
		random.ints().limit(10).forEach((num) -> {
			System.out.println("The uuid is: " + new UUID(num, num));
		});
	}
	
	public void printListUsingFilters() {
		
		List<String> strList = new ArrayList<String>();
		strList.addAll(Arrays.asList("el2", "el4", "el1", "el3", "el5"));
		strList.add("el9");
		
	    Predicate<String> matchPredicate = element -> element.equals("el4");
		//Predicate<String> predicate2 = e -> e.id < 10 && e.name.startsWith("A");
	    
		System.out.println("Conditional result of all match:" + strList.stream().allMatch(matchPredicate));
		System.out.println("Conditional result of any match:" + strList.stream().anyMatch(matchPredicate));
		System.out.println("Conditional result of no match:" + strList.stream().noneMatch(matchPredicate));
		
		// Filter a word from ArrayList
		Predicate<String> filterPredicate = word -> !"el3".equals(word);
		List<String> fltStrList = strList.stream()
											.filter(filterPredicate)
											.collect(Collectors.toList());
		
		fltStrList.forEach(System.out::println);
		
		// Print elements in a sorted order
		strList.stream().sorted().forEach((str) -> {
			System.out.println("The element is: " + str);
		});
	}
	
	
	public void sortElementsByName() {
		
		TestEntity ent1 = new TestEntity("101", "ent1", "2341", 105, "loc1");
		TestEntity ent2 = new TestEntity("102", "ent2", "2342", 104, "loc5");
		TestEntity ent3 = new TestEntity("103", "ent3", "2343", 103, "loc3");
		TestEntity ent4 = new TestEntity("104", "ent4", "2344", 102, "loc2");
		TestEntity ent5 = new TestEntity("105", "ent5", "2345", 101, "loc4");
		
		List<TestEntity> entList = new ArrayList<>();
		entList.addAll(Arrays.asList(ent1, ent3, ent5, ent2, ent4));
	    
		Collections.sort(entList, (e1, e2) -> e1.getLocation().compareTo(e2.getLocation()));
		
		entList.forEach(System.out::println);
	}
	
	
	public void findMatchingWordLines() {
		
		try {
			String fileName = "..//WarmUp//src//lambdaFunction//Internate Id.txt";

			Path path = Paths.get(fileName);
			
			Stream<String> stream = Files.lines(path);
			
			// 1. filter "Pass:" key word
			// 2. convert all content to upper case
			// 3. convert it into a List
			List<String> strlist = stream.filter(line -> line.startsWith("Pass:"))
								         .map(String::toUpperCase)
								         .collect(Collectors.toList());

			strlist.forEach(System.out::println);
			stream.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void findAllWordsCount() {

		try {
			String fileName = "..//WarmUp//src//lambdaFunction//Internate Id.txt";

			Path path = Paths.get(fileName);
			List<String> strList = Files.readAllLines(path);
			
			// Print all lines as part of List
			strList.stream().forEach(System.out::println);

			Stream<String> fileLineStream = Files.lines(path);

			// stream can be operated only once
			//stream.forEach(System.out::println);
			
			Map<String, Integer> counts = fileLineStream.parallel()
					.collect(
					Collectors.toConcurrentMap(
					line -> line, line -> 1, Integer::sum));
			
			System.out.println(counts);

			// To print distinct values from collection & // stream can be operated only once
			//stream.distinct().collect(Collectors.toList()).forEach(System.out::println);

			// Get list of unique squares
			List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
			
			List<Integer> squaresList = numbers.stream().map( i -> i*i ).distinct().collect(Collectors.toList());
			squaresList.forEach(System.out::println);
			fileLineStream.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void findAllWordsCountInJobs() {

		try {
			String fileName = "..//WarmUp//src//lambdaFunction//Internate Id.txt";

			fileName = "D:\\Code\\work-space-r\\WarmUp\\src\\lambdaFunction\\TextFileTest";
			
			Path path = Paths.get(fileName);
			List<String> strList = Files.readAllLines(path);
			Map<String, Integer> result = new HashMap<>();
	
			for (String line : strList) {
				line = line.replace(".", "");
				line = line.replace(")", "");
				line = line.replace("(", "");
				String[] words = line.split("[\\s']");
				
				for (String word : words) {
					if (result.keySet().contains(word)) {
						result.put(word.toLowerCase(), result.get(word) + 1);
					} else {
						result.put(word.toLowerCase(), 1);
					}
				}
			}	
			
			for (String key : result.keySet()) {
				
				if (result.get(key) < 10 ) {
					System.out.println("0" + result.get(key) +  "----" + key);
				} else {
					System.out.println(result.get(key) +  "----" + key);
				}
			}			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
