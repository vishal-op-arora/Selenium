package TestNGLearning;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCase1 {
	
	static int num = 1;
	
	@BeforeTest
	public void beforeTestExeu() {
		System.out.println("@BeforeTest : Execute before the start of first method." + num++);
	}
	
	@AfterTest
	public void afterTestExec() {
		System.out.println("@AfterTest : Execute after the end of last method." + num++);
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("-- @BeforeMethod : execute just befor the start of every method." + num++);
	}
	
	@AfterMethod
	public void afterMetod() {
		System.out.println("-- @AfterMethod : execute just after the end of every method." + num++);
	}
	
	@Test (priority = 2, groups = "low")//Annotation
	public void doLogin() {
		System.out.println("---- @Test : Executing LoiIn Page." + num++);
		Reporter.log("#### -- Inside Do User Login Test of TestCase 1");
	}
	
	@Test (priority = 1, groups = "high")
	public void doUserReg() {
		System.out.println("---- @Test : Executing User Registration." + num++);
	}
	
}
