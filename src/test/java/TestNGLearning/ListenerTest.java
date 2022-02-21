package TestNGLearning;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerTest implements ITestListener {

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log(
				"<a href=\"D:\\WorkSpace\\eclipse-workspace\\Selenium\\screenshot\\error.jpg\" target=\"_blank\">Capture Screenshot from ListenerTest.</a> ");
		Reporter.log("<br>");
		Reporter.log(
				"<a href=\"D:\\WorkSpace\\eclipse-workspace\\Selenium\\screenshot\\error.jpg\" target=\"_blank\"><img src=\"D:\\WorkSpace\\eclipse-workspace\\Selenium\\screenshot\\error.jpg\" height=100 width=100></a> ");
	}
}
