package TestNGLearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {

	
	@Test (enabled = false)
	public void validTitle() {
		String actual_title = "Gmail.com";
		String expected_title = "Yahoo.com";
		
		Assert.assertEquals(expected_title, actual_title);
		
	}
	
	@Test (groups = {"high", "low"})
	public void isElementFound() {
		Assert.assertTrue(true, "Element not found.");
	}
	
	@Test (enabled = false)
	public void forcefullyFail() {
		Assert.fail("Forcefully failed.");
	}
	
	@Test (enabled = false)
	public void multipleAsserts() {
		
		System.out.println("*********** multipleAsserts : Begining ************");
		
		String actual_title = "Gmail.com";
		String expected_title = "Yahoo.com";
		
		Assert.assertEquals(expected_title, actual_title);
		
		Assert.assertTrue(false, "Element not found.");
		
		Assert.fail("Forcefully failed.");
		
		System.out.println("*********** multipleAsserts : Ending ************");
	}
	
	/*
	 * if any of the soft assert failed 
	 * assertAll() method failed the Test at point that if 
	 *  any of the soft assert failed.
	 * if assertAll() method is missing soft-assert failed will not be consider as test failure
	 */
	
	@Test (groups = "medium")
	public void multipleSoftAsserts() {
		
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("*********** multipleSoftAsserts : Begining ************");
		
		String actual_title = "Gmail.com";
		String expected_title = "Yahoo.com";
		
		softAssert.assertEquals(expected_title, actual_title);
		
		softAssert.assertTrue(false, "Element not found.");
		
		softAssert.fail("Forcefully failed.");
		
		System.out.println("*********** multipleSoftAsserts : Ending ************");
		
		
	}
	
	@Test (groups = {"high", "medium"})
	public void multipleSoftAssertsAll() {
		
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("*********** multipleSoftAssertsAll : Begining ************");
		
		String actual_title = "Gmail.com";
		String expected_title = "Yahoo.com";
		
		softAssert.assertEquals(expected_title, actual_title);
		
		softAssert.assertTrue(true, "-> Element not found.");
		
		softAssert.fail("-> Forcefully failed.");
		
		System.out.println("*********** multipleSoftAssertsAll : Ending ************");
		
		softAssert.assertAll();
		
		Reporter.log("####  inside the Soft Assert all");
	}
}
