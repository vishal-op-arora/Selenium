package _01_testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {

	public static String browser = "chrome";
	
	//public static ChromeDriver driver; 
	public static WebDriver driver; 
	//public static RemoteWebDriver driver; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		//or
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		//RemoteWebDriver driver;
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		// enter URL
		driver.get("https://www.gmail.com"); // Exception in thread "main" java.lang.NullPointerException
		
		// Get Title
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.manage().window().maximize();
		
		/*
		 * Options opt = driver.manage(); 
		 * Window win = opt.window(); 
		 * win.maximize();
		 */
		
		driver.close(); // Close the current window, quitting the browser if it's the last window currently open
		
		driver.quit(); // Quits this driver, closing every associated window

	}

}
