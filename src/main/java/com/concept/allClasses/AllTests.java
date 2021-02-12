package com.concept.allClasses;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.concept.junitTest.AnimalTest;
import com.concept.junitTest.ElephantTest;

@RunWith(Suite.class)
@SuiteClasses({ AnimalTest.class, ElephantTest.class })
public class AllTests {


}
