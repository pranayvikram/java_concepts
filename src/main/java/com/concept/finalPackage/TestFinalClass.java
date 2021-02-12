package com.concept.finalPackage;

public class TestFinalClass {
	
	
	
	public static void main(String... arg) {
		
		TestFinalClass testF = new TestFinalClass();
		testF.test();
		
	}
	
	public void test() {

		AFinalClass aFinalClass1 = new AFinalClass(11, "name1", "addr1", "city1");
		
		System.out.println(aFinalClass1.getAddr());
		System.out.println(aFinalClass1.hashCode());
		System.out.println(aFinalClass1.hashCode());
		
		aFinalClass1 = new AFinalClass(111, "name2", "addr2", "city2");
		System.out.println(aFinalClass1.getAddr());
		System.out.println(aFinalClass1.hashCode());
		
		System.out.println("*****************************");		
		AFinalClass aFinalClass2 = new AFinalClass();
		System.out.println(aFinalClass2.getAddr());
		System.out.println(aFinalClass2.hashCode());
	}


}


