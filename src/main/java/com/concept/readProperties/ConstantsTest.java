package com.concept.readProperties;

import java.util.*;  
import java.io.*;  

public class ConstantsTest {

	public static void main(String[] args) {  

		ConstantsTest ref = new ConstantsTest();
		try {
			ref.readPropFile();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		ref.systemProperties();
		
	}

	private void readPropFile() throws Exception {
		
		FileReader reader = new FileReader("E:/Code/WorkSpace/WarmUp/src/properties/constants.properties");  

		Properties property = new Properties();  
		property.load(reader);  

		System.out.println(property.getProperty("user"));  
		System.out.println(property.getProperty("password"));
	}
	
	@SuppressWarnings("rawtypes")
	private void systemProperties() {

		Properties property = System.getProperties();  
		Set<?> set = property.entrySet();  

		Iterator<?> itr = set.iterator();  
		while(itr.hasNext()){  
			
			Map.Entry entry = (Map.Entry)itr.next();  
			System.out.println(entry.getKey() + " = " + entry.getValue());  
		}  

	}
}  