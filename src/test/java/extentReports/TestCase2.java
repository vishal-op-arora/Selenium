package extentReports;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestCase2 {

	/*
	 * Create HTML File
	 * Basic Configuration 
	 * 	- document Title
	 * 	- Report name
	 * 	- Theme
	 * 
	 * should be done before call test 
	 */
	public ExtentSparkReporter htmlReporter;
	
	/*
	 * Attach all the configuration 
	 * - who is tester
	 * - Build number
	 * - Organization info
	 * 
	 * should be done before call test 
	 */
	public ExtentReports extent;
	
	/*
	 * Logs for Test cases
	 * Test case in Report 
	 * 	- Pass
	 * 	- Fail
	 *  - attach log if pass or fail
	 */
	public ExtentTest test;
	
	
	@BeforeTest
	public void startReport() {
		
		htmlReporter = new ExtentSparkReporter("./reports/extentt.html"); // automatically report will be generated 
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("W2A Automation Reports - Title");
		htmlReporter.config().setReportName("Automation Test Results - Report Name");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Automation Tester", "Visahl Arora");
		extent.setSystemInfo("Organization", "ABC - Organization");
		extent.setSystemInfo("Build Number", "ABC-Build-21-Feb-2021");
		
	}
	
	@Test
	public void doLogin() {
		test = extent.createTest("Login Test");
		test.log(Status.INFO, "Inside DO Login test");
	}
	
	@Test
	public void doUserReg() {
		test = extent.createTest("User Registration Test");
		test.log(Status.INFO, "Inside User Registration test");
		
		Assert.fail("Failing user reg test.");
	}
	
	@Test
	public void validateTitle() {
		test = extent.createTest("Validate Title Test");
		test.log(Status.INFO, "Inside Validate Title test");
		throw new SkipException("Skipping Validate Title Test.");
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if(result.getStatus() == ITestResult.FAILURE) {
			String exceptionMessage = Arrays.toString((result.getThrowable().getStackTrace()));
			test.fail(exceptionMessage);
			
			String screenShot = "D:\\WorkSpace\\eclipse-workspace\\Selenium\\screenshot\\error.jpg";
			test.fail("<b><font color=red>Screenshot of failure</font></b><br>", MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
			
			String methodName = result.getMethod().getMethodName().toUpperCase();
			String text = "<b> Test Case : - " + methodName + " FAILED </b>";
			
			Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);
			test.log(Status.FAIL, m);
			test.log(Status.FAIL, "Failed test");
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS) {
			
			String methodName = result.getMethod().getMethodName().toUpperCase();
			String text = "<b> Test Case : - " + methodName + " PASSED </b>";
			
			Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
			test.log(Status.PASS, m);
		}
		
		else if(result.getStatus() == ITestResult.SKIP) {
			
			String methodName = result.getMethod().getMethodName().toUpperCase();
			String text = "<b> Test Case : - " + methodName + " SKIPPED </b>";
			
			Markup m = MarkupHelper.createLabel(text, ExtentColor.YELLOW);
			test.log(Status.SKIP, m);
		}
	}
	
	private String build() {
		// TODO Auto-generated method stub
		return null;
	}

	@AfterTest
	public void endReport() {
		extent.flush(); // To be call end of all test to generate report 
		
	}
	
}
