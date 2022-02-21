/**
 * 
 */
package _02_WebElements;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author CEPL
 *
 */
import myPackage.*;

public class TestCheckBoxes {

	public static WebDriver driver;
	public static String browser = "chrome";
	
	public static int countCheckbox(String xpath) {
		
		int checkboxCount = 0;	
		try {
			do {
				driver.findElement(By.xpath(xpath + "[" + (checkboxCount + 1) + "]"));
				checkboxCount ++;
			} while(true);
		}
		catch(Throwable t) {
			return checkboxCount;
		}
	}
	
	public static boolean isElementPresent(By by) {
		int elementCount = driver.findElements(by).size();
		return elementCount == 0 ? false : true;
	}
	
	public static void main (String[] args) {
		
		driver = new SelectDriver().getDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		
		// *************************************************************
		// Check the individual Check-Box 
		/*
		driver.findElement(By.xpath("//div[4]/input[1]")).click();
		driver.findElement(By.xpath("//div[4]/input[2]")).click();
		driver.findElement(By.xpath("//div[4]/input[3]")).click();
		driver.findElement(By.xpath("//div[4]/input[4]")).click();
		*/
		
		
		// ************************************************************
		// Check the Check-Boxes 
		/*
		for(int i = 1; i<= 4; i++) {
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
		}
		*/
		
		System.out.println(countCheckbox("//div[4]/input"));
		
		int checkBoxCount = 0;
		
		
		
		// Find all the element with name
		/*
		List<WebElement> checkboxes = driver.findElements(By.name("sports"));
		for(WebElement checkbox : checkboxes) {
			checkbox.click();
		}
		System.out.println("Number of Check boxes : " + checkboxes.size());
		*/
		
		
		// Find the section and find the check boxes 
		WebElement displayOneSection = driver.findElement(By.xpath("//div[@class='display'][1]"));
		
		List<WebElement> displayOneCheckboxes = displayOneSection.findElements(By.name("sports"));
		for(WebElement checkbox : displayOneCheckboxes) {
			checkbox.click();
		}
		System.out.println("Number of Check boxes : " + displayOneCheckboxes.size());
		
	}
	
}
