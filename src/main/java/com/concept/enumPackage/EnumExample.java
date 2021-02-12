package com.concept.enumPackage;


public class EnumExample {

	
	private enum ENUM_VALUES {VAL1, VAL2, VAL3}
	
	public static void main(String[] args) {
		
		new EnumExample().testEnum();
	}
	
	private void testEnum() {
		
		System.out.println(ENUM_VALUES.VAL1);
		System.out.println(ENUM_VALUES.VAL2.getClass());
		
		/*if(VALUES.VAL1 IsInstanceOf enum) {
			System.out.println(true);
		}*/
	}

}
