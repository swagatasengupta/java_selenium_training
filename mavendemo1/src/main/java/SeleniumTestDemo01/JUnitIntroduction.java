package SeleniumTestDemo01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

public class JUnitIntroduction {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executed before class...");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executed after class...");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("Executed before...");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("Executed after...");
	}

	@Test
	public void test1() {
		System.out.println("Executed Test1...");
	}
	
	@Test
	public void test2() {
		System.out.println("Executed Test2...");
	}

}
