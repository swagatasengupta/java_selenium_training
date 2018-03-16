package testng_priority;

import org.testng.annotations.Test;

public class TestNG_PrioritiyTest2 {
	

	@Test(priority=2) //5
	public void testMethod1() {
		System.out.println("TestNG_PrioritiyTest2 -> testMethod1");
	}
	
	@Test(priority=2) //3
	public void testMethod2() {
		System.out.println("TestNG_PrioritiyTest2 -> testMethod2");
	}
	
	@Test(priority=0)
	public void testMethod3() {
		System.out.println("TestNG_PrioritiyTest2 -> testMethod3");
	}
}