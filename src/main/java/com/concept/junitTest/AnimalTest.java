package com.concept.junitTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnimalTest {

	@Test
	public void test() {
		Animal test = new Animal();
		String strRes = test.animalHello();
		assertEquals("", strRes);
		//fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		Animal test = new Animal();
		String strRes = test.animalHello();
		assertEquals("", strRes);
		//fail("Not yet implemented");
	}

}
