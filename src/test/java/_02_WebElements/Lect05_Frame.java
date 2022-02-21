package _02_WebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lect05_Frame {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		List <WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("No of Frames : " + frames.size());
		for (WebElement frame : frames) {
			System.out.println("Frame ID " + frame.getAttribute("id"));
		}
		
		// Switch to frame
		driver.switchTo().frame("iframeResult");
		/*
		 * Assignment : Switch to frame which don't have ID and Name
		 */
		//driver.findElement(By.xpath("/html/body/button")).click();
		
		/*
		 * To execute the javaScript method
		 * 
		 */
		 ((JavascriptExecutor) driver).executeScript("myFunction()");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",driver.findElement(By.xpath("//*[@id=\"mySubmit\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/button")));
		
		driver.switchTo().defaultContent(); // Switch to Main webpage
		/*
		 * does not work for Tabs
		 */
		
		
	}

}
