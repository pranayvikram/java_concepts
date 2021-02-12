package com.concept.optionalConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class OptionalTest {

	public static void main(String[] args) {

		Optional<String> test = Optional.of("TEST");
		String answer1 = "Yes";
		String answer2 = null;

		OptionalTest optionalTest = new OptionalTest();
		
		//optionalTest.optionalBasics(test, answer1, answer2);

		//optionalTest.optionalFlatMap(test);

		//optionalTest.optionalFilter(test);

		//optionalTest.optionalIsPresent(test);

		//optionalTest.optionalOrElse(test);
		
		optionalTest.testMapVsFlatMap();
	}

	private void optionalBasics(Optional<String> test, String answer1, String answer2) {
		
		System.out.println("Non-Empty Optional: " + test);
		System.out.println("Non-Empty Optional: Test value : " + test.get());
		System.out.println("Empty Optional: " + Optional.empty());

		System.out.println();
		
		System.out.println("Optional.ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
		System.out.println("Optional.ofNullable on Empty Optional: " + Optional.ofNullable(answer2));

		// java.lang.NullPointerException
		System.out.println("Optional.of on Non-Empty Optional: " + Optional.of(answer1));
		System.out.println("Optional.of on Empty Optional: " + Optional.of(answer2));
	}

	private void optionalFlatMap(Optional<String> test) {

		Optional<String> emptyTest = Optional.empty();

		System.out.println("Non-Empty Optional:: " + test.map(String::toLowerCase));
		System.out.println("Empty Optional    :: " + emptyTest.map(String::toLowerCase));
		
		Optional<Optional<String>> nonEmptyOtionalTest = Optional.of(Optional.of("TEST"));
		
		System.out.println("Optional value   :: " + nonEmptyOtionalTest);
		System.out.println("Optional.map     :: " + nonEmptyOtionalTest.map(test1 -> test1.map(String::toLowerCase)));
		
		// If the result is already an Optional, flatMap does not wrap it with an additional Optional
		System.out.println("Optional.flatMap :: " + nonEmptyOtionalTest.flatMap(test1 -> test1.map(String::toLowerCase)));
	}
	
	private void optionalFilter(Optional<String> test) {

		Optional<String> emptyTest = Optional.empty();

		// Filter on Optional
		System.out.println(test.filter(g -> g.equals("test")));
		System.out.println(test.filter(g -> g.equalsIgnoreCase("test")));
		System.out.println(emptyTest.filter(g -> g.equalsIgnoreCase("TEST")));
		
		List<String> testList = Arrays.asList("test1", "test2", "test3", "test4", "test7");
		
		// Find first and print - high performance
		Optional<String> result1 = testList.stream().findFirst().filter(t -> t.equals("test1"));
		System.out.println(result1);
		
		// Find all and then print first - low performance
		Optional<String> result2 = testList.stream().filter(t -> t.equals("test1")).findFirst();
		System.out.println(result2);
		
		testList.stream().forEach(System.out::println);
		
		testList.stream().forEach(t -> System.out.println(!t.equals("test")));
	}

	private void optionalIsPresent(Optional<String> test) {

		Optional<String> emptyTest = Optional.empty();

		if (test.isPresent()) {
			System.out.println("Value available.");
		} else {
			System.out.println("Value not available.");
		}
		
		test.ifPresent(g -> System.out.println("In test Option, value available."));

		// Condition failed, no output print
		emptyTest.ifPresent(g -> System.out.println("In emptyTest Option, value available."));
	}


	private void optionalOrElse(Optional<String> test) {

		Optional<String> emptyTest = Optional.empty();

		System.out.println(test);
		System.out.println(test.orElse("Not Available"));
		System.out.println(emptyTest.orElse("Not Available"));

		System.out.println(test.orElseGet(() -> "Not Available"));
		System.out.println(emptyTest.orElseGet(() -> "Not Available"));
	}
	
	private static List<String> test(String abc) {
		return new ArrayList<>();
	}
	
	
	private void testMapVsFlatMap() {
   
	Optional<Optional<String>> nonEmptyOtionalTest = Optional.of(Optional.of("TEST"));
		
	System.out.println("Optional value   :: " + nonEmptyOtionalTest);
	System.out.println("Optional.map     :: " + nonEmptyOtionalTest.map(e -> e.map(String::toLowerCase)));
	
	// If the result is already an Optional, flatMap does not wrap it with an additional Optional
	System.out.println("Optional.flatMap :: " + nonEmptyOtionalTest.flatMap(e -> e.map(String::toLowerCase)));

	
	List<String> testList = new ArrayList<>();
		/*
		 * List<String> new1 = testList.stream() .flatMap(e -> { OptionalTest.test(e);
		 * }) .collect(Collectors.toList());
		 */
	
	List<String> new2 = testList.stream()
		    .map(String::valueOf)
		    .collect(Collectors.toList());
	
	boolean new3 = testList.stream()
			.anyMatch(e -> e.equals("12"));
	}
	

}