package myPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDriver {
	
	public static WebDriver driver = null;
	
	
	/**
	 * Returns WebDriver Object for the provided browser name
	 * <p>	   Browser 	:	browser
	 * <br>	1. Chrome	:	chrome
	 * <br>	2. FireFox	:	firefox
	 * <br>	3. Edge		: 	edge
	 * <br>	4. Opera	: 	opera 
	 * 
	 * @param browser Browser Name
	 * @return WebDriver object
	 * 
	 */
	public WebDriver getDriver(String browser) {
		
		if(browser.toLowerCase().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.toLowerCase().equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.toLowerCase().equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browser.toLowerCase().equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver =new OperaDriver();
		}
		else {
			System.out.println("Provide the correct browser Name");
		}
		
		return driver;
	}
}
