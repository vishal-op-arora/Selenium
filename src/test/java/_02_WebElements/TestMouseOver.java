package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Step 1. Driver & Web Browser Setup
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Step 2. Launch WebPage
		driver.get("http://www.way2automation.com/");
		
		/*
		 * Can't skip the Step 3 and click the menu item 
		 * You will not get menu until mouse over the menu 
		 * if skip this step 3 you will get 
		 * 		Exception in thread "main" org.openqa.selenium.ElementNotInteractableException: element not interactable
		 */
		
		// Step 3. Perform Mouse Over the menu  
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		
		// Step 4. Click the menu Item 		
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/ul/li[2]/a")).click();
		
	}

}
