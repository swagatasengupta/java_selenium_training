package testng_priority;

import org.testng.annotations.Test;

public class TestNG_PrioritiyTest1 {
	

	@Test(priority=2)
	public void testMethod1() {
		System.out.println("TestNG_PrioritiyTest1 -> testMethod1");
	}
	
	@Test(priority=2) //4
	public void testMethod2() {
		System.out.println("TestNG_PrioritiyTest1 -> testMethod2");
	}
	
	@Test(priority=1)
	public void testMethod3() {
		System.out.println("TestNG_PrioritiyTest1 -> testMethod3");
	}
}