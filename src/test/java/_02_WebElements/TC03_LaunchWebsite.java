package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03_LaunchWebsite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// WebDriver Setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Browse the Web Page
		driver.get("https://www.wikipedia.org/");
		
		// Title
		System.out.println("Title : " + driver.getTitle());
		
		// Current URL
		System.out.println("Current URL : " + driver.getCurrentUrl());
		
		// Compare Object
		System.out.println("Compare Object : " + driver.equals(driver));
		
	}
	
}
