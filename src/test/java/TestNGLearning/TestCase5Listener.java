package TestNGLearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase5Listener {

	/*
	 * 
	 * Test Fail and 
	 * Report Message
	 * 
	 */
	@Test(priority = 1, groups = {"high", "medium", "low"})
	public void doUserReg() {
		System.out.println("---- @Test : Executing User Registration.");
		Assert.fail("Test Case failed");
		
	}

	
	/*
	 * Test Don't failed even Assert fail
	 * Error store in t2 but not reported
	 */
	
	@Test(priority = 1, groups = {"medium", "low"})
	public void doUserReg2() {
		System.out.println("---- @Test : Executing User Registration.");
		Assert.fail("Test Case failed");
	}


}
