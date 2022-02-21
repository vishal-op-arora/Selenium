package TestNGLearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase4TryCatch {

	/*
	 * 
	 * Test Fail and 
	 * Report Message
	 * 
	 */
	@Test(priority = 1, groups = {"high", "medium", "low"})
	public void doUserReg() {
		try {
		System.out.println("---- @Test : Executing User Registration.");
		Assert.fail("Test Case failed");
		
		} catch (Throwable t) {
			Reporter.log("Capture Screen Shot : Failed and Reported ");
			Assert.fail(t.getMessage());
		}
	}

	
	/*
	 * Test Don't failed even Assert fail
	 * Error store in t2 but not reported
	 */
	
	@Test(priority = 1, groups = {"medium", "low"})
	public void doUserReg2() {
		try {
		System.out.println("---- @Test : Executing User Registration.");
		Assert.fail("Test Case failed");
		} catch (Throwable t2) {
			Reporter.log("Capture Screen Shot : FAiled but not reported");
		}
	}


}
