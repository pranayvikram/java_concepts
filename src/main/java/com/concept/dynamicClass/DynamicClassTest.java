package com.concept.dynamicClass;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DynamicClassTest {
	
	public static void main(String... str) {
		
		new DynamicClassTest().test();
	}
	
	private void test() {
		
		String whatClass = null;
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(in);

			// Enter "FieldOne" or "FieldTwo"
			System.out.println("You have two options \n1. FieldOne  2. FieldTwo ");
			System.out.println("Enter Class Name: ");
			whatClass = reader.readLine();
			// When we are not sure, which class to load, then a string value of an existing class is used
			// based on the business logic to create a Class object.
			// Here "dynamicClass." is the package name of expected class.
			Class<?> exampleClass = Class.forName("dynamicClass." + whatClass);
			Object ob = exampleClass.newInstance();
			if (ob instanceof FieldOne) {
				FieldOne fld = (FieldOne)ob;
				fld.setKey("This instance is of class FieldOne");
				System.out.println(fld.getKey());
			} else if (ob instanceof FieldTwo) {
				FieldTwo fld = (FieldTwo)ob;
				fld.setKey("This instance is of class FieldTwo");
				System.out.println(fld.getKey());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: The class '" + whatClass + "' is missing!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
