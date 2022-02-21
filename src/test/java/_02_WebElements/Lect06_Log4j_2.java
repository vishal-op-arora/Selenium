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

public class Lect06_Log4j_2 {

	/*
	 * even use fro developer as well 
	 * 1 - add log4j dependencies 
	 * 2 - Logger - getLogger()
	 * 3 - Log4j Appenders - Format, information, Error, Debug
	 * 		Append true : log appended to same file
	 * 		Append false - create new file, overwrite older one 
	 * 		where the log file should be genrator..... ........................   log4j.properties 
	 * 4 - PropertyConfigurator 
	 * 
	 * 
	 */
	
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(Letc06_Log4j.class.getName());
	public static Properties OR = new Properties(); // Object of Properties Class
	
	public static void click(String key) {
		
		if(key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key))).click();
		} 
		else if (key.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(key)));
		}
		else if (key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(key)));
		}
		log.info("Clicking on an Element : " + key);
	}
	
	public static void sendKeys(String key, String value) {
		
		if(key.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		} 
		else if (key.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
		}
		else if (key.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
		}
		log.info("Typing in an Element : " + key +"  enter a value as : " + value);
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		PropertyConfigurator.configure(System.getProperty("user.dir") +"\\src\\test\\resources\\properties\\log4j.properties");;
		log.info("****************            LogStarted           *****************");;
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\properties\\OR.properties"); // Objject of File
		OR.load(fis); 
		log.info("OR Properties Loaded");
		
		Properties Config = new Properties();
		fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\properties\\Config.properties");
		Config.load(fis);
		log.info("Config Properties File Loaded.");
		
		if(Config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched.");
			
		} else if(Config.getProperty("browser").equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched.");
			
		}
		
		driver.manage().window().setPosition(new Point (100, -600));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		
		driver.get(Config.getProperty("testsiteurl"));
		log.info("Navigated to : " + Config.getProperty("testsiteurl"));
		
		sendKeys("username_ID", "vishal.op.arora@gmail.com");
		click("nextBtn_XPATH");
		
		driver.quit();
		log.info("Test execution completed. !!!");
	}

}