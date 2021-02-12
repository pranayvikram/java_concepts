package com.concept.immutableClass;

public class ImmutableClassTest {

	public static void main(String[] args) {
		
		ImmutableClassCreate immutableObj = new ImmutableClassCreate(101, "CalssName", "Address");

		System.out.println(immutableObj.getId());
		System.out.println(immutableObj.getName());
		System.out.println(immutableObj.getAddress());
		
	}
}
