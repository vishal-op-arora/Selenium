package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect04_isElementPresent {

	public static WebDriver driver;
	
	// Check is the element is present or not 
	public static boolean isElementPresentCss(String cssSelector) {
		try {
			driver.findElement(By.cssSelector(cssSelector));
			return true;
		} catch(Throwable t) {
			return false;
		}
	}
	
	public static boolean isElementPresentXPath(String XPath) {
		try {
			driver.findElement(By.xpath(XPath));
			return true;
		} catch(Throwable t) {
			return false;
		}
	}
	
	
	/*
	 * Dynamic function 
	 */
	public static boolean isElementPresent(By by) {
		int size = driver.findElements(by).size();
		if(size == 0) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.gmail.com/");
		
		System.out.println(driver.findElement(By.cssSelector("#identifierId")).isDisplayed() + " " +
				driver.findElement(By.cssSelector("#identifierId")).isEnabled() + " " +
				driver.findElement(By.cssSelector("#identifierId")).isSelected()
				);
		
		// Below are the static methods
		System.out.println(isElementPresentCss("#identifierId"));
		System.out.println(isElementPresentXPath("//*[@id ='identifierId']"));
		
		// Below is dynamic method
		System.out.println(isElementPresent(By.cssSelector("#identifierId")));
		System.out.println(isElementPresent(By.xpath("//*[@id ='identifierId']")));
		
		driver.close();
		
	}
	

}
