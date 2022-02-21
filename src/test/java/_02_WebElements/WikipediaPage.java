package _02_WebElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import myPackage.SelectDriver;

public class WikipediaPage {

	public static WebDriver driver = null;
	public static String browser = "firefox";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new SelectDriver().getDriver(browser);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
		
		driver.get("https://www.wikipedia.org");
		
		// Get all links
		System.out.println("**************** Links *********************");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println("Links Count : " + links.size());
		
		int linkCount = 1 ; 
		for(WebElement link : links) {
			System.out.println(linkCount + ". --   " + link.getText() + " -:- " + link.getAttribute("href"));
			linkCount++;
			break; // break loop
		}
		
		// Get all links
		System.out.println("**************** Block Elemnts *********************");
		WebElement optPrjsBlock = driver.findElement(By.xpath("//div[@class='other-projects']"));
		List<WebElement> optPrjBlockElements = optPrjsBlock.findElements(By.xpath("//div[@class='other-project']"));
		for(WebElement optPrjBlockElement : optPrjBlockElements) {
			System.out.println(optPrjBlockElement.findElement(By.xpath("//a")).getAttribute("href"));
		}
		
		

		
		
		// Close Browser
		driver.close();
		
		if(driver != null) {
			System.out.println("Failed to close the web-browser.");
		}
		else {
			System.out.println("Web-Browser Closed.");
		}
		
		
		
	}

	public static int main(int i) {
		return 100;
	}
}
