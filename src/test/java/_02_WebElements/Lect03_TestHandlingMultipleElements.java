package _02_WebElements;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import myPackage.*;

public class Lect03_TestHandlingMultipleElements {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
		
		int num = 2;
		
		// Way2Autoamtion
		if(num == 1) {
			driver.get("http://way2automation.com/way2auto_jquery/index.php");
			
			// XPath
			List <WebElement> elements = driver.findElements(By.xpath("//input"));
			System.out.println(elements.size());
			
			//CSS Selector
			List <WebElement> elementsCSS = driver.findElements(By.cssSelector("input"));
			System.out.println(elementsCSS.size());
			
			// Select Element in Drop Down List
			driver.findElement(By.xpath("//select[@name='country']")).sendKeys("Hong Kong");
	
			Thread.sleep(3000);
			driver.findElement(By.xpath("//select[@name='country']")).sendKeys("India");
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//select[@name='country']")).sendKeys("Germany");
		}
		
		// Wikipedia Page
		if(num == 2) {
			driver.get("https://www.wikipedia.org");
			
			driver.findElement(By.xpath("//select[@id='searchLanguage']")).sendKeys("Dansk");

			WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
			Select select = new Select(dropDown);
			
			Thread.sleep(1000);
			select.selectByVisibleText("Eesti");
			
			Thread.sleep(1000);
			select.selectByIndex(9);  // 10th value
			
			Thread.sleep(1000);
			select.selectByValue("hi"); // Select Hindi
			
			Thread.sleep(1000);
			List <WebElement> values = driver.findElements(By.tagName("option"));
			System.out.println("Toal Values are : " + values.size());
			
			int valueIndex = 0;
			for(WebElement value : values) {
				System.out.println(valueIndex + ".   " + value.getAttribute("value") + "  -  " + value.getText());
				valueIndex++;
			}
			
			System.out.println("******************************");
			WebElement value = values.get(9); //10th Position 
			System.out.println(value.getText());
		
			/*
			 *  Find all links with anchor tag 
			 *  each link would have anchor "a" tag 
			 */
			System.out.println("**************** All Links *************************");
			List <WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("No of links on this web page are  : " + links.size());
			int linkIndex = 0;
			for(WebElement link : links) {
				System.out.println(linkIndex + " .   " + link.getText() + " -- " + link.getAttribute("href"));
				linkIndex++;
			}
			
			
			System.out.println("************************** Block  *******************************");
			
			WebElement block = driver.findElement(By.xpath("//div[@class='other-projects']"));
			
			List <WebElement> blockLinks = block.findElements(By.tagName("a"));
			System.out.println("Block links count : " + blockLinks.size());
			int blockLinkIndex = 0;
			for(WebElement blocklink : blockLinks) {
				System.out.println(blockLinkIndex + "  .  " + blocklink.getAttribute("href"));
				blockLinkIndex++;
			}
			
		}
		
		
		
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
