package SeleniumTestDemo01;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

public class TestNGIntroduction {

	public static SoftAssert sa;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executed before class...");
	sa = new SoftAssert();
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
		sa.assertEquals(1+2, 4);
		System.out.println("After assert 1");
		Assert.assertEquals("A"+"B", "AB");
		sa.assertAll();
		
	}
	
	@Test
	public void test2() {
		System.out.println("Executed Test2...");
		Assert.assertEquals("A"+"B", "AC");
	}

}
