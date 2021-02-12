package com.concept.allClasses;

public class StringSwap {

	
	
	public static void main(String... abc) {
	
		String s1 = "123";
		String s2 = "1234";
		
		s2 = s2 + s1; // abc123
		//s1 = s2.replace(s1,""); // abc
		//s2 = s2.replace(s1,""); // 123
		
		s1 = s2.substring(0, s2.length() - s1.length()); // abc
		s2 = s2.substring(s1.length(), s2.length()); // 123
		
		System.out.println("S1 -> " + s1);
		System.out.println("S2 -> " + s2);
		
		String ss = "ABC";
		String bb = "ABC";
		
		System.out.println(ss==bb);
		System.out.println("this time it is: " + ss==bb); // Answer ("this time it is: " + ss) == bb 
		
		Object o = 3.5/2.5f;
		System.out.println(o.getClass());
	
	}
	
	
}
