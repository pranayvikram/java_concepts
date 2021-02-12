package com.concept.junitTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Assert;

public class ElephantTest {
	
	// @BeforeClass � Run once before any of the test methods in the class, public static void.
	@BeforeClass	
	public static void setUpBeforeClass() throws Exception {
		System.out.println("STR-BeforeClass");
	}

	// @AfterClass � Run once after all the tests in the class have been run, public static void.
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("STR-AfterClass");
	}

	// @Before � Run before @Test, public void.
	@Before
	public void setUp() throws Exception {
		System.out.println("STR-BeforeTestMethod");
	}
	
	// @After � Run after @Test, public void.
	@After
	public void tearDown() throws Exception {
		System.out.println("STR-AfterTestMethod");
	}
	
	@Test
	public void test() {
		Elephant test = new Elephant();
		String strRes = test.animalHello(true);
		Assert.assertEquals("", strRes);
		//fail("Not yet implemented");
	}
	
	@Test
	public void test2() {
		Elephant test = new Elephant();
		String strRes = test.animalHello(true);
		Assert.assertEquals("", strRes);
		//fail("Not yet implemented");
	}

	
}
