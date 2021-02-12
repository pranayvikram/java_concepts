package com.concept.junitTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AnimalTestRunner {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(AnimalTest.class, ElephantTest.class);

		for (Failure failure : result.getFailures()) {
			// Print failure reason
			System.out.println(failure.toString());
		}

		// Print true on success
		System.out.println(result.wasSuccessful());
	}
}