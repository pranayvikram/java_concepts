package com.concept.abstractFactoryPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GenerateBill {

	public static void main(String args[]) {

		HashMap<String, String> input = findInput();

		HouseFactory planFactory = new HouseFactory();
		
		House house = planFactory.getHouse(input.get("HOUSE"));

		if (house != null) {

			try {
				// To set bill rate
				house.getRate();
				int units = house.add(Integer.parseInt(input.get("INTERNAL")), Integer.parseInt(input.get("EXTERNAL")));
				
				String planName = house.findName(input.get("HOUSE"));
				
				System.out.print("Bill amount on plan id: " + planName + " for " + units + " units is: ");
				house.calculateBill(units);
			}
			catch (NumberFormatException nfe) {
				System.out.print("Internal number units! ");
			}
		}
		else {
			System.out.println("Invalid inputs!");
		}
	}
	

	private static HashMap<String, String> findInput() {
		
		HashMap<String, String> input = new HashMap<String, String>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Plans: 1.DOMESTIC_HOUSE 2.COMMERCIAL_HOUSE 3.INSTITUTIONAL_HOUSE");
			System.out.println("Enter plan any of above name: ");
			String planName = br.readLine();

			System.out.print("Internal units: ");
			String internalUnits = br.readLine();

			System.out.print("External units: ");
			String externalUnits = br.readLine();

			input.put("HOUSE", planName);
			input.put("INTERNAL", internalUnits);
			input.put("EXTERNAL", externalUnits);
		}
		catch (NumberFormatException | IOException e) {
			System.out.println("Invalid unit inputs!");
			e.printStackTrace();
		}
		
		return input;
	}
}
