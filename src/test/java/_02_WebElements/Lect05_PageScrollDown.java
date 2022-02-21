package _02_WebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect05_PageScrollDown {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(100, -600));
		driver.manage().window().maximize();
		driver.get("http://www.way2automation.com/");
		
		// Page Down
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html")).sendKeys(Keys.PAGE_DOWN);
		
		// Page Down
		Thread.sleep(1500);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		
		Thread.sleep(1500);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(2000);
		driver.close();
	}

}
