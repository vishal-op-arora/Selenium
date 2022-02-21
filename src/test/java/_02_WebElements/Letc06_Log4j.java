package _02_WebElements;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Letc06_Log4j {

	/*
	 * even use fro developer as well 1 - add log4j dependencies 2 - Logger -
	 * getLogger() 3 - Log4j Appenders - Format, information, Error, Debug Append
	 * true : log appended to same file Append false - create new file, overwrite
	 * older one where the log file should be genrator..... ........................
	 * log4j.properties 4 - PropertyConfigurator
	 * 
	 * 
	 */

	public static Logger log = Logger.getLogger(Letc06_Log4j.class.getName());

	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		PropertyConfigurator
				.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");
		;
		log.debug("****************            LogStarted           *****************");
		;
		Properties OR = new Properties(); // Object of Properties Class
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties"); // Objject of
																										// File
		OR.load(fis); // Load the Object

		/*
		 * Logger.getLogger(Letc06_Log4j.class.getName()).info("OR Properties Loaded");
		 * or create static varaible of Logger log
		 */
		log.info("OR Properties Loaded");

		Properties Config = new Properties();
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		Config.load(fis);

		/*
		 * Logger.getLogger(Letc06_Log4j.class.getName()).
		 * info("Config Properties Loaded"); or use Log
		 */

		log.info("Config Properties File Loaded.");

		System.out.println(OR.getProperty("username_ID"));
		System.out.println(Config.getProperty("browser"));

		if (Config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched.");

		} else if (Config.getProperty("browser").equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched.");

		}

		driver.manage().window().setPosition(new Point(100, -600));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		driver.get(Config.getProperty("testsiteurl"));
		log.info("Navigated to : " + Config.getProperty("testsiteurl"));

		driver.findElement(By.id(OR.getProperty("username_ID"))).sendKeys("vishal.op.arora@gmail.com");
		;
		log.info("Username entered : vishal.op.arora@gmail.com !!!");

		driver.findElement(By.xpath(OR.getProperty("nextBtn_XPATH"))).click();
		log.info("Clicking on Next Button. !!!");
		Thread.sleep(3000);
		driver.quit();

		log.info("Test execution completed. !!!");
		System.out.println("Program Ends");

	}

}
