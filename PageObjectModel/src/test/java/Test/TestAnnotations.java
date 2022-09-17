package Test;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class TestAnnotations {

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("beforeMethod",true);
	}
	
	@AfterMethod
	public void afterMethod() {
		Reporter.log("afterMethod",true);
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("beforeClass",true);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("afterClass",true);
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("beforeTest",true);
	}
	
	@AfterTest
	public void AfterTest() {
		Reporter.log("afterTest",true);
	}
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("beforeSuite",true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("afterSuite",true);
	}
	
	@Test(priority = 1)
	public void test() {
		System.out.println("Test started....");
		Reporter.log("Test",true);
	}
	
	@Test(groups= {"module1"})
	public void test2() {
		System.out.println("test2");
		Reporter.log("Test2",true);
	}
	
	@Test(invocationCount=2)
	public void  test3() {
		System.out.println("Test3");
		Reporter.log("Test3",true);
	}
}

