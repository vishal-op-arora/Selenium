package TestNGLearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {

	@Test(priority = 1, groups = {"high", "medium", "low"})
	public void doUserReg() {
		System.out.println("---- @Test : Executing User Registration.");
		Assert.fail("Test Case failed");
	}

	
	@Test(priority = 1, groups = {"medium", "low"})
	public void doUserReg2() {
		System.out.println("---- @Test : Executing User Registration.");
		Assert.fail("Test Case failed");
	}

	@Test(priority = 2, dependsOnMethods = "doUserReg", groups = {"high", "medium", "low"}) // depend upon single testcase
	public void doLoin() {
		System.out.println("---- @Test : Executing LoiIn Page.");
	}

	@Test(priority = 2, dependsOnMethods = { "doUserReg", "doUserReg2" }) // Depend upon multiple tes cases
	public void doLoin2() {
		System.out.println("---- @Test : Executing LoiIn Page.");
	}

	@Test(priority = 3, groups = {"high", "medium", "low"})
	public void isSkip() {
		throw new SkipException("isSkip : Skipping the tes as condition is not met.");
	}

	@Test(priority = 3, groups = {"high", "medium", "low"})
	public void isSkip2() {
		int i = 10;
		if (i == 10) {
			throw new SkipException("isSkip2 : Skipping the test as condition is not met.");
		}
	}
}
